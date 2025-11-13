package org.broadleafcommerce.core.web.controller.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.web.controller.account.validator.UpdateAccountValidator;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
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

@RunWith(MockitoJUnitRunner.class)
public class BroadleafUpdateAccountControllerDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafUpdateAccountController.processUpdateAccount(HttpServletRequest, Model, UpdateAccountForm, BindingResult, RedirectAttributes)"
  })
  public void testProcessUpdateAccount() throws ServiceException {
    // Arrange
    doThrow(
            new AuthenticationCredentialsNotFoundException(
                "Authentication was null, not authenticated, or not logged in."))
        .when(updateAccountValidator)
        .validate(Mockito.<UpdateAccountForm>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafUpdateAccountController.processUpdateAccount(HttpServletRequest, Model, UpdateAccountForm, BindingResult, RedirectAttributes)"
  })
  public void testProcessUpdateAccount_givenTrue_thenReturnAccountUpdateAccount()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(updateAccountValidator)
        .validate(Mockito.<UpdateAccountForm>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafUpdateAccountController.processUpdateAccount(HttpServletRequest, Model, UpdateAccountForm, BindingResult, RedirectAttributes)"
  })
  public void testProcessUpdateAccount_thenThrowAuthenticationCredentialsNotFoundException()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(updateAccountValidator)
        .validate(Mockito.<UpdateAccountForm>any(), Mockito.<Errors>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafUpdateAccountController.<init>()",
    "String BroadleafUpdateAccountController.getAccountRedirectView()",
    "String BroadleafUpdateAccountController.getAccountUpdatedMessage()",
    "String BroadleafUpdateAccountController.getUpdateAccountView()"
  })
  public void testGettersAndSetters() {
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
