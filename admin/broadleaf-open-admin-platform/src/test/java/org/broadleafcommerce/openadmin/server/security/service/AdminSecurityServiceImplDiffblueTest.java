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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.cache.Cache;
import javax.cache.CacheManager;
import org.broadleafcommerce.common.event.BroadleafApplicationEventPublisher;
import org.broadleafcommerce.common.service.GenericResponse;
import org.broadleafcommerce.openadmin.server.security.dao.AdminPermissionDao;
import org.broadleafcommerce.openadmin.server.security.dao.AdminRoleDao;
import org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao;
import org.broadleafcommerce.openadmin.server.security.dao.ForgotPasswordSecurityTokenDao;
import org.broadleafcommerce.openadmin.server.security.domain.AdminPermission;
import org.broadleafcommerce.openadmin.server.security.domain.AdminPermissionImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRole;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRoleImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.domain.ForgotPasswordSecurityToken;
import org.broadleafcommerce.openadmin.server.security.domain.ForgotPasswordSecurityTokenImpl;
import org.broadleafcommerce.openadmin.server.security.service.type.PermissionType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AdminSecurityServiceImplDiffblueTest {
  @InjectMocks
  private AdminSecurityServiceImpl adminSecurityServiceImpl;

  @Mock
  private AdminUserDao adminUserDao;

  @Mock
  private PasswordEncoder passwordEncoder;

  @Mock
  private AdminPermissionDao adminPermissionDao;

  @Mock
  private CacheManager cacheManager;

  @Mock
  private ForgotPasswordSecurityTokenDao forgotPasswordSecurityTokenDao;

  @Mock
  private AdminRoleDao adminRoleDao;

  @Mock
  private BroadleafApplicationEventPublisher broadleafApplicationEventPublisher;

  /**
   * Test {@link AdminSecurityServiceImpl#readAdminPermissionById(Long)}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#readAdminPermissionById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminPermission AdminSecurityServiceImpl.readAdminPermissionById(Long)"})
  public void testReadAdminPermissionById() {
    // Arrange
    AdminPermissionImpl adminPermissionImpl = new AdminPermissionImpl();
    when(adminPermissionDao.readAdminPermissionById(Mockito.<Long>any())).thenReturn(adminPermissionImpl);

    // Act
    AdminPermission actualReadAdminPermissionByIdResult = adminSecurityServiceImpl.readAdminPermissionById(1L);

    // Assert
    verify(adminPermissionDao).readAdminPermissionById(eq(1L));
    assertSame(adminPermissionImpl, actualReadAdminPermissionByIdResult);
  }

  /**
   * Test {@link AdminSecurityServiceImpl#readAdminRoleById(Long)}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#readAdminRoleById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminRole AdminSecurityServiceImpl.readAdminRoleById(Long)"})
  public void testReadAdminRoleById() {
    // Arrange
    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    when(adminRoleDao.readAdminRoleById(Mockito.<Long>any())).thenReturn(adminRoleImpl);

    // Act
    AdminRole actualReadAdminRoleByIdResult = adminSecurityServiceImpl.readAdminRoleById(1L);

    // Assert
    verify(adminRoleDao).readAdminRoleById(eq(1L));
    assertSame(adminRoleImpl, actualReadAdminRoleByIdResult);
  }

  /**
   * Test {@link AdminSecurityServiceImpl#readAdminUserById(Long)}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#readAdminUserById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminUser AdminSecurityServiceImpl.readAdminUserById(Long)"})
  public void testReadAdminUserById() {
    // Arrange
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(adminUserDao.readAdminUserById(Mockito.<Long>any())).thenReturn(adminUserImpl);

    // Act
    AdminUser actualReadAdminUserByIdResult = adminSecurityServiceImpl.readAdminUserById(1L);

    // Assert
    verify(adminUserDao).readAdminUserById(eq(1L));
    assertSame(adminUserImpl, actualReadAdminUserByIdResult);
  }

  /**
   * Test {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)} with {@code username}, {@code oldPassword}, {@code password}, {@code confirmPassword}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse AdminSecurityServiceImpl.changePassword(String, String, String, String)"})
  public void testChangePasswordWithUsernameOldPasswordPasswordConfirmPassword() {
    // Arrange
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(new AdminUserImpl());

    // Act
    GenericResponse actualChangePasswordResult = adminSecurityServiceImpl.changePassword("janedoe", "iloveyou",
        "iloveyou", "iloveyou");

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    List<String> errorCodesList = actualChangePasswordResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("emailNotFound", errorCodesList.get(0));
    assertTrue(actualChangePasswordResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)} with {@code username}, {@code oldPassword}, {@code password}, {@code confirmPassword}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse AdminSecurityServiceImpl.changePassword(String, String, String, String)"})
  public void testChangePasswordWithUsernameOldPasswordPasswordConfirmPassword2() {
    // Arrange
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);

    // Act
    GenericResponse actualChangePasswordResult = adminSecurityServiceImpl.changePassword("janedoe", "iloveyou",
        "iloveyou", "iloveyou");

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    List<String> errorCodesList = actualChangePasswordResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualChangePasswordResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)} with {@code username}, {@code oldPassword}, {@code password}, {@code confirmPassword}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse AdminSecurityServiceImpl.changePassword(String, String, String, String)"})
  public void testChangePasswordWithUsernameOldPasswordPasswordConfirmPassword3() {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getActiveStatusFlag()).thenReturn(false);
    when(adminUserImpl.getEmail()).thenReturn("jane.doe@example.org");
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUserImpl);

    // Act
    GenericResponse actualChangePasswordResult = adminSecurityServiceImpl.changePassword("janedoe", "iloveyou",
        "iloveyou", "iloveyou");

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    verify(adminUserImpl).getActiveStatusFlag();
    verify(adminUserImpl).getEmail();
    List<String> errorCodesList = actualChangePasswordResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertTrue(actualChangePasswordResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)} with {@code username}, {@code oldPassword}, {@code password}, {@code confirmPassword}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse AdminSecurityServiceImpl.changePassword(String, String, String, String)"})
  public void testChangePasswordWithUsernameOldPasswordPasswordConfirmPassword4() {
    // Arrange and Act
    GenericResponse actualChangePasswordResult = adminSecurityServiceImpl.changePassword(null, "iloveyou", "iloveyou",
        "iloveyou");

    // Assert
    List<String> errorCodesList = actualChangePasswordResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualChangePasswordResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)} with {@code username}, {@code oldPassword}, {@code password}, {@code confirmPassword}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse AdminSecurityServiceImpl.changePassword(String, String, String, String)"})
  public void testChangePasswordWithUsernameOldPasswordPasswordConfirmPassword5() {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getActiveStatusFlag()).thenReturn(false);
    when(adminUserImpl.getEmail()).thenReturn("jane.doe@example.org");
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUserImpl);

    // Act
    GenericResponse actualChangePasswordResult = adminSecurityServiceImpl.changePassword("janedoe", "iloveyou",
        "inactiveUser", "iloveyou");

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    verify(adminUserImpl).getActiveStatusFlag();
    verify(adminUserImpl).getEmail();
    List<String> errorCodesList = actualChangePasswordResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertEquals("passwordMismatch", errorCodesList.get(1));
    assertTrue(actualChangePasswordResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)} with {@code username}, {@code oldPassword}, {@code password}, {@code confirmPassword}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse AdminSecurityServiceImpl.changePassword(String, String, String, String)"})
  public void testChangePasswordWithUsernameOldPasswordPasswordConfirmPassword6() {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getActiveStatusFlag()).thenReturn(false);
    when(adminUserImpl.getEmail()).thenReturn("jane.doe@example.org");
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUserImpl);

    // Act
    GenericResponse actualChangePasswordResult = adminSecurityServiceImpl.changePassword("janedoe", "iloveyou", null,
        "iloveyou");

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    verify(adminUserImpl).getActiveStatusFlag();
    verify(adminUserImpl).getEmail();
    List<String> errorCodesList = actualChangePasswordResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertEquals("invalidPassword", errorCodesList.get(1));
    assertTrue(actualChangePasswordResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)} with {@code username}, {@code oldPassword}, {@code password}, {@code confirmPassword}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#changePassword(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse AdminSecurityServiceImpl.changePassword(String, String, String, String)"})
  public void testChangePasswordWithUsernameOldPasswordPasswordConfirmPassword7() {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getActiveStatusFlag()).thenReturn(false);
    when(adminUserImpl.getEmail()).thenReturn("jane.doe@example.org");
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUserImpl);

    // Act
    GenericResponse actualChangePasswordResult = adminSecurityServiceImpl.changePassword("janedoe", "iloveyou",
        "iloveyou", null);

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    verify(adminUserImpl).getActiveStatusFlag();
    verify(adminUserImpl).getEmail();
    List<String> errorCodesList = actualChangePasswordResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertEquals("invalidPassword", errorCodesList.get(1));
    assertTrue(actualChangePasswordResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#isPasswordValid(String, String)}.
   * <ul>
   *   <li>Given {@link PasswordEncoder} {@link PasswordEncoder#matches(CharSequence, String)} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#isPasswordValid(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminSecurityServiceImpl.isPasswordValid(String, String)"})
  public void testIsPasswordValid_givenPasswordEncoderMatchesReturnFalse_thenReturnFalse() {
    // Arrange
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualIsPasswordValidResult = adminSecurityServiceImpl.isPasswordValid("secret", "iloveyou");

    // Assert
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("secret"));
    assertFalse(actualIsPasswordValidResult);
  }

  /**
   * Test {@link AdminSecurityServiceImpl#isPasswordValid(String, String)}.
   * <ul>
   *   <li>Given {@link PasswordEncoder} {@link PasswordEncoder#matches(CharSequence, String)} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#isPasswordValid(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminSecurityServiceImpl.isPasswordValid(String, String)"})
  public void testIsPasswordValid_givenPasswordEncoderMatchesReturnTrue_thenReturnTrue() {
    // Arrange
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualIsPasswordValidResult = adminSecurityServiceImpl.isPasswordValid("secret", "iloveyou");

    // Assert
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("secret"));
    assertTrue(actualIsPasswordValidResult);
  }

  /**
   * Test {@link AdminSecurityServiceImpl#encodePassword(String)}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#encodePassword(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminSecurityServiceImpl.encodePassword(String)"})
  public void testEncodePassword() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    String actualEncodePasswordResult = adminSecurityServiceImpl.encodePassword("iloveyou");

    // Assert
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertEquals("secret", actualEncodePasswordResult);
  }

  /**
   * Test {@link AdminSecurityServiceImpl#getCache()}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#getCache()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Cache AdminSecurityServiceImpl.getCache()"})
  public void testGetCache() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache<String, Boolean> actualCache = adminSecurityServiceImpl.getCache();

    // Assert
    verify(cacheManager).getCache(eq("blSecurityElements"));
    assertNull(actualCache);
  }

  /**
   * Test {@link AdminSecurityServiceImpl#buildCacheKey(AdminUser, PermissionType, String)}.
   * <ul>
   *   <li>Then return {@code security:user:null,permType:All,ceiling:Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#buildCacheKey(AdminUser, PermissionType, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminSecurityServiceImpl.buildCacheKey(AdminUser, PermissionType, String)"})
  public void testBuildCacheKey_thenReturnSecurityUserNullPermTypeAllCeilingDrJaneDoe() {
    // Arrange, Act and Assert
    assertEquals("security:user:null,permType:All,ceiling:Dr Jane Doe",
        adminSecurityServiceImpl.buildCacheKey(new AdminUserImpl(), PermissionType.ALL, "Dr Jane Doe"));
  }

  /**
   * Test {@link AdminSecurityServiceImpl#doesOperationExistForCeilingEntity(PermissionType, String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#doesOperationExistForCeilingEntity(PermissionType, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminSecurityServiceImpl.doesOperationExistForCeilingEntity(PermissionType, String)"})
  public void testDoesOperationExistForCeilingEntity_thenReturnFalse() {
    // Arrange
    when(adminPermissionDao.doesOperationExistForCeilingEntity(Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act
    boolean actualDoesOperationExistForCeilingEntityResult = adminSecurityServiceImpl
        .doesOperationExistForCeilingEntity(PermissionType.ALL, "Dr Jane Doe");

    // Assert
    verify(adminPermissionDao).doesOperationExistForCeilingEntity(isA(PermissionType.class), eq("Dr Jane Doe"));
    assertFalse(actualDoesOperationExistForCeilingEntityResult);
  }

  /**
   * Test {@link AdminSecurityServiceImpl#doesOperationExistForCeilingEntity(PermissionType, String)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#doesOperationExistForCeilingEntity(PermissionType, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminSecurityServiceImpl.doesOperationExistForCeilingEntity(PermissionType, String)"})
  public void testDoesOperationExistForCeilingEntity_thenReturnTrue() {
    // Arrange
    when(adminPermissionDao.doesOperationExistForCeilingEntity(Mockito.<PermissionType>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    boolean actualDoesOperationExistForCeilingEntityResult = adminSecurityServiceImpl
        .doesOperationExistForCeilingEntity(PermissionType.ALL, "Dr Jane Doe");

    // Assert
    verify(adminPermissionDao).doesOperationExistForCeilingEntity(isA(PermissionType.class), eq("Dr Jane Doe"));
    assertTrue(actualDoesOperationExistForCeilingEntityResult);
  }

  /**
   * Test {@link AdminSecurityServiceImpl#readAdminUserByUserName(String)}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#readAdminUserByUserName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminUser AdminSecurityServiceImpl.readAdminUserByUserName(String)"})
  public void testReadAdminUserByUserName() {
    // Arrange
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUserImpl);

    // Act
    AdminUser actualReadAdminUserByUserNameResult = adminSecurityServiceImpl.readAdminUserByUserName("janedoe");

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    assertSame(adminUserImpl, actualReadAdminUserByUserNameResult);
  }

  /**
   * Test {@link AdminSecurityServiceImpl#readAdminUsersByEmail(String)}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#readAdminUsersByEmail(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminSecurityServiceImpl.readAdminUsersByEmail(String)"})
  public void testReadAdminUsersByEmail() {
    // Arrange
    when(adminUserDao.readAdminUserByEmail(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<AdminUser> actualReadAdminUsersByEmailResult = adminSecurityServiceImpl
        .readAdminUsersByEmail("jane.doe@example.org");

    // Assert
    verify(adminUserDao).readAdminUserByEmail(eq("jane.doe@example.org"));
    assertTrue(actualReadAdminUsersByEmailResult.isEmpty());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#readAllAdminUsers()}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#readAllAdminUsers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminSecurityServiceImpl.readAllAdminUsers()"})
  public void testReadAllAdminUsers() {
    // Arrange
    when(adminUserDao.readAllAdminUsers()).thenReturn(new ArrayList<>());

    // Act
    List<AdminUser> actualReadAllAdminUsersResult = adminSecurityServiceImpl.readAllAdminUsers();

    // Assert
    verify(adminUserDao).readAllAdminUsers();
    assertTrue(actualReadAllAdminUsersResult.isEmpty());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#readAllAdminRoles()}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#readAllAdminRoles()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminSecurityServiceImpl.readAllAdminRoles()"})
  public void testReadAllAdminRoles() {
    // Arrange
    when(adminRoleDao.readAllAdminRoles()).thenReturn(new ArrayList<>());

    // Act
    List<AdminRole> actualReadAllAdminRolesResult = adminSecurityServiceImpl.readAllAdminRoles();

    // Assert
    verify(adminRoleDao).readAllAdminRoles();
    assertTrue(actualReadAllAdminRolesResult.isEmpty());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#readAllAdminPermissions()}.
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#readAllAdminPermissions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminSecurityServiceImpl.readAllAdminPermissions()"})
  public void testReadAllAdminPermissions() {
    // Arrange
    when(adminPermissionDao.readAllAdminPermissions()).thenReturn(new ArrayList<>());

    // Act
    List<AdminPermission> actualReadAllAdminPermissionsResult = adminSecurityServiceImpl.readAllAdminPermissions();

    // Assert
    verify(adminPermissionDao).readAllAdminPermissions();
    assertTrue(actualReadAllAdminPermissionsResult.isEmpty());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#sendForgotUsernameNotification(String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code inactiveUser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse AdminSecurityServiceImpl.sendForgotUsernameNotification(String)"})
  public void testSendForgotUsernameNotification_thenReturnErrorCodesListFirstIsInactiveUser() {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getActiveStatusFlag()).thenReturn(false);

    ArrayList<AdminUser> adminUserList = new ArrayList<>();
    adminUserList.add(adminUserImpl);
    when(adminUserDao.readAdminUserByEmail(Mockito.<String>any())).thenReturn(adminUserList);

    // Act
    GenericResponse actualSendForgotUsernameNotificationResult = adminSecurityServiceImpl
        .sendForgotUsernameNotification("42 Main St");

    // Assert
    verify(adminUserDao).readAdminUserByEmail(eq("42 Main St"));
    verify(adminUserImpl).getActiveStatusFlag();
    List<String> errorCodesList = actualSendForgotUsernameNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertTrue(actualSendForgotUsernameNotificationResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#sendForgotUsernameNotification(String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code notFound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse AdminSecurityServiceImpl.sendForgotUsernameNotification(String)"})
  public void testSendForgotUsernameNotification_thenReturnErrorCodesListFirstIsNotFound() {
    // Arrange
    when(adminUserDao.readAdminUserByEmail(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    GenericResponse actualSendForgotUsernameNotificationResult = adminSecurityServiceImpl
        .sendForgotUsernameNotification("42 Main St");

    // Assert
    verify(adminUserDao).readAdminUserByEmail(eq("42 Main St"));
    List<String> errorCodesList = actualSendForgotUsernameNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("notFound", errorCodesList.get(0));
    assertTrue(actualSendForgotUsernameNotificationResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#sendForgotUsernameNotification(String)}.
   * <ul>
   *   <li>Then return not HasErrors.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse AdminSecurityServiceImpl.sendForgotUsernameNotification(String)"})
  public void testSendForgotUsernameNotification_thenReturnNotHasErrors() {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getLogin()).thenReturn("Login");
    when(adminUserImpl.getActiveStatusFlag()).thenReturn(true);

    ArrayList<AdminUser> adminUserList = new ArrayList<>();
    adminUserList.add(adminUserImpl);
    when(adminUserDao.readAdminUserByEmail(Mockito.<String>any())).thenReturn(adminUserList);
    doNothing().when(broadleafApplicationEventPublisher).publishEvent(Mockito.<ApplicationEvent>any());

    // Act
    GenericResponse actualSendForgotUsernameNotificationResult = adminSecurityServiceImpl
        .sendForgotUsernameNotification("42 Main St");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(adminUserDao).readAdminUserByEmail(eq("42 Main St"));
    verify(adminUserImpl).getActiveStatusFlag();
    verify(adminUserImpl).getLogin();
    assertFalse(actualSendForgotUsernameNotificationResult.getHasErrors());
    assertTrue(actualSendForgotUsernameNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#sendForgotUsernameNotification(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse AdminSecurityServiceImpl.sendForgotUsernameNotification(String)"})
  public void testSendForgotUsernameNotification_whenNull() {
    // Arrange and Act
    GenericResponse actualSendForgotUsernameNotificationResult = adminSecurityServiceImpl
        .sendForgotUsernameNotification(null);

    // Assert
    List<String> errorCodesList = actualSendForgotUsernameNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("notFound", errorCodesList.get(0));
    assertTrue(actualSendForgotUsernameNotificationResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#sendResetPasswordNotification(String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code emailNotFound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#sendResetPasswordNotification(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse AdminSecurityServiceImpl.sendResetPasswordNotification(String)"})
  public void testSendResetPasswordNotification_thenReturnErrorCodesListFirstIsEmailNotFound() {
    // Arrange
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(new AdminUserImpl());

    // Act
    GenericResponse actualSendResetPasswordNotificationResult = adminSecurityServiceImpl
        .sendResetPasswordNotification("janedoe");

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    List<String> errorCodesList = actualSendResetPasswordNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("emailNotFound", errorCodesList.get(0));
    assertTrue(actualSendResetPasswordNotificationResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#sendResetPasswordNotification(String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code inactiveUser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#sendResetPasswordNotification(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse AdminSecurityServiceImpl.sendResetPasswordNotification(String)"})
  public void testSendResetPasswordNotification_thenReturnErrorCodesListFirstIsInactiveUser() {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getActiveStatusFlag()).thenReturn(false);
    when(adminUserImpl.getEmail()).thenReturn("jane.doe@example.org");
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUserImpl);

    // Act
    GenericResponse actualSendResetPasswordNotificationResult = adminSecurityServiceImpl
        .sendResetPasswordNotification("janedoe");

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    verify(adminUserImpl).getActiveStatusFlag();
    verify(adminUserImpl).getEmail();
    List<String> errorCodesList = actualSendResetPasswordNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertTrue(actualSendResetPasswordNotificationResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#sendResetPasswordNotification(String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code invalidUser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#sendResetPasswordNotification(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse AdminSecurityServiceImpl.sendResetPasswordNotification(String)"})
  public void testSendResetPasswordNotification_thenReturnErrorCodesListFirstIsInvalidUser() {
    // Arrange and Act
    GenericResponse actualSendResetPasswordNotificationResult = adminSecurityServiceImpl
        .sendResetPasswordNotification(null);

    // Assert
    List<String> errorCodesList = actualSendResetPasswordNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualSendResetPasswordNotificationResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Given {@link AdminUserDao} {@link AdminUserDao#readAdminUserByUserName(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GenericResponse AdminSecurityServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_givenAdminUserDaoReadAdminUserByUserNameReturnNull() {
    // Arrange
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = adminSecurityServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Given {@link PasswordEncoder} {@link PasswordEncoder#matches(CharSequence, String)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GenericResponse AdminSecurityServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_givenPasswordEncoderMatchesReturnFalse() {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getId()).thenReturn(1L);
    when(adminUserImpl.getActiveStatusFlag()).thenReturn(true);
    when(adminUserImpl.getEmail()).thenReturn("jane.doe@example.org");
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUserImpl);
    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl = mock(ForgotPasswordSecurityTokenImpl.class);
    when(forgotPasswordSecurityTokenImpl.getToken()).thenReturn("ABC123");

    ArrayList<ForgotPasswordSecurityToken> forgotPasswordSecurityTokenList = new ArrayList<>();
    forgotPasswordSecurityTokenList.add(forgotPasswordSecurityTokenImpl);
    when(forgotPasswordSecurityTokenDao.readUnusedTokensByAdminUserId(Mockito.<Long>any()))
        .thenReturn(forgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(false);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = adminSecurityServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    verify(forgotPasswordSecurityTokenDao).readUnusedTokensByAdminUserId(eq(1L));
    verify(adminUserImpl).getActiveStatusFlag();
    verify(adminUserImpl).getEmail();
    verify(adminUserImpl).getId();
    verify(forgotPasswordSecurityTokenImpl).getToken();
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code emailNotFound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GenericResponse AdminSecurityServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_thenReturnErrorCodesListFirstIsEmailNotFound() {
    // Arrange
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(new AdminUserImpl());

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = adminSecurityServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("emailNotFound", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code inactiveUser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GenericResponse AdminSecurityServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_thenReturnErrorCodesListFirstIsInactiveUser() {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getActiveStatusFlag()).thenReturn(false);
    when(adminUserImpl.getEmail()).thenReturn("jane.doe@example.org");
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUserImpl);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = adminSecurityServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    verify(adminUserImpl).getActiveStatusFlag();
    verify(adminUserImpl).getEmail();
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code invalidPassword}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GenericResponse AdminSecurityServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_thenReturnErrorCodesListFirstIsInvalidPassword() {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getActiveStatusFlag()).thenReturn(true);
    when(adminUserImpl.getEmail()).thenReturn("jane.doe@example.org");
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUserImpl);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = adminSecurityServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", null, "iloveyou");

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    verify(adminUserImpl).getActiveStatusFlag();
    verify(adminUserImpl).getEmail();
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code invalidPassword}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GenericResponse AdminSecurityServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_thenReturnErrorCodesListFirstIsInvalidPassword2() {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getActiveStatusFlag()).thenReturn(true);
    when(adminUserImpl.getEmail()).thenReturn("jane.doe@example.org");
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUserImpl);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = adminSecurityServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", "iloveyou", null);

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    verify(adminUserImpl).getActiveStatusFlag();
    verify(adminUserImpl).getEmail();
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code invalidToken}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GenericResponse AdminSecurityServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_thenReturnErrorCodesListFirstIsInvalidToken() {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getId()).thenReturn(1L);
    when(adminUserImpl.getActiveStatusFlag()).thenReturn(true);
    when(adminUserImpl.getEmail()).thenReturn("jane.doe@example.org");
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUserImpl);
    when(forgotPasswordSecurityTokenDao.readUnusedTokensByAdminUserId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = adminSecurityServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    verify(forgotPasswordSecurityTokenDao).readUnusedTokensByAdminUserId(eq(1L));
    verify(adminUserImpl).getActiveStatusFlag();
    verify(adminUserImpl).getEmail();
    verify(adminUserImpl).getId();
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code passwordMismatch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GenericResponse AdminSecurityServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_thenReturnErrorCodesListFirstIsPasswordMismatch() {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getActiveStatusFlag()).thenReturn(true);
    when(adminUserImpl.getEmail()).thenReturn("jane.doe@example.org");
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUserImpl);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = adminSecurityServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", "tokenUsed", "iloveyou");

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    verify(adminUserImpl).getActiveStatusFlag();
    verify(adminUserImpl).getEmail();
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("passwordMismatch", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code tokenUsed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GenericResponse AdminSecurityServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_thenReturnErrorCodesListFirstIsTokenUsed() {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getId()).thenReturn(1L);
    when(adminUserImpl.getActiveStatusFlag()).thenReturn(true);
    when(adminUserImpl.getEmail()).thenReturn("jane.doe@example.org");
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUserImpl);
    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl = mock(ForgotPasswordSecurityTokenImpl.class);
    when(forgotPasswordSecurityTokenImpl.isTokenUsedFlag()).thenReturn(true);
    when(forgotPasswordSecurityTokenImpl.getToken()).thenReturn("ABC123");

    ArrayList<ForgotPasswordSecurityToken> forgotPasswordSecurityTokenList = new ArrayList<>();
    forgotPasswordSecurityTokenList.add(forgotPasswordSecurityTokenImpl);
    when(forgotPasswordSecurityTokenDao.readUnusedTokensByAdminUserId(Mockito.<Long>any()))
        .thenReturn(forgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(true);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = adminSecurityServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    verify(forgotPasswordSecurityTokenDao).readUnusedTokensByAdminUserId(eq(1L));
    verify(adminUserImpl).getActiveStatusFlag();
    verify(adminUserImpl).getEmail();
    verify(adminUserImpl).getId();
    verify(forgotPasswordSecurityTokenImpl).getToken();
    verify(forgotPasswordSecurityTokenImpl).isTokenUsedFlag();
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("tokenUsed", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ErrorCodesList first is {@code invalidToken}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GenericResponse AdminSecurityServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_whenNull_thenReturnErrorCodesListFirstIsInvalidToken() {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getActiveStatusFlag()).thenReturn(true);
    when(adminUserImpl.getEmail()).thenReturn("jane.doe@example.org");
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUserImpl);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = adminSecurityServiceImpl.resetPasswordUsingToken("janedoe",
        null, "iloveyou", "iloveyou");

    // Assert
    verify(adminUserDao).readAdminUserByUserName(eq("janedoe"));
    verify(adminUserImpl).getActiveStatusFlag();
    verify(adminUserImpl).getEmail();
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ErrorCodesList first is {@code invalidUser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GenericResponse AdminSecurityServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_whenNull_thenReturnErrorCodesListFirstIsInvalidUser() {
    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult = adminSecurityServiceImpl.resetPasswordUsingToken(null,
        "ABC123", "iloveyou", "iloveyou");

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidUser", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#invalidateAllTokensForAdminUser(AdminUser)}.
   * <ul>
   *   <li>Then calls {@link ForgotPasswordSecurityTokenDao#readUnusedTokensByAdminUserId(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#invalidateAllTokensForAdminUser(AdminUser)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceImpl.invalidateAllTokensForAdminUser(AdminUser)"})
  public void testInvalidateAllTokensForAdminUser_thenCallsReadUnusedTokensByAdminUserId() {
    // Arrange
    when(forgotPasswordSecurityTokenDao.readUnusedTokensByAdminUserId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    adminSecurityServiceImpl.invalidateAllTokensForAdminUser(new AdminUserImpl());

    // Assert
    verify(forgotPasswordSecurityTokenDao).readUnusedTokensByAdminUserId(isNull());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#invalidateAllTokensForAdminUser(AdminUser)}.
   * <ul>
   *   <li>Then calls {@link ForgotPasswordSecurityTokenDao#saveToken(ForgotPasswordSecurityToken)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#invalidateAllTokensForAdminUser(AdminUser)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceImpl.invalidateAllTokensForAdminUser(AdminUser)"})
  public void testInvalidateAllTokensForAdminUser_thenCallsSaveToken() {
    // Arrange
    ArrayList<ForgotPasswordSecurityToken> forgotPasswordSecurityTokenList = new ArrayList<>();
    forgotPasswordSecurityTokenList.add(new ForgotPasswordSecurityTokenImpl());
    when(forgotPasswordSecurityTokenDao.saveToken(Mockito.<ForgotPasswordSecurityToken>any()))
        .thenReturn(new ForgotPasswordSecurityTokenImpl());
    when(forgotPasswordSecurityTokenDao.readUnusedTokensByAdminUserId(Mockito.<Long>any()))
        .thenReturn(forgotPasswordSecurityTokenList);

    // Act
    adminSecurityServiceImpl.invalidateAllTokensForAdminUser(new AdminUserImpl());

    // Assert
    verify(forgotPasswordSecurityTokenDao).readUnusedTokensByAdminUserId(isNull());
    verify(forgotPasswordSecurityTokenDao).saveToken(isA(ForgotPasswordSecurityToken.class));
  }

  /**
   * Test {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first is {@code inactiveUser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceImpl.checkUser(AdminUser, GenericResponse)"})
  public void testCheckUser_givenFalse_thenGenericResponseErrorCodesListFirstIsInactiveUser() {
    // Arrange
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
   * Test {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then not {@link GenericResponse} (default constructor) HasErrors.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceImpl.checkUser(AdminUser, GenericResponse)"})
  public void testCheckUser_givenTrue_thenNotGenericResponseHasErrors() {
    // Arrange
    AdminUserImpl user = mock(AdminUserImpl.class);
    when(user.getActiveStatusFlag()).thenReturn(true);
    when(user.getEmail()).thenReturn("jane.doe@example.org");
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkUser(user, response);

    // Assert that nothing has changed
    verify(user).getActiveStatusFlag();
    verify(user).getEmail();
    assertFalse(response.getHasErrors());
    assertTrue(response.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}.
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first is {@code emailNotFound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceImpl.checkUser(AdminUser, GenericResponse)"})
  public void testCheckUser_thenGenericResponseErrorCodesListFirstIsEmailNotFound() {
    // Arrange
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
   * Test {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first is {@code invalidUser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#checkUser(AdminUser, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceImpl.checkUser(AdminUser, GenericResponse)"})
  public void testCheckUser_whenNull_thenGenericResponseErrorCodesListFirstIsInvalidUser() {
    // Arrange
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
   * Test {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}.
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first is {@code invalidPassword}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceImpl.checkPassword(String, String, GenericResponse)"})
  public void testCheckPassword_thenGenericResponseErrorCodesListFirstIsInvalidPassword() {
    // Arrange
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
   * Test {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}.
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first is {@code invalidPassword}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceImpl.checkPassword(String, String, GenericResponse)"})
  public void testCheckPassword_thenGenericResponseErrorCodesListFirstIsInvalidPassword2() {
    // Arrange
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkPassword("iloveyou", "", response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}.
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first is {@code passwordMismatch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceImpl.checkPassword(String, String, GenericResponse)"})
  public void testCheckPassword_thenGenericResponseErrorCodesListFirstIsPasswordMismatch() {
    // Arrange
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
   * Test {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}.
   * <ul>
   *   <li>When {@link GenericResponse} (default constructor).</li>
   *   <li>Then not {@link GenericResponse} (default constructor) HasErrors.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceImpl.checkPassword(String, String, GenericResponse)"})
  public void testCheckPassword_whenGenericResponse_thenNotGenericResponseHasErrors() {
    // Arrange
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkPassword("iloveyou", "iloveyou", response);

    // Assert that nothing has changed
    assertFalse(response.getHasErrors());
    assertTrue(response.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#checkExistingPassword(String, AdminUser, GenericResponse)}.
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#checkExistingPassword(String, AdminUser, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceImpl.checkExistingPassword(String, AdminUser, GenericResponse)"})
  public void testCheckExistingPassword_thenGenericResponseErrorCodesListSizeIsOne() {
    // Arrange
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(false);
    AdminUserImpl user = new AdminUserImpl();
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkExistingPassword("secret", user, response);

    // Assert
    verify(passwordEncoder).matches(isA(CharSequence.class), isNull());
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link AdminSecurityServiceImpl#checkExistingPassword(String, AdminUser, GenericResponse)}.
   * <ul>
   *   <li>Then not {@link GenericResponse} (default constructor) HasErrors.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityServiceImpl#checkExistingPassword(String, AdminUser, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityServiceImpl.checkExistingPassword(String, AdminUser, GenericResponse)"})
  public void testCheckExistingPassword_thenNotGenericResponseHasErrors() {
    // Arrange
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(true);
    AdminUserImpl user = new AdminUserImpl();
    GenericResponse response = new GenericResponse();

    // Act
    adminSecurityServiceImpl.checkExistingPassword("secret", user, response);

    // Assert that nothing has changed
    verify(passwordEncoder).matches(isA(CharSequence.class), isNull());
    assertFalse(response.getHasErrors());
    assertTrue(response.getErrorCodesList().isEmpty());
  }
}
