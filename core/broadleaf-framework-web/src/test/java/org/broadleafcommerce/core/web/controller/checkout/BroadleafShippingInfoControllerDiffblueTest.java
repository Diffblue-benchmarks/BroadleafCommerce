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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.OrderMultishipOptionService;
import org.broadleafcommerce.core.order.service.call.OrderMultishipOptionDTO;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.checkout.model.OrderMultishipOptionForm;
import org.broadleafcommerce.core.web.checkout.model.ShippingInfoForm;
import org.broadleafcommerce.core.web.checkout.validator.MultishipAddAddressFormValidator;
import org.broadleafcommerce.core.web.checkout.validator.ShippingInfoFormValidator;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Country;
import org.broadleafcommerce.profile.core.domain.CountrySubdivision;
import org.broadleafcommerce.profile.core.domain.CustomerAddress;
import org.broadleafcommerce.profile.core.domain.CustomerAddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

@ExtendWith(MockitoExtension.class)
class BroadleafShippingInfoControllerDiffblueTest {
  @Mock private AddressService addressService;

  @Mock
  private BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;

  @InjectMocks private BroadleafShippingInfoController broadleafShippingInfoController;

  @Mock private CountryService countryService;

  @Mock private CountrySubdivisionService countrySubdivisionService;

  @Mock private CustomerAddressService customerAddressService;

  @Mock private FulfillmentGroupService fulfillmentGroupService;

  @Mock private MultishipAddAddressFormValidator multishipAddAddressFormValidator;

  @Mock private OrderMultishipOptionService orderMultishipOptionService;

  @Mock private ShippingInfoFormValidator shippingInfoFormValidator;

  @Mock private StateService stateService;

