package org.broadleafcommerce.core.web.controller.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator;
import org.broadleafcommerce.profile.web.core.form.RegisterCustomerForm;
import org.broadleafcommerce.profile.web.core.service.login.LoginService;
import org.broadleafcommerce.profile.web.core.service.register.RegistrationService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

@ContextConfiguration(classes = {BroadleafRegisterController.class})
@ExtendWith(SpringExtension.class)
class BroadleafRegisterControllerDiffblueTest {
  @Autowired
  private BroadleafRegisterController broadleafRegisterController;

  @MockBean
  private CustomerService customerService;

  @MockBean
  private LoginService loginService;

  @MockBean
  private OrderService orderService;

  @MockBean(name = "blRegisterCustomerValidator")
  private RegisterCustomerValidator registerCustomerValidator;

  @MockBean
  private RegistrationService registrationService;

  /**
   * Test
   * {@link BroadleafRegisterController#register(RegisterCustomerForm, HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link BroadleafRegisterController#register(RegisterCustomerForm, HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test register(RegisterCustomerForm, HttpServletRequest, HttpServletResponse, Model)")
  @Disabled("TODO: Complete this test")
  void testRegister() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.account;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.account.BroadleafRegisterController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.account.BroadleafRegisterController broadleafRegisterController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.web.core.service.login.LoginService loginService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blRegisterCustomerValidator") org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator registerCustomerValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.web.core.service.register.RegistrationService registrationService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("https://example.org/example");
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafRegisterController.register(registerCustomerForm, request, response, new ConcurrentModel());
  }

  /**
   * Test
   * {@link BroadleafRegisterController#processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link BroadleafRegisterController#processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)")
  @Disabled("TODO: Complete this test")
  void testProcessRegister() throws ServiceException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.account;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.account.BroadleafRegisterController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.account.BroadleafRegisterController broadleafRegisterController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.web.core.service.login.LoginService loginService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blRegisterCustomerValidator") org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator registerCustomerValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.web.core.service.register.RegistrationService registrationService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("https://example.org/example");
    BindException errors = new BindException("Target", "Object Name");

    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafRegisterController.processRegister(registerCustomerForm, errors, request, response, new ConcurrentModel());
  }

  /**
   * Test {@link BroadleafRegisterController#initCustomerRegistrationForm()}.
   * <p>
   * Method under test:
   * {@link BroadleafRegisterController#initCustomerRegistrationForm()}
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
    //   package org.broadleafcommerce.core.web.controller.account;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.account.BroadleafRegisterController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.account.BroadleafRegisterController broadleafRegisterController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.web.core.service.login.LoginService loginService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blRegisterCustomerValidator") org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator registerCustomerValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.web.core.service.register.RegistrationService registrationService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    broadleafRegisterController.initCustomerRegistrationForm();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafRegisterController}
   *   <li>{@link BroadleafRegisterController#setUseEmailForLogin(boolean)}
   *   <li>{@link BroadleafRegisterController#getRegisterSuccessView()}
   *   <li>{@link BroadleafRegisterController#getRegisterView()}
   *   <li>{@link BroadleafRegisterController#isUseEmailForLogin()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafRegisterController actualBroadleafRegisterController = new BroadleafRegisterController();
    actualBroadleafRegisterController.setUseEmailForLogin(true);
    String actualRegisterSuccessView = actualBroadleafRegisterController.getRegisterSuccessView();
    String actualRegisterView = actualBroadleafRegisterController.getRegisterView();

    // Assert that nothing has changed
    assertEquals("ajaxredirect:", actualRegisterSuccessView);
    assertEquals("authentication/register", actualRegisterView);
    assertTrue(actualBroadleafRegisterController.isUseEmailForLogin());
  }
}
