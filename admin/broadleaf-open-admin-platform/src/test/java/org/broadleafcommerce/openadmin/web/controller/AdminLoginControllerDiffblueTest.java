package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.openadmin.server.security.domain.AdminMenu;
import org.broadleafcommerce.openadmin.server.security.domain.AdminModule;
import org.broadleafcommerce.openadmin.server.security.domain.AdminModuleDTO;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.web.form.ResetPasswordForm;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class AdminLoginControllerDiffblueTest {
  @InjectMocks private AdminLoginController adminLoginController;

  @Mock private AdminNavigationService adminNavigationService;

  /**
   * Test {@link AdminLoginController#loginSuccess(HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <p>Method under test: {@link AdminLoginController#loginSuccess(HttpServletRequest,
   * HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String AdminLoginController.loginSuccess(HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testLoginSuccess() throws Exception {
    // Arrange
    AdminMenu adminMenu = new AdminMenu();
    adminMenu.setAdminModule(new ArrayList<>());
    when(adminNavigationService.buildMenu(Mockito.<AdminUser>any())).thenReturn(adminMenu);

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminLoginController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(1))
        .andExpect(model().attributeExists("resetPasswordForm"))
        .andExpect(view().name("noAccess"))
        .andExpect(forwardedUrl("noAccess"));
  }

  /**
   * Test {@link AdminLoginController#loginSuccess(HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminModuleDTO} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminLoginController#loginSuccess(HttpServletRequest,
   * HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String AdminLoginController.loginSuccess(HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testLoginSuccess_givenArrayListAddAdminModuleDTO() throws Exception {
    // Arrange
    ArrayList<AdminModule> adminModules = new ArrayList<>();
    adminModules.add(new AdminModuleDTO());

    AdminMenu adminMenu = new AdminMenu();
    adminMenu.setAdminModule(adminModules);
    when(adminNavigationService.buildMenu(Mockito.<AdminUser>any())).thenReturn(adminMenu);

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminLoginController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(1))
        .andExpect(model().attributeExists("resetPasswordForm"))
        .andExpect(view().name("noAccess"))
        .andExpect(forwardedUrl("noAccess"));
  }

  /**
   * Test {@link AdminLoginController#initResetPasswordForm(HttpServletRequest)}.
   *
   * <p>Method under test: {@link AdminLoginController#initResetPasswordForm(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResetPasswordForm AdminLoginController.initResetPasswordForm(HttpServletRequest)"
  })
  public void testInitResetPasswordForm() {
    // Arrange
    AdminLoginController adminLoginController = new AdminLoginController();

    // Act
    ResetPasswordForm actualInitResetPasswordFormResult =
        adminLoginController.initResetPasswordForm(new MockHttpServletRequest());

    // Assert
    assertNull(actualInitResetPasswordFormResult.getConfirmPassword());
    assertNull(actualInitResetPasswordFormResult.getOldPassword());
    assertNull(actualInitResetPasswordFormResult.getPassword());
    assertNull(actualInitResetPasswordFormResult.getToken());
    assertNull(actualInitResetPasswordFormResult.getUsername());
  }

  /**
   * Test {@link AdminLoginController#getPersistentAdminUser()}.
   *
   * <p>Method under test: {@link AdminLoginController#getPersistentAdminUser()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminUser AdminLoginController.getPersistentAdminUser()"})
  public void testGetPersistentAdminUser() {
    // Arrange, Act and Assert
    assertNull(new AdminLoginController().getPersistentAdminUser());
  }
}
