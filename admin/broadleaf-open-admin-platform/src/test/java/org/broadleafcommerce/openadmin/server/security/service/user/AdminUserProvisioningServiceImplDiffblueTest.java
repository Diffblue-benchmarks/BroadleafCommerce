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
package org.broadleafcommerce.openadmin.server.security.service.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.security.BroadleafExternalAuthenticationUserDetails;
import org.broadleafcommerce.openadmin.server.security.domain.AdminPermission;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRole;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRoleImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.external.AdminExternalLoginExtensionHandler;
import org.broadleafcommerce.openadmin.server.security.external.AdminExternalLoginUserExtensionManager;
import org.broadleafcommerce.openadmin.server.security.service.AdminSecurityHelper;
import org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AdminUserProvisioningServiceImplDiffblueTest {
  @Mock
  private AdminExternalLoginUserExtensionManager adminExternalLoginUserExtensionManager;

  @Mock
  private AdminSecurityHelper adminSecurityHelper;

  @Mock
  private AdminSecurityService adminSecurityService;

  @InjectMocks
  private AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl;

  /**
   * Test {@link AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}.
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AdminUserDetails AdminUserProvisioningServiceImpl.provisionAdminUser(BroadleafExternalAuthenticationUserDetails)"})
  public void testProvisionAdminUser() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler = mock(
        AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(Mockito.<AdminUser>any(),
        Mockito.<BroadleafExternalAuthenticationUserDetails>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy()).thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(new AdminUserImpl());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(new AdminUserImpl());
    BroadleafExternalAuthenticationUserDetails details = new BroadleafExternalAuthenticationUserDetails("janedoe",
        "iloveyou", new ArrayList<>());

    // Act
    AdminUserDetails actualProvisionAdminUserResult = adminUserProvisioningServiceImpl.provisionAdminUser(details);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(adminExternalLoginExtensionHandler).performAdditionalAuthenticationTasks(isA(AdminUser.class),
        isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName(eq("janedoe"));
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertEquals(details, actualProvisionAdminUserResult);
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}.
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AdminUserDetails AdminUserProvisioningServiceImpl.provisionAdminUser(BroadleafExternalAuthenticationUserDetails)"})
  public void testProvisionAdminUser2() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler = mock(
        AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(Mockito.<AdminUser>any(),
        Mockito.<BroadleafExternalAuthenticationUserDetails>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy()).thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(new AdminUserImpl());
    BroadleafExternalAuthenticationUserDetails details = new BroadleafExternalAuthenticationUserDetails("janedoe",
        "iloveyou", new ArrayList<>());

    // Act
    AdminUserDetails actualProvisionAdminUserResult = adminUserProvisioningServiceImpl.provisionAdminUser(details);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(adminExternalLoginExtensionHandler).performAdditionalAuthenticationTasks(isA(AdminUser.class),
        isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName(eq("janedoe"));
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertEquals(details, actualProvisionAdminUserResult);
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminRoleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AdminUserDetails AdminUserProvisioningServiceImpl.provisionAdminUser(BroadleafExternalAuthenticationUserDetails)"})
  public void testProvisionAdminUser_givenArrayListAddAdminRoleImpl() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler = mock(
        AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(Mockito.<AdminUser>any(),
        Mockito.<BroadleafExternalAuthenticationUserDetails>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy()).thenReturn(adminExternalLoginExtensionHandler);

    ArrayList<AdminRole> adminRoleList = new ArrayList<>();
    adminRoleList.add(new AdminRoleImpl());
    when(adminSecurityService.readAllAdminRoles()).thenReturn(adminRoleList);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(new AdminUserImpl());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(new AdminUserImpl());
    BroadleafExternalAuthenticationUserDetails details = new BroadleafExternalAuthenticationUserDetails("janedoe",
        "iloveyou", new ArrayList<>());

    // Act
    AdminUserDetails actualProvisionAdminUserResult = adminUserProvisioningServiceImpl.provisionAdminUser(details);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(adminExternalLoginExtensionHandler).performAdditionalAuthenticationTasks(isA(AdminUser.class),
        isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName(eq("janedoe"));
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertEquals(details, actualProvisionAdminUserResult);
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}.
   * <ul>
   *   <li>Given {@code jane.doe@example.org}.</li>
   *   <li>Then return Authorities size is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AdminUserDetails AdminUserProvisioningServiceImpl.provisionAdminUser(BroadleafExternalAuthenticationUserDetails)"})
  public void testProvisionAdminUser_givenJaneDoeExampleOrg_thenReturnAuthoritiesSizeIsSix() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler = mock(
        AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(Mockito.<AdminUser>any(),
        Mockito.<BroadleafExternalAuthenticationUserDetails>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy()).thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(new AdminUserImpl());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(new AdminUserImpl());
    BroadleafExternalAuthenticationUserDetails details = mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getEmail()).thenReturn("jane.doe@example.org");
    when(details.getFirstName()).thenReturn("Jane");
    when(details.getLastName()).thenReturn("Doe");
    when(details.getUsername()).thenReturn("janedoe");
    when(details.getAuthorities()).thenReturn(new ArrayList<>());

    // Act
    AdminUserDetails actualProvisionAdminUserResult = adminUserProvisioningServiceImpl.provisionAdminUser(details);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(details, atLeast(1)).getEmail();
    verify(details, atLeast(1)).getFirstName();
    verify(details, atLeast(1)).getLastName();
    verify(adminExternalLoginExtensionHandler).performAdditionalAuthenticationTasks(isA(AdminUser.class),
        isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName(eq("janedoe"));
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(details).getAuthorities();
    verify(details, atLeast(1)).getUsername();
    Collection<GrantedAuthority> authorities = actualProvisionAdminUserResult.getAuthorities();
    assertEquals(6, authorities.size());
    assertTrue(authorities instanceof Set);
    assertEquals("", actualProvisionAdminUserResult.getPassword());
    assertEquals("janedoe", actualProvisionAdminUserResult.getUsername());
    assertNull(actualProvisionAdminUserResult.getId());
    assertTrue(actualProvisionAdminUserResult.isAccountNonExpired());
    assertTrue(actualProvisionAdminUserResult.isAccountNonLocked());
    assertTrue(actualProvisionAdminUserResult.isCredentialsNonExpired());
    assertTrue(actualProvisionAdminUserResult.isEnabled());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}.
   * <ul>
   *   <li>Given {@link SimpleGrantedAuthority#SimpleGrantedAuthority(String)} with role is {@link AdminUserDetailsServiceImpl#LEGACY_ROLE_PREFIX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AdminUserDetails AdminUserProvisioningServiceImpl.provisionAdminUser(BroadleafExternalAuthenticationUserDetails)"})
  public void testProvisionAdminUser_givenSimpleGrantedAuthorityWithRoleIsLegacy_role_prefix() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler = mock(
        AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(Mockito.<AdminUser>any(),
        Mockito.<BroadleafExternalAuthenticationUserDetails>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy()).thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(new AdminUserImpl());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(new AdminUserImpl());

    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(AdminUserDetailsServiceImpl.LEGACY_ROLE_PREFIX));
    BroadleafExternalAuthenticationUserDetails details = new BroadleafExternalAuthenticationUserDetails("janedoe",
        "iloveyou", authorities);

    // Act
    AdminUserDetails actualProvisionAdminUserResult = adminUserProvisioningServiceImpl.provisionAdminUser(details);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(adminExternalLoginExtensionHandler).performAdditionalAuthenticationTasks(isA(AdminUser.class),
        isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName(eq("janedoe"));
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertEquals(details, actualProvisionAdminUserResult);
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}.
   * <ul>
   *   <li>Given space.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AdminUserDetails AdminUserProvisioningServiceImpl.provisionAdminUser(BroadleafExternalAuthenticationUserDetails)"})
  public void testProvisionAdminUser_givenSpace() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler = mock(
        AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(Mockito.<AdminUser>any(),
        Mockito.<BroadleafExternalAuthenticationUserDetails>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy()).thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(new AdminUserImpl());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(new AdminUserImpl());
    BroadleafExternalAuthenticationUserDetails details = mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getEmail()).thenReturn(" ");
    when(details.getFirstName()).thenReturn("Jane");
    when(details.getLastName()).thenReturn("Doe");
    when(details.getUsername()).thenReturn("janedoe");
    when(details.getAuthorities()).thenReturn(new ArrayList<>());

    // Act
    AdminUserDetails actualProvisionAdminUserResult = adminUserProvisioningServiceImpl.provisionAdminUser(details);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(details).getEmail();
    verify(details, atLeast(1)).getFirstName();
    verify(details, atLeast(1)).getLastName();
    verify(adminExternalLoginExtensionHandler).performAdditionalAuthenticationTasks(isA(AdminUser.class),
        isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName(eq("janedoe"));
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(details).getAuthorities();
    verify(details, atLeast(1)).getUsername();
    Collection<GrantedAuthority> authorities = actualProvisionAdminUserResult.getAuthorities();
    assertEquals(6, authorities.size());
    assertTrue(authorities instanceof Set);
    assertEquals("", actualProvisionAdminUserResult.getPassword());
    assertEquals("janedoe", actualProvisionAdminUserResult.getUsername());
    assertNull(actualProvisionAdminUserResult.getId());
    assertTrue(actualProvisionAdminUserResult.isAccountNonExpired());
    assertTrue(actualProvisionAdminUserResult.isAccountNonLocked());
    assertTrue(actualProvisionAdminUserResult.isCredentialsNonExpired());
    assertTrue(actualProvisionAdminUserResult.isEnabled());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#parseAdminRoles(BroadleafExternalAuthenticationUserDetails)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminRoleImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#parseAdminRoles(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "HashSet AdminUserProvisioningServiceImpl.parseAdminRoles(BroadleafExternalAuthenticationUserDetails)"})
  public void testParseAdminRoles_givenArrayListAddAdminRoleImpl_thenReturnEmpty() {
    // Arrange
    ArrayList<AdminRole> adminRoleList = new ArrayList<>();
    adminRoleList.add(new AdminRoleImpl());
    when(adminSecurityService.readAllAdminRoles()).thenReturn(adminRoleList);

    // Act
    HashSet<AdminRole> actualParseAdminRolesResult = adminUserProvisioningServiceImpl
        .parseAdminRoles(new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>()));

    // Assert
    verify(adminSecurityService).readAllAdminRoles();
    assertTrue(actualParseAdminRolesResult.isEmpty());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#parseAdminRoles(BroadleafExternalAuthenticationUserDetails)}.
   * <ul>
   *   <li>Given {@link SimpleGrantedAuthority#SimpleGrantedAuthority(String)} with {@code Role}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#parseAdminRoles(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "HashSet AdminUserProvisioningServiceImpl.parseAdminRoles(BroadleafExternalAuthenticationUserDetails)"})
  public void testParseAdminRoles_givenSimpleGrantedAuthorityWithRole() {
    // Arrange
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());

    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    HashSet<AdminRole> actualParseAdminRolesResult = adminUserProvisioningServiceImpl
        .parseAdminRoles(new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", authorities));

    // Assert
    verify(adminSecurityService).readAllAdminRoles();
    assertTrue(actualParseAdminRolesResult.isEmpty());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#parseAdminRoles(BroadleafExternalAuthenticationUserDetails)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#parseAdminRoles(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "HashSet AdminUserProvisioningServiceImpl.parseAdminRoles(BroadleafExternalAuthenticationUserDetails)"})
  public void testParseAdminRoles_thenReturnEmpty() {
    // Arrange
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());

    // Act
    HashSet<AdminRole> actualParseAdminRolesResult = adminUserProvisioningServiceImpl
        .parseAdminRoles(new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>()));

    // Assert
    verify(adminSecurityService).readAllAdminRoles();
    assertTrue(actualParseAdminRolesResult.isEmpty());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#extractAdminUserAuthorities(HashSet)}.
   * <ul>
   *   <li>Given {@link AdminSecurityHelper}.</li>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#extractAdminUserAuthorities(HashSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set AdminUserProvisioningServiceImpl.extractAdminUserAuthorities(HashSet)"})
  public void testExtractAdminUserAuthorities_givenAdminSecurityHelper_whenHashSet() {
    // Arrange, Act and Assert
    assertEquals(6, adminUserProvisioningServiceImpl.extractAdminUserAuthorities(new HashSet<>()).size());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#extractAdminUserAuthorities(HashSet)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()} add {@link AdminRoleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#extractAdminUserAuthorities(HashSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set AdminUserProvisioningServiceImpl.extractAdminUserAuthorities(HashSet)"})
  public void testExtractAdminUserAuthorities_whenHashSetAddAdminRoleImpl() {
    // Arrange
    doNothing().when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    HashSet<AdminRole> parsedRoles = new HashSet<>();
    parsedRoles.add(new AdminRoleImpl());
    parsedRoles.add(new AdminRoleImpl());

    // Act
    Set<SimpleGrantedAuthority> actualExtractAdminUserAuthoritiesResult = adminUserProvisioningServiceImpl
        .extractAdminUserAuthorities(parsedRoles);

    // Assert
    verify(adminSecurityHelper, atLeast(1)).addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    assertEquals(6, actualExtractAdminUserAuthoritiesResult.size());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#extractAdminUserAuthorities(HashSet)}.
   * <ul>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@link AdminRoleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#extractAdminUserAuthorities(HashSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set AdminUserProvisioningServiceImpl.extractAdminUserAuthorities(HashSet)"})
  public void testExtractAdminUserAuthorities_whenLinkedHashSetAddAdminRoleImpl() {
    // Arrange
    doNothing().when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    LinkedHashSet<AdminRole> parsedRoles = new LinkedHashSet<>();
    parsedRoles.add(new AdminRoleImpl());

    // Act
    Set<SimpleGrantedAuthority> actualExtractAdminUserAuthoritiesResult = adminUserProvisioningServiceImpl
        .extractAdminUserAuthorities(parsedRoles);

    // Assert
    verify(adminSecurityHelper).addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    assertEquals(6, actualExtractAdminUserAuthoritiesResult.size());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#addPermissions(HashSet, List)}.
   * <ul>
   *   <li>Given {@link AdminSecurityHelper}.</li>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#addPermissions(HashSet, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.addPermissions(HashSet, List)"})
  public void testAddPermissions_givenAdminSecurityHelper_whenHashSet_thenArrayListSizeIsTwo() {
    // Arrange
    HashSet<AdminRole> parsedRoles = new HashSet<>();
    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();

    // Act
    adminUserProvisioningServiceImpl.addPermissions(parsedRoles, adminUserAuthorities);

    // Assert
    assertEquals(2, adminUserAuthorities.size());
    SimpleGrantedAuthority getResult = adminUserAuthorities.get(1);
    assertEquals("PERMISSION_ALL_USER_SANDBOX", getResult.getAuthority());
    assertEquals("PERMISSION_ALL_USER_SANDBOX", getResult.toString());
    SimpleGrantedAuthority getResult2 = adminUserAuthorities.get(0);
    assertEquals("PERMISSION_OTHER_DEFAULT", getResult2.getAuthority());
    assertEquals("PERMISSION_OTHER_DEFAULT", getResult2.toString());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#addPermissions(HashSet, List)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()} add {@link AdminRoleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#addPermissions(HashSet, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.addPermissions(HashSet, List)"})
  public void testAddPermissions_whenHashSetAddAdminRoleImpl() {
    // Arrange
    doNothing().when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    HashSet<AdminRole> parsedRoles = new HashSet<>();
    parsedRoles.add(new AdminRoleImpl());
    parsedRoles.add(new AdminRoleImpl());
    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();

    // Act
    adminUserProvisioningServiceImpl.addPermissions(parsedRoles, adminUserAuthorities);

    // Assert
    verify(adminSecurityHelper, atLeast(1)).addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    assertEquals(2, adminUserAuthorities.size());
    SimpleGrantedAuthority getResult = adminUserAuthorities.get(1);
    assertEquals("PERMISSION_ALL_USER_SANDBOX", getResult.getAuthority());
    assertEquals("PERMISSION_ALL_USER_SANDBOX", getResult.toString());
    SimpleGrantedAuthority getResult2 = adminUserAuthorities.get(0);
    assertEquals("PERMISSION_OTHER_DEFAULT", getResult2.getAuthority());
    assertEquals("PERMISSION_OTHER_DEFAULT", getResult2.toString());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#addPermissions(HashSet, List)}.
   * <ul>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@link AdminRoleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#addPermissions(HashSet, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.addPermissions(HashSet, List)"})
  public void testAddPermissions_whenLinkedHashSetAddAdminRoleImpl() {
    // Arrange
    doNothing().when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    LinkedHashSet<AdminRole> parsedRoles = new LinkedHashSet<>();
    parsedRoles.add(new AdminRoleImpl());
    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();

    // Act
    adminUserProvisioningServiceImpl.addPermissions(parsedRoles, adminUserAuthorities);

    // Assert
    verify(adminSecurityHelper).addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    assertEquals(2, adminUserAuthorities.size());
    SimpleGrantedAuthority getResult = adminUserAuthorities.get(1);
    assertEquals("PERMISSION_ALL_USER_SANDBOX", getResult.getAuthority());
    assertEquals("PERMISSION_ALL_USER_SANDBOX", getResult.toString());
    SimpleGrantedAuthority getResult2 = adminUserAuthorities.get(0);
    assertEquals("PERMISSION_OTHER_DEFAULT", getResult2.getAuthority());
    assertEquals("PERMISSION_OTHER_DEFAULT", getResult2.toString());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}.
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole() {
    // Arrange
    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities.add(new SimpleGrantedAuthority("PERMISSION_PERMISSION_"));

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert
    assertEquals(3, adminUserAuthorities.size());
    SimpleGrantedAuthority getResult = adminUserAuthorities.get(1);
    assertEquals("ROLE_PERMISSION_PERMISSION_", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_PERMISSION_", getResult.toString());
    SimpleGrantedAuthority getResult2 = adminUserAuthorities.get(2);
    assertEquals("ROLE_ROLE_", getResult2.getAuthority());
    assertEquals("ROLE_ROLE_", getResult2.toString());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}.
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole2() {
    // Arrange
    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities.add(new SimpleGrantedAuthority("PERMISSION_Role"));

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert
    assertEquals(3, adminUserAuthorities.size());
    SimpleGrantedAuthority getResult = adminUserAuthorities.get(1);
    assertEquals("ROLE_PERMISSION_Role", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_Role", getResult.toString());
    SimpleGrantedAuthority getResult2 = adminUserAuthorities.get(2);
    assertEquals("ROLE_Role", getResult2.getAuthority());
    assertEquals("ROLE_Role", getResult2.toString());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}.
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole3() {
    // Arrange
    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities.add(new SimpleGrantedAuthority("PERMISSION_ROLE_"));
    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("Role");
    adminUserAuthorities.add(simpleGrantedAuthority);

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert
    assertEquals(4, adminUserAuthorities.size());
    SimpleGrantedAuthority getResult = adminUserAuthorities.get(1);
    assertEquals("ROLE_PERMISSION_ROLE_", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_ROLE_", getResult.toString());
    assertSame(simpleGrantedAuthority, adminUserAuthorities.get(3));
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} second Authority is {@code ROLE_PERMISSION_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole_thenArrayListSecondAuthorityIsRolePermission() {
    // Arrange
    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities.add(new SimpleGrantedAuthority(AdminUserDetailsServiceImpl.LEGACY_ROLE_PREFIX));
    adminUserAuthorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert
    assertEquals(4, adminUserAuthorities.size());
    SimpleGrantedAuthority getResult = adminUserAuthorities.get(1);
    assertEquals("ROLE_PERMISSION_", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_", getResult.toString());
    SimpleGrantedAuthority getResult2 = adminUserAuthorities.get(2);
    assertEquals(AdminUserDetailsServiceImpl.DEFAULT_SPRING_SECURITY_ROLE_PREFIX, getResult2.getAuthority());
    assertEquals(AdminUserDetailsServiceImpl.DEFAULT_SPRING_SECURITY_ROLE_PREFIX, getResult2.toString());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole_thenArrayListSizeIsOne() {
    // Arrange
    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert that nothing has changed
    assertEquals(1, adminUserAuthorities.size());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole_thenArrayListSizeIsTwo() {
    // Arrange
    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities
        .add(new SimpleGrantedAuthority(AdminUserDetailsServiceImpl.DEFAULT_SPRING_SECURITY_ROLE_PREFIX));
    adminUserAuthorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert that nothing has changed
    assertEquals(2, adminUserAuthorities.size());
    SimpleGrantedAuthority getResult = adminUserAuthorities.get(1);
    assertEquals("Role", getResult.getAuthority());
    assertEquals("Role", getResult.toString());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} third Authority is {@code ROLE_42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole_thenArrayListThirdAuthorityIsRole42() {
    // Arrange
    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities.add(new SimpleGrantedAuthority("PERMISSION_42"));

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert
    assertEquals(3, adminUserAuthorities.size());
    SimpleGrantedAuthority getResult = adminUserAuthorities.get(2);
    assertEquals("ROLE_42", getResult.getAuthority());
    assertEquals("ROLE_42", getResult.toString());
    SimpleGrantedAuthority getResult2 = adminUserAuthorities.get(1);
    assertEquals("ROLE_PERMISSION_42", getResult2.getAuthority());
    assertEquals("ROLE_PERMISSION_42", getResult2.toString());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole_whenArrayList_thenArrayListEmpty() {
    // Arrange
    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert that nothing has changed
    assertTrue(adminUserAuthorities.isEmpty());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)}.
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AdminUser AdminUserProvisioningServiceImpl.getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)"})
  public void testGetAdminUser() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler = mock(
        AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(Mockito.<AdminUser>any(),
        Mockito.<BroadleafExternalAuthenticationUserDetails>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy()).thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(new AdminUserImpl());
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(adminUserImpl);
    BroadleafExternalAuthenticationUserDetails details = new BroadleafExternalAuthenticationUserDetails("janedoe",
        "iloveyou", new ArrayList<>());

    // Act
    AdminUser actualAdminUser = adminUserProvisioningServiceImpl.getAdminUser(details, new HashSet<>());

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(adminExternalLoginExtensionHandler).performAdditionalAuthenticationTasks(isA(AdminUser.class),
        isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName(eq("janedoe"));
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertSame(adminUserImpl, actualAdminUser);
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)}.
   * <ul>
   *   <li>Given {@link AdminRoleImpl} (default constructor).</li>
   *   <li>When {@link HashSet#HashSet()} add {@link AdminRoleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AdminUser AdminUserProvisioningServiceImpl.getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)"})
  public void testGetAdminUser_givenAdminRoleImpl_whenHashSetAddAdminRoleImpl() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler = mock(
        AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(Mockito.<AdminUser>any(),
        Mockito.<BroadleafExternalAuthenticationUserDetails>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy()).thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(new AdminUserImpl());
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(adminUserImpl);
    BroadleafExternalAuthenticationUserDetails details = mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getEmail()).thenReturn("jane.doe@example.org");
    when(details.getFirstName()).thenReturn("Jane");
    when(details.getLastName()).thenReturn("Doe");
    when(details.getUsername()).thenReturn("janedoe");

    HashSet<AdminRole> parsedRoles = new HashSet<>();
    parsedRoles.add(new AdminRoleImpl());

    // Act
    AdminUser actualAdminUser = adminUserProvisioningServiceImpl.getAdminUser(details, parsedRoles);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(details, atLeast(1)).getEmail();
    verify(details, atLeast(1)).getFirstName();
    verify(details, atLeast(1)).getLastName();
    verify(adminExternalLoginExtensionHandler).performAdditionalAuthenticationTasks(isA(AdminUser.class),
        isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName(eq("janedoe"));
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(details).getUsername();
    assertSame(adminUserImpl, actualAdminUser);
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)}.
   * <ul>
   *   <li>Given {@link AdminRoleImpl} (default constructor).</li>
   *   <li>When {@link HashSet#HashSet()} add {@link AdminRoleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AdminUser AdminUserProvisioningServiceImpl.getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)"})
  public void testGetAdminUser_givenAdminRoleImpl_whenHashSetAddAdminRoleImpl2() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler = mock(
        AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(Mockito.<AdminUser>any(),
        Mockito.<BroadleafExternalAuthenticationUserDetails>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy()).thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(new AdminUserImpl());
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(adminUserImpl);
    BroadleafExternalAuthenticationUserDetails details = mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getEmail()).thenReturn("jane.doe@example.org");
    when(details.getFirstName()).thenReturn("Jane");
    when(details.getLastName()).thenReturn("Doe");
    when(details.getUsername()).thenReturn("janedoe");

    HashSet<AdminRole> parsedRoles = new HashSet<>();
    parsedRoles.add(new AdminRoleImpl());
    parsedRoles.add(new AdminRoleImpl());

    // Act
    AdminUser actualAdminUser = adminUserProvisioningServiceImpl.getAdminUser(details, parsedRoles);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(details, atLeast(1)).getEmail();
    verify(details, atLeast(1)).getFirstName();
    verify(details, atLeast(1)).getLastName();
    verify(adminExternalLoginExtensionHandler).performAdditionalAuthenticationTasks(isA(AdminUser.class),
        isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName(eq("janedoe"));
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(details).getUsername();
    assertSame(adminUserImpl, actualAdminUser);
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)}.
   * <ul>
   *   <li>Given {@link AdminSecurityService} {@link AdminSecurityService#readAdminUserByUserName(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AdminUser AdminUserProvisioningServiceImpl.getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)"})
  public void testGetAdminUser_givenAdminSecurityServiceReadAdminUserByUserNameReturnNull() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler = mock(
        AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(Mockito.<AdminUser>any(),
        Mockito.<BroadleafExternalAuthenticationUserDetails>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy()).thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(adminUserImpl);
    BroadleafExternalAuthenticationUserDetails details = new BroadleafExternalAuthenticationUserDetails("janedoe",
        "iloveyou", new ArrayList<>());

    // Act
    AdminUser actualAdminUser = adminUserProvisioningServiceImpl.getAdminUser(details, new HashSet<>());

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(adminExternalLoginExtensionHandler).performAdditionalAuthenticationTasks(isA(AdminUser.class),
        isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName(eq("janedoe"));
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertSame(adminUserImpl, actualAdminUser);
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)}.
   * <ul>
   *   <li>Given {@code jane.doe@example.org}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AdminUser AdminUserProvisioningServiceImpl.getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)"})
  public void testGetAdminUser_givenJaneDoeExampleOrg() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler = mock(
        AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(Mockito.<AdminUser>any(),
        Mockito.<BroadleafExternalAuthenticationUserDetails>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy()).thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(new AdminUserImpl());
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(adminUserImpl);
    BroadleafExternalAuthenticationUserDetails details = mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getEmail()).thenReturn("jane.doe@example.org");
    when(details.getFirstName()).thenReturn("Jane");
    when(details.getLastName()).thenReturn("Doe");
    when(details.getUsername()).thenReturn("janedoe");

    // Act
    AdminUser actualAdminUser = adminUserProvisioningServiceImpl.getAdminUser(details, new HashSet<>());

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(details, atLeast(1)).getEmail();
    verify(details, atLeast(1)).getFirstName();
    verify(details, atLeast(1)).getLastName();
    verify(adminExternalLoginExtensionHandler).performAdditionalAuthenticationTasks(isA(AdminUser.class),
        isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName(eq("janedoe"));
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(details).getUsername();
    assertSame(adminUserImpl, actualAdminUser);
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)}.
   * <ul>
   *   <li>Given space.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AdminUser AdminUserProvisioningServiceImpl.getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)"})
  public void testGetAdminUser_givenSpace() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler = mock(
        AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(Mockito.<AdminUser>any(),
        Mockito.<BroadleafExternalAuthenticationUserDetails>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy()).thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(new AdminUserImpl());
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(adminUserImpl);
    BroadleafExternalAuthenticationUserDetails details = mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getEmail()).thenReturn(" ");
    when(details.getFirstName()).thenReturn("Jane");
    when(details.getLastName()).thenReturn("Doe");
    when(details.getUsername()).thenReturn("janedoe");

    // Act
    AdminUser actualAdminUser = adminUserProvisioningServiceImpl.getAdminUser(details, new HashSet<>());

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(details).getEmail();
    verify(details, atLeast(1)).getFirstName();
    verify(details, atLeast(1)).getLastName();
    verify(adminExternalLoginExtensionHandler).performAdditionalAuthenticationTasks(isA(AdminUser.class),
        isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName(eq("janedoe"));
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(details).getUsername();
    assertSame(adminUserImpl, actualAdminUser);
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#createDetails(AdminUser, BroadleafExternalAuthenticationUserDetails, Set)}.
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#createDetails(AdminUser, BroadleafExternalAuthenticationUserDetails, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AdminUserDetails AdminUserProvisioningServiceImpl.createDetails(AdminUser, BroadleafExternalAuthenticationUserDetails, Set)"})
  public void testCreateDetails() {
    // Arrange
    AdminUserImpl adminUser = new AdminUserImpl();
    BroadleafExternalAuthenticationUserDetails details = new BroadleafExternalAuthenticationUserDetails("janedoe",
        "iloveyou", new ArrayList<>());

    // Act and Assert
    assertEquals(details, adminUserProvisioningServiceImpl.createDetails(adminUser, details, new HashSet<>()));
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#createDetails(AdminUser, BroadleafExternalAuthenticationUserDetails, Set)}.
   * <ul>
   *   <li>Given {@code janedoe}.</li>
   *   <li>Then return Authorities size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#createDetails(AdminUser, BroadleafExternalAuthenticationUserDetails, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AdminUserDetails AdminUserProvisioningServiceImpl.createDetails(AdminUser, BroadleafExternalAuthenticationUserDetails, Set)"})
  public void testCreateDetails_givenJanedoe_thenReturnAuthoritiesSizeIsOne() {
    // Arrange
    AdminUserImpl adminUser = new AdminUserImpl();
    BroadleafExternalAuthenticationUserDetails details = mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getUsername()).thenReturn("janedoe");

    HashSet<SimpleGrantedAuthority> adminUserAuthorities = new HashSet<>();
    adminUserAuthorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    AdminUserDetails actualCreateDetailsResult = adminUserProvisioningServiceImpl.createDetails(adminUser, details,
        adminUserAuthorities);

    // Assert
    verify(details).getUsername();
    Collection<GrantedAuthority> authorities = actualCreateDetailsResult.getAuthorities();
    assertEquals(1, authorities.size());
    assertTrue(authorities instanceof Set);
    assertEquals("", actualCreateDetailsResult.getPassword());
    assertEquals("janedoe", actualCreateDetailsResult.getUsername());
    assertNull(actualCreateDetailsResult.getId());
    assertTrue(actualCreateDetailsResult.isAccountNonExpired());
    assertTrue(actualCreateDetailsResult.isAccountNonLocked());
    assertTrue(actualCreateDetailsResult.isCredentialsNonExpired());
    assertTrue(actualCreateDetailsResult.isEnabled());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}.
   * <ul>
   *   <li>Given {@link AdminSecurityHelper}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "HashSet AdminUserProvisioningServiceImpl.parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)"})
  public void testParseRolesFromUserDetails_givenAdminSecurityHelper_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        adminUserProvisioningServiceImpl
            .parseRolesFromUserDetails(
                new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>()))
            .isEmpty());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is array of {@link String} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "HashSet AdminUserProvisioningServiceImpl.parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)"})
  public void testParseRolesFromUserDetails_givenHashMapFooIsArrayOfStringWithFoo() {
    // Arrange
    HashMap<String, String[]> roleNameSubstitutions = new HashMap<>();
    roleNameSubstitutions.put("foo", new String[]{"foo"});

    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();
    adminUserProvisioningServiceImpl.setRoleNameSubstitutions(roleNameSubstitutions);

    // Act and Assert
    assertTrue(
        adminUserProvisioningServiceImpl
            .parseRolesFromUserDetails(
                new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>()))
            .isEmpty());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "HashSet AdminUserProvisioningServiceImpl.parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)"})
  public void testParseRolesFromUserDetails_thenReturnEmpty() {
    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();
    adminUserProvisioningServiceImpl.setRoleNameSubstitutions(new HashMap<>());

    // Act and Assert
    assertTrue(
        adminUserProvisioningServiceImpl
            .parseRolesFromUserDetails(
                new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>()))
            .isEmpty());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "HashSet AdminUserProvisioningServiceImpl.parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)"})
  public void testParseRolesFromUserDetails_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    HashSet<String> actualParseRolesFromUserDetailsResult = adminUserProvisioningServiceImpl
        .parseRolesFromUserDetails(new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", authorities));

    // Assert
    assertEquals(1, actualParseRolesFromUserDetailsResult.size());
    assertTrue(actualParseRolesFromUserDetailsResult.contains("Role"));
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "HashSet AdminUserProvisioningServiceImpl.parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)"})
  public void testParseRolesFromUserDetails_thenReturnSizeIsOne2() {
    // Arrange
    HashMap<String, String[]> roleNameSubstitutions = new HashMap<>();
    roleNameSubstitutions.put("foo", new String[]{"foo"});

    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();
    adminUserProvisioningServiceImpl.setRoleNameSubstitutions(roleNameSubstitutions);

    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    HashSet<String> actualParseRolesFromUserDetailsResult = adminUserProvisioningServiceImpl
        .parseRolesFromUserDetails(new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", authorities));

    // Assert
    assertEquals(1, actualParseRolesFromUserDetailsResult.size());
    assertTrue(actualParseRolesFromUserDetailsResult.contains("Role"));
  }
}
