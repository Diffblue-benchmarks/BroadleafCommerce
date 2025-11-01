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
package org.broadleafcommerce.openadmin.server.security.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.broadleafcommerce.common.service.GenericResponse;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.service.type.PermissionType;
import org.junit.Test;

public class AdminSecurityServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   */
  @Test
  public void testChangePassword() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualChangePasswordResult = (new AdminSecurityServiceImpl()).changePassword(null, "iloveyou",
        "iloveyou", "iloveyou");

    // Assert
    List<String> errorCodesList = actualChangePasswordResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualChangePasswordResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   */
  @Test
  public void testChangePassword2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualChangePasswordResult = (new AdminSecurityServiceImpl()).changePassword(null, "iloveyou",
        "invalidUser", "iloveyou");

    // Assert
    List<String> errorCodesList = actualChangePasswordResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidUser", errorCodesList.get(0));
    assertEquals("passwordMismatch", errorCodesList.get(1));
    assertTrue(actualChangePasswordResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   */
  @Test
  public void testChangePassword3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualChangePasswordResult = (new AdminSecurityServiceImpl()).changePassword(null, "iloveyou", null,
        "iloveyou");

    // Assert
    List<String> errorCodesList = actualChangePasswordResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(1));
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualChangePasswordResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   */
  @Test
  public void testChangePassword4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualChangePasswordResult = (new AdminSecurityServiceImpl()).changePassword(null, "iloveyou",
        "iloveyou", null);

    // Assert
    List<String> errorCodesList = actualChangePasswordResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(1));
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualChangePasswordResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#buildCacheKey(AdminUser, PermissionType, String)}
   */
  @Test
  public void testBuildCacheKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();

    // Act and Assert
    assertEquals("security:user:null,permType:All,ceiling:Dr Jane Doe",
        adminSecurityServiceImpl.buildCacheKey(new AdminUserImpl(), PermissionType.ALL, "Dr Jane Doe"));
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#buildCacheKey(AdminUser, PermissionType, String)}
   */
  @Test
  public void testBuildCacheKey2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    AdminUserImpl adminUser = mock(AdminUserImpl.class);
    when(adminUser.getId()).thenReturn(1L);

    // Act
    String actualBuildCacheKeyResult = adminSecurityServiceImpl.buildCacheKey(adminUser, PermissionType.ALL,
        "Dr Jane Doe");

    // Assert
    verify(adminUser).getId();
    assertEquals("security:user:1,permType:All,ceiling:Dr Jane Doe", actualBuildCacheKeyResult);
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  public void testSendForgotUsernameNotification() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualSendForgotUsernameNotificationResult = (new AdminSecurityServiceImpl())
        .sendForgotUsernameNotification(null);

    // Assert
    List<String> errorCodesList = actualSendForgotUsernameNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("notFound", errorCodesList.get(0));
    assertTrue(actualSendForgotUsernameNotificationResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#sendResetPasswordNotification(String)}
   */
  @Test
  public void testSendResetPasswordNotification() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualSendResetPasswordNotificationResult = (new AdminSecurityServiceImpl())
        .sendResetPasswordNotification(null);

    // Assert
    List<String> errorCodesList = actualSendResetPasswordNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualSendResetPasswordNotificationResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  public void testResetPasswordUsingToken() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult = (new AdminSecurityServiceImpl()).resetPasswordUsingToken(null,
        "ABC123", "iloveyou", "iloveyou");

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  public void testResetPasswordUsingToken2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult = (new AdminSecurityServiceImpl()).resetPasswordUsingToken(null,
        null, "iloveyou", "iloveyou");

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(1));
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  public void testResetPasswordUsingToken3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult = (new AdminSecurityServiceImpl()).resetPasswordUsingToken(null,
        "ABC123", "invalidUser", "iloveyou");

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidUser", errorCodesList.get(0));
    assertEquals("passwordMismatch", errorCodesList.get(1));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  public void testResetPasswordUsingToken4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult = (new AdminSecurityServiceImpl()).resetPasswordUsingToken(null,
        "ABC123", null, "iloveyou");

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(1));
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  public void testResetPasswordUsingToken5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult = (new AdminSecurityServiceImpl()).resetPasswordUsingToken(null,
        "ABC123", "iloveyou", null);

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(1));
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}
   */
  @Test
  public void testCheckUser() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    AdminUserImpl user = new AdminUserImpl();
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkUser(user, response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("emailNotFound", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}
   */
  @Test
  public void testCheckUser2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkUser(null, response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}
   */
  @Test
  public void testCheckUser3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    AdminUserImpl user = mock(AdminUserImpl.class);
    when(user.getActiveStatusFlag()).thenReturn(true);
    when(user.getEmail()).thenReturn("jane.doe@example.org");
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkUser(user, response);

    // Assert
    verify(user).getActiveStatusFlag();
    verify(user).getEmail();
    assertFalse(response.getHasErrors());
    assertTrue(response.getErrorCodesList().isEmpty());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}
   */
  @Test
  public void testCheckUser4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    AdminUserImpl user = mock(AdminUserImpl.class);
    when(user.getActiveStatusFlag()).thenReturn(false);
    when(user.getEmail()).thenReturn("jane.doe@example.org");
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkUser(user, response);

    // Assert
    verify(user).getActiveStatusFlag();
    verify(user).getEmail();
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  public void testCheckPassword() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkPassword("iloveyou", "iloveyou", response);

    // Assert that nothing has changed
    assertFalse(response.getHasErrors());
    assertTrue(response.getErrorCodesList().isEmpty());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  public void testCheckPassword2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkPassword("Password", "iloveyou", response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("passwordMismatch", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  public void testCheckPassword3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkPassword("", "iloveyou", response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Method under test:
   * {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  public void testCheckPassword4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityServiceImpl adminSecurityServiceImpl = new AdminSecurityServiceImpl();
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkPassword("iloveyou", "", response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }
}
