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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator;
import org.broadleafcommerce.profile.web.core.form.RegisterCustomerForm;
import org.broadleafcommerce.profile.web.core.service.login.LoginService;
import org.broadleafcommerce.profile.web.core.service.register.RegistrationService;
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
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

@ExtendWith(MockitoExtension.class)
class BroadleafRegisterControllerDiffblueTest {
  @InjectMocks
  private BroadleafRegisterController broadleafRegisterController;

  @Mock
  private CustomerService customerService;

  @Mock
  private LoginService loginService;

  @Mock
  private OrderService orderService;

  @Mock
  private RegisterCustomerValidator registerCustomerValidator;

  @Mock
  private RegistrationService registrationService;

  /**
   * Test {@link BroadleafRegisterController#register(RegisterCustomerForm, HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test: {@link BroadleafRegisterController#register(RegisterCustomerForm, HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test register(RegisterCustomerForm, HttpServletRequest, HttpServletResponse, Model)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafRegisterController.register(RegisterCustomerForm, HttpServletRequest, HttpServletResponse, Model)"})
  void testRegister() {
    // Arrange
    doNothing().when(registrationService).addRedirectUrlToForm(Mockito.<RegisterCustomerForm>any());

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
    String actualRegisterResult = broadleafRegisterController.register(registerCustomerForm, request, response,
        new ConcurrentModel());

    // Assert
    verify(registrationService).addRedirectUrlToForm(isA(RegisterCustomerForm.class));
    assertEquals("authentication/register", actualRegisterResult);
  }

  /**
   * Test {@link BroadleafRegisterController#processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRegisterController#processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model); given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafRegisterController.processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)"})
  void testProcessRegister_givenEmptyString() throws ServiceException, PricingException {
    // Arrange
    when(customerService.registerCustomer(Mockito.<Customer>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(loginService.loginCustomer(Mockito.<Customer>any()))
        .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));
    doNothing().when(registerCustomerValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any(), anyBoolean());
    RegisterCustomerForm registerCustomerForm = mock(RegisterCustomerForm.class);
    when(registerCustomerForm.getPassword()).thenReturn("iloveyou");
    when(registerCustomerForm.getPasswordConfirm()).thenReturn("Password Confirm");
    when(registerCustomerForm.getRedirectUrl()).thenReturn("");
    when(registerCustomerForm.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(registerCustomerForm).setCustomer(Mockito.<Customer>any());
    doNothing().when(registerCustomerForm).setPassword(Mockito.<String>any());
    doNothing().when(registerCustomerForm).setPasswordConfirm(Mockito.<String>any());
    doNothing().when(registerCustomerForm).setRedirectUrl(Mockito.<String>any());
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
    String actualProcessRegisterResult = broadleafRegisterController.processRegister(registerCustomerForm, errors,
        request, response, new ConcurrentModel());

    // Assert
    verify(customerService).registerCustomer(isA(Customer.class), eq("iloveyou"), eq("Password Confirm"));
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class), eq(false));
    verify(registerCustomerForm, atLeast(1)).getCustomer();
    verify(registerCustomerForm).getPassword();
    verify(registerCustomerForm).getPasswordConfirm();
    verify(registerCustomerForm).getRedirectUrl();
    verify(registerCustomerForm).setCustomer(isA(Customer.class));
    verify(registerCustomerForm).setPassword(eq("iloveyou"));
    verify(registerCustomerForm).setPasswordConfirm(eq("Password Confirm"));
    verify(registerCustomerForm).setRedirectUrl(eq("https://example.org/example"));
    verify(loginService).loginCustomer(isA(Customer.class));
    assertEquals("ajaxredirect:", actualProcessRegisterResult);
  }

  /**
   * Test {@link BroadleafRegisterController#processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return {@code redirect:foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRegisterController#processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model); given 'foo'; then return 'redirect:foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafRegisterController.processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)"})
  void testProcessRegister_givenFoo_thenReturnRedirectFoo() throws ServiceException, PricingException {
    // Arrange
    when(customerService.registerCustomer(Mockito.<Customer>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(loginService.loginCustomer(Mockito.<Customer>any()))
        .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));
    doNothing().when(registerCustomerValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any(), anyBoolean());
    RegisterCustomerForm registerCustomerForm = mock(RegisterCustomerForm.class);
    when(registerCustomerForm.getPassword()).thenReturn("iloveyou");
    when(registerCustomerForm.getPasswordConfirm()).thenReturn("Password Confirm");
    when(registerCustomerForm.getRedirectUrl()).thenReturn("foo");
    when(registerCustomerForm.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(registerCustomerForm).setCustomer(Mockito.<Customer>any());
    doNothing().when(registerCustomerForm).setPassword(Mockito.<String>any());
    doNothing().when(registerCustomerForm).setPasswordConfirm(Mockito.<String>any());
    doNothing().when(registerCustomerForm).setRedirectUrl(Mockito.<String>any());
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
    String actualProcessRegisterResult = broadleafRegisterController.processRegister(registerCustomerForm, errors,
        request, response, new ConcurrentModel());

    // Assert
    verify(customerService).registerCustomer(isA(Customer.class), eq("iloveyou"), eq("Password Confirm"));
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class), eq(false));
    verify(registerCustomerForm, atLeast(1)).getCustomer();
    verify(registerCustomerForm).getPassword();
    verify(registerCustomerForm).getPasswordConfirm();
    verify(registerCustomerForm).getRedirectUrl();
    verify(registerCustomerForm).setCustomer(isA(Customer.class));
    verify(registerCustomerForm).setPassword(eq("iloveyou"));
    verify(registerCustomerForm).setPasswordConfirm(eq("Password Confirm"));
    verify(registerCustomerForm).setRedirectUrl(eq("https://example.org/example"));
    verify(loginService).loginCustomer(isA(Customer.class));
    assertEquals("redirect:foo", actualProcessRegisterResult);
  }

  /**
   * Test {@link BroadleafRegisterController#processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)}.
   * <ul>
   *   <li>Then return {@code authentication/register}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRegisterController#processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model); then return 'authentication/register'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafRegisterController.processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)"})
  void testProcessRegister_thenReturnAuthenticationRegister() throws ServiceException, PricingException {
    // Arrange
    doNothing().when(customerService).detachCustomer(Mockito.<Customer>any());
    doNothing().when(registerCustomerValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any(), anyBoolean());
    RegisterCustomerForm registerCustomerForm = mock(RegisterCustomerForm.class);
    when(registerCustomerForm.getCustomer()).thenReturn(new CustomerImpl());
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
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualProcessRegisterResult = broadleafRegisterController.processRegister(registerCustomerForm, errors,
        request, response, new ConcurrentModel());

    // Assert
    verify(customerService).detachCustomer(isA(Customer.class));
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class), eq(false));
    verify(registerCustomerForm).getCustomer();
    verify(registerCustomerForm).setCustomer(isA(Customer.class));
    verify(registerCustomerForm).setPassword(eq("iloveyou"));
    verify(registerCustomerForm).setPasswordConfirm(eq("Password Confirm"));
    verify(registerCustomerForm).setRedirectUrl(eq("https://example.org/example"));
    assertEquals("authentication/register", actualProcessRegisterResult);
  }

  /**
   * Test {@link BroadleafRegisterController#processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)}.
   * <ul>
   *   <li>When {@link RegisterCustomerForm} (default constructor) Customer is {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRegisterController#processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model); when RegisterCustomerForm (default constructor) Customer is CustomerImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafRegisterController.processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)"})
  void testProcessRegister_whenRegisterCustomerFormCustomerIsCustomerImpl() throws ServiceException, PricingException {
    // Arrange
    when(customerService.registerCustomer(Mockito.<Customer>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(loginService.loginCustomer(Mockito.<Customer>any()))
        .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));
    doNothing().when(registerCustomerValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any(), anyBoolean());

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
    String actualProcessRegisterResult = broadleafRegisterController.processRegister(registerCustomerForm, errors,
        request, response, new ConcurrentModel());

    // Assert
    verify(customerService).registerCustomer(isA(Customer.class), eq("iloveyou"), eq("Password Confirm"));
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class), eq(false));
    verify(loginService).loginCustomer(isA(Customer.class));
    assertEquals("ajaxredirect:", actualProcessRegisterResult);
  }

  /**
   * Test {@link BroadleafRegisterController#initCustomerRegistrationForm()}.
   * <p>
   * Method under test: {@link BroadleafRegisterController#initCustomerRegistrationForm()}
   */
  @Test
  @DisplayName("Test initCustomerRegistrationForm()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RegisterCustomerForm BroadleafRegisterController.initCustomerRegistrationForm()"})
  void testInitCustomerRegistrationForm() {
    // Arrange
    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("https://example.org/example");
    when(registrationService.initCustomerRegistrationForm()).thenReturn(registerCustomerForm);

    // Act
    RegisterCustomerForm actualInitCustomerRegistrationFormResult = broadleafRegisterController
        .initCustomerRegistrationForm();

    // Assert
    verify(registrationService).initCustomerRegistrationForm();
    assertSame(registerCustomerForm, actualInitCustomerRegistrationFormResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafRegisterController}
   *   <li>{@link BroadleafRegisterController#setUseEmailForLogin(boolean)}
   *   <li>{@link BroadleafRegisterController#getRegisterSuccessView()}
   *   <li>{@link BroadleafRegisterController#getRegisterView()}
   *   <li>{@link BroadleafRegisterController#isUseEmailForLogin()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafRegisterController.<init>()",
      "String BroadleafRegisterController.getRegisterSuccessView()",
      "String BroadleafRegisterController.getRegisterView()",
      "boolean BroadleafRegisterController.isUseEmailForLogin()",
      "void BroadleafRegisterController.setUseEmailForLogin(boolean)"})
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafRegisterController actualBroadleafRegisterController = new BroadleafRegisterController();
    actualBroadleafRegisterController.setUseEmailForLogin(true);
    String actualRegisterSuccessView = actualBroadleafRegisterController.getRegisterSuccessView();
    String actualRegisterView = actualBroadleafRegisterController.getRegisterView();

    // Assert
    assertEquals("ajaxredirect:", actualRegisterSuccessView);
    assertEquals("authentication/register", actualRegisterView);
    assertTrue(actualBroadleafRegisterController.isUseEmailForLogin());
  }
}
