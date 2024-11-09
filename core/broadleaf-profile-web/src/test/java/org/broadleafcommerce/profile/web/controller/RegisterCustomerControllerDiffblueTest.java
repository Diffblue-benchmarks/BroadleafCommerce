/*-
 * #%L
 * BroadleafCommerce Profile Web
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import org.broadleafcommerce.profile.web.controller.validator.RegisterCustomerValidator;
import org.broadleafcommerce.profile.web.core.form.RegisterCustomerForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

class RegisterCustomerControllerDiffblueTest {
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
