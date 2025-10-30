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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.OrderMultishipOptionService;
import org.broadleafcommerce.core.order.service.call.OrderMultishipOptionDTO;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.checkout.model.OrderMultishipOptionForm;
import org.broadleafcommerce.core.web.checkout.model.ShippingInfoForm;
import org.broadleafcommerce.core.web.checkout.validator.MultishipAddAddressFormValidator;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Country;
import org.broadleafcommerce.profile.core.domain.CountrySubdivision;
import org.broadleafcommerce.profile.core.domain.CustomerAddress;
import org.broadleafcommerce.profile.core.domain.CustomerAddressImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.domain.State;
import org.broadleafcommerce.profile.core.service.AddressService;
import org.broadleafcommerce.profile.core.service.CountryService;
import org.broadleafcommerce.profile.core.service.CountrySubdivisionService;
import org.broadleafcommerce.profile.core.service.CustomerAddressService;
import org.broadleafcommerce.profile.core.service.StateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

@ExtendWith(MockitoExtension.class)
class BroadleafShippingInfoControllerDiffblueTest {
  @Mock
  private BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;

  @InjectMocks
  private BroadleafShippingInfoController broadleafShippingInfoController;

  @Mock
  private FulfillmentGroupService fulfillmentGroupService;

  @Mock
  private OrderMultishipOptionService orderMultishipOptionService;

  @Mock
  private AddressService addressService;

  @Mock
  private CustomerAddressService customerAddressService;

  @Mock
  private MultishipAddAddressFormValidator multishipAddAddressFormValidator;

  @Mock
  private CountryService countryService;

  @Mock
  private CountrySubdivisionService countrySubdivisionService;

  @Mock
  private StateService stateService;

