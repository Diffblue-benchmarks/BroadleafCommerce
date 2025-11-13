package org.broadleafcommerce.core.web.controller.checkout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.checkout.model.ShippingInfoForm;
import org.broadleafcommerce.core.web.checkout.validator.MultishipAddAddressFormValidator;
import org.broadleafcommerce.core.web.checkout.validator.ShippingInfoFormValidator;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafShippingInfoControllerDiffblueTest {
  @Mock private AddressService addressService;

  @Mock
  private BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;

  @InjectMocks private BroadleafShippingInfoController broadleafShippingInfoController;

  @Mock private CountryService countryService;

  @Mock private CountrySubdivisionService countrySubdivisionService;

  @Mock private CustomerAddressService customerAddressService;

  @Mock private FulfillmentGroupService fulfillmentGroupService;

  @Mock private MultishipAddAddressFormValidator multishipAddAddressFormValidator;

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.convertToSingleship(HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testConvertToSingleship_thenReturnRedirectCheckout() throws PricingException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.convertToSingleship(HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testConvertToSingleship_thenThrowPricingException() throws PricingException {
    // Arrange
    when(fulfillmentGroupService.collapseToOneShippableFulfillmentGroup(
            Mockito.<Order>any(), anyBoolean()))
        .thenThrow(new PricingException());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveSingleShip(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  public void testSaveSingleShip_thenCallsGetAddress() throws ServiceException, PricingException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    doNothing()
        .when(shippingInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveSingleShip(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  public void testSaveSingleShip_thenReturnCheckoutCheckout()
      throws ServiceException, PricingException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    doNothing()
        .when(shippingInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
   * Test {@link BroadleafShippingInfoController#showMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model)}.
   *
   * <p>Method under test: {@link
   * BroadleafShippingInfoController#showMultishipAddAddress(HttpServletRequest,
   * HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.showMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testShowMultishipAddAddress() {
    // Arrange
    ArrayList<Country> countryList = new ArrayList<>();
    when(countryService.findCountries()).thenReturn(countryList);
    ArrayList<CountrySubdivision> countrySubdivisionList = new ArrayList<>();
    when(countrySubdivisionService.findSubdivisions()).thenReturn(countrySubdivisionList);
    ArrayList<State> stateList = new ArrayList<>();
    when(stateService.findStates()).thenReturn(stateList);
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  public void testSaveMultishipAddAddress() throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(multishipAddAddressFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  public void testSaveMultishipAddAddress_givenAddressImpl() throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(multishipAddAddressFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  public void testSaveMultishipAddAddress_givenAddressImplGetPhoneFaxReturnPhoneImpl()
      throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(multishipAddAddressFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  public void testSaveMultishipAddAddress_givenAddressImplPrimaryPhoneIs6625550144()
      throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(multishipAddAddressFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  public void testSaveMultishipAddAddress_givenAddressImplSecondaryPhoneIs6625550144()
      throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(multishipAddAddressFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  public void testSaveMultishipAddAddress_givenAddressImpl_thenConcurrentModelSizeIsThree()
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
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  public void testSaveMultishipAddAddress_thenCallsGetPhoneNumber() throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(multishipAddAddressFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  public void testSaveMultishipAddAddress_thenConcurrentModelSizeIsThree() throws ServiceException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafShippingInfoController.saveMultishipAddAddress(HttpServletRequest, HttpServletResponse, Model, ShippingInfoForm, BindingResult)"
  })
  public void testSaveMultishipAddAddress_thenShippingInfoFormAddressAddressImpl()
      throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.create()).thenReturn(new CustomerAddressImpl());
    doNothing()
        .when(multishipAddAddressFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafShippingInfoController.removeUnusedPhones(ShippingInfoForm)"})
  public void testRemoveUnusedPhones_givenAddressImpl() {
    // Arrange
    BroadleafShippingInfoController broadleafShippingInfoController =
        new BroadleafShippingInfoController();

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafShippingInfoController.removeUnusedPhones(ShippingInfoForm)"})
  public void testRemoveUnusedPhones_givenAddressImplFaxIsFax() {
    // Arrange
    BroadleafShippingInfoController broadleafShippingInfoController =
        new BroadleafShippingInfoController();

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafShippingInfoController.removeUnusedPhones(ShippingInfoForm)"})
  public void testRemoveUnusedPhones_givenAddressImplGetPhoneFaxReturnPhoneImpl() {
    // Arrange
    BroadleafShippingInfoController broadleafShippingInfoController =
        new BroadleafShippingInfoController();

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafShippingInfoController.removeUnusedPhones(ShippingInfoForm)"})
  public void testRemoveUnusedPhones_givenAddressImplPrimaryPhoneIs6625550144() {
    // Arrange
    BroadleafShippingInfoController broadleafShippingInfoController =
        new BroadleafShippingInfoController();

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafShippingInfoController.removeUnusedPhones(ShippingInfoForm)"})
  public void testRemoveUnusedPhones_givenAddressImplSecondaryPhoneIs6625550144() {
    // Arrange
    BroadleafShippingInfoController broadleafShippingInfoController =
        new BroadleafShippingInfoController();

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafShippingInfoController.removeUnusedPhones(ShippingInfoForm)"})
  public void testRemoveUnusedPhones_thenCallsGetPhoneNumber() {
    // Arrange
    BroadleafShippingInfoController broadleafShippingInfoController =
        new BroadleafShippingInfoController();

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafShippingInfoController.removeUnusedPhones(ShippingInfoForm)"})
  public void testRemoveUnusedPhones_thenShippingInfoFormAddressAddressImpl() {
    // Arrange
    BroadleafShippingInfoController broadleafShippingInfoController =
        new BroadleafShippingInfoController();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafShippingInfoController.<init>()",
    "String BroadleafShippingInfoController.getMultishipAddAddressSuccessView()",
    "String BroadleafShippingInfoController.getMultishipAddAddressView()",
    "String BroadleafShippingInfoController.getMultishipSuccessView()",
    "String BroadleafShippingInfoController.getMultishipView()"
  })
  public void testGettersAndSetters() {
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
