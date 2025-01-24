package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.service.GenericResponse;
import org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService;
import org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.broadleafcommerce.openadmin.web.form.ResetPasswordForm;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {AdminLoginController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminLoginControllerDiffblueTest {
  @Autowired
  private AdminLoginController adminLoginController;

  @MockBean
  private AdminNavigationService adminNavigationService;

  @MockBean
  private AdminSecurityService adminSecurityService;

  /**
   * Test
   * {@link AdminLoginController#baseLogin(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#baseLogin(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  public void testBaseLogin() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminLoginController adminLoginController = new AdminLoginController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals("Login View", adminLoginController.baseLogin(request, response, new ConcurrentModel()));
  }

  /**
   * Test
   * {@link AdminLoginController#baseLogin(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#baseLogin(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  public void testBaseLogin2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminLoginController adminLoginController = new AdminLoginController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals("Login View", adminLoginController.baseLogin(request, response, new ConcurrentModel()));
  }

  /**
   * Test
   * {@link AdminLoginController#baseLogin(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#baseLogin(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBaseLogin3() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminLoginController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8128 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminLoginController adminLoginController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService adminSecurityService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/login");

    // Act
    MockMvcBuilders.standaloneSetup(adminLoginController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminLoginController#loginSuccess(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#loginSuccess(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testLoginSuccess() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminLoginController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8132 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminLoginController adminLoginController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService adminSecurityService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");

    // Act
    MockMvcBuilders.standaloneSetup(adminLoginController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminLoginController#forgotPassword(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#forgotPassword(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  public void testForgotPassword() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminLoginController adminLoginController = new AdminLoginController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals("Forgot Password View", adminLoginController.forgotPassword(request, response, new ConcurrentModel()));
  }

  /**
   * Test
   * {@link AdminLoginController#forgotPassword(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#forgotPassword(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  public void testForgotPassword2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminLoginController adminLoginController = new AdminLoginController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals("Forgot Password View", adminLoginController.forgotPassword(request, response, new ConcurrentModel()));
  }

  /**
   * Test
   * {@link AdminLoginController#forgotPassword(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#forgotPassword(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testForgotPassword3() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminLoginController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8130 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminLoginController adminLoginController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService adminSecurityService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/forgotPassword");

    // Act
    MockMvcBuilders.standaloneSetup(adminLoginController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminLoginController#forgotUsername(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#forgotUsername(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  public void testForgotUsername() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminLoginController adminLoginController = new AdminLoginController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals("janedoe", adminLoginController.forgotUsername(request, response, new ConcurrentModel()));
  }

  /**
   * Test
   * {@link AdminLoginController#forgotUsername(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#forgotUsername(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  public void testForgotUsername2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminLoginController adminLoginController = new AdminLoginController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals("janedoe", adminLoginController.forgotUsername(request, response, new ConcurrentModel()));
  }

  /**
   * Test
   * {@link AdminLoginController#forgotUsername(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#forgotUsername(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testForgotUsername3() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminLoginController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8131 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminLoginController adminLoginController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService adminSecurityService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/forgotUsername");

    // Act
    MockMvcBuilders.standaloneSetup(adminLoginController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminLoginController#processSendResetPasswordEmail(HttpServletRequest, HttpServletResponse, String)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#processSendResetPasswordEmail(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcessSendResetPasswordEmail() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminLoginController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8135 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminLoginController adminLoginController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService adminSecurityService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/sendResetPassword")
        .param("username", "foo");

    // Act
    MockMvcBuilders.standaloneSetup(adminLoginController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminLoginController#processResetPassword(HttpServletRequest, HttpServletResponse, Model, ResetPasswordForm)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#processResetPassword(HttpServletRequest, HttpServletResponse, Model, ResetPasswordForm)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcessResetPassword() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminLoginController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8134 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminLoginController adminLoginController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService adminSecurityService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/resetPassword");

    // Act
    MockMvcBuilders.standaloneSetup(adminLoginController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminLoginController#processForgotUserName(HttpServletRequest, String)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#processForgotUserName(HttpServletRequest, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcessForgotUserName() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminLoginController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8133 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminLoginController adminLoginController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService adminSecurityService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/forgotUsername")
        .param("emailAddress", "foo");

    // Act
    MockMvcBuilders.standaloneSetup(adminLoginController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminLoginController#resetPassword(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#resetPassword(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  public void testResetPassword() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminLoginController adminLoginController = new AdminLoginController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals("Reset Password View", adminLoginController.resetPassword(request, response, new ConcurrentModel()));
  }

  /**
   * Test
   * {@link AdminLoginController#resetPassword(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#resetPassword(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  public void testResetPassword2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminLoginController adminLoginController = new AdminLoginController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals("Reset Password View", adminLoginController.resetPassword(request, response, new ConcurrentModel()));
  }

  /**
   * Test
   * {@link AdminLoginController#resetPassword(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#resetPassword(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResetPassword3() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminLoginController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8137 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminLoginController adminLoginController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService adminSecurityService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/resetPassword");

    // Act
    MockMvcBuilders.standaloneSetup(adminLoginController).build().perform(requestBuilder);
  }

  /**
   * Test {@link AdminLoginController#initResetPasswordForm(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#initResetPasswordForm(HttpServletRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInitResetPasswordForm() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminLoginController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8139 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminLoginController adminLoginController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService adminSecurityService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminLoginController.initResetPasswordForm(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
  }

  /**
   * Test {@link AdminLoginController#initResetPasswordForm(HttpServletRequest)}.
   * <ul>
   *   <li>Then return Token is {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminLoginController#initResetPasswordForm(HttpServletRequest)}
   */
  @Test
  public void testInitResetPasswordForm_thenReturnTokenIsHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminLoginController adminLoginController = new AdminLoginController();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    when(request.getSession(anyBoolean())).thenReturn(new MockHttpSession());

    // Act
    ResetPasswordForm actualInitResetPasswordFormResult = adminLoginController.initResetPasswordForm(request);

    // Assert
    verify(request).getSession(eq(true));
    verify(request).getParameter(eq("token"));
    assertEquals("https://example.org/example", actualInitResetPasswordFormResult.getToken());
    assertNull(actualInitResetPasswordFormResult.getConfirmPassword());
    assertNull(actualInitResetPasswordFormResult.getOldPassword());
    assertNull(actualInitResetPasswordFormResult.getPassword());
    assertNull(actualInitResetPasswordFormResult.getUsername());
  }

  /**
   * Test {@link AdminLoginController#initResetPasswordForm(HttpServletRequest)}.
   * <ul>
   *   <li>Then return Token is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminLoginController#initResetPasswordForm(HttpServletRequest)}
   */
  @Test
  public void testInitResetPasswordForm_thenReturnTokenIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminLoginController adminLoginController = new AdminLoginController();

    // Act
    ResetPasswordForm actualInitResetPasswordFormResult = adminLoginController
        .initResetPasswordForm(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));

    // Assert
    assertNull(actualInitResetPasswordFormResult.getConfirmPassword());
    assertNull(actualInitResetPasswordFormResult.getOldPassword());
    assertNull(actualInitResetPasswordFormResult.getPassword());
    assertNull(actualInitResetPasswordFormResult.getToken());
    assertNull(actualInitResetPasswordFormResult.getUsername());
  }

  /**
   * Test
   * {@link AdminLoginController#changePassword(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#changePassword(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testChangePassword() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminLoginController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8129 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminLoginController adminLoginController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService adminSecurityService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/changePassword");

    // Act
    MockMvcBuilders.standaloneSetup(adminLoginController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminLoginController#processchangePassword(HttpServletRequest, HttpServletResponse, Model, ResetPasswordForm)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#processchangePassword(HttpServletRequest, HttpServletResponse, Model, ResetPasswordForm)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcesschangePassword() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminLoginController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8136 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminLoginController adminLoginController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService adminSecurityService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/changePassword");

    // Act
    MockMvcBuilders.standaloneSetup(adminLoginController).build().perform(requestBuilder);
  }

  /**
   * Test {@link AdminLoginController#redirectToLoginWithMessage(String)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#redirectToLoginWithMessage(String)}
   */
  @Test
  public void testRedirectToLoginWithMessage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminLoginController adminLoginController = new AdminLoginController();
    adminLoginController.setAdminSecurityService(mock(AdminSecurityServiceImpl.class));

    // Act and Assert
    assertEquals("redirect:Login Redirect?messageCode=Not all who wander are lost",
        adminLoginController.redirectToLoginWithMessage("Not all who wander are lost"));
  }

  /**
   * Test {@link AdminLoginController#redirectToLoginWithMessage(String)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#redirectToLoginWithMessage(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRedirectToLoginWithMessage2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminLoginController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8140 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminLoginController adminLoginController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService adminSecurityService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminLoginController.redirectToLoginWithMessage("Not all who wander are lost");
  }

  /**
   * Test {@link AdminLoginController#redirectToLoginWithMessage(String)}.
   * <ul>
   *   <li>Given {@link AdminLoginController} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminLoginController#redirectToLoginWithMessage(String)}
   */
  @Test
  public void testRedirectToLoginWithMessage_givenAdminLoginController() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:Login Redirect?messageCode=Not all who wander are lost",
        (new AdminLoginController()).redirectToLoginWithMessage("Not all who wander are lost"));
  }

  /**
   * Test {@link AdminLoginController#redirectToResetPasswordWithMessage(String)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#redirectToResetPasswordWithMessage(String)}
   */
  @Test
  public void testRedirectToResetPasswordWithMessage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminLoginController adminLoginController = new AdminLoginController();
    adminLoginController.setAdminSecurityService(mock(AdminSecurityServiceImpl.class));

    // Act and Assert
    assertEquals("redirect:Reset Password Redirect?messageCode=Not all who wander are lost",
        adminLoginController.redirectToResetPasswordWithMessage("Not all who wander are lost"));
  }

  /**
   * Test {@link AdminLoginController#redirectToResetPasswordWithMessage(String)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#redirectToResetPasswordWithMessage(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRedirectToResetPasswordWithMessage2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminLoginController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8141 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminLoginController adminLoginController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService adminSecurityService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminLoginController.redirectToResetPasswordWithMessage("Not all who wander are lost");
  }

  /**
   * Test {@link AdminLoginController#redirectToResetPasswordWithMessage(String)}.
   * <ul>
   *   <li>Given {@link AdminLoginController} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminLoginController#redirectToResetPasswordWithMessage(String)}
   */
  @Test
  public void testRedirectToResetPasswordWithMessage_givenAdminLoginController() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:Reset Password Redirect?messageCode=Not all who wander are lost",
        (new AdminLoginController()).redirectToResetPasswordWithMessage("Not all who wander are lost"));
  }

  /**
   * Test
   * {@link AdminLoginController#setErrors(GenericResponse, HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link AdminLoginController#setErrors(GenericResponse, HttpServletRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetErrors() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminLoginController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8142 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminLoginController adminLoginController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService adminSecurityService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    GenericResponse response = new GenericResponse();

    // Act
    adminLoginController.setErrors(response, new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
  }

  /**
   * Test
   * {@link AdminLoginController#setErrors(GenericResponse, HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then calls {@link GenericResponse#getErrorCodesList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminLoginController#setErrors(GenericResponse, HttpServletRequest)}
   */
  @Test
  public void testSetErrors_givenArrayListAddFoo_thenCallsGetErrorCodesList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminLoginController adminLoginController = new AdminLoginController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    GenericResponse response = mock(GenericResponse.class);
    when(response.getErrorCodesList()).thenReturn(stringList);

    // Act
    adminLoginController.setErrors(response, new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));

    // Assert
    verify(response).getErrorCodesList();
  }

  /**
   * Test {@link AdminLoginController#getPersistentAdminUser()}.
   * <p>
   * Method under test: {@link AdminLoginController#getPersistentAdminUser()}
   */
  @Test
  public void testGetPersistentAdminUser() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminLoginController adminLoginController = new AdminLoginController();
    adminLoginController.setAdminSecurityService(mock(AdminSecurityServiceImpl.class));

    // Act and Assert
    assertNull(adminLoginController.getPersistentAdminUser());
  }

  /**
   * Test {@link AdminLoginController#getPersistentAdminUser()}.
   * <p>
   * Method under test: {@link AdminLoginController#getPersistentAdminUser()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPersistentAdminUser2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminLoginController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8138 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminLoginController adminLoginController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService adminSecurityService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminLoginController.getPersistentAdminUser();
  }

  /**
   * Test {@link AdminLoginController#getPersistentAdminUser()}.
   * <ul>
   *   <li>Given {@link AdminLoginController} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminLoginController#getPersistentAdminUser()}
   */
  @Test
  public void testGetPersistentAdminUser_givenAdminLoginController() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminLoginController()).getPersistentAdminUser());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AdminLoginController#setAdminSecurityService(AdminSecurityService)}
   *   <li>{@link AdminLoginController#getChangePasswordView()}
   *   <li>{@link AdminLoginController#getForgotPasswordView()}
   *   <li>{@link AdminLoginController#getForgotUsernameView()}
   *   <li>{@link AdminLoginController#getLoginRedirect()}
   *   <li>{@link AdminLoginController#getLoginView()}
   *   <li>{@link AdminLoginController#getResetPasswordRedirect()}
   *   <li>{@link AdminLoginController#getResetPasswordView()}
   *   <li>{@link AdminLoginController#setChangePasswordView(String)}
   *   <li>{@link AdminLoginController#setForgotPasswordView(String)}
   *   <li>{@link AdminLoginController#setForgotUsernameView(String)}
   *   <li>{@link AdminLoginController#setLoginRedirect(String)}
   *   <li>{@link AdminLoginController#setLoginView(String)}
   *   <li>{@link AdminLoginController#setResetPasswordRedirect(String)}
   *   <li>{@link AdminLoginController#setResetPasswordView(String)}
   *   <li>{@link AdminLoginController#getAdminSecurityService()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AdminLoginController adminLoginController = new AdminLoginController();
    AdminSecurityServiceImpl adminSecurityService = new AdminSecurityServiceImpl();

    // Act
    adminLoginController.setAdminSecurityService(adminSecurityService);
    String actualChangePasswordView = adminLoginController.getChangePasswordView();
    String actualForgotPasswordView = adminLoginController.getForgotPasswordView();
    String actualForgotUsernameView = adminLoginController.getForgotUsernameView();
    String actualLoginRedirect = adminLoginController.getLoginRedirect();
    String actualLoginView = adminLoginController.getLoginView();
    String actualResetPasswordRedirect = adminLoginController.getResetPasswordRedirect();
    String actualResetPasswordView = adminLoginController.getResetPasswordView();
    adminLoginController.setChangePasswordView("Change Password View");
    adminLoginController.setForgotPasswordView("Forgot Password View");
    adminLoginController.setForgotUsernameView("janedoe");
    adminLoginController.setLoginRedirect("Login Redirect");
    adminLoginController.setLoginView("Login View");
    adminLoginController.setResetPasswordRedirect("Reset Password Redirect");
    adminLoginController.setResetPasswordView("Reset Password View");

    // Assert that nothing has changed
    assertEquals("Change Password View", actualChangePasswordView);
    assertEquals("Forgot Password View", actualForgotPasswordView);
    assertEquals("Login Redirect", actualLoginRedirect);
    assertEquals("Login View", actualLoginView);
    assertEquals("Reset Password Redirect", actualResetPasswordRedirect);
    assertEquals("Reset Password View", actualResetPasswordView);
    assertEquals("janedoe", actualForgotUsernameView);
    assertSame(adminSecurityService, adminLoginController.getAdminSecurityService());
  }
}
