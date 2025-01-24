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
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.i18n.service.ISOService;
import org.broadleafcommerce.core.web.controller.account.validator.CustomerAddressValidator;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.core.web.service.InitBinderService;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerAddress;
import org.broadleafcommerce.profile.core.domain.CustomerAddressImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.service.AddressService;
import org.broadleafcommerce.profile.core.service.CountryService;
import org.broadleafcommerce.profile.core.service.CustomerAddressService;
import org.broadleafcommerce.profile.core.service.StateService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@ContextConfiguration(classes = {BroadleafManageCustomerAddressesController.class})
@ExtendWith(SpringExtension.class)
class BroadleafManageCustomerAddressesControllerDiffblueTest {
  @MockBean
  private AddressService addressService;

  @Autowired
  private BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController;

  @MockBean
  private CountryService countryService;

  @MockBean
  private CustomerAddressService customerAddressService;

  @MockBean(name = "blCustomerAddressValidator")
  private CustomerAddressValidator customerAddressValidator;

  @MockBean
  private ISOService iSOService;

  @MockBean
  private InitBinderService initBinderService;

  @MockBean
  private StateService stateService;

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
   * {@link BroadleafManageCustomerAddressesController#viewCustomerAddresses(HttpServletRequest, Model)}.
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#viewCustomerAddresses(HttpServletRequest, Model)}
   */
  @Test
  @DisplayName("Test viewCustomerAddresses(HttpServletRequest, Model)")
  @Disabled("TODO: Complete this test")
  void testViewCustomerAddresses3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.account;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.account.BroadleafManageCustomerAddressesController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3585 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.account.BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CountryService countryService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerAddressService customerAddressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCustomerAddressValidator") org.broadleafcommerce.core.web.controller.account.validator.CustomerAddressValidator customerAddressValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.i18n.service.ISOService iSOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.InitBinderService initBinderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.StateService stateService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    broadleafManageCustomerAddressesController.viewCustomerAddresses(request, new ConcurrentModel());
  }

  /**
   * Test
   * {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}.
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}
   */
  @Test
  @DisplayName("Test viewCustomerAddress(HttpServletRequest, Model, Long)")
  @Disabled("TODO: Complete this test")
  void testViewCustomerAddress() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.account;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.account.BroadleafManageCustomerAddressesController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3584 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.account.BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CountryService countryService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerAddressService customerAddressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCustomerAddressValidator") org.broadleafcommerce.core.web.controller.account.validator.CustomerAddressValidator customerAddressValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.i18n.service.ISOService iSOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.InitBinderService initBinderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.StateService stateService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    broadleafManageCustomerAddressesController.viewCustomerAddress(request, new ConcurrentModel(), 1L);
  }

  /**
   * Test
   * {@link BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes)")
  @Disabled("TODO: Complete this test")
  void testAddCustomerAddress() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.account;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.account.BroadleafManageCustomerAddressesController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3579 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.account.BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CountryService countryService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerAddressService customerAddressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCustomerAddressValidator") org.broadleafcommerce.core.web.controller.account.validator.CustomerAddressValidator customerAddressValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.i18n.service.ISOService iSOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.InitBinderService initBinderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.StateService stateService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
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
    broadleafManageCustomerAddressesController.addCustomerAddress(request, model, form, result,
        new RedirectAttributesModelMap());
  }

  /**
   * Test
   * {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)")
  @Disabled("TODO: Complete this test")
  void testUpdateCustomerAddress() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.account;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.account.BroadleafManageCustomerAddressesController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3582 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.account.BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CountryService countryService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerAddressService customerAddressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCustomerAddressValidator") org.broadleafcommerce.core.web.controller.account.validator.CustomerAddressValidator customerAddressValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.i18n.service.ISOService iSOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.InitBinderService initBinderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.StateService stateService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
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
    broadleafManageCustomerAddressesController.updateCustomerAddress(request, model, 1L, form, result,
        new RedirectAttributesModelMap());
  }

  /**
   * Test
   * {@link BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)}.
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)")
  @Disabled("TODO: Complete this test")
  void testRemoveCustomerAddress() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.account;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.account.BroadleafManageCustomerAddressesController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3580 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.account.BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CountryService countryService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerAddressService customerAddressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCustomerAddressValidator") org.broadleafcommerce.core.web.controller.account.validator.CustomerAddressValidator customerAddressValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.i18n.service.ISOService iSOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.InitBinderService initBinderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.StateService stateService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafManageCustomerAddressesController.removeCustomerAddress(request, model, 1L,
        new RedirectAttributesModelMap());
  }

  /**
   * Test
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm)")
  @Disabled("TODO: Complete this test")
  void testRemoveUnusedPhones() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.account;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.account.BroadleafManageCustomerAddressesController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3581 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.account.BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CountryService countryService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerAddressService customerAddressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCustomerAddressValidator") org.broadleafcommerce.core.web.controller.account.validator.CustomerAddressValidator customerAddressValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.i18n.service.ISOService iSOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.InitBinderService initBinderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.StateService stateService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act
    broadleafManageCustomerAddressesController.removeUnusedPhones(form);
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
   * Test
   * {@link BroadleafManageCustomerAddressesController#validateCustomerOwnedData(CustomerAddress)}.
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#validateCustomerOwnedData(CustomerAddress)}
   */
  @Test
  @DisplayName("Test validateCustomerOwnedData(CustomerAddress)")
  @Disabled("TODO: Complete this test")
  void testValidateCustomerOwnedData() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.account;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.account.BroadleafManageCustomerAddressesController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3583 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.AddressService addressService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.account.BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CountryService countryService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerAddressService customerAddressService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCustomerAddressValidator") org.broadleafcommerce.core.web.controller.account.validator.CustomerAddressValidator customerAddressValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.i18n.service.ISOService iSOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.InitBinderService initBinderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.StateService stateService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    broadleafManageCustomerAddressesController.validateCustomerOwnedData(new CustomerAddressImpl());
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