  /**
   * Test {@link BroadleafShippingInfoController#convertToSingleship(HttpServletRequest,
   * HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Then return {@code redirect:/checkout}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#convertToSingleship(HttpServletRequest, HttpServletResponse,
   * Model)}
   */
  @Test
  @DisplayName(
      "Test convertToSingleship(HttpServletRequest, HttpServletResponse, Model); then return 'redirect:/checkout'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.convertToSingleship(HttpServletRequest, HttpServletResponse, Model)"
  })
  void testConvertToSingleship_thenReturnRedirectCheckout() throws PricingException {
    // Arrange
    BroadleafCheckoutControllerExtensionHandler broadleafCheckoutControllerExtensionHandler =
        mock(BroadleafCheckoutControllerExtensionHandler.class);
    when(broadleafCheckoutControllerExtensionHandler.performAdditionalShippingAction())
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(broadleafCheckoutControllerExtensionManager.getProxy())
        .thenReturn(broadleafCheckoutControllerExtensionHandler);
    when(fulfillmentGroupService.collapseToOneShippableFulfillmentGroup(
            Mockito.<Order>any(), anyBoolean()))
        .thenReturn(new NullOrderImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualConvertToSingleshipResult =
        broadleafShippingInfoController.convertToSingleship(
            request, response, new ConcurrentModel());

    // Assert
    verify(broadleafCheckoutControllerExtensionManager).getProxy();
    verify(fulfillmentGroupService).collapseToOneShippableFulfillmentGroup(isNull(), eq(true));
    verify(broadleafCheckoutControllerExtensionHandler).performAdditionalShippingAction();
    assertEquals("redirect:/checkout", actualConvertToSingleshipResult);
  }

  /**
   * Test {@link BroadleafShippingInfoController#convertToSingleship(HttpServletRequest,
   * HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Then throw {@link PricingException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#convertToSingleship(HttpServletRequest, HttpServletResponse,
   * Model)}
   */
  @Test
  @DisplayName(
      "Test convertToSingleship(HttpServletRequest, HttpServletResponse, Model); then throw PricingException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.convertToSingleship(HttpServletRequest, HttpServletResponse, Model)"
  })
  void testConvertToSingleship_thenThrowPricingException() throws PricingException {
    // Arrange
    when(fulfillmentGroupService.collapseToOneShippableFulfillmentGroup(
            Mockito.<Order>any(), anyBoolean()))
        .thenThrow(new PricingException("An error occurred"));
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(
        PricingException.class,
        () ->
            broadleafShippingInfoController.convertToSingleship(
                request, response, new ConcurrentModel()));
    verify(fulfillmentGroupService).collapseToOneShippableFulfillmentGroup(isNull(), eq(true));
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveSingleShip(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then calls {@link ShippingInfoForm#getAddress()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafShippingInfoController#saveSingleShip(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveSingleShip(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult); then calls getAddress()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveSingleShip(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  void testSaveSingleShip_thenCallsGetAddress() throws ServiceException, PricingException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    doNothing()
        .when(shippingInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    AddressImpl addressImpl = mock(AddressImpl.class);
    doNothing().when(addressImpl).setPrimaryPhone(Mockito.<String>any());
    addressImpl.setPrimaryPhone("");

    ShippingInfoForm shippingForm = mock(ShippingInfoForm.class);
    when(shippingForm.shouldUseBillingAddress()).thenReturn(false);
    when(shippingForm.getAddress()).thenReturn(addressImpl);

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("Object Name", "Default Message"));

    // Act
    String actualSaveSingleShipResult =
        broadleafShippingInfoController.saveSingleShip(
            request, response, model, shippingForm, result);

    // Assert
    verify(shippingForm).getAddress();
    verify(shippingForm).shouldUseBillingAddress();
    verify(shippingInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressImpl).setPrimaryPhone("");
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    assertEquals("checkout/checkout", actualSaveSingleShipResult);
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveSingleShip(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then return {@code checkout/checkout}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafShippingInfoController#saveSingleShip(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveSingleShip(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult); then return 'checkout/checkout'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveSingleShip(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  void testSaveSingleShip_thenReturnCheckoutCheckout() throws ServiceException, PricingException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    doNothing()
        .when(shippingInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    ShippingInfoForm shippingForm = new ShippingInfoForm();

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("Object Name", "Default Message"));

    // Act
    String actualSaveSingleShipResult =
        broadleafShippingInfoController.saveSingleShip(
            request, response, model, shippingForm, result);

    // Assert
    verify(shippingInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    assertEquals("checkout/checkout", actualSaveSingleShipResult);
  }

  /**
   * Test {@link BroadleafShippingInfoController#copyBillingAddressToShippingAddress(Order,
   * ShippingInfoForm)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderPaymentImpl#isActive()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#copyBillingAddressToShippingAddress(Order, ShippingInfoForm)}
   */
  @Test
  @DisplayName(
      "Test copyBillingAddressToShippingAddress(Order, ShippingInfoForm); then calls isActive()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafShippingInfoController.copyBillingAddressToShippingAddress(Order, ShippingInfoForm)"
  })
  void testCopyBillingAddressToShippingAddress_thenCallsIsActive() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);

    ArrayList<OrderPayment> payments = new ArrayList<>();
    payments.add(orderPaymentImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setStatus(new OrderStatus("Type", "Friendly Type"));
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setPayments(payments);

    // Act
    broadleafShippingInfoController.copyBillingAddressToShippingAddress(
        order, new ShippingInfoForm());

    // Assert
    verify(orderPaymentImpl).isActive();
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveMultiship(HttpServletRequest,
   * HttpServletResponse, Model, OrderMultishipOptionForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then return {@code redirect:/checkout}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafShippingInfoController#saveMultiship(HttpServletRequest,
   * HttpServletResponse, Model, OrderMultishipOptionForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveMultiship(HttpServletRequest, HttpServletResponse, Model, OrderMultishipOptionForm, BindingResult); then return 'redirect:/checkout'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultiship(HttpServletRequest, HttpServletResponse, Model, OrderMultishipOptionForm, BindingResult)"
  })
  void testSaveMultiship_thenReturnRedirectCheckout() throws ServiceException, PricingException {
    // Arrange
    BroadleafCheckoutControllerExtensionHandler broadleafCheckoutControllerExtensionHandler =
        mock(BroadleafCheckoutControllerExtensionHandler.class);
    when(broadleafCheckoutControllerExtensionHandler.performAdditionalShippingAction())
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(broadleafCheckoutControllerExtensionManager.getProxy())
        .thenReturn(broadleafCheckoutControllerExtensionHandler);
    when(fulfillmentGroupService.matchFulfillmentGroupsToMultishipOptions(
            Mockito.<Order>any(), anyBoolean()))
        .thenReturn(new NullOrderImpl());
    doNothing()
        .when(orderMultishipOptionService)
        .saveOrderMultishipOptions(
            Mockito.<Order>any(), Mockito.<List<OrderMultishipOptionDTO>>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    OrderMultishipOptionForm orderMultishipOptionForm = new OrderMultishipOptionForm();
    orderMultishipOptionForm.setOptions(new ArrayList<>());

    // Act
    String actualSaveMultishipResult =
        broadleafShippingInfoController.saveMultiship(
            request,
            response,
            model,
            orderMultishipOptionForm,
            new BindException("Target", "Object Name"));

    // Assert
    verify(broadleafCheckoutControllerExtensionManager).getProxy();
    verify(fulfillmentGroupService).matchFulfillmentGroupsToMultishipOptions(isNull(), eq(true));
    verify(orderMultishipOptionService).saveOrderMultishipOptions(isNull(), isA(List.class));
    verify(broadleafCheckoutControllerExtensionHandler).performAdditionalShippingAction();
    assertEquals("redirect:/checkout", actualSaveMultishipResult);
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveMultiship(HttpServletRequest,
   * HttpServletResponse, Model, OrderMultishipOptionForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then throw {@link PricingException}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafShippingInfoController#saveMultiship(HttpServletRequest,
   * HttpServletResponse, Model, OrderMultishipOptionForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveMultiship(HttpServletRequest, HttpServletResponse, Model, OrderMultishipOptionForm, BindingResult); then throw PricingException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultiship(HttpServletRequest, HttpServletResponse, Model, OrderMultishipOptionForm, BindingResult)"
  })
  void testSaveMultiship_thenThrowPricingException() throws ServiceException, PricingException {
    // Arrange
    when(fulfillmentGroupService.matchFulfillmentGroupsToMultishipOptions(
            Mockito.<Order>any(), anyBoolean()))
        .thenThrow(new PricingException("An error occurred"));
    doNothing()
        .when(orderMultishipOptionService)
        .saveOrderMultishipOptions(
            Mockito.<Order>any(), Mockito.<List<OrderMultishipOptionDTO>>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    OrderMultishipOptionForm orderMultishipOptionForm = new OrderMultishipOptionForm();
    orderMultishipOptionForm.setOptions(new ArrayList<>());

    // Act and Assert
    assertThrows(
        PricingException.class,
        () ->
            broadleafShippingInfoController.saveMultiship(
                request,
                response,
                model,
                orderMultishipOptionForm,
                new BindException("Target", "Object Name")));
    verify(fulfillmentGroupService).matchFulfillmentGroupsToMultishipOptions(isNull(), eq(true));
    verify(orderMultishipOptionService).saveOrderMultishipOptions(isNull(), isA(List.class));
  }

  /**
   * Test {@link BroadleafShippingInfoController#showMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model)}.
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#showMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test showMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.showMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model)"
  })
  void testShowMultishipAddAddress() {
    // Arrange
    ArrayList<Country> countryList = new ArrayList<>();
    when(countryService.findCountries()).thenReturn(countryList);
    ArrayList<CountrySubdivision> countrySubdivisionList = new ArrayList<>();
    when(countrySubdivisionService.findSubdivisions()).thenReturn(countrySubdivisionList);
    ArrayList<State> stateList = new ArrayList<>();
    when(stateService.findStates()).thenReturn(stateList);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualShowMultishipAddAddressResult =
        broadleafShippingInfoController.showMultishipAddAddress(request, response, model);

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
   * Test {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  void testSaveMultishipAddAddress() throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(multishipAddAddressFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setFax("?_=");

    ShippingInfoForm addressForm = mock(ShippingInfoForm.class);
    when(addressForm.getAddressName()).thenReturn("42 Main St");
    when(addressForm.getAddress()).thenReturn(addressImpl);

    BindException result = mock(BindException.class);
    when(result.hasErrors()).thenReturn(false);
    doNothing().when(result).addError(Mockito.<ObjectError>any());
    result.addError(new ObjectError("?_=", "?_="));

    // Act
    broadleafShippingInfoController.saveMultishipAddAddress(
        request, response, model, addressForm, result);

    // Assert
    verify(addressForm, atLeast(1)).getAddress();
    verify(addressForm).getAddressName();
    verify(multishipAddAddressFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerAddressService).create();
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
    verify(result).addError(isA(ObjectError.class));
    verify(result).hasErrors();
    assertTrue(model.isEmpty());
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult); given AddressImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  void testSaveMultishipAddAddress_givenAddressImpl() throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(multishipAddAddressFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    ShippingInfoForm addressForm = mock(ShippingInfoForm.class);
    when(addressForm.getAddressName()).thenReturn("42 Main St");
    when(addressForm.getAddress()).thenReturn(new AddressImpl());

    BindException result = mock(BindException.class);
    when(result.hasErrors()).thenReturn(false);
    doNothing().when(result).addError(Mockito.<ObjectError>any());
    result.addError(new ObjectError("?_=", "?_="));

    // Act
    broadleafShippingInfoController.saveMultishipAddAddress(
        request, response, model, addressForm, result);

    // Assert
    verify(addressForm, atLeast(1)).getAddress();
    verify(addressForm).getAddressName();
    verify(multishipAddAddressFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerAddressService).create();
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
    verify(result).addError(isA(ObjectError.class));
    verify(result).hasErrors();
    assertTrue(model.isEmpty());
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPhoneFax()} return {@link PhoneImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult); given AddressImpl getPhoneFax() return PhoneImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  void testSaveMultishipAddAddress_givenAddressImplGetPhoneFaxReturnPhoneImpl()
      throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(multishipAddAddressFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
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

    BindException result = mock(BindException.class);
    when(result.hasErrors()).thenReturn(false);
    doNothing().when(result).addError(Mockito.<ObjectError>any());
    result.addError(new ObjectError("?_=", "?_="));

    // Act
    broadleafShippingInfoController.saveMultishipAddAddress(
        request, response, model, addressForm, result);

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
    verify(result).addError(isA(ObjectError.class));
    verify(result).hasErrors();
    assertTrue(model.isEmpty());
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) PrimaryPhone is {@code 6625550144}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult); given AddressImpl (default constructor) PrimaryPhone is '6625550144'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  void testSaveMultishipAddAddress_givenAddressImplPrimaryPhoneIs6625550144()
      throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(multishipAddAddressFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setPrimaryPhone("6625550144");

    ShippingInfoForm addressForm = mock(ShippingInfoForm.class);
    when(addressForm.getAddressName()).thenReturn("42 Main St");
    when(addressForm.getAddress()).thenReturn(addressImpl);

    BindException result = mock(BindException.class);
    when(result.hasErrors()).thenReturn(false);
    doNothing().when(result).addError(Mockito.<ObjectError>any());
    result.addError(new ObjectError("?_=", "?_="));

    // Act
    broadleafShippingInfoController.saveMultishipAddAddress(
        request, response, model, addressForm, result);

    // Assert
    verify(addressForm, atLeast(1)).getAddress();
    verify(addressForm).getAddressName();
    verify(multishipAddAddressFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerAddressService).create();
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
    verify(result).addError(isA(ObjectError.class));
    verify(result).hasErrors();
    assertTrue(model.isEmpty());
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) SecondaryPhone is {@code 6625550144}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult); given AddressImpl (default constructor) SecondaryPhone is '6625550144'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  void testSaveMultishipAddAddress_givenAddressImplSecondaryPhoneIs6625550144()
      throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(multishipAddAddressFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setSecondaryPhone("6625550144");

    ShippingInfoForm addressForm = mock(ShippingInfoForm.class);
    when(addressForm.getAddressName()).thenReturn("42 Main St");
    when(addressForm.getAddress()).thenReturn(addressImpl);

    BindException result = mock(BindException.class);
    when(result.hasErrors()).thenReturn(false);
    doNothing().when(result).addError(Mockito.<ObjectError>any());
    result.addError(new ObjectError("?_=", "?_="));

    // Act
    broadleafShippingInfoController.saveMultishipAddAddress(
        request, response, model, addressForm, result);

    // Assert
    verify(addressForm, atLeast(1)).getAddress();
    verify(addressForm).getAddressName();
    verify(multishipAddAddressFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerAddressService).create();
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
    verify(result).addError(isA(ObjectError.class));
    verify(result).hasErrors();
    assertTrue(model.isEmpty());
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor).
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult); given AddressImpl (default constructor); then ConcurrentModel() size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  void testSaveMultishipAddAddress_givenAddressImpl_thenConcurrentModelSizeIsThree()
      throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    ArrayList<Country> countryList = new ArrayList<>();
    when(countryService.findCountries()).thenReturn(countryList);
    ArrayList<CountrySubdivision> countrySubdivisionList = new ArrayList<>();
    when(countrySubdivisionService.findSubdivisions()).thenReturn(countrySubdivisionList);
    doNothing()
        .when(multishipAddAddressFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    ArrayList<State> stateList = new ArrayList<>();
    when(stateService.findStates()).thenReturn(stateList);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    ShippingInfoForm addressForm = mock(ShippingInfoForm.class);
    when(addressForm.getAddress()).thenReturn(new AddressImpl());

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("?_=", "?_="));

    // Act
    String actualSaveMultishipAddAddressResult =
        broadleafShippingInfoController.saveMultishipAddAddress(
            request, response, model, addressForm, result);

    // Assert
    verify(addressForm).getAddress();
    verify(multishipAddAddressFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountries();
    verify(countrySubdivisionService).findSubdivisions();
    verify(stateService).findStates();
    assertEquals(3, model.size());
    Object getResult = model.get("countries");
    assertTrue(getResult instanceof List);
    assertEquals("checkout/multishipAddAddressForm", actualSaveMultishipAddAddressResult);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(countryList, getResult);
    assertSame(countrySubdivisionList, model.get("countrySubdivisions"));
    assertSame(stateList, model.get("states"));
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then calls {@link Phone#getPhoneNumber()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult); then calls getPhoneNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  void testSaveMultishipAddAddress_thenCallsGetPhoneNumber() throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(multishipAddAddressFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    Phone phone = mock(Phone.class);
    when(phone.getPhoneNumber()).thenReturn("");

    AddressImpl addressImpl = mock(AddressImpl.class);
    doNothing().when(addressImpl).setPhoneFax(Mockito.<Phone>any());
    doNothing().when(addressImpl).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(addressImpl).setPhoneSecondary(Mockito.<Phone>any());
    when(addressImpl.getPhoneFax()).thenReturn(phone);
    when(addressImpl.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhoneSecondary()).thenReturn(new PhoneImpl());

    ShippingInfoForm addressForm = mock(ShippingInfoForm.class);
    when(addressForm.getAddressName()).thenReturn("42 Main St");
    when(addressForm.getAddress()).thenReturn(addressImpl);

    BindException result = mock(BindException.class);
    when(result.hasErrors()).thenReturn(false);
    doNothing().when(result).addError(Mockito.<ObjectError>any());
    result.addError(new ObjectError("?_=", "?_="));

    // Act
    broadleafShippingInfoController.saveMultishipAddAddress(
        request, response, model, addressForm, result);

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
    verify(phone).getPhoneNumber();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerAddressService).create();
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
    verify(result).addError(isA(ObjectError.class));
    verify(result).hasErrors();
    assertTrue(model.isEmpty());
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult); then ConcurrentModel() size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  void testSaveMultishipAddAddress_thenConcurrentModelSizeIsThree() throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    ArrayList<Country> countryList = new ArrayList<>();
    when(countryService.findCountries()).thenReturn(countryList);
    ArrayList<CountrySubdivision> countrySubdivisionList = new ArrayList<>();
    when(countrySubdivisionService.findSubdivisions()).thenReturn(countrySubdivisionList);
    doNothing()
        .when(multishipAddAddressFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    ArrayList<State> stateList = new ArrayList<>();
    when(stateService.findStates()).thenReturn(stateList);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    ShippingInfoForm addressForm = new ShippingInfoForm();

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("?_=", "?_="));

    // Act
    String actualSaveMultishipAddAddressResult =
        broadleafShippingInfoController.saveMultishipAddAddress(
            request, response, model, addressForm, result);

    // Assert
    verify(multishipAddAddressFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountries();
    verify(countrySubdivisionService).findSubdivisions();
    verify(stateService).findStates();
    assertEquals(3, model.size());
    Object getResult = model.get("countries");
    assertTrue(getResult instanceof List);
    assertEquals("checkout/multishipAddAddressForm", actualSaveMultishipAddAddressResult);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(countryList, getResult);
    assertSame(countrySubdivisionList, model.get("countrySubdivisions"));
    assertSame(stateList, model.get("states"));
  }

  /**
   * Test {@link BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then {@link ShippingInfoForm} (default constructor) Address {@link AddressImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#saveMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model, ShippingInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult); then ShippingInfoForm (default constructor) Address AddressImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  void testSaveMultishipAddAddress_thenShippingInfoFormAddressAddressImpl()
      throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(multishipAddAddressFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    ShippingInfoForm addressForm = new ShippingInfoForm();

    // Act
    broadleafShippingInfoController.saveMultishipAddAddress(
        request, response, model, addressForm, new BindException("Target", "Object Name"));

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
    assertTrue(model.isEmpty());
  }

  /**
   * Test {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(ShippingInfoForm); given AddressImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) Fax is {@code Fax}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName(
      "Test removeUnusedPhones(ShippingInfoForm); given AddressImpl (default constructor) Fax is 'Fax'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPhoneFax()} return {@link PhoneImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName(
      "Test removeUnusedPhones(ShippingInfoForm); given AddressImpl getPhoneFax() return PhoneImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafShippingInfoController.removeUnusedPhones(ShippingInfoForm)"})
  void testRemoveUnusedPhones_givenAddressImplGetPhoneFaxReturnPhoneImpl() {
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
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) PrimaryPhone is {@code 6625550144}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName(
      "Test removeUnusedPhones(ShippingInfoForm); given AddressImpl (default constructor) PrimaryPhone is '6625550144'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) SecondaryPhone is {@code 6625550144}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName(
      "Test removeUnusedPhones(ShippingInfoForm); given AddressImpl (default constructor) SecondaryPhone is '6625550144'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then calls {@link Phone#getPhoneNumber()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(ShippingInfoForm); then calls getPhoneNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafShippingInfoController.removeUnusedPhones(ShippingInfoForm)"})
  void testRemoveUnusedPhones_thenCallsGetPhoneNumber() {
    // Arrange
    Phone phone = mock(Phone.class);
    when(phone.getPhoneNumber()).thenReturn("");

    AddressImpl addressImpl = mock(AddressImpl.class);
    doNothing().when(addressImpl).setPhoneFax(Mockito.<Phone>any());
    doNothing().when(addressImpl).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(addressImpl).setPhoneSecondary(Mockito.<Phone>any());
    when(addressImpl.getPhoneFax()).thenReturn(phone);
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
    verify(phone).getPhoneNumber();
  }

  /**
   * Test {@link BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}.
   *
   * <ul>
   *   <li>Then {@link ShippingInfoForm} (default constructor) Address {@link AddressImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#removeUnusedPhones(ShippingInfoForm)}
   */
  @Test
  @DisplayName(
      "Test removeUnusedPhones(ShippingInfoForm); then ShippingInfoForm (default constructor) Address AddressImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafShippingInfoController.<init>()",
    "String BroadleafShippingInfoController.getMultishipAddAddressSuccessView()",
    "String BroadleafShippingInfoController.getMultishipAddAddressView()",
    "String BroadleafShippingInfoController.getMultishipSuccessView()",
    "String BroadleafShippingInfoController.getMultishipView()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafShippingInfoController actualBroadleafShippingInfoController =
        new BroadleafShippingInfoController();
    String actualMultishipAddAddressSuccessView =
        actualBroadleafShippingInfoController.getMultishipAddAddressSuccessView();
    String actualMultishipAddAddressView =
        actualBroadleafShippingInfoController.getMultishipAddAddressView();
    String actualMultishipSuccessView =
        actualBroadleafShippingInfoController.getMultishipSuccessView();

    // Assert
    assertEquals("checkout/multiship", actualBroadleafShippingInfoController.getMultishipView());
    assertEquals("checkout/multishipAddAddressForm", actualMultishipAddAddressView);
    assertEquals("redirect:/checkout", actualMultishipSuccessView);
    assertEquals("redirect:/checkout/multiship", actualMultishipAddAddressSuccessView);
  }
}
