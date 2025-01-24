package org.broadleafcommerce.profile.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.ChallengeQuestionService;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator;
import org.broadleafcommerce.profile.web.core.form.RegisterCustomerForm;
import org.broadleafcommerce.profile.web.core.service.login.LoginService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

@ContextConfiguration(classes = {RegisterCustomerController.class})
@ExtendWith(SpringExtension.class)
class RegisterCustomerControllerDiffblueTest {
  @MockBean
  private ChallengeQuestionService challengeQuestionService;

  @MockBean
  private CustomerService customerService;

  @MockBean
  private LoginService loginService;

  @Autowired
  private RegisterCustomerController registerCustomerController;

  @MockBean(name = "blRegisterCustomerValidator")
  private RegisterCustomerValidator registerCustomerValidator;

  /**
   * Test {@link RegisterCustomerController#registerCustomer()}.
   * <p>
   * Method under test: {@link RegisterCustomerController#registerCustomer()}
   */
  @Test
  @DisplayName("Test registerCustomer()")
  void testRegisterCustomer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RegisterCustomerController registerCustomerController = new RegisterCustomerController();
    registerCustomerController.setRegisterCustomerValidator(mock(RegisterCustomerValidator.class));

    // Act and Assert
    assertEquals("/account/registration/registerCustomer", registerCustomerController.registerCustomer());
  }

  /**
   * Test {@link RegisterCustomerController#registerCustomer()}.
   * <p>
   * Method under test: {@link RegisterCustomerController#registerCustomer()}
   */
  @Test
  @DisplayName("Test registerCustomer()")
  @Disabled("TODO: Complete this test")
  void testRegisterCustomer2() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.profile.web.controller.RegisterCustomerController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.ChallengeQuestionService challengeQuestionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.web.core.service.login.LoginService loginService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.controller.RegisterCustomerController registerCustomerController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blRegisterCustomerValidator") org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator registerCustomerValidator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/registerCustomer/registerCustomer");

    // Act
    MockMvcBuilders.standaloneSetup(registerCustomerController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link RegisterCustomerController#registerCustomer(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse)}
   * with {@code RegisterCustomerForm}, {@code BindingResult},
   * {@code HttpServletRequest}, {@code HttpServletResponse}.
   * <p>
   * Method under test:
   * {@link RegisterCustomerController#registerCustomer(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test registerCustomer(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse) with 'RegisterCustomerForm', 'BindingResult', 'HttpServletRequest', 'HttpServletResponse'")
  void testRegisterCustomerWithRegisterCustomerFormBindingResultHttpServletRequestHttpServletResponse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RegisterCustomerValidator registerCustomerValidator = mock(RegisterCustomerValidator.class);
    doNothing().when(registerCustomerValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());

    RegisterCustomerController registerCustomerController = new RegisterCustomerController();
    registerCustomerController.setRegisterCustomerValidator(registerCustomerValidator);
    RegisterCustomerForm registerCustomerForm = mock(RegisterCustomerForm.class);
    doNothing().when(registerCustomerForm).setCustomer(Mockito.<Customer>any());
    doNothing().when(registerCustomerForm).setPassword(Mockito.<String>any());
    doNothing().when(registerCustomerForm).setPasswordConfirm(Mockito.<String>any());
    doNothing().when(registerCustomerForm).setRedirectUrl(Mockito.<String>any());
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("https://example.org/example");

    BindException errors = new BindException("Target", "Object Name");
    errors.addError(new ObjectError("Object Name", "Default Message"));
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    ModelAndView actualRegisterCustomerResult = registerCustomerController.registerCustomer(registerCustomerForm,
        errors, request, new MockHttpServletResponse());

    // Assert
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class));
    verify(registerCustomerForm).setCustomer(isA(Customer.class));
    verify(registerCustomerForm).setPassword(eq("iloveyou"));
    verify(registerCustomerForm).setPasswordConfirm(eq("Password Confirm"));
    verify(registerCustomerForm).setRedirectUrl(eq("https://example.org/example"));
    assertEquals("/account/registration/registerCustomer", actualRegisterCustomerResult.getViewName());
    assertNull(actualRegisterCustomerResult.getStatus());
    assertNull(actualRegisterCustomerResult.getView());
    assertFalse(actualRegisterCustomerResult.isEmpty());
    Map<String, Object> model = actualRegisterCustomerResult.getModel();
    assertTrue(model.isEmpty());
    assertTrue(actualRegisterCustomerResult.hasView());
    assertTrue(actualRegisterCustomerResult.isReference());
    assertSame(model, actualRegisterCustomerResult.getModelMap());
  }

  /**
   * Test
   * {@link RegisterCustomerController#registerCustomer(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse)}
   * with {@code RegisterCustomerForm}, {@code BindingResult},
   * {@code HttpServletRequest}, {@code HttpServletResponse}.
   * <p>
   * Method under test:
   * {@link RegisterCustomerController#registerCustomer(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test registerCustomer(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse) with 'RegisterCustomerForm', 'BindingResult', 'HttpServletRequest', 'HttpServletResponse'")
  @Disabled("TODO: Complete this test")
  void testRegisterCustomerWithRegisterCustomerFormBindingResultHttpServletRequestHttpServletResponse2()
      throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.profile.web.controller.RegisterCustomerController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.ChallengeQuestionService challengeQuestionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.web.core.service.login.LoginService loginService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.controller.RegisterCustomerController registerCustomerController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blRegisterCustomerValidator") org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator registerCustomerValidator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/registerCustomer/registerCustomer");

    // Act
    MockMvcBuilders.standaloneSetup(registerCustomerController).build().perform(requestBuilder);
  }

  /**
   * Test {@link RegisterCustomerController#registerCustomer()}.
   * <ul>
   *   <li>Given {@link RegisterCustomerController} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RegisterCustomerController#registerCustomer()}
   */
  @Test
  @DisplayName("Test registerCustomer(); given RegisterCustomerController (default constructor)")
  void testRegisterCustomer_givenRegisterCustomerController() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/account/registration/registerCustomer", (new RegisterCustomerController()).registerCustomer());
  }

  /**
   * Test {@link RegisterCustomerController#registerCustomerSuccess()}.
   * <p>
   * Method under test:
   * {@link RegisterCustomerController#registerCustomerSuccess()}
   */
  @Test
  @DisplayName("Test registerCustomerSuccess()")
  void testRegisterCustomerSuccess() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RegisterCustomerController registerCustomerController = new RegisterCustomerController();
    registerCustomerController.setRegisterCustomerValidator(mock(RegisterCustomerValidator.class));

    // Act and Assert
    assertEquals("/account/registration/registerCustomerSuccess", registerCustomerController.registerCustomerSuccess());
  }

  /**
   * Test {@link RegisterCustomerController#registerCustomerSuccess()}.
   * <p>
   * Method under test:
   * {@link RegisterCustomerController#registerCustomerSuccess()}
   */
  @Test
  @DisplayName("Test registerCustomerSuccess()")
  @Disabled("TODO: Complete this test")
  void testRegisterCustomerSuccess2() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.profile.web.controller.RegisterCustomerController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.ChallengeQuestionService challengeQuestionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.web.core.service.login.LoginService loginService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.controller.RegisterCustomerController registerCustomerController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blRegisterCustomerValidator") org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator registerCustomerValidator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/registerCustomer/registerCustomerSuccess");

    // Act
    MockMvcBuilders.standaloneSetup(registerCustomerController).build().perform(requestBuilder);
  }

  /**
   * Test {@link RegisterCustomerController#registerCustomerSuccess()}.
   * <ul>
   *   <li>Given {@link RegisterCustomerController} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RegisterCustomerController#registerCustomerSuccess()}
   */
  @Test
  @DisplayName("Test registerCustomerSuccess(); given RegisterCustomerController (default constructor)")
  void testRegisterCustomerSuccess_givenRegisterCustomerController() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/account/registration/registerCustomerSuccess",
        (new RegisterCustomerController()).registerCustomerSuccess());
  }

  /**
   * Test {@link RegisterCustomerController#initCustomerRegistrationForm()}.
   * <p>
   * Method under test:
   * {@link RegisterCustomerController#initCustomerRegistrationForm()}
   */
  @Test
  @DisplayName("Test initCustomerRegistrationForm()")
  @Disabled("TODO: Complete this test")
  void testInitCustomerRegistrationForm() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.profile.web.controller.RegisterCustomerController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.ChallengeQuestionService challengeQuestionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.web.core.service.login.LoginService loginService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.controller.RegisterCustomerController registerCustomerController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blRegisterCustomerValidator") org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator registerCustomerValidator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    registerCustomerController.initCustomerRegistrationForm();
  }

  /**
   * Test {@link RegisterCustomerController#getChallengeQuestions()}.
   * <p>
   * Method under test: {@link RegisterCustomerController#getChallengeQuestions()}
   */
  @Test
  @DisplayName("Test getChallengeQuestions()")
  @Disabled("TODO: Complete this test")
  void testGetChallengeQuestions() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.profile.web.controller.RegisterCustomerController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.ChallengeQuestionService challengeQuestionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.web.core.service.login.LoginService loginService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.controller.RegisterCustomerController registerCustomerController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blRegisterCustomerValidator") org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator registerCustomerValidator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    registerCustomerController.getChallengeQuestions();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RegisterCustomerController#setDisplayRegistrationFormView(String)}
   *   <li>
   * {@link RegisterCustomerController#setRegisterCustomerValidator(RegisterCustomerValidator)}
   *   <li>{@link RegisterCustomerController#setRegistrationErrorView(String)}
   *   <li>{@link RegisterCustomerController#setRegistrationSuccessView(String)}
   *   <li>{@link RegisterCustomerController#getDisplayRegistrationFormView()}
   *   <li>{@link RegisterCustomerController#getRegisterCustomerValidator()}
   *   <li>{@link RegisterCustomerController#getRegistrationErrorView()}
   *   <li>{@link RegisterCustomerController#getRegistrationSuccessView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    RegisterCustomerController registerCustomerController = new RegisterCustomerController();

    // Act
    registerCustomerController.setDisplayRegistrationFormView("Display Registration Form View");
    RegisterCustomerValidator registerCustomerValidator = new RegisterCustomerValidator();
    registerCustomerController.setRegisterCustomerValidator(registerCustomerValidator);
    registerCustomerController.setRegistrationErrorView("An error occurred");
    registerCustomerController.setRegistrationSuccessView("Registration Success View");
    String actualDisplayRegistrationFormView = registerCustomerController.getDisplayRegistrationFormView();
    RegisterCustomerValidator actualRegisterCustomerValidator = registerCustomerController
        .getRegisterCustomerValidator();
    String actualRegistrationErrorView = registerCustomerController.getRegistrationErrorView();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualRegistrationErrorView);
    assertEquals("Display Registration Form View", actualDisplayRegistrationFormView);
    assertEquals("Registration Success View", registerCustomerController.getRegistrationSuccessView());
    assertSame(registerCustomerValidator, actualRegisterCustomerValidator);
  }
}
