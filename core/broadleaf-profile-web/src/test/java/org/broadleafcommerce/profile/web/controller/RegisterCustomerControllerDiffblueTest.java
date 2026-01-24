package org.broadleafcommerce.profile.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.ChallengeQuestionService;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator;
import org.broadleafcommerce.profile.web.core.form.RegisterCustomerForm;
import org.broadleafcommerce.profile.web.core.service.login.LoginService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

@ExtendWith(MockitoExtension.class)
class RegisterCustomerControllerDiffblueTest {
  @Mock private ChallengeQuestionService challengeQuestionService;

  @Mock private CustomerService customerService;

  @Mock private LoginService loginService;

  @InjectMocks private RegisterCustomerController registerCustomerController;

  @Mock private RegisterCustomerValidator registerCustomerValidator;

  /**
   * Test {@link RegisterCustomerController#registerCustomer()}.
   *
   * <p>Method under test: {@link RegisterCustomerController#registerCustomer()}
   */
  @Test
  @DisplayName("Test registerCustomer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RegisterCustomerController.registerCustomer()"})
  void testRegisterCustomer() throws Exception {
    // Arrange
    when(challengeQuestionService.readChallengeQuestions()).thenReturn(new ArrayList<>());
    when(customerService.createCustomerWithNullId()).thenReturn(new CustomerImpl());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/registerCustomer/registerCustomer");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(registerCustomerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(2))
        .andExpect(model().attributeExists("challengeQuestions", "registerCustomerForm"))
        .andExpect(view().name("/account/registration/registerCustomer"))
        .andExpect(forwardedUrl("/account/registration/registerCustomer"));
  }

  /**
   * Test {@link RegisterCustomerController#registerCustomer(RegisterCustomerForm, BindingResult,
   * HttpServletRequest, HttpServletResponse)} with {@code RegisterCustomerForm}, {@code
   * BindingResult}, {@code HttpServletRequest}, {@code HttpServletResponse}.
   *
   * <p>Method under test: {@link RegisterCustomerController#registerCustomer(RegisterCustomerForm,
   * BindingResult, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName(
      "Test registerCustomer(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse) with 'RegisterCustomerForm', 'BindingResult', 'HttpServletRequest', 'HttpServletResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.servlet.ModelAndView RegisterCustomerController.registerCustomer(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse)"
  })
  void
      testRegisterCustomerWithRegisterCustomerFormBindingResultHttpServletRequestHttpServletResponse()
          throws Exception {
    // Arrange
    when(challengeQuestionService.readChallengeQuestions()).thenReturn(new ArrayList<>());
    when(customerService.registerCustomer(
            Mockito.<Customer>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(customerService.createCustomerWithNullId()).thenReturn(new CustomerImpl());
    when(loginService.loginCustomer(Mockito.<Customer>any()))
        .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));
    doNothing()
        .when(registerCustomerValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/registerCustomer/registerCustomer")
            .param("customer.emailAddress", "bob@example.com");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(registerCustomerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isFound())
        .andExpect(model().size(2))
        .andExpect(model().attributeExists("challengeQuestions", "registerCustomerForm"))
        .andExpect(view().name("redirect:/registerCustomer/registerCustomerSuccess.htm"))
        .andExpect(redirectedUrl("/registerCustomer/registerCustomerSuccess.htm"));
  }

  /**
   * Test {@link RegisterCustomerController#registerCustomerSuccess()}.
   *
   * <p>Method under test: {@link RegisterCustomerController#registerCustomerSuccess()}
   */
  @Test
  @DisplayName("Test registerCustomerSuccess()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RegisterCustomerController.registerCustomerSuccess()"})
  void testRegisterCustomerSuccess() throws Exception {
    // Arrange
    when(challengeQuestionService.readChallengeQuestions()).thenReturn(new ArrayList<>());
    when(customerService.createCustomerWithNullId()).thenReturn(new CustomerImpl());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/registerCustomer/registerCustomerSuccess");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(registerCustomerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(2))
        .andExpect(model().attributeExists("challengeQuestions", "registerCustomerForm"))
        .andExpect(view().name("/account/registration/registerCustomerSuccess"))
        .andExpect(forwardedUrl("/account/registration/registerCustomerSuccess"));
  }

  /**
   * Test {@link RegisterCustomerController#initCustomerRegistrationForm()}.
   *
   * <p>Method under test: {@link RegisterCustomerController#initCustomerRegistrationForm()}
   */
  @Test
  @DisplayName("Test initCustomerRegistrationForm()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RegisterCustomerForm RegisterCustomerController.initCustomerRegistrationForm()"
  })
  void testInitCustomerRegistrationForm() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerService.createCustomerWithNullId()).thenReturn(customerImpl);

    // Act
    RegisterCustomerForm actualInitCustomerRegistrationFormResult =
        registerCustomerController.initCustomerRegistrationForm();

    // Assert
    verify(customerService).createCustomerWithNullId();
    Customer customer = actualInitCustomerRegistrationFormResult.getCustomer();
    assertTrue(customer instanceof CustomerImpl);
    assertNull(actualInitCustomerRegistrationFormResult.getPassword());
    assertNull(actualInitCustomerRegistrationFormResult.getPasswordConfirm());
    assertNull(actualInitCustomerRegistrationFormResult.getRedirectUrl());
    assertSame(customerImpl, customer);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RegisterCustomerController#setDisplayRegistrationFormView(String)}
   *   <li>{@link
   *       RegisterCustomerController#setRegisterCustomerValidator(RegisterCustomerValidator)}
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String RegisterCustomerController.getDisplayRegistrationFormView()",
    "RegisterCustomerValidator RegisterCustomerController.getRegisterCustomerValidator()",
    "String RegisterCustomerController.getRegistrationErrorView()",
    "String RegisterCustomerController.getRegistrationSuccessView()",
    "void RegisterCustomerController.setDisplayRegistrationFormView(String)",
    "void RegisterCustomerController.setRegisterCustomerValidator(RegisterCustomerValidator)",
    "void RegisterCustomerController.setRegistrationErrorView(String)",
    "void RegisterCustomerController.setRegistrationSuccessView(String)"
  })
  void testGettersAndSetters() {
    // Arrange
    RegisterCustomerController registerCustomerController = new RegisterCustomerController();

    // Act
    registerCustomerController.setDisplayRegistrationFormView("Display Registration Form View");
    RegisterCustomerValidator registerCustomerValidator = new RegisterCustomerValidator();
    registerCustomerController.setRegisterCustomerValidator(registerCustomerValidator);
    registerCustomerController.setRegistrationErrorView("An error occurred");
    registerCustomerController.setRegistrationSuccessView("Registration Success View");
    String actualDisplayRegistrationFormView =
        registerCustomerController.getDisplayRegistrationFormView();
    RegisterCustomerValidator actualRegisterCustomerValidator =
        registerCustomerController.getRegisterCustomerValidator();
    String actualRegistrationErrorView = registerCustomerController.getRegistrationErrorView();

    // Assert
    assertEquals("An error occurred", actualRegistrationErrorView);
    assertEquals("Display Registration Form View", actualDisplayRegistrationFormView);
    assertEquals(
        "Registration Success View", registerCustomerController.getRegistrationSuccessView());
    assertSame(registerCustomerValidator, actualRegisterCustomerValidator);
  }
}
