/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.openadmin.server.security.domain.AdminMenu;
import org.broadleafcommerce.openadmin.server.security.domain.AdminModule;
import org.broadleafcommerce.openadmin.server.security.domain.AdminModuleDTO;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class AdminLoginControllerDiffblueTest {
  @InjectMocks
  private AdminLoginController adminLoginController;

  @Mock
  private AdminNavigationService adminNavigationService;

  @Mock
  private AdminSecurityService adminSecurityService;

  /**
   * Test {@link AdminLoginController#loginSuccess(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test: {@link AdminLoginController#loginSuccess(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.String AdminLoginController.loginSuccess(HttpServletRequest, HttpServletResponse, Model)"})
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
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("resetPasswordForm"))
        .andExpect(MockMvcResultMatchers.view().name("noAccess"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("noAccess"));
  }

  /**
   * Test {@link AdminLoginController#loginSuccess(HttpServletRequest, HttpServletResponse, Model)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminModuleDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminLoginController#loginSuccess(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.String AdminLoginController.loginSuccess(HttpServletRequest, HttpServletResponse, Model)"})
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
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("resetPasswordForm"))
        .andExpect(MockMvcResultMatchers.view().name("noAccess"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("noAccess"));
  }

  /**
   * Test {@link AdminLoginController#initResetPasswordForm(HttpServletRequest)}.
   * <ul>
   *   <li>Then return ConfirmPassword is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminLoginController#initResetPasswordForm(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResetPasswordForm AdminLoginController.initResetPasswordForm(HttpServletRequest)"})
  public void testInitResetPasswordForm_thenReturnConfirmPasswordIsNull() {
    // Arrange and Act
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
   * Test {@link AdminLoginController#getPersistentAdminUser()}.
   * <p>
   * Method under test: {@link AdminLoginController#getPersistentAdminUser()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminUser AdminLoginController.getPersistentAdminUser()"})
  public void testGetPersistentAdminUser() {
    // Arrange, Act and Assert
    assertNull(adminLoginController.getPersistentAdminUser());
  }
}
