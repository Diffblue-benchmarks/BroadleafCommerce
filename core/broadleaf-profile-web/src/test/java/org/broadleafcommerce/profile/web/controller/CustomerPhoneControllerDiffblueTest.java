package org.broadleafcommerce.profile.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.service.CustomerPhoneService;
import org.broadleafcommerce.profile.core.service.CustomerPhoneServiceImpl;
import org.broadleafcommerce.profile.web.controller.validator.CustomerPhoneValidator;
import org.broadleafcommerce.profile.web.controller.validator.PhoneValidator;
import org.broadleafcommerce.profile.web.core.CustomerState;
import org.broadleafcommerce.profile.web.core.model.PhoneNameForm;
import org.broadleafcommerce.profile.web.core.util.PhoneFormatter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

@ContextConfiguration(classes = {CustomerPhoneController.class})
@ExtendWith(SpringExtension.class)
class CustomerPhoneControllerDiffblueTest {
  @Autowired
  private CustomerPhoneController customerPhoneController;

  @MockBean
  private CustomerPhoneService customerPhoneService;

  @MockBean(name = "blCustomerPhoneValidator")
  private CustomerPhoneValidator customerPhoneValidator;

  @MockBean(name = "blCustomerState")
  private CustomerState customerState;

  @MockBean(name = "blEntityConfiguration")
  private EntityConfiguration entityConfiguration;

  @MockBean
  private PhoneFormatter phoneFormatter;

  @MockBean(name = "blPhoneValidator")
  private PhoneValidator phoneValidator;

