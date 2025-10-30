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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

class BroadleafLoginControllerDiffblueTest {
  /**
   * Test {@link BroadleafLoginController#login(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test: {@link BroadleafLoginController#login(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test login(HttpServletRequest, HttpServletResponse, Model)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.login(HttpServletRequest, HttpServletResponse, Model)"})
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
   * Test {@link BroadleafLoginController#login(HttpServletRequest, HttpServletResponse, Model)}.
   * <ul>
   *   <li>Then return {@code authentication/login}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafLoginController#login(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test login(HttpServletRequest, HttpServletResponse, Model); then return 'authentication/login'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.login(HttpServletRequest, HttpServletResponse, Model)"})
  void testLogin_thenReturnAuthenticationLogin() {
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
   * Test {@link BroadleafLoginController#forgotPassword(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test: {@link BroadleafLoginController#forgotPassword(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test forgotPassword(HttpServletRequest, HttpServletResponse, Model)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.forgotPassword(HttpServletRequest, HttpServletResponse, Model)"})
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
   * Test {@link BroadleafLoginController#forcedPasswordChange(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test: {@link BroadleafLoginController#forcedPasswordChange(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test forcedPasswordChange(HttpServletRequest, HttpServletResponse, Model)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafLoginController.forcedPasswordChange(HttpServletRequest, HttpServletResponse, Model)"})
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
   * Test {@link BroadleafLoginController#forgotUsername(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test: {@link BroadleafLoginController#forgotUsername(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test forgotUsername(HttpServletRequest, HttpServletResponse, Model)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.forgotUsername(HttpServletRequest, HttpServletResponse, Model)"})
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
   * Test {@link BroadleafLoginController#resetPassword(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test: {@link BroadleafLoginController#resetPassword(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test resetPassword(HttpServletRequest, HttpServletResponse, Model)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.resetPassword(HttpServletRequest, HttpServletResponse, Model)"})
  void testResetPassword() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
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
  }

  /**
   * Test {@link BroadleafLoginController#resetPassword(HttpServletRequest, HttpServletResponse, Model)}.
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafLoginController#resetPassword(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test resetPassword(HttpServletRequest, HttpServletResponse, Model); then ConcurrentModel() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.resetPassword(HttpServletRequest, HttpServletResponse, Model)"})
  void testResetPassword_thenConcurrentModelSizeIsOne() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(), new String[]{"token"}));
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
  }

  /**
   * Test {@link BroadleafLoginController#buildRedirectToLoginWithMessage(String)}.
   * <p>
   * Method under test: {@link BroadleafLoginController#buildRedirectToLoginWithMessage(String)}
   */
  @Test
  @DisplayName("Test buildRedirectToLoginWithMessage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.buildRedirectToLoginWithMessage(String)"})
  void testBuildRedirectToLoginWithMessage() {
    // Arrange, Act and Assert
    assertEquals("redirect:authentication/login?messageCode=Not all who wander are lost",
        (new BroadleafLoginController()).buildRedirectToLoginWithMessage("Not all who wander are lost"));
  }

  /**
   * Test {@link BroadleafLoginController#initResetPasswordForm(HttpServletRequest)}.
   * <p>
   * Method under test: {@link BroadleafLoginController#initResetPasswordForm(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test initResetPasswordForm(HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResetPasswordForm BroadleafLoginController.initResetPasswordForm(HttpServletRequest)"})
  void testInitResetPasswordForm() {
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
   * Test {@link BroadleafLoginController#initResetPasswordForm(HttpServletRequest)}.
   * <ul>
   *   <li>Then return Password is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafLoginController#initResetPasswordForm(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test initResetPasswordForm(HttpServletRequest); then return Password is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResetPasswordForm BroadleafLoginController.initResetPasswordForm(HttpServletRequest)"})
  void testInitResetPasswordForm_thenReturnPasswordIsNull() {
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
   * Test {@link BroadleafLoginController#getResetPasswordScheme(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code http}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafLoginController#getResetPasswordScheme(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getResetPasswordScheme(HttpServletRequest); then return 'http'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.getResetPasswordScheme(HttpServletRequest)"})
  void testGetResetPasswordScheme_thenReturnHttp() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertEquals("http",
        broadleafLoginController.getResetPasswordScheme(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest, String)}.
   * <ul>
   *   <li>Given {@code 8080}.</li>
   *   <li>Then return {@code :8080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest, String)}
   */
  @Test
  @DisplayName("Test getResetPasswordPort(HttpServletRequest, String); given '8080'; then return ':8080'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.getResetPasswordPort(HttpServletRequest, String)"})
  void testGetResetPasswordPort_given8080_thenReturn8080() {
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
   * Test {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest, String)}.
   * <ul>
   *   <li>When {@code http}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest, String)}
   */
  @Test
  @DisplayName("Test getResetPasswordPort(HttpServletRequest, String); when 'http'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.getResetPasswordPort(HttpServletRequest, String)"})
  void testGetResetPasswordPort_whenHttp_thenReturnEmptyString() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertEquals("",
        broadleafLoginController.getResetPasswordPort(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})), "http"));
  }

  /**
   * Test {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest, String)}.
   * <ul>
   *   <li>When {@code https}.</li>
   *   <li>Then return {@code :80}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest, String)}
   */
  @Test
  @DisplayName("Test getResetPasswordPort(HttpServletRequest, String); when 'https'; then return ':80'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.getResetPasswordPort(HttpServletRequest, String)"})
  void testGetResetPasswordPort_whenHttps_thenReturn80() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertEquals(":80",
        broadleafLoginController.getResetPasswordPort(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})), "https"));
  }

  /**
   * Test {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest, String)}.
   * <ul>
   *   <li>When {@code Scheme}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest, String)}
   */
  @Test
  @DisplayName("Test getResetPasswordPort(HttpServletRequest, String); when 'Scheme'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.getResetPasswordPort(HttpServletRequest, String)"})
  void testGetResetPasswordPort_whenScheme_thenReturnEmptyString() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertEquals("",
        broadleafLoginController.getResetPasswordPort(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})), "Scheme"));
  }

  /**
   * Test {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}.
   * <p>
   * Method under test: {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getResetPasswordUrl(HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.getResetPasswordUrl(HttpServletRequest)"})
  void testGetResetPasswordUrl() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setContextPath("https://example.org/example");

    // Act and Assert
    assertEquals("http://localhosthttps://example.org/exampleauthentication/resetPassword",
        broadleafLoginController.getResetPasswordUrl(request));
  }

  /**
   * Test {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}.
   * <p>
   * Method under test: {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getResetPasswordUrl(HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.getResetPasswordUrl(HttpServletRequest)"})
  void testGetResetPasswordUrl2() {
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
   * Test {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} ContextPath is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getResetPasswordUrl(HttpServletRequest); given 'null'; when MockHttpServletRequest() ContextPath is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.getResetPasswordUrl(HttpServletRequest)"})
  void testGetResetPasswordUrl_givenNull_whenMockHttpServletRequestContextPathIsNull() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setContextPath(null);

    // Act and Assert
    assertEquals("http://localhostauthentication/resetPassword", broadleafLoginController.getResetPasswordUrl(request));
  }

  /**
   * Test {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code http://localhost:8080authentication/resetPassword}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getResetPasswordUrl(HttpServletRequest); then return 'http://localhost:8080authentication/resetPassword'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.getResetPasswordUrl(HttpServletRequest)"})
  void testGetResetPasswordUrl_thenReturnHttpLocalhost8080authenticationResetPassword() {
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
   * Test {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code http://localhostauthentication/resetPassword}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getResetPasswordUrl(HttpServletRequest); then return 'http://localhostauthentication/resetPassword'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.getResetPasswordUrl(HttpServletRequest)"})
  void testGetResetPasswordUrl_thenReturnHttpLocalhostauthenticationResetPassword() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertEquals("http://localhostauthentication/resetPassword",
        broadleafLoginController.getResetPasswordUrl(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code https://localhost:80authentication/resetPassword}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getResetPasswordUrl(HttpServletRequest); then return 'https://localhost:80authentication/resetPassword'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafLoginController.getResetPasswordUrl(HttpServletRequest)"})
  void testGetResetPasswordUrl_thenReturnHttpsLocalhost80authenticationResetPassword() {
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafLoginController.<init>()",
      "String BroadleafLoginController.getForcedPasswordChangeSuccessView()",
      "String BroadleafLoginController.getForcedPasswordChangeView()",
      "String BroadleafLoginController.getForgotPasswordSuccessView()",
      "String BroadleafLoginController.getForgotPasswordView()",
      "String BroadleafLoginController.getForgotUsernameView()", "String BroadleafLoginController.getLoginView()",
      "String BroadleafLoginController.getResetPasswordErrorView()",
      "String BroadleafLoginController.getResetPasswordFormView()",
      "String BroadleafLoginController.getResetPasswordSuccessView()",
      "String BroadleafLoginController.getResetPasswordView()"})
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
