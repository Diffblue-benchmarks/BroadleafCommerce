package org.broadleafcommerce.core.web.controller.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator;
import org.broadleafcommerce.profile.web.core.form.RegisterCustomerForm;
import org.broadleafcommerce.profile.web.core.service.login.LoginService;
import org.broadleafcommerce.profile.web.core.service.register.RegistrationService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestAttributes;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafSocialRegisterControllerDiffblueTest {
  @InjectMocks private BroadleafSocialRegisterController broadleafSocialRegisterController;

  @Mock private CustomerService customerService;

  @Mock private LoginService loginService;

  @Mock private ProviderSignInUtils providerSignInUtils;

  @Mock private RegisterCustomerValidator registerCustomerValidator;

  @Mock private RegistrationService registrationService;

  /**
   * Test {@link BroadleafSocialRegisterController#register(RegisterCustomerForm,
   * HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Then {@link RegisterCustomerForm} (default constructor) Customer MainEntityName is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSocialRegisterController#register(RegisterCustomerForm,
   * HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafSocialRegisterController.register(RegisterCustomerForm, HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testRegister_thenRegisterCustomerFormCustomerMainEntityNameIsNull() {
    // Arrange
    doNothing().when(registrationService).addRedirectUrlToForm(Mockito.<RegisterCustomerForm>any());
    Mockito.<Connection<?>>when(
            providerSignInUtils.getConnectionFromSession(Mockito.<RequestAttributes>any()))
        .thenReturn(null);

    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("https://example.org/example");
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafSocialRegisterController.register(
        registerCustomerForm, request, response, new ConcurrentModel());

    // Assert that nothing has changed
    verify(registrationService).addRedirectUrlToForm(isA(RegisterCustomerForm.class));
    verify(providerSignInUtils).getConnectionFromSession(isA(RequestAttributes.class));
    Customer customer = registerCustomerForm.getCustomer();
    assertTrue(customer instanceof CustomerImpl);
    assertEquals("null", ((CustomerImpl) customer).getMainEntityName());
  }

  /**
   * Test {@link BroadleafSocialRegisterController#processRegister(RegisterCustomerForm,
   * BindingResult, HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafSocialRegisterController#processRegister(RegisterCustomerForm, BindingResult,
   * HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafSocialRegisterController.processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testProcessRegister_givenAuditableCreatedByIsOne()
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
    doNothing()
        .when(providerSignInUtils)
        .doPostSignUp(Mockito.<String>any(), Mockito.<RequestAttributes>any());

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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualProcessRegisterResult =
        broadleafSocialRegisterController.processRegister(
            registerCustomerForm, errors, request, response, new ConcurrentModel());

    // Assert
    verify(customerService)
        .registerCustomer(isA(Customer.class), eq("iloveyou"), eq("Password Confirm"));
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class), eq(false));
    verify(loginService).loginCustomer(isA(Customer.class));
    verify(providerSignInUtils).doPostSignUp(isNull(), isA(RequestAttributes.class));
    assertEquals("ajaxredirect:", actualProcessRegisterResult);
  }

  /**
   * Test {@link BroadleafSocialRegisterController#processRegister(RegisterCustomerForm,
   * BindingResult, HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafSocialRegisterController#processRegister(RegisterCustomerForm, BindingResult,
   * HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafSocialRegisterController.processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testProcessRegister_givenEmptyString() throws ServiceException, PricingException {
    // Arrange
    when(customerService.registerCustomer(
            Mockito.<Customer>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new CustomerImpl());
    when(loginService.loginCustomer(Mockito.<Customer>any()))
        .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));
    doNothing()
        .when(registerCustomerValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any(), anyBoolean());
    doNothing()
        .when(providerSignInUtils)
        .doPostSignUp(Mockito.<String>any(), Mockito.<RequestAttributes>any());

    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("");
    BindException errors = new BindException("Target", "Object Name");
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualProcessRegisterResult =
        broadleafSocialRegisterController.processRegister(
            registerCustomerForm, errors, request, response, new ConcurrentModel());

    // Assert
    verify(customerService)
        .registerCustomer(isA(Customer.class), eq("iloveyou"), eq("Password Confirm"));
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class), eq(false));
    verify(loginService).loginCustomer(isA(Customer.class));
    verify(providerSignInUtils).doPostSignUp(isNull(), isA(RequestAttributes.class));
    assertEquals("ajaxredirect:", actualProcessRegisterResult);
  }

  /**
   * Test {@link BroadleafSocialRegisterController#processRegister(RegisterCustomerForm,
   * BindingResult, HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafSocialRegisterController#processRegister(RegisterCustomerForm, BindingResult,
   * HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafSocialRegisterController.processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testProcessRegister_givenHttpsExampleOrgExample()
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
    doNothing()
        .when(providerSignInUtils)
        .doPostSignUp(Mockito.<String>any(), Mockito.<RequestAttributes>any());

    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("https://example.org/example");
    BindException errors = new BindException("Target", "Object Name");
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualProcessRegisterResult =
        broadleafSocialRegisterController.processRegister(
            registerCustomerForm, errors, request, response, new ConcurrentModel());

    // Assert
    verify(customerService)
        .registerCustomer(isA(Customer.class), eq("iloveyou"), eq("Password Confirm"));
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class), eq(false));
    verify(loginService).loginCustomer(isA(Customer.class));
    verify(providerSignInUtils).doPostSignUp(isNull(), isA(RequestAttributes.class));
    assertEquals("ajaxredirect:", actualProcessRegisterResult);
  }

  /**
   * Test {@link BroadleafSocialRegisterController#processRegister(RegisterCustomerForm,
   * BindingResult, HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link RegisterCustomerForm} (default constructor) RedirectUrl is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafSocialRegisterController#processRegister(RegisterCustomerForm, BindingResult,
   * HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafSocialRegisterController.processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testProcessRegister_givenNull_whenRegisterCustomerFormRedirectUrlIsNull()
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
    doNothing()
        .when(providerSignInUtils)
        .doPostSignUp(Mockito.<String>any(), Mockito.<RequestAttributes>any());

    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl(null);
    BindException errors = new BindException("Target", "Object Name");
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualProcessRegisterResult =
        broadleafSocialRegisterController.processRegister(
            registerCustomerForm, errors, request, response, new ConcurrentModel());

    // Assert
    verify(customerService)
        .registerCustomer(isA(Customer.class), eq("iloveyou"), eq("Password Confirm"));
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class), eq(false));
    verify(loginService).loginCustomer(isA(Customer.class));
    verify(providerSignInUtils).doPostSignUp(isNull(), isA(RequestAttributes.class));
    assertEquals("ajaxredirect:", actualProcessRegisterResult);
  }

  /**
   * Test {@link BroadleafSocialRegisterController#processRegister(RegisterCustomerForm,
   * BindingResult, HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Given {@code Redirect Url}.
   *   <li>Then return {@code redirect:Redirect Url}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafSocialRegisterController#processRegister(RegisterCustomerForm, BindingResult,
   * HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafSocialRegisterController.processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testProcessRegister_givenRedirectUrl_thenReturnRedirectRedirectUrl()
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
    doNothing()
        .when(providerSignInUtils)
        .doPostSignUp(Mockito.<String>any(), Mockito.<RequestAttributes>any());

    RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    registerCustomerForm.setCustomer(new CustomerImpl());
    registerCustomerForm.setPassword("iloveyou");
    registerCustomerForm.setPasswordConfirm("Password Confirm");
    registerCustomerForm.setRedirectUrl("Redirect Url");
    BindException errors = new BindException("Target", "Object Name");
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualProcessRegisterResult =
        broadleafSocialRegisterController.processRegister(
            registerCustomerForm, errors, request, response, new ConcurrentModel());

    // Assert
    verify(customerService)
        .registerCustomer(isA(Customer.class), eq("iloveyou"), eq("Password Confirm"));
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class), eq(false));
    verify(loginService).loginCustomer(isA(Customer.class));
    verify(providerSignInUtils).doPostSignUp(isNull(), isA(RequestAttributes.class));
    assertEquals("redirect:Redirect Url", actualProcessRegisterResult);
  }

  /**
   * Test {@link BroadleafSocialRegisterController#processRegister(RegisterCustomerForm,
   * BindingResult, HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Then return {@code authentication/register}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafSocialRegisterController#processRegister(RegisterCustomerForm, BindingResult,
   * HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafSocialRegisterController.processRegister(RegisterCustomerForm, BindingResult, HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testProcessRegister_thenReturnAuthenticationRegister()
      throws ServiceException, PricingException {
    // Arrange
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualProcessRegisterResult =
        broadleafSocialRegisterController.processRegister(
            registerCustomerForm, errors, request, response, new ConcurrentModel());

    // Assert
    verify(registerCustomerValidator).validate(isA(Object.class), isA(Errors.class), eq(false));
    assertEquals("authentication/register", actualProcessRegisterResult);
  }

  /**
   * Test new {@link BroadleafSocialRegisterController} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * BroadleafSocialRegisterController}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafSocialRegisterController.<init>()"})
  public void testNewBroadleafSocialRegisterController() {
    // Arrange, Act and Assert
    assertFalse(new BroadleafSocialRegisterController().isUseEmailForLogin());
  }
}
