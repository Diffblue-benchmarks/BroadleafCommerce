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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.web.controller.account.validator.UpdateAccountValidator;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@ExtendWith(MockitoExtension.class)
class BroadleafUpdateAccountControllerDiffblueTest {
  @InjectMocks private BroadleafUpdateAccountController broadleafUpdateAccountController;

  @Mock private UpdateAccountValidator updateAccountValidator;

  /**
   * Test {@link BroadleafUpdateAccountController#processUpdateAccount(HttpServletRequest, Model,
   * UpdateAccountForm, BindingResult, RedirectAttributes)}.
   *
   * <p>Method under test: {@link
   * BroadleafUpdateAccountController#processUpdateAccount(HttpServletRequest, Model,
   * UpdateAccountForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName(
      "Test processUpdateAccount(HttpServletRequest, Model, UpdateAccountForm, BindingResult, RedirectAttributes)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafUpdateAccountController.processUpdateAccount(HttpServletRequest, Model, UpdateAccountForm, BindingResult, RedirectAttributes)"
  })
  void testProcessUpdateAccount() throws ServiceException {
    // Arrange
    doThrow(
            new AuthenticationCredentialsNotFoundException(
                "Authentication was null, not authenticated, or not logged in."))
        .when(updateAccountValidator)
        .validate(Mockito.<UpdateAccountForm>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ConcurrentModel model = new ConcurrentModel();

    UpdateAccountForm form = new UpdateAccountForm();
    form.setEmailAddress("42 Main St");
    form.setFirstName("Jane");
    form.setLastName("Doe");
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(
        AuthenticationCredentialsNotFoundException.class,
        () ->
            broadleafUpdateAccountController.processUpdateAccount(
                request, model, form, result, new RedirectAttributesModelMap()));
    verify(updateAccountValidator).validate(isA(UpdateAccountForm.class), isA(Errors.class));
  }

  /**
   * Test {@link BroadleafUpdateAccountController#processUpdateAccount(HttpServletRequest, Model,
   * UpdateAccountForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code account/updateAccount}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafUpdateAccountController#processUpdateAccount(HttpServletRequest, Model,
   * UpdateAccountForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName(
      "Test processUpdateAccount(HttpServletRequest, Model, UpdateAccountForm, BindingResult, RedirectAttributes); given 'true'; then return 'account/updateAccount'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafUpdateAccountController.processUpdateAccount(HttpServletRequest, Model, UpdateAccountForm, BindingResult, RedirectAttributes)"
  })
  void testProcessUpdateAccount_givenTrue_thenReturnAccountUpdateAccount() throws ServiceException {
    // Arrange
    doNothing()
        .when(updateAccountValidator)
        .validate(Mockito.<UpdateAccountForm>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ConcurrentModel model = new ConcurrentModel();

    UpdateAccountForm form = new UpdateAccountForm();
    form.setEmailAddress("42 Main St");
    form.setFirstName("Jane");
    form.setLastName("Doe");

    BeanPropertyBindingResult result = mock(BeanPropertyBindingResult.class);
    when(result.hasErrors()).thenReturn(true);

    // Act
    String actualProcessUpdateAccountResult =
        broadleafUpdateAccountController.processUpdateAccount(
            request, model, form, result, new RedirectAttributesModelMap());

    // Assert
    verify(updateAccountValidator).validate(isA(UpdateAccountForm.class), isA(Errors.class));
    verify(result).hasErrors();
    assertEquals("account/updateAccount", actualProcessUpdateAccountResult);
  }

  /**
   * Test {@link BroadleafUpdateAccountController#processUpdateAccount(HttpServletRequest, Model,
   * UpdateAccountForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Then throw {@link AuthenticationCredentialsNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafUpdateAccountController#processUpdateAccount(HttpServletRequest, Model,
   * UpdateAccountForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName(
      "Test processUpdateAccount(HttpServletRequest, Model, UpdateAccountForm, BindingResult, RedirectAttributes); then throw AuthenticationCredentialsNotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafUpdateAccountController.processUpdateAccount(HttpServletRequest, Model, UpdateAccountForm, BindingResult, RedirectAttributes)"
  })
  void testProcessUpdateAccount_thenThrowAuthenticationCredentialsNotFoundException()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(updateAccountValidator)
        .validate(Mockito.<UpdateAccountForm>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ConcurrentModel model = new ConcurrentModel();

    UpdateAccountForm form = new UpdateAccountForm();
    form.setEmailAddress("42 Main St");
    form.setFirstName("Jane");
    form.setLastName("Doe");
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(
        AuthenticationCredentialsNotFoundException.class,
        () ->
            broadleafUpdateAccountController.processUpdateAccount(
                request, model, form, result, new RedirectAttributesModelMap()));
    verify(updateAccountValidator).validate(isA(UpdateAccountForm.class), isA(Errors.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafUpdateAccountController}
   *   <li>{@link BroadleafUpdateAccountController#getAccountRedirectView()}
   *   <li>{@link BroadleafUpdateAccountController#getAccountUpdatedMessage()}
   *   <li>{@link BroadleafUpdateAccountController#getUpdateAccountView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafUpdateAccountController.<init>()",
    "String BroadleafUpdateAccountController.getAccountRedirectView()",
    "String BroadleafUpdateAccountController.getAccountUpdatedMessage()",
    "String BroadleafUpdateAccountController.getUpdateAccountView()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafUpdateAccountController actualBroadleafUpdateAccountController =
        new BroadleafUpdateAccountController();
    String actualAccountRedirectView =
        actualBroadleafUpdateAccountController.getAccountRedirectView();
    String actualAccountUpdatedMessage =
        actualBroadleafUpdateAccountController.getAccountUpdatedMessage();

    // Assert
    assertEquals("Account successfully updated", actualAccountUpdatedMessage);
    assertEquals(
        "account/updateAccount", actualBroadleafUpdateAccountController.getUpdateAccountView());
    assertEquals("redirect:/account", actualAccountRedirectView);
  }
}
