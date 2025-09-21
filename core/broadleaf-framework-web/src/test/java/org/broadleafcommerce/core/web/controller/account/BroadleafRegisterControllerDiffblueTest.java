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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
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
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class BroadleafRegisterControllerDiffblueTest {
  @InjectMocks private BroadleafRegisterController broadleafRegisterController;

  @Mock private CustomerService customerService;

  @Mock private LoginService loginService;

  @Mock private RegisterCustomerValidator registerCustomerValidator;

  @Mock private RegistrationService registrationService;

  /**
   * Test {@link BroadleafRegisterController#register(RegisterCustomerForm, HttpServletRequest,
   * HttpServletResponse, Model)}.
   *
   * <p>Method under test: {@link BroadleafRegisterController#register(RegisterCustomerForm,
   * HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName(
      "Test register(RegisterCustomerForm, HttpServletRequest, HttpServletResponse, Model)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafRegisterController.register(RegisterCustomerForm, HttpServletRequest, HttpServletResponse, Model)"
  })
  void testRegister() {
    // Arrange
    doNothing().when(registrationService).addRedirectUrlToForm(Mockito.<RegisterCustomerForm>any());

    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("https://example.org/example");
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualRegisterResult =
        broadleafRegisterController.register(
            registerCustomerForm, request, response, new ConcurrentModel());

    // Assert
    verify(registrationService).addRedirectUrlToForm(isA(RegisterCustomerForm.class));
    assertEquals("authentication/register", actualRegisterResult);
  }

  /**
   * Test {@link BroadleafRegisterController#processRegister(RegisterCustomerForm, BindingResult,
   * HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRegisterController#processRegister(RegisterCustomerForm,
   * BindingResult, HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName(
      "Test processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model); given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafRegisterController.processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)"
  })
  void testProcessRegister_givenEmptyString() throws ServiceException, PricingException {
    // Arrange
    when(customerService.registerCustomer(
            Mockito.<Customer>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(loginService.loginCustomer(Mockito.<Customer>any()))
        .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));
    doNothing()
        .when(registerCustomerValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any(), anyBoolean());

    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("");
    BindException errors = new BindException("Target", "Object Name");
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualProcessRegisterResult =
        broadleafRegisterController.processRegister(
            registerCustomerForm, errors, request, response, new ConcurrentModel());

    // Assert
    verify(customerService)
        .registerCustomer(isA(Customer.class), eq("iloveyou"), eq("Password Confirm"));
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class), eq(false));
    verify(loginService).loginCustomer(isA(Customer.class));
    Customer customer = registerCustomerForm.getCustomer();
    assertTrue(customer instanceof CustomerImpl);
    assertEquals("ajaxredirect:", actualProcessRegisterResult);
    assertNull(customer.getUsername());
  }

  /**
   * Test {@link BroadleafRegisterController#processRegister(RegisterCustomerForm, BindingResult,
   * HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRegisterController#processRegister(RegisterCustomerForm,
   * BindingResult, HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName(
      "Test processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model); given 'https://example.org/example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafRegisterController.processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)"
  })
  void testProcessRegister_givenHttpsExampleOrgExample() throws ServiceException, PricingException {
    // Arrange
    when(customerService.registerCustomer(
            Mockito.<Customer>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(loginService.loginCustomer(Mockito.<Customer>any()))
        .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));
    doNothing()
        .when(registerCustomerValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any(), anyBoolean());

    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("https://example.org/example");
    BindException errors = new BindException("Target", "Object Name");
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualProcessRegisterResult =
        broadleafRegisterController.processRegister(
            registerCustomerForm, errors, request, response, new ConcurrentModel());

    // Assert
    verify(customerService)
        .registerCustomer(isA(Customer.class), eq("iloveyou"), eq("Password Confirm"));
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class), eq(false));
    verify(loginService).loginCustomer(isA(Customer.class));
    Customer customer = registerCustomerForm.getCustomer();
    assertTrue(customer instanceof CustomerImpl);
    assertEquals("ajaxredirect:", actualProcessRegisterResult);
    assertNull(customer.getUsername());
  }

  /**
   * Test {@link BroadleafRegisterController#processRegister(RegisterCustomerForm, BindingResult,
   * HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link RegisterCustomerForm} (default constructor) RedirectUrl is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRegisterController#processRegister(RegisterCustomerForm,
   * BindingResult, HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName(
      "Test processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model); given 'null'; when RegisterCustomerForm (default constructor) RedirectUrl is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafRegisterController.processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)"
  })
  void testProcessRegister_givenNull_whenRegisterCustomerFormRedirectUrlIsNull()
      throws ServiceException, PricingException {
    // Arrange
    when(customerService.registerCustomer(
            Mockito.<Customer>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(loginService.loginCustomer(Mockito.<Customer>any()))
        .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));
    doNothing()
        .when(registerCustomerValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any(), anyBoolean());

    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl(null);
    BindException errors = new BindException("Target", "Object Name");
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualProcessRegisterResult =
        broadleafRegisterController.processRegister(
            registerCustomerForm, errors, request, response, new ConcurrentModel());

    // Assert
    verify(customerService)
        .registerCustomer(isA(Customer.class), eq("iloveyou"), eq("Password Confirm"));
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class), eq(false));
    verify(loginService).loginCustomer(isA(Customer.class));
    Customer customer = registerCustomerForm.getCustomer();
    assertTrue(customer instanceof CustomerImpl);
    assertEquals("ajaxredirect:", actualProcessRegisterResult);
    assertNull(customer.getUsername());
  }

  /**
   * Test {@link BroadleafRegisterController#processRegister(RegisterCustomerForm, BindingResult,
   * HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Given {@code Redirect Url}.
   *   <li>Then return {@code redirect:Redirect Url}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRegisterController#processRegister(RegisterCustomerForm,
   * BindingResult, HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName(
      "Test processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model); given 'Redirect Url'; then return 'redirect:Redirect Url'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafRegisterController.processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)"
  })
  void testProcessRegister_givenRedirectUrl_thenReturnRedirectRedirectUrl()
      throws ServiceException, PricingException {
    // Arrange
    when(customerService.registerCustomer(
            Mockito.<Customer>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(loginService.loginCustomer(Mockito.<Customer>any()))
        .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));
    doNothing()
        .when(registerCustomerValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any(), anyBoolean());

    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("Redirect Url");
    BindException errors = new BindException("Target", "Object Name");
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualProcessRegisterResult =
        broadleafRegisterController.processRegister(
            registerCustomerForm, errors, request, response, new ConcurrentModel());

    // Assert
    verify(customerService)
        .registerCustomer(isA(Customer.class), eq("iloveyou"), eq("Password Confirm"));
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class), eq(false));
    verify(loginService).loginCustomer(isA(Customer.class));
    Customer customer = registerCustomerForm.getCustomer();
    assertTrue(customer instanceof CustomerImpl);
    assertEquals("redirect:Redirect Url", actualProcessRegisterResult);
    assertNull(customer.getUsername());
  }

  /**
   * Test {@link BroadleafRegisterController#processRegister(RegisterCustomerForm, BindingResult,
   * HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Then {@link RegisterCustomerForm} (default constructor) Customer Username is {@code
   *       bob@example.com}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRegisterController#processRegister(RegisterCustomerForm,
   * BindingResult, HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName(
      "Test processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model); then RegisterCustomerForm (default constructor) Customer Username is 'bob@example.com'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafRegisterController.processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)"
  })
  void testProcessRegister_thenRegisterCustomerFormCustomerUsernameIsBobExampleCom()
      throws ServiceException, PricingException {
    // Arrange
    when(customerService.registerCustomer(
            Mockito.<Customer>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(loginService.loginCustomer(Mockito.<Customer>any()))
        .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));
    doNothing()
        .when(registerCustomerValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any(), anyBoolean());
    broadleafRegisterController.setUseEmailForLogin(true);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress("bob@example.com");

    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("not blank");
    registerCustomerForm.setCustomer(customer);
    BindException errors = new BindException("Target", "Object Name");
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualProcessRegisterResult =
        broadleafRegisterController.processRegister(
            registerCustomerForm, errors, request, response, new ConcurrentModel());

    // Assert
    verify(customerService)
        .registerCustomer(isA(Customer.class), eq("iloveyou"), eq("Password Confirm"));
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class), eq(true));
    verify(loginService).loginCustomer(isA(Customer.class));
    Customer customer2 = registerCustomerForm.getCustomer();
    assertTrue(customer2 instanceof CustomerImpl);
    assertEquals("bob@example.com", customer2.getUsername());
    assertEquals("redirect:not blank", actualProcessRegisterResult);
  }

  /**
   * Test {@link BroadleafRegisterController#processRegister(RegisterCustomerForm, BindingResult,
   * HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Then {@link RegisterCustomerForm} (default constructor) Customer Username is {@code
   *       janedoe}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRegisterController#processRegister(RegisterCustomerForm,
   * BindingResult, HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName(
      "Test processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model); then RegisterCustomerForm (default constructor) Customer Username is 'janedoe'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafRegisterController.processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)"
  })
  void testProcessRegister_thenRegisterCustomerFormCustomerUsernameIsJanedoe()
      throws ServiceException, PricingException {
    // Arrange
    when(customerService.registerCustomer(
            Mockito.<Customer>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(loginService.loginCustomer(Mockito.<Customer>any()))
        .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));
    doNothing()
        .when(registerCustomerValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any(), anyBoolean());
    broadleafRegisterController.setUseEmailForLogin(false);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress("bob@example.com");

    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl(" ");
    registerCustomerForm.setCustomer(customer);
    BindException errors = new BindException("Target", "Object Name");
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualProcessRegisterResult =
        broadleafRegisterController.processRegister(
            registerCustomerForm, errors, request, response, new ConcurrentModel());

    // Assert
    verify(customerService)
        .registerCustomer(isA(Customer.class), eq("iloveyou"), eq("Password Confirm"));
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class), eq(false));
    verify(loginService).loginCustomer(isA(Customer.class));
    Customer customer2 = registerCustomerForm.getCustomer();
    assertTrue(customer2 instanceof CustomerImpl);
    assertEquals("ajaxredirect:", actualProcessRegisterResult);
    assertEquals("janedoe", customer2.getUsername());
  }

  /**
   * Test {@link BroadleafRegisterController#processRegister(RegisterCustomerForm, BindingResult,
   * HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Then return {@code authentication/register}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRegisterController#processRegister(RegisterCustomerForm,
   * BindingResult, HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName(
      "Test processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model); then return 'authentication/register'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafRegisterController.processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)"
  })
  void testProcessRegister_thenReturnAuthenticationRegister()
      throws ServiceException, PricingException {
    // Arrange
    doNothing().when(customerService).detachCustomer(Mockito.<Customer>any());
    doNothing()
        .when(registerCustomerValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any(), anyBoolean());

    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("https://example.org/example");

    BindException errors = new BindException("Target", "Object Name");
    errors.addError(new ObjectError(":", ":"));
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualProcessRegisterResult =
        broadleafRegisterController.processRegister(
            registerCustomerForm, errors, request, response, new ConcurrentModel());

    // Assert
    verify(customerService).detachCustomer(isA(Customer.class));
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class), eq(false));
    Customer customer = registerCustomerForm.getCustomer();
    assertTrue(customer instanceof CustomerImpl);
    assertEquals("authentication/register", actualProcessRegisterResult);
    assertNull(customer.getUsername());
  }

  /**
   * Test {@link BroadleafRegisterController#initCustomerRegistrationForm()}.
   *
   * <p>Method under test: {@link BroadleafRegisterController#initCustomerRegistrationForm()}
   */
  @Test
  @DisplayName("Test initCustomerRegistrationForm()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RegisterCustomerForm BroadleafRegisterController.initCustomerRegistrationForm()"
  })
  void testInitCustomerRegistrationForm() {
    // Arrange
    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("https://example.org/example");
    when(registrationService.initCustomerRegistrationForm()).thenReturn(registerCustomerForm);

    // Act
    RegisterCustomerForm actualInitCustomerRegistrationFormResult =
        broadleafRegisterController.initCustomerRegistrationForm();

    // Assert
    verify(registrationService).initCustomerRegistrationForm();
    assertSame(registerCustomerForm, actualInitCustomerRegistrationFormResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafRegisterController.<init>()",
    "String BroadleafRegisterController.getRegisterSuccessView()",
    "String BroadleafRegisterController.getRegisterView()",
    "boolean BroadleafRegisterController.isUseEmailForLogin()",
    "void BroadleafRegisterController.setUseEmailForLogin(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafRegisterController actualBroadleafRegisterController =
        new BroadleafRegisterController();
    actualBroadleafRegisterController.setUseEmailForLogin(true);
    String actualRegisterSuccessView = actualBroadleafRegisterController.getRegisterSuccessView();
    String actualRegisterView = actualBroadleafRegisterController.getRegisterView();

    // Assert
    assertEquals("ajaxredirect:", actualRegisterSuccessView);
    assertEquals("authentication/register", actualRegisterView);
    assertTrue(actualBroadleafRegisterController.isUseEmailForLogin());
  }
}