  /**
   * Test {@link CustomerPhoneController#deletePhone(Long, HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link CustomerPhoneController#deletePhone(Long, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test deletePhone(Long, HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testDeletePhone() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.profile.web.controller.CustomerPhoneController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.controller.CustomerPhoneController customerPhoneController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerPhoneService customerPhoneService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCustomerPhoneValidator") org.broadleafcommerce.profile.web.controller.validator.CustomerPhoneValidator customerPhoneValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCustomerState") org.broadleafcommerce.profile.web.core.CustomerState customerState;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.web.core.util.PhoneFormatter phoneFormatter;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blPhoneValidator") org.broadleafcommerce.profile.web.controller.validator.PhoneValidator phoneValidator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/myaccount/phone/deletePhone");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("customerPhoneId", String.valueOf(1L));

    // Act
    MockMvcBuilders.standaloneSetup(customerPhoneController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link CustomerPhoneController#initPhoneNameForm(HttpServletRequest, Model)}.
   * <p>
   * Method under test:
   * {@link CustomerPhoneController#initPhoneNameForm(HttpServletRequest, Model)}
   */
  @Test
  @DisplayName("Test initPhoneNameForm(HttpServletRequest, Model)")
  @Disabled("TODO: Complete this test")
  void testInitPhoneNameForm() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.profile.web.controller.CustomerPhoneController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.controller.CustomerPhoneController customerPhoneController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerPhoneService customerPhoneService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCustomerPhoneValidator") org.broadleafcommerce.profile.web.controller.validator.CustomerPhoneValidator customerPhoneValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCustomerState") org.broadleafcommerce.profile.web.core.CustomerState customerState;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.web.core.util.PhoneFormatter phoneFormatter;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blPhoneValidator") org.broadleafcommerce.profile.web.controller.validator.PhoneValidator phoneValidator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    customerPhoneController.initPhoneNameForm(request, new ConcurrentModel());
  }

  /**
   * Test
   * {@link CustomerPhoneController#initPhoneNameForm(HttpServletRequest, Model)}.
   * <ul>
   *   <li>Given {@link PhoneImpl} (default constructor) Active is
   * {@code true}.</li>
   *   <li>Then return PhoneName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPhoneController#initPhoneNameForm(HttpServletRequest, Model)}
   */
  @Test
  @DisplayName("Test initPhoneNameForm(HttpServletRequest, Model); given PhoneImpl (default constructor) Active is 'true'; then return PhoneName is 'null'")
  void testInitPhoneNameForm_givenPhoneImplActiveIsTrue_thenReturnPhoneNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("org.broadleafcommerce.profile.core.domain.Phone");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("6625550144");
    EntityConfiguration entityConfiguration = mock(EntityConfiguration.class);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(phoneImpl);

    CustomerPhoneController customerPhoneController = new CustomerPhoneController();
    customerPhoneController.setEntityConfiguration(entityConfiguration);
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    PhoneNameForm actualInitPhoneNameFormResult = customerPhoneController.initPhoneNameForm(request,
        new ConcurrentModel());

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.profile.core.domain.Phone"));
    assertNull(actualInitPhoneNameFormResult.getPhoneName());
    assertSame(phoneImpl, actualInitPhoneNameFormResult.getPhone());
  }

  /**
   * Test
   * {@link CustomerPhoneController#makePhoneDefault(Long, HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link CustomerPhoneController#makePhoneDefault(Long, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test makePhoneDefault(Long, HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testMakePhoneDefault() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.profile.web.controller.CustomerPhoneController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.controller.CustomerPhoneController customerPhoneController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerPhoneService customerPhoneService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCustomerPhoneValidator") org.broadleafcommerce.profile.web.controller.validator.CustomerPhoneValidator customerPhoneValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCustomerState") org.broadleafcommerce.profile.web.core.CustomerState customerState;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.web.core.util.PhoneFormatter phoneFormatter;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blPhoneValidator") org.broadleafcommerce.profile.web.controller.validator.PhoneValidator phoneValidator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/myaccount/phone/makePhoneDefault");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("customerPhoneId", String.valueOf(1L));

    // Act
    MockMvcBuilders.standaloneSetup(customerPhoneController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}.
   * <p>
   * Method under test:
   * {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}
   */
  @Test
  @DisplayName("Test savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)")
  @Disabled("TODO: Complete this test")
  void testSavePhone() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.profile.web.controller.CustomerPhoneController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.controller.CustomerPhoneController customerPhoneController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerPhoneService customerPhoneService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCustomerPhoneValidator") org.broadleafcommerce.profile.web.controller.validator.CustomerPhoneValidator customerPhoneValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCustomerState") org.broadleafcommerce.profile.web.core.CustomerState customerState;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.web.core.util.PhoneFormatter phoneFormatter;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blPhoneValidator") org.broadleafcommerce.profile.web.controller.validator.PhoneValidator phoneValidator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/myaccount/phone/savePhone");

    // Act
    MockMvcBuilders.standaloneSetup(customerPhoneController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}.
   * <ul>
   *   <li>Given {@link PhoneImpl} {@link PhoneImpl#setId(Long)} does nothing.</li>
   *   <li>Then calls {@link PhoneImpl#setId(Long)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}
   */
  @Test
  @DisplayName("Test savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long); given PhoneImpl setId(Long) does nothing; then calls setId(Long)")
  void testSavePhone_givenPhoneImplSetIdDoesNothing_thenCallsSetId() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatter phoneFormatter = mock(PhoneFormatter.class);
    doNothing().when(phoneFormatter).formatPhoneNumber(Mockito.<Phone>any());
    PhoneValidator phoneValidator = mock(PhoneValidator.class);
    doNothing().when(phoneValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());

    CustomerPhoneController customerPhoneController = new CustomerPhoneController();
    customerPhoneController.setEntityConfiguration(mock(EntityConfiguration.class));
    customerPhoneController.setPhoneValidator(phoneValidator);
    customerPhoneController.setPhoneFormatter(phoneFormatter);
    PhoneImpl phoneImpl = mock(PhoneImpl.class);
    doNothing().when(phoneImpl).setId(Mockito.<Long>any());
    PhoneNameForm phoneNameForm = mock(PhoneNameForm.class);
    when(phoneNameForm.getPhone()).thenReturn(phoneImpl);
    when(phoneNameForm.getPhoneName()).thenReturn("");
    doNothing().when(phoneNameForm).setPhone(Mockito.<Phone>any());
    doNothing().when(phoneNameForm).setPhoneName(Mockito.<String>any());
    phoneNameForm.setPhone(new PhoneImpl());
    phoneNameForm.setPhoneName("6625550144");
    BindingResult errors = mock(BindingResult.class);
    when(errors.getFieldValue(Mockito.<String>any())).thenReturn("Field Value");
    when(errors.hasErrors()).thenReturn(true);
    doNothing().when(errors).popNestedPath();
    doNothing().when(errors).pushNestedPath(Mockito.<String>any());

    // Act
    String actualSavePhoneResult = customerPhoneController.savePhone(phoneNameForm, errors,
        new MockHttpServletRequest(), 1L, 1L);

    // Assert
    verify(phoneImpl).setId(eq(1L));
    verify(phoneValidator).validate(isA(Object.class), isA(Errors.class));
    verify(phoneNameForm, atLeast(1)).getPhone();
    verify(phoneNameForm).getPhoneName();
    verify(phoneNameForm).setPhone(isA(Phone.class));
    verify(phoneNameForm).setPhoneName(eq("6625550144"));
    verify(phoneFormatter).formatPhoneNumber(isA(Phone.class));
    verify(errors).getFieldValue(eq("phoneName"));
    verify(errors).hasErrors();
    verify(errors).popNestedPath();
    verify(errors).pushNestedPath(eq("phone"));
    assertEquals("myAccount/phone/customerPhones", actualSavePhoneResult);
  }

  /**
   * Test
   * {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}.
   * <ul>
   *   <li>Then return {@code myAccount/phone/customerPhones}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}
   */
  @Test
  @DisplayName("Test savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long); then return 'myAccount/phone/customerPhones'")
  void testSavePhone_thenReturnMyAccountPhoneCustomerPhones() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatter phoneFormatter = mock(PhoneFormatter.class);
    doNothing().when(phoneFormatter).formatPhoneNumber(Mockito.<Phone>any());
    PhoneValidator phoneValidator = mock(PhoneValidator.class);
    doNothing().when(phoneValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());

    CustomerPhoneController customerPhoneController = new CustomerPhoneController();
    customerPhoneController.setPhoneValidator(phoneValidator);
    customerPhoneController.setPhoneFormatter(phoneFormatter);
    PhoneNameForm phoneNameForm = mock(PhoneNameForm.class);
    when(phoneNameForm.getPhone()).thenReturn(new PhoneImpl());
    when(phoneNameForm.getPhoneName()).thenReturn("6625550144");
    doNothing().when(phoneNameForm).setPhone(Mockito.<Phone>any());
    doNothing().when(phoneNameForm).setPhoneName(Mockito.<String>any());
    phoneNameForm.setPhone(new PhoneImpl());
    phoneNameForm.setPhoneName("6625550144");

    BindException errors = new BindException("Target", "Object Name");
    errors.addError(new ObjectError("phone", "phone"));

    // Act
    String actualSavePhoneResult = customerPhoneController.savePhone(phoneNameForm, errors,
        new MockHttpServletRequest(), 1L, 1L);

    // Assert
    verify(phoneValidator).validate(isA(Object.class), isA(Errors.class));
    verify(phoneNameForm, atLeast(1)).getPhone();
    verify(phoneNameForm).getPhoneName();
    verify(phoneNameForm).setPhone(isA(Phone.class));
    verify(phoneNameForm).setPhoneName(eq("6625550144"));
    verify(phoneFormatter).formatPhoneNumber(isA(Phone.class));
    assertEquals("myAccount/phone/customerPhones", actualSavePhoneResult);
  }

  /**
   * Test
   * {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code myAccount/phone/customerPhones}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}
   */
  @Test
  @DisplayName("Test savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long); when 'null'; then return 'myAccount/phone/customerPhones'")
  void testSavePhone_whenNull_thenReturnMyAccountPhoneCustomerPhones() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatter phoneFormatter = mock(PhoneFormatter.class);
    doNothing().when(phoneFormatter).formatPhoneNumber(Mockito.<Phone>any());
    PhoneValidator phoneValidator = mock(PhoneValidator.class);
    doNothing().when(phoneValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());

    CustomerPhoneController customerPhoneController = new CustomerPhoneController();
    customerPhoneController.setPhoneValidator(phoneValidator);
    customerPhoneController.setPhoneFormatter(phoneFormatter);
    PhoneNameForm phoneNameForm = mock(PhoneNameForm.class);
    when(phoneNameForm.getPhone()).thenReturn(new PhoneImpl());
    when(phoneNameForm.getPhoneName()).thenReturn("6625550144");
    doNothing().when(phoneNameForm).setPhone(Mockito.<Phone>any());
    doNothing().when(phoneNameForm).setPhoneName(Mockito.<String>any());
    phoneNameForm.setPhone(new PhoneImpl());
    phoneNameForm.setPhoneName("6625550144");

    BindException errors = new BindException("Target", "Object Name");
    errors.addError(new ObjectError("phone", "phone"));

    // Act
    String actualSavePhoneResult = customerPhoneController.savePhone(phoneNameForm, errors,
        new MockHttpServletRequest(), 1L, null);

    // Assert
    verify(phoneValidator).validate(isA(Object.class), isA(Errors.class));
    verify(phoneNameForm, atLeast(1)).getPhone();
    verify(phoneNameForm).getPhoneName();
    verify(phoneNameForm).setPhone(isA(Phone.class));
    verify(phoneNameForm).setPhoneName(eq("6625550144"));
    verify(phoneFormatter).formatPhoneNumber(isA(Phone.class));
    assertEquals("myAccount/phone/customerPhones", actualSavePhoneResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link CustomerPhoneController#setCustomerPhoneService(CustomerPhoneService)}
   *   <li>
   * {@link CustomerPhoneController#setCustomerPhoneValidator(CustomerPhoneValidator)}
   *   <li>{@link CustomerPhoneController#setCustomerState(CustomerState)}
   *   <li>
   * {@link CustomerPhoneController#setEntityConfiguration(EntityConfiguration)}
   *   <li>{@link CustomerPhoneController#setPhoneFormatter(PhoneFormatter)}
   *   <li>{@link CustomerPhoneController#setPhoneValidator(PhoneValidator)}
   *   <li>{@link CustomerPhoneController#setdeletePhoneSuccessView(String)}
   *   <li>{@link CustomerPhoneController#setmakePhoneDefaultSuccessView(String)}
   *   <li>{@link CustomerPhoneController#setsavePhoneErrorView(String)}
   *   <li>{@link CustomerPhoneController#setsavePhoneSuccessView(String)}
   *   <li>{@link CustomerPhoneController#setviewPhoneErrorView(String)}
   *   <li>{@link CustomerPhoneController#setviewPhoneSuccessView(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     CustomerPhoneController.customerPhoneService
    //     CustomerPhoneController.customerPhoneValidator
    //     CustomerPhoneController.customerState
    //     CustomerPhoneController.deletePhoneSuccessView
    //     CustomerPhoneController.entityConfiguration
    //     CustomerPhoneController.makePhoneDefaultSuccessView
    //     CustomerPhoneController.phoneFormatter
    //     CustomerPhoneController.phoneValidator
    //     CustomerPhoneController.savePhoneErrorView
    //     CustomerPhoneController.savePhoneSuccessView
    //     CustomerPhoneController.viewPhoneErrorView
    //     CustomerPhoneController.viewPhoneSuccessView

    // Arrange
    CustomerPhoneController customerPhoneController = new CustomerPhoneController();

    // Act
    customerPhoneController.setCustomerPhoneService(new CustomerPhoneServiceImpl());
    customerPhoneController.setCustomerPhoneValidator(new CustomerPhoneValidator());
    customerPhoneController.setCustomerState(new CustomerState());
    customerPhoneController.setEntityConfiguration(new EntityConfiguration());
    customerPhoneController.setPhoneFormatter(mock(PhoneFormatter.class));
    customerPhoneController.setPhoneValidator(new PhoneValidator());
    customerPhoneController.setdeletePhoneSuccessView("6625550144");
    customerPhoneController.setmakePhoneDefaultSuccessView("6625550144");
    customerPhoneController.setsavePhoneErrorView("6625550144");
    customerPhoneController.setsavePhoneSuccessView("6625550144");
    customerPhoneController.setviewPhoneErrorView("6625550144");
    customerPhoneController.setviewPhoneSuccessView("6625550144");
  }

  /**
   * Test
   * {@link CustomerPhoneController#viewPhone(Long, HttpServletRequest, PhoneNameForm, BindingResult)}.
   * <p>
   * Method under test:
   * {@link CustomerPhoneController#viewPhone(Long, HttpServletRequest, PhoneNameForm, BindingResult)}
   */
  @Test
  @DisplayName("Test viewPhone(Long, HttpServletRequest, PhoneNameForm, BindingResult)")
  @Disabled("TODO: Complete this test")
  void testViewPhone() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.profile.web.controller.CustomerPhoneController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.controller.CustomerPhoneController customerPhoneController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerPhoneService customerPhoneService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCustomerPhoneValidator") org.broadleafcommerce.profile.web.controller.validator.CustomerPhoneValidator customerPhoneValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCustomerState") org.broadleafcommerce.profile.web.core.CustomerState customerState;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.web.core.util.PhoneFormatter phoneFormatter;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blPhoneValidator") org.broadleafcommerce.profile.web.controller.validator.PhoneValidator phoneValidator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/myaccount/phone/viewPhone");

    // Act
    MockMvcBuilders.standaloneSetup(customerPhoneController).build().perform(requestBuilder);
  }
}
