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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

class BroadleafLoginControllerDiffblueTest {
  /**
   * Method under test:
   * {@link BroadleafLoginController#login(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  void testLogin() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals("authentication/login", broadleafLoginController.login(request, response, new ConcurrentModel()));
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#login(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  void testLogin2() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(), new String[]{"successUrl"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals("authentication/login", broadleafLoginController.login(request, response, new ConcurrentModel()));
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#forgotPassword(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  void testForgotPassword() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals("authentication/forgotPassword",
        broadleafLoginController.forgotPassword(request, response, new ConcurrentModel()));
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#forgotPassword(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  void testForgotPassword2() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    Function<String, Object> function = mock(Function.class);
    when(function.apply(Mockito.<String>any())).thenReturn("Apply");

    ConcurrentModel model = new ConcurrentModel();
    model.computeIfAbsent("foo", function);

    // Act
    String actualForgotPasswordResult = broadleafLoginController.forgotPassword(request, response, model);

    // Assert
    verify(function).apply(eq("foo"));
    assertEquals("authentication/forgotPassword", actualForgotPasswordResult);
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#forcedPasswordChange(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  void testForcedPasswordChange() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals("authentication/forcedPasswordChange",
        broadleafLoginController.forcedPasswordChange(request, response, new ConcurrentModel()));
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#forcedPasswordChange(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  void testForcedPasswordChange2() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    Function<String, Object> function = mock(Function.class);
    when(function.apply(Mockito.<String>any())).thenReturn("Apply");

    ConcurrentModel model = new ConcurrentModel();
    model.computeIfAbsent("foo", function);

    // Act
    String actualForcedPasswordChangeResult = broadleafLoginController.forcedPasswordChange(request, response, model);

    // Assert
    verify(function).apply(eq("foo"));
    assertEquals("authentication/forcedPasswordChange", actualForcedPasswordChangeResult);
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#forgotUsername(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  void testForgotUsername() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals("authentication/forgotUsername",
        broadleafLoginController.forgotUsername(request, response, new ConcurrentModel()));
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#forgotUsername(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  void testForgotUsername2() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    Function<String, Object> function = mock(Function.class);
    when(function.apply(Mockito.<String>any())).thenReturn("Apply");

    ConcurrentModel model = new ConcurrentModel();
    model.computeIfAbsent("foo", function);

    // Act
    String actualForgotUsernameResult = broadleafLoginController.forgotUsername(request, response, model);

    // Assert
    verify(function).apply(eq("foo"));
    assertEquals("authentication/forgotUsername", actualForgotUsernameResult);
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#resetPassword(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  void testResetPassword() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    XssRequestWrapper servletRequest2 = new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"});

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest2);
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualResetPasswordResult = broadleafLoginController.resetPassword(request, response, model);

    // Assert
    assertEquals(1, model.size());
    Object getResult = model.get("resetPasswordForm");
    assertTrue(getResult instanceof ResetPasswordForm);
    assertEquals("authentication/resetPassword", actualResetPasswordResult);
    assertNull(((ResetPasswordForm) getResult).getPassword());
    assertNull(((ResetPasswordForm) getResult).getPasswordConfirm());
    assertNull(((ResetPasswordForm) getResult).getToken());
    assertNull(((ResetPasswordForm) getResult).getUsername());
    assertTrue(request.getTrailerFields().isEmpty());
    assertSame(servletRequest2, request.getRequest());
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#resetPassword(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  void testResetPassword2() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    XssRequestWrapper servletRequest2 = new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"token"});

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest2);
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualResetPasswordResult = broadleafLoginController.resetPassword(request, response, model);

    // Assert
    assertEquals(1, model.size());
    Object getResult = model.get("resetPasswordForm");
    assertTrue(getResult instanceof ResetPasswordForm);
    assertEquals("authentication/resetPassword", actualResetPasswordResult);
    assertNull(((ResetPasswordForm) getResult).getPassword());
    assertNull(((ResetPasswordForm) getResult).getPasswordConfirm());
    assertNull(((ResetPasswordForm) getResult).getToken());
    assertNull(((ResetPasswordForm) getResult).getUsername());
    assertTrue(request.getTrailerFields().isEmpty());
    assertSame(servletRequest2, request.getRequest());
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#resetPassword(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  void testResetPassword3() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    XssRequestWrapper servletRequest2 = new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"});

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest2);
    MockHttpServletResponse response = new MockHttpServletResponse();
    Function<String, Object> function = mock(Function.class);
    when(function.apply(Mockito.<String>any())).thenReturn("Apply");

    ConcurrentModel model = new ConcurrentModel();
    model.computeIfAbsent("token", function);

    // Act
    String actualResetPasswordResult = broadleafLoginController.resetPassword(request, response, model);

    // Assert
    verify(function).apply(eq("token"));
    assertEquals(2, model.size());
    Object getResult = model.get("resetPasswordForm");
    assertTrue(getResult instanceof ResetPasswordForm);
    assertEquals("authentication/resetPassword", actualResetPasswordResult);
    assertNull(((ResetPasswordForm) getResult).getPassword());
    assertNull(((ResetPasswordForm) getResult).getPasswordConfirm());
    assertNull(((ResetPasswordForm) getResult).getToken());
    assertNull(((ResetPasswordForm) getResult).getUsername());
    assertTrue(request.getTrailerFields().isEmpty());
    assertTrue(model.containsKey("token"));
    assertSame(servletRequest2, request.getRequest());
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#buildRedirectToLoginWithMessage(String)}
   */
  @Test
  void testBuildRedirectToLoginWithMessage() {
    // Arrange, Act and Assert
    assertEquals("redirect:authentication/login?messageCode=Not all who wander are lost",
        (new BroadleafLoginController()).buildRedirectToLoginWithMessage("Not all who wander are lost"));
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#initResetPasswordForm(HttpServletRequest)}
   */
  @Test
  void testInitResetPasswordForm() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    ResetPasswordForm actualInitResetPasswordFormResult = broadleafLoginController
        .initResetPasswordForm(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Assert
    assertNull(actualInitResetPasswordFormResult.getPassword());
    assertNull(actualInitResetPasswordFormResult.getPasswordConfirm());
    assertNull(actualInitResetPasswordFormResult.getToken());
    assertNull(actualInitResetPasswordFormResult.getUsername());
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#initResetPasswordForm(HttpServletRequest)}
   */
  @Test
  void testInitResetPasswordForm2() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    ResetPasswordForm actualInitResetPasswordFormResult = broadleafLoginController
        .initResetPasswordForm(new SearchRequestWrapper(
            new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(), new String[]{"token"})));

    // Assert
    assertNull(actualInitResetPasswordFormResult.getPassword());
    assertNull(actualInitResetPasswordFormResult.getPasswordConfirm());
    assertNull(actualInitResetPasswordFormResult.getToken());
    assertNull(actualInitResetPasswordFormResult.getUsername());
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#getResetPasswordScheme(HttpServletRequest)}
   */
  @Test
  void testGetResetPasswordScheme() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertEquals("http",
        broadleafLoginController.getResetPasswordScheme(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest, String)}
   */
  @Test
  void testGetResetPasswordPort() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertEquals("",
        broadleafLoginController.getResetPasswordPort(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})), "Scheme"));
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest, String)}
   */
  @Test
  void testGetResetPasswordPort2() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertEquals("",
        broadleafLoginController.getResetPasswordPort(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})), "http"));
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest, String)}
   */
  @Test
  void testGetResetPasswordPort3() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertEquals(":80",
        broadleafLoginController.getResetPasswordPort(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})), "https"));
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest, String)}
   */
  @Test
  void testGetResetPasswordPort4() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    servletRequest.setServerPort(8080);

    // Act and Assert
    assertEquals(":8080",
        broadleafLoginController.getResetPasswordPort(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})), "http"));
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}
   */
  @Test
  void testGetResetPasswordUrl() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertEquals("http://localhostauthentication/resetPassword",
        broadleafLoginController.getResetPasswordUrl(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}
   */
  @Test
  void testGetResetPasswordUrl2() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setContextPath(null);

    // Act and Assert
    assertEquals("http://localhostauthentication/resetPassword", broadleafLoginController.getResetPasswordUrl(request));
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}
   */
  @Test
  void testGetResetPasswordUrl3() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setContextPath("https://example.org/example");

    // Act and Assert
    assertEquals("http://localhosthttps://example.org/exampleauthentication/resetPassword",
        broadleafLoginController.getResetPasswordUrl(request));
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}
   */
  @Test
  void testGetResetPasswordUrl4() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    servletRequest.setScheme("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example://localhostauthentication/resetPassword",
        broadleafLoginController.getResetPasswordUrl(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}
   */
  @Test
  void testGetResetPasswordUrl5() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    servletRequest.setServerPort(8080);

    // Act and Assert
    assertEquals("http://localhost:8080authentication/resetPassword",
        broadleafLoginController.getResetPasswordUrl(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Method under test:
   * {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}
   */
  @Test
  void testGetResetPasswordUrl6() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    servletRequest.setScheme("https");

    // Act and Assert
    assertEquals("https://localhost:80authentication/resetPassword",
        broadleafLoginController.getResetPasswordUrl(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafLoginController}
   *   <li>{@link BroadleafLoginController#getForcedPasswordChangeSuccessView()}
   *   <li>{@link BroadleafLoginController#getForcedPasswordChangeView()}
   *   <li>{@link BroadleafLoginController#getForgotPasswordSuccessView()}
   *   <li>{@link BroadleafLoginController#getForgotPasswordView()}
   *   <li>{@link BroadleafLoginController#getForgotUsernameView()}
   *   <li>{@link BroadleafLoginController#getLoginView()}
   *   <li>{@link BroadleafLoginController#getResetPasswordErrorView()}
   *   <li>{@link BroadleafLoginController#getResetPasswordFormView()}
   *   <li>{@link BroadleafLoginController#getResetPasswordSuccessView()}
   *   <li>{@link BroadleafLoginController#getResetPasswordView()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafLoginController actualBroadleafLoginController = new BroadleafLoginController();
    String actualForcedPasswordChangeSuccessView = actualBroadleafLoginController.getForcedPasswordChangeSuccessView();
    String actualForcedPasswordChangeView = actualBroadleafLoginController.getForcedPasswordChangeView();
    String actualForgotPasswordSuccessView = actualBroadleafLoginController.getForgotPasswordSuccessView();
    String actualForgotPasswordView = actualBroadleafLoginController.getForgotPasswordView();
    String actualForgotUsernameView = actualBroadleafLoginController.getForgotUsernameView();
    String actualLoginView = actualBroadleafLoginController.getLoginView();
    String actualResetPasswordErrorView = actualBroadleafLoginController.getResetPasswordErrorView();
    String actualResetPasswordFormView = actualBroadleafLoginController.getResetPasswordFormView();
    String actualResetPasswordSuccessView = actualBroadleafLoginController.getResetPasswordSuccessView();

    // Assert
    assertEquals("authentication/forcedPasswordChange", actualForcedPasswordChangeView);
    assertEquals("authentication/forcedPasswordChangeSuccess", actualForcedPasswordChangeSuccessView);
    assertEquals("authentication/forgotPassword", actualForgotPasswordView);
    assertEquals("authentication/forgotPasswordSuccess", actualForgotPasswordSuccessView);
    assertEquals("authentication/forgotUsername", actualForgotUsernameView);
    assertEquals("authentication/login", actualLoginView);
    assertEquals("authentication/resetPassword", actualBroadleafLoginController.getResetPasswordView());
    assertEquals("authentication/resetPasswordError", actualResetPasswordErrorView);
    assertEquals("authentication/resetPasswordForm", actualResetPasswordFormView);
    assertEquals("redirect:/", actualResetPasswordSuccessView);
  }
}
