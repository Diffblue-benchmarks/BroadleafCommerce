package org.broadleafcommerce.core.web.controller.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

public class BroadleafLoginControllerDiffblueTest {
  /**
   * Test {@link BroadleafLoginController#login(HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafLoginController#login(HttpServletRequest,
   * HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafLoginController.login(HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testLogin_givenEmptyString() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("successUrl", "");
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertEquals("authentication/login", broadleafLoginController.login(request, response, model));
    assertTrue(model.isEmpty());
  }

  /**
   * Test {@link BroadleafLoginController#login(HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Given {@code not blank}.
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafLoginController#login(HttpServletRequest,
   * HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafLoginController.login(HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testLogin_givenNotBlank_thenConcurrentModelSizeIsOne() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("successUrl", "not blank");
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafLoginController.login(request, response, model);

    // Assert
    assertEquals(1, model.size());
    assertEquals("not blank", model.get("successUrl"));
  }

  /**
   * Test {@link BroadleafLoginController#login(HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Given space.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code
   *       successUrl} and space.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafLoginController#login(HttpServletRequest,
   * HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafLoginController.login(HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testLogin_givenSpace_whenMockHttpServletRequestAddParameterSuccessUrlAndSpace() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("successUrl", " ");
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertEquals("authentication/login", broadleafLoginController.login(request, response, model));
    assertTrue(model.isEmpty());
  }

  /**
   * Test {@link BroadleafLoginController#login(HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return {@code authentication/login}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafLoginController#login(HttpServletRequest,
   * HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafLoginController.login(HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testLogin_whenMockHttpServletRequest_thenReturnAuthenticationLogin() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertEquals("authentication/login", broadleafLoginController.login(request, response, model));
    assertTrue(model.isEmpty());
  }

  /**
   * Test {@link BroadleafLoginController#forgotPassword(HttpServletRequest, HttpServletResponse,
   * Model)}.
   *
   * <p>Method under test: {@link BroadleafLoginController#forgotPassword(HttpServletRequest,
   * HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafLoginController.forgotPassword(HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testForgotPassword() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals(
        "authentication/forgotPassword",
        broadleafLoginController.forgotPassword(request, response, new ConcurrentModel()));
  }

  /**
   * Test {@link BroadleafLoginController#forcedPasswordChange(HttpServletRequest,
   * HttpServletResponse, Model)}.
   *
   * <p>Method under test: {@link BroadleafLoginController#forcedPasswordChange(HttpServletRequest,
   * HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafLoginController.forcedPasswordChange(HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testForcedPasswordChange() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals(
        "authentication/forcedPasswordChange",
        broadleafLoginController.forcedPasswordChange(request, response, new ConcurrentModel()));
  }

  /**
   * Test {@link BroadleafLoginController#forgotUsername(HttpServletRequest, HttpServletResponse,
   * Model)}.
   *
   * <p>Method under test: {@link BroadleafLoginController#forgotUsername(HttpServletRequest,
   * HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafLoginController.forgotUsername(HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testForgotUsername() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals(
        "authentication/forgotUsername",
        broadleafLoginController.forgotUsername(request, response, new ConcurrentModel()));
  }

  /**
   * Test {@link BroadleafLoginController#resetPassword(HttpServletRequest, HttpServletResponse,
   * Model)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafLoginController#resetPassword(HttpServletRequest,
   * HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafLoginController.resetPassword(HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testResetPassword_whenMockHttpServletRequest_thenConcurrentModelSizeIsOne() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualResetPasswordResult =
        broadleafLoginController.resetPassword(request, response, model);

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
   *
   * <p>Method under test: {@link BroadleafLoginController#buildRedirectToLoginWithMessage(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafLoginController.buildRedirectToLoginWithMessage(String)"})
  public void testBuildRedirectToLoginWithMessage() {
    // Arrange, Act and Assert
    assertEquals(
        "redirect:authentication/login?messageCode=Not all who wander are lost",
        new BroadleafLoginController()
            .buildRedirectToLoginWithMessage("Not all who wander are lost"));
  }

  /**
   * Test {@link BroadleafLoginController#initResetPasswordForm(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return Password is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafLoginController#initResetPasswordForm(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResetPasswordForm BroadleafLoginController.initResetPasswordForm(HttpServletRequest)"
  })
  public void testInitResetPasswordForm_whenMockHttpServletRequest_thenReturnPasswordIsNull() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    // Act
    ResetPasswordForm actualInitResetPasswordFormResult =
        broadleafLoginController.initResetPasswordForm(new MockHttpServletRequest());

    // Assert
    assertNull(actualInitResetPasswordFormResult.getPassword());
    assertNull(actualInitResetPasswordFormResult.getPasswordConfirm());
    assertNull(actualInitResetPasswordFormResult.getToken());
    assertNull(actualInitResetPasswordFormResult.getUsername());
  }

  /**
   * Test {@link BroadleafLoginController#getResetPasswordScheme(HttpServletRequest)}.
   *
   * <p>Method under test: {@link
   * BroadleafLoginController#getResetPasswordScheme(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafLoginController.getResetPasswordScheme(HttpServletRequest)"})
  public void testGetResetPasswordScheme() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    // Act and Assert
    assertEquals(
        "http", broadleafLoginController.getResetPasswordScheme(new MockHttpServletRequest()));
  }

  /**
   * Test {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>When {@code http}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafLoginController.getResetPasswordPort(HttpServletRequest, String)"
  })
  public void testGetResetPasswordPort_whenHttp_thenReturnEmptyString() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    // Act and Assert
    assertEquals(
        "", broadleafLoginController.getResetPasswordPort(new MockHttpServletRequest(), "http"));
  }

  /**
   * Test {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>When {@code https}.
   *   <li>Then return {@code :80}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafLoginController.getResetPasswordPort(HttpServletRequest, String)"
  })
  public void testGetResetPasswordPort_whenHttps_thenReturn80() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    // Act and Assert
    assertEquals(
        ":80",
        broadleafLoginController.getResetPasswordPort(new MockHttpServletRequest(), "https"));
  }

  /**
   * Test {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>When {@code Scheme}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafLoginController#getResetPasswordPort(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafLoginController.getResetPasswordPort(HttpServletRequest, String)"
  })
  public void testGetResetPasswordPort_whenScheme_thenReturnEmptyString() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    // Act and Assert
    assertEquals(
        "", broadleafLoginController.getResetPasswordPort(new MockHttpServletRequest(), "Scheme"));
  }

  /**
   * Test {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafLoginController.getResetPasswordUrl(HttpServletRequest)"})
  public void testGetResetPasswordUrl_givenNull() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setContextPath(null);

    // Act
    String actualResetPasswordUrl = broadleafLoginController.getResetPasswordUrl(request);

    // Assert
    assertEquals("http://localhostauthentication/resetPassword", actualResetPasswordUrl);
  }

  /**
   * Test {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return {@code http://localhost authentication/resetPassword}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafLoginController.getResetPasswordUrl(HttpServletRequest)"})
  public void testGetResetPasswordUrl_thenReturnHttpLocalhostAuthenticationResetPassword() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setContextPath("  ");

    // Act
    String actualResetPasswordUrl = broadleafLoginController.getResetPasswordUrl(request);

    // Assert
    assertEquals("http://localhost  authentication/resetPassword", actualResetPasswordUrl);
  }

  /**
   * Test {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafLoginController#getResetPasswordUrl(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafLoginController.getResetPasswordUrl(HttpServletRequest)"})
  public void testGetResetPasswordUrl_whenMockHttpServletRequest() {
    // Arrange
    BroadleafLoginController broadleafLoginController = new BroadleafLoginController();

    // Act and Assert
    assertEquals(
        "http://localhostauthentication/resetPassword",
        broadleafLoginController.getResetPasswordUrl(new MockHttpServletRequest()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafLoginController.<init>()",
    "String BroadleafLoginController.getForcedPasswordChangeSuccessView()",
    "String BroadleafLoginController.getForcedPasswordChangeView()",
    "String BroadleafLoginController.getForgotPasswordSuccessView()",
    "String BroadleafLoginController.getForgotPasswordView()",
    "String BroadleafLoginController.getForgotUsernameView()",
    "String BroadleafLoginController.getLoginView()",
    "String BroadleafLoginController.getResetPasswordErrorView()",
    "String BroadleafLoginController.getResetPasswordFormView()",
    "String BroadleafLoginController.getResetPasswordSuccessView()",
    "String BroadleafLoginController.getResetPasswordView()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BroadleafLoginController actualBroadleafLoginController = new BroadleafLoginController();
    String actualForcedPasswordChangeSuccessView =
        actualBroadleafLoginController.getForcedPasswordChangeSuccessView();
    String actualForcedPasswordChangeView =
        actualBroadleafLoginController.getForcedPasswordChangeView();
    String actualForgotPasswordSuccessView =
        actualBroadleafLoginController.getForgotPasswordSuccessView();
    String actualForgotPasswordView = actualBroadleafLoginController.getForgotPasswordView();
    String actualForgotUsernameView = actualBroadleafLoginController.getForgotUsernameView();
    String actualLoginView = actualBroadleafLoginController.getLoginView();
    String actualResetPasswordErrorView =
        actualBroadleafLoginController.getResetPasswordErrorView();
    String actualResetPasswordFormView = actualBroadleafLoginController.getResetPasswordFormView();
    String actualResetPasswordSuccessView =
        actualBroadleafLoginController.getResetPasswordSuccessView();

    // Assert
    assertEquals("authentication/forcedPasswordChange", actualForcedPasswordChangeView);
    assertEquals(
        "authentication/forcedPasswordChangeSuccess", actualForcedPasswordChangeSuccessView);
    assertEquals("authentication/forgotPassword", actualForgotPasswordView);
    assertEquals("authentication/forgotPasswordSuccess", actualForgotPasswordSuccessView);
    assertEquals("authentication/forgotUsername", actualForgotUsernameView);
    assertEquals("authentication/login", actualLoginView);
    assertEquals(
        "authentication/resetPassword", actualBroadleafLoginController.getResetPasswordView());
    assertEquals("authentication/resetPasswordError", actualResetPasswordErrorView);
    assertEquals("authentication/resetPasswordForm", actualResetPasswordFormView);
    assertEquals("redirect:/", actualResetPasswordSuccessView);
  }
}
