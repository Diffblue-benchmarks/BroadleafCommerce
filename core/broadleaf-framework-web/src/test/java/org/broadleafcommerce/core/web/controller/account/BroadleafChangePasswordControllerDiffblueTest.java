package org.broadleafcommerce.core.web.controller.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

class BroadleafChangePasswordControllerDiffblueTest {
  /**
   * Test
   * {@link BroadleafChangePasswordController#viewChangePassword(HttpServletRequest, Model)}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return
   * {@code Apply}.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafChangePasswordController#viewChangePassword(HttpServletRequest, Model)}
   */
  @Test
  @DisplayName("Test viewChangePassword(HttpServletRequest, Model); given Function apply(Object) return 'Apply'; then calls apply(Object)")
  void testViewChangePassword_givenFunctionApplyReturnApply_thenCallsApply() {
    // Arrange
    BroadleafChangePasswordController broadleafChangePasswordController = new BroadleafChangePasswordController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    Function<String, Object> function = mock(Function.class);
    when(function.apply(Mockito.<String>any())).thenReturn("Apply");

    ConcurrentModel model = new ConcurrentModel();
    model.computeIfAbsent("foo", function);

    // Act
    String actualViewChangePasswordResult = broadleafChangePasswordController.viewChangePassword(request, model);

    // Assert
    verify(function).apply(eq("foo"));
    assertEquals("account/changePassword", actualViewChangePasswordResult);
  }

  /**
   * Test
   * {@link BroadleafChangePasswordController#viewChangePassword(HttpServletRequest, Model)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafChangePasswordController#viewChangePassword(HttpServletRequest, Model)}
   */
  @Test
  @DisplayName("Test viewChangePassword(HttpServletRequest, Model); when ConcurrentModel()")
  void testViewChangePassword_whenConcurrentModel() {
    // Arrange
    BroadleafChangePasswordController broadleafChangePasswordController = new BroadleafChangePasswordController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertEquals("account/changePassword",
        broadleafChangePasswordController.viewChangePassword(request, new ConcurrentModel()));
  }

  /**
   * Test
   * {@link BroadleafChangePasswordController#processChangePassword(HttpServletRequest, Model, ChangePasswordForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafChangePasswordController#processChangePassword(HttpServletRequest, Model, ChangePasswordForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test processChangePassword(HttpServletRequest, Model, ChangePasswordForm, BindingResult, RedirectAttributes); when ConcurrentModel()")
  @Disabled("TODO: Complete this test")
  void testProcessChangePassword_whenConcurrentModel() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.controller.account.BroadleafChangePasswordController.processChangePassword(BroadleafChangePasswordController.java:53)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BroadleafChangePasswordController broadleafChangePasswordController = new BroadleafChangePasswordController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    ChangePasswordForm form = new ChangePasswordForm();
    form.setCurrentPassword("iloveyou");
    form.setNewPassword("iloveyou");
    form.setNewPasswordConfirm("New Password Confirm");
    BindException result = new BindException("Target", "Object Name");

    // Act
    broadleafChangePasswordController.processChangePassword(request, model, form, result,
        new RedirectAttributesModelMap());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafChangePasswordController}
   *   <li>{@link BroadleafChangePasswordController#getChangePasswordRedirect()}
   *   <li>{@link BroadleafChangePasswordController#getChangePasswordView()}
   *   <li>{@link BroadleafChangePasswordController#getPasswordChangedMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafChangePasswordController actualBroadleafChangePasswordController = new BroadleafChangePasswordController();
    String actualChangePasswordRedirect = actualBroadleafChangePasswordController.getChangePasswordRedirect();
    String actualChangePasswordView = actualBroadleafChangePasswordController.getChangePasswordView();

    // Assert
    assertEquals("Password successfully changed", actualBroadleafChangePasswordController.getPasswordChangedMessage());
    assertEquals("account/changePassword", actualChangePasswordView);
    assertEquals("redirect:/account/password", actualChangePasswordRedirect);
  }
}
