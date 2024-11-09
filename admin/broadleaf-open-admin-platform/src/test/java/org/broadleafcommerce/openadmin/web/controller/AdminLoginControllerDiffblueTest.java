/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.service.GenericResponse;
import org.broadleafcommerce.openadmin.server.security.service.AdminSecurityServiceImpl;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.broadleafcommerce.openadmin.web.form.ResetPasswordForm;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class AdminLoginControllerDiffblueTest {
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
}