  /**
   * Test {@link BroadleafShippingInfoController#convertToSingleship(HttpServletRequest, HttpServletResponse, Model)}.
   * <ul>
   *   <li>Then return {@code redirect:/checkout}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafShippingInfoController#convertToSingleship(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test convertToSingleship(HttpServletRequest, HttpServletResponse, Model); then return 'redirect:/checkout'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafShippingInfoController.convertToSingleship(HttpServletRequest, HttpServletResponse, Model)"})
  void testConvertToSingleship_thenReturnRedirectCheckout() throws PricingException {
    // Arrange
    BroadleafCheckoutControllerExtensionHandler broadleafCheckoutControllerExtensionHandler = mock(
        BroadleafCheckoutControllerExtensionHandler.class);
    when(broadleafCheckoutControllerExtensionHandler.performAdditionalShippingAction())
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(broadleafCheckoutControllerExtensionManager.getProxy())
        .thenReturn(broadleafCheckoutControllerExtensionHandler);
    when(fulfillmentGroupService.collapseToOneShippableFulfillmentGroup(Mockito.<Order>any(), anyBoolean()))
        .thenReturn(new NullOrderImpl());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualConvertToSingleshipResult = broadleafShippingInfoController.convertToSingleship(request, response,
        new ConcurrentModel());

    // Assert
    verify(broadleafCheckoutControllerExtensionManager).getProxy();
    verify(fulfillmentGroupService).collapseToOneShippableFulfillmentGroup(isNull(), eq(true));
    verify(broadleafCheckoutControllerExtensionHandler).performAdditionalShippingAction();
    assertEquals("redirect:/checkout", actualConvertToSingleshipResult);
  }

  /**
   * Test {@link BroadleafShippingInfoController#convertToSingleship(HttpServletRequest, HttpServletResponse, Model)}.
   * <ul>
   *   <li>Then throw {@link PricingException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafShippingInfoController#convertToSingleship(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test convertToSingleship(HttpServletRequest, HttpServletResponse, Model); then throw PricingException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafShippingInfoController.convertToSingleship(HttpServletRequest, HttpServletResponse, Model)"})
  void testConvertToSingleship_thenThrowPricingException() throws PricingException {
    // Arrange
    when(fulfillmentGroupService.collapseToOneShippableFulfillmentGroup(Mockito.<Order>any(), anyBoolean()))
        .thenThrow(new PricingException("An error occurred"));
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(PricingException.class,
        () -> broadleafShippingInfoController.convertToSingleship(request, response, new ConcurrentModel()));
    verify(fulfillmentGroupService).collapseToOneShippableFulfillmentGroup(isNull(), eq(true));
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveMultiship(HttpServletRequest, HttpServletResponse, Model, OrderMultishipOptionForm, BindingResult)}.
   * <p>
   * Method under test: {@link BroadleafShippingInfoController#saveMultiship(HttpServletRequest, HttpServletResponse, Model, OrderMultishipOptionForm, BindingResult)}
   */
  @Test
  @DisplayName("Test saveMultiship(HttpServletRequest, HttpServletResponse, Model, OrderMultishipOptionForm, BindingResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafShippingInfoController.saveMultiship(HttpServletRequest, HttpServletResponse, Model, OrderMultishipOptionForm, BindingResult)"})
  void testSaveMultiship() throws ServiceException, PricingException {
    // Arrange
    BroadleafCheckoutControllerExtensionHandler broadleafCheckoutControllerExtensionHandler = mock(
        BroadleafCheckoutControllerExtensionHandler.class);
    when(broadleafCheckoutControllerExtensionHandler.performAdditionalShippingAction())
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(broadleafCheckoutControllerExtensionManager.getProxy())
        .thenReturn(broadleafCheckoutControllerExtensionHandler);
    when(fulfillmentGroupService.matchFulfillmentGroupsToMultishipOptions(Mockito.<Order>any(), anyBoolean()))
        .thenReturn(new NullOrderImpl());
    doNothing().when(orderMultishipOptionService)
        .saveOrderMultishipOptions(Mockito.<Order>any(), Mockito.<List<OrderMultishipOptionDTO>>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    OrderMultishipOptionForm orderMultishipOptionForm = new OrderMultishipOptionForm();
    orderMultishipOptionForm.setOptions(new ArrayList<>());

    // Act
    String actualSaveMultishipResult = broadleafShippingInfoController.saveMultiship(request, response, model,
        orderMultishipOptionForm, new BindException("Target", "Object Name"));

    // Assert
    verify(broadleafCheckoutControllerExtensionManager).getProxy();
    verify(fulfillmentGroupService).matchFulfillmentGroupsToMultishipOptions(isNull(), eq(true));
    verify(orderMultishipOptionService).saveOrderMultishipOptions(isNull(), isA(List.class));
    verify(broadleafCheckoutControllerExtensionHandler).performAdditionalShippingAction();
    assertEquals("redirect:/checkout", actualSaveMultishipResult);
  }

  /**
   * Test {@link BroadleafShippingInfoController#showMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test: {@link BroadleafShippingInfoController#showMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test showMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafShippingInfoController.showMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model)"})
  void testShowMultishipAddAddress() {
    // Arrange
    ArrayList<Country> countryList = new ArrayList<>();
    when(countryService.findCountries()).thenReturn(countryList);
    ArrayList<CountrySubdivision> countrySubdivisionList = new ArrayList<>();
    when(countrySubdivisionService.findSubdivisions()).thenReturn(countrySubdivisionList);
    ArrayList<State> stateList = new ArrayList<>();
    when(stateService.findStates()).thenReturn(stateList);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualShowMultishipAddAddressResult = broadleafShippingInfoController.showMultishipAddAddress(request,
        response, model);

    // Assert
    verify(countryService).findCountries();
    verify(countrySubdivisionService).findSubdivisions();
    verify(stateService).findStates();
    assertEquals(3, model.size());
    Object getResult = model.get("countries");
    assertTrue(getResult instanceof List);
    assertEquals("checkout/multishipAddAddressForm", actualShowMultishipAddAddressResult);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(countryList, getResult);
    assertSame(countrySubdivisionList, model.get("countrySubdivisions"));
    assertSame(stateList, model.get("states"));
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName("Test saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult); given AddressImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"})
  void testSaveMultishipAddAddress_givenAddressImpl() throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing().when(multishipAddAddressFormValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    ShippingInfoForm addressForm = mock(ShippingInfoForm.class);
    when(addressForm.getAddressName()).thenReturn("42 Main St");
    when(addressForm.getAddress()).thenReturn(new AddressImpl());

    // Act
    broadleafShippingInfoController.saveMultishipAddAddress(request, response, model, addressForm,
        new BindException("Target", "Object Name"));

    // Assert
    verify(addressForm, atLeast(1)).getAddress();
    verify(addressForm).getAddressName();
    verify(multishipAddAddressFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerAddressService).create();
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) Fax is {@code ThreadLocalManager.notify.orphans}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName("Test saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult); given AddressImpl (default constructor) Fax is 'ThreadLocalManager.notify.orphans'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"})
  void testSaveMultishipAddAddress_givenAddressImplFaxIsThreadLocalManagerNotifyOrphans() throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing().when(multishipAddAddressFormValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setFax("ThreadLocalManager.notify.orphans");
    ShippingInfoForm addressForm = mock(ShippingInfoForm.class);
    when(addressForm.getAddressName()).thenReturn("42 Main St");
    when(addressForm.getAddress()).thenReturn(addressImpl);

    // Act
    broadleafShippingInfoController.saveMultishipAddAddress(request, response, model, addressForm,
        new BindException("Target", "Object Name"));

    // Assert
    verify(addressForm, atLeast(1)).getAddress();
    verify(addressForm).getAddressName();
    verify(multishipAddAddressFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerAddressService).create();
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) PrimaryPhone is {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName("Test saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult); given AddressImpl (default constructor) PrimaryPhone is '6625550144'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"})
  void testSaveMultishipAddAddress_givenAddressImplPrimaryPhoneIs6625550144() throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing().when(multishipAddAddressFormValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setPrimaryPhone("6625550144");
    ShippingInfoForm addressForm = mock(ShippingInfoForm.class);
    when(addressForm.getAddressName()).thenReturn("42 Main St");
    when(addressForm.getAddress()).thenReturn(addressImpl);

    // Act
    broadleafShippingInfoController.saveMultishipAddAddress(request, response, model, addressForm,
        new BindException("Target", "Object Name"));

    // Assert
    verify(addressForm, atLeast(1)).getAddress();
    verify(addressForm).getAddressName();
    verify(multishipAddAddressFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerAddressService).create();
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) SecondaryPhone is {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName("Test saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult); given AddressImpl (default constructor) SecondaryPhone is '6625550144'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"})
  void testSaveMultishipAddAddress_givenAddressImplSecondaryPhoneIs6625550144() throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing().when(multishipAddAddressFormValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setSecondaryPhone("6625550144");
    ShippingInfoForm addressForm = mock(ShippingInfoForm.class);
    when(addressForm.getAddressName()).thenReturn("42 Main St");
    when(addressForm.getAddress()).thenReturn(addressImpl);

    // Act
    broadleafShippingInfoController.saveMultishipAddAddress(request, response, model, addressForm,
        new BindException("Target", "Object Name"));

    // Assert
    verify(addressForm, atLeast(1)).getAddress();
    verify(addressForm).getAddressName();
    verify(multishipAddAddressFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerAddressService).create();
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   * <ul>
   *   <li>Then calls {@link AddressImpl#getPhoneFax()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName("Test saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult); then calls getPhoneFax()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"})
  void testSaveMultishipAddAddress_thenCallsGetPhoneFax() throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing().when(multishipAddAddressFormValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    AddressImpl addressImpl = mock(AddressImpl.class);
    doNothing().when(addressImpl).setPhoneFax(Mockito.<Phone>any());
    doNothing().when(addressImpl).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(addressImpl).setPhoneSecondary(Mockito.<Phone>any());
    when(addressImpl.getPhoneFax()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhoneSecondary()).thenReturn(new PhoneImpl());
    ShippingInfoForm addressForm = mock(ShippingInfoForm.class);
    when(addressForm.getAddressName()).thenReturn("42 Main St");
    when(addressForm.getAddress()).thenReturn(addressImpl);

    // Act
    broadleafShippingInfoController.saveMultishipAddAddress(request, response, model, addressForm,
        new BindException("Target", "Object Name"));

    // Assert
    verify(addressForm, atLeast(1)).getAddress();
    verify(addressForm).getAddressName();
    verify(multishipAddAddressFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressImpl).getPhoneFax();
    verify(addressImpl).getPhonePrimary();
    verify(addressImpl).getPhoneSecondary();
    verify(addressImpl).setPhoneFax(isNull());
    verify(addressImpl).setPhonePrimary(isNull());
    verify(addressImpl).setPhoneSecondary(isNull());
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerAddressService).create();
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   * <ul>
   *   <li>Then {@link ShippingInfoForm} (default constructor) Address {@link AddressImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName("Test saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult); then ShippingInfoForm (default constructor) Address AddressImpl")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"})
  void testSaveMultishipAddAddress_thenShippingInfoFormAddressAddressImpl() throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing().when(multishipAddAddressFormValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    ShippingInfoForm addressForm = new ShippingInfoForm();

    // Act
    broadleafShippingInfoController.saveMultishipAddAddress(request, response, model, addressForm,
        new BindException("Target", "Object Name"));

    // Assert
    verify(multishipAddAddressFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerAddressService).create();
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
    Address address = addressForm.getAddress();
    assertTrue(address instanceof AddressImpl);
    assertNull(address.getPhoneFax());
    assertNull(address.getPhonePrimary());
    assertNull(address.getPhoneSecondary());
  }

  /**
   * Test {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(ShippingInfoForm); given AddressImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafShippingInfoController.removeUnusedPhones(ShippingInfoForm)"})
  void testRemoveUnusedPhones_givenAddressImpl() {
    // Arrange
    ShippingInfoForm form = mock(ShippingInfoForm.class);
    when(form.getAddress()).thenReturn(new AddressImpl());

    // Act
    broadleafShippingInfoController.removeUnusedPhones(form);

    // Assert
    verify(form).getAddress();
  }

  /**
   * Test {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) Fax is {@code Fax}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(ShippingInfoForm); given AddressImpl (default constructor) Fax is 'Fax'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafShippingInfoController.removeUnusedPhones(ShippingInfoForm)"})
  void testRemoveUnusedPhones_givenAddressImplFaxIsFax() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setFax("Fax");
    ShippingInfoForm form = mock(ShippingInfoForm.class);
    when(form.getAddress()).thenReturn(addressImpl);

    // Act
    broadleafShippingInfoController.removeUnusedPhones(form);

    // Assert
    verify(form).getAddress();
  }

  /**
   * Test {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) PrimaryPhone is {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(ShippingInfoForm); given AddressImpl (default constructor) PrimaryPhone is '6625550144'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafShippingInfoController.removeUnusedPhones(ShippingInfoForm)"})
  void testRemoveUnusedPhones_givenAddressImplPrimaryPhoneIs6625550144() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setPrimaryPhone("6625550144");
    ShippingInfoForm form = mock(ShippingInfoForm.class);
    when(form.getAddress()).thenReturn(addressImpl);

    // Act
    broadleafShippingInfoController.removeUnusedPhones(form);

    // Assert
    verify(form).getAddress();
  }

  /**
   * Test {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) SecondaryPhone is {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(ShippingInfoForm); given AddressImpl (default constructor) SecondaryPhone is '6625550144'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafShippingInfoController.removeUnusedPhones(ShippingInfoForm)"})
  void testRemoveUnusedPhones_givenAddressImplSecondaryPhoneIs6625550144() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setSecondaryPhone("6625550144");
    ShippingInfoForm form = mock(ShippingInfoForm.class);
    when(form.getAddress()).thenReturn(addressImpl);

    // Act
    broadleafShippingInfoController.removeUnusedPhones(form);

    // Assert
    verify(form).getAddress();
  }

  /**
   * Test {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}.
   * <ul>
   *   <li>Then calls {@link AddressImpl#getPhoneFax()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(ShippingInfoForm); then calls getPhoneFax()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafShippingInfoController.removeUnusedPhones(ShippingInfoForm)"})
  void testRemoveUnusedPhones_thenCallsGetPhoneFax() {
    // Arrange
    AddressImpl addressImpl = mock(AddressImpl.class);
    doNothing().when(addressImpl).setPhoneFax(Mockito.<Phone>any());
    doNothing().when(addressImpl).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(addressImpl).setPhoneSecondary(Mockito.<Phone>any());
    when(addressImpl.getPhoneFax()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhoneSecondary()).thenReturn(new PhoneImpl());
    ShippingInfoForm form = mock(ShippingInfoForm.class);
    when(form.getAddress()).thenReturn(addressImpl);

    // Act
    broadleafShippingInfoController.removeUnusedPhones(form);

    // Assert
    verify(form).getAddress();
    verify(addressImpl).getPhoneFax();
    verify(addressImpl).getPhonePrimary();
    verify(addressImpl).getPhoneSecondary();
    verify(addressImpl).setPhoneFax(isNull());
    verify(addressImpl).setPhonePrimary(isNull());
    verify(addressImpl).setPhoneSecondary(isNull());
  }

  /**
   * Test {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}.
   * <ul>
   *   <li>Then {@link ShippingInfoForm} (default constructor) Address {@link AddressImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(ShippingInfoForm); then ShippingInfoForm (default constructor) Address AddressImpl")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafShippingInfoController.removeUnusedPhones(ShippingInfoForm)"})
  void testRemoveUnusedPhones_thenShippingInfoFormAddressAddressImpl() {
    // Arrange
    ShippingInfoForm form = new ShippingInfoForm();

    // Act
    broadleafShippingInfoController.removeUnusedPhones(form);

    // Assert
    Address address = form.getAddress();
    assertTrue(address instanceof AddressImpl);
    assertNull(address.getPhoneFax());
    assertNull(address.getPhonePrimary());
    assertNull(address.getPhoneSecondary());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafShippingInfoController}
   *   <li>{@link BroadleafShippingInfoController#getMultishipAddAddressSuccessView()}
   *   <li>{@link BroadleafShippingInfoController#getMultishipAddAddressView()}
   *   <li>{@link BroadleafShippingInfoController#getMultishipSuccessView()}
   *   <li>{@link BroadleafShippingInfoController#getMultishipView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafShippingInfoController.<init>()",
      "String BroadleafShippingInfoController.getMultishipAddAddressSuccessView()",
      "String BroadleafShippingInfoController.getMultishipAddAddressView()",
      "String BroadleafShippingInfoController.getMultishipSuccessView()",
      "String BroadleafShippingInfoController.getMultishipView()"})
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafShippingInfoController actualBroadleafShippingInfoController = new BroadleafShippingInfoController();
    String actualMultishipAddAddressSuccessView = actualBroadleafShippingInfoController
        .getMultishipAddAddressSuccessView();
    String actualMultishipAddAddressView = actualBroadleafShippingInfoController.getMultishipAddAddressView();
    String actualMultishipSuccessView = actualBroadleafShippingInfoController.getMultishipSuccessView();

    // Assert
    assertEquals("checkout/multiship", actualBroadleafShippingInfoController.getMultishipView());
    assertEquals("checkout/multishipAddAddressForm", actualMultishipAddAddressView);
    assertEquals("redirect:/checkout", actualMultishipSuccessView);
    assertEquals("redirect:/checkout/multiship", actualMultishipAddAddressSuccessView);
  }
}
