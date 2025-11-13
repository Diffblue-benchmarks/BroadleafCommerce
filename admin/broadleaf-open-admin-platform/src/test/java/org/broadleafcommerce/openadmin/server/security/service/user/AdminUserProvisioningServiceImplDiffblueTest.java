package org.broadleafcommerce.openadmin.server.security.service.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class AdminUserProvisioningServiceImplDiffblueTest {
  @Mock private AdminExternalLoginUserExtensionManager adminExternalLoginUserExtensionManager;

  @Mock private AdminSecurityHelper adminSecurityHelper;

  @Mock private AdminSecurityService adminSecurityService;

  @InjectMocks private AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl;

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}.
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUserDetails AdminUserProvisioningServiceImpl.provisionAdminUser(BroadleafExternalAuthenticationUserDetails)"
  })
  public void testProvisionAdminUser() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler =
        mock(AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(
            Mockito.<AdminUser>any(), Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy())
        .thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any()))
        .thenReturn(new AdminUserImpl());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any()))
        .thenReturn(new AdminUserImpl());
    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());

    // Act
    AdminUserDetails actualProvisionAdminUserResult =
        adminUserProvisioningServiceImpl.provisionAdminUser(details);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(adminExternalLoginExtensionHandler)
        .performAdditionalAuthenticationTasks(
            isA(AdminUser.class), isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName("janedoe");
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertEquals(details, actualProvisionAdminUserResult);
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}.
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUserDetails AdminUserProvisioningServiceImpl.provisionAdminUser(BroadleafExternalAuthenticationUserDetails)"
  })
  public void testProvisionAdminUser2() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler =
        mock(AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(
            Mockito.<AdminUser>any(), Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy())
        .thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any()))
        .thenReturn(new AdminUserImpl());

    BroadleafExternalAuthenticationUserDetails details =
        mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getEmail()).thenReturn("not blank");
    when(details.getFirstName()).thenReturn("not blank");
    when(details.getLastName()).thenReturn("not blank");
    when(details.getUsername()).thenReturn("janedoe");
    when(details.getAuthorities()).thenReturn(new ArrayList<>());

    // Act
    AdminUserDetails actualProvisionAdminUserResult =
        adminUserProvisioningServiceImpl.provisionAdminUser(details);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(details, atLeast(1)).getEmail();
    verify(details, atLeast(1)).getFirstName();
    verify(details, atLeast(1)).getLastName();
    verify(adminExternalLoginExtensionHandler)
        .performAdditionalAuthenticationTasks(
            isA(AdminUser.class), isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName("janedoe");
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
   * Test {@link
   * AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminRoleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUserDetails AdminUserProvisioningServiceImpl.provisionAdminUser(BroadleafExternalAuthenticationUserDetails)"
  })
  public void testProvisionAdminUser_givenArrayListAddAdminRoleImpl() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler =
        mock(AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(
            Mockito.<AdminUser>any(), Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy())
        .thenReturn(adminExternalLoginExtensionHandler);

    ArrayList<AdminRole> adminRoleList = new ArrayList<>();
    adminRoleList.add(new AdminRoleImpl());
    when(adminSecurityService.readAllAdminRoles()).thenReturn(adminRoleList);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any()))
        .thenReturn(new AdminUserImpl());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any()))
        .thenReturn(new AdminUserImpl());
    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());

    // Act
    AdminUserDetails actualProvisionAdminUserResult =
        adminUserProvisioningServiceImpl.provisionAdminUser(details);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(adminExternalLoginExtensionHandler)
        .performAdditionalAuthenticationTasks(
            isA(AdminUser.class), isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName("janedoe");
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertEquals(details, actualProvisionAdminUserResult);
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       SimpleGrantedAuthority#SimpleGrantedAuthority(String)} with {@code Role}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUserDetails AdminUserProvisioningServiceImpl.provisionAdminUser(BroadleafExternalAuthenticationUserDetails)"
  })
  public void testProvisionAdminUser_givenArrayListAddSimpleGrantedAuthorityWithRole() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler =
        mock(AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(
            Mockito.<AdminUser>any(), Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy())
        .thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any()))
        .thenReturn(new AdminUserImpl());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any()))
        .thenReturn(new AdminUserImpl());

    ArrayList<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
    grantedAuthorityList.add(new SimpleGrantedAuthority("Role"));

    BroadleafExternalAuthenticationUserDetails details =
        mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getEmail()).thenReturn("not blank");
    when(details.getFirstName()).thenReturn("not blank");
    when(details.getLastName()).thenReturn("not blank");
    when(details.getUsername()).thenReturn("janedoe");
    when(details.getAuthorities()).thenReturn(grantedAuthorityList);

    // Act
    AdminUserDetails actualProvisionAdminUserResult =
        adminUserProvisioningServiceImpl.provisionAdminUser(details);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(details, atLeast(1)).getEmail();
    verify(details, atLeast(1)).getFirstName();
    verify(details, atLeast(1)).getLastName();
    verify(adminExternalLoginExtensionHandler)
        .performAdditionalAuthenticationTasks(
            isA(AdminUser.class), isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName("janedoe");
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
   * Test {@link
   * AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}.
   *
   * <ul>
   *   <li>Given {@code Doe}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUserDetails AdminUserProvisioningServiceImpl.provisionAdminUser(BroadleafExternalAuthenticationUserDetails)"
  })
  public void testProvisionAdminUser_givenDoe() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler =
        mock(AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(
            Mockito.<AdminUser>any(), Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy())
        .thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any()))
        .thenReturn(new AdminUserImpl());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any()))
        .thenReturn(new AdminUserImpl());

    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());
    details.setLastName("Doe");

    // Act
    AdminUserDetails actualProvisionAdminUserResult =
        adminUserProvisioningServiceImpl.provisionAdminUser(details);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(adminExternalLoginExtensionHandler)
        .performAdditionalAuthenticationTasks(
            isA(AdminUser.class), isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName("janedoe");
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertEquals(details, actualProvisionAdminUserResult);
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}.
   *
   * <ul>
   *   <li>Given {@code Jane}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUserDetails AdminUserProvisioningServiceImpl.provisionAdminUser(BroadleafExternalAuthenticationUserDetails)"
  })
  public void testProvisionAdminUser_givenJane() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler =
        mock(AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(
            Mockito.<AdminUser>any(), Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy())
        .thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any()))
        .thenReturn(new AdminUserImpl());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any()))
        .thenReturn(new AdminUserImpl());

    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());
    details.setFirstName("Jane");

    // Act
    AdminUserDetails actualProvisionAdminUserResult =
        adminUserProvisioningServiceImpl.provisionAdminUser(details);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(adminExternalLoginExtensionHandler)
        .performAdditionalAuthenticationTasks(
            isA(AdminUser.class), isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName("janedoe");
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertEquals(details, actualProvisionAdminUserResult);
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}.
   *
   * <ul>
   *   <li>Given {@code jane.doe@example.org}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUserDetails AdminUserProvisioningServiceImpl.provisionAdminUser(BroadleafExternalAuthenticationUserDetails)"
  })
  public void testProvisionAdminUser_givenJaneDoeExampleOrg() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler =
        mock(AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(
            Mockito.<AdminUser>any(), Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy())
        .thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any()))
        .thenReturn(new AdminUserImpl());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any()))
        .thenReturn(new AdminUserImpl());

    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());
    details.setEmail("jane.doe@example.org");

    // Act
    AdminUserDetails actualProvisionAdminUserResult =
        adminUserProvisioningServiceImpl.provisionAdminUser(details);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(adminExternalLoginExtensionHandler)
        .performAdditionalAuthenticationTasks(
            isA(AdminUser.class), isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName("janedoe");
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertEquals(details, actualProvisionAdminUserResult);
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}.
   *
   * <ul>
   *   <li>Given space.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#provisionAdminUser(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUserDetails AdminUserProvisioningServiceImpl.provisionAdminUser(BroadleafExternalAuthenticationUserDetails)"
  })
  public void testProvisionAdminUser_givenSpace() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler =
        mock(AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(
            Mockito.<AdminUser>any(), Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy())
        .thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any()))
        .thenReturn(new AdminUserImpl());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any()))
        .thenReturn(new AdminUserImpl());

    BroadleafExternalAuthenticationUserDetails details =
        mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getEmail()).thenReturn(" ");
    when(details.getFirstName()).thenReturn(" ");
    when(details.getLastName()).thenReturn(" ");
    when(details.getUsername()).thenReturn("janedoe");
    when(details.getAuthorities()).thenReturn(new ArrayList<>());

    // Act
    AdminUserDetails actualProvisionAdminUserResult =
        adminUserProvisioningServiceImpl.provisionAdminUser(details);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(details).getEmail();
    verify(details).getFirstName();
    verify(details).getLastName();
    verify(adminExternalLoginExtensionHandler)
        .performAdditionalAuthenticationTasks(
            isA(AdminUser.class), isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName("janedoe");
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
   * Test {@link
   * AdminUserProvisioningServiceImpl#parseAdminRoles(BroadleafExternalAuthenticationUserDetails)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminRoleImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#parseAdminRoles(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HashSet AdminUserProvisioningServiceImpl.parseAdminRoles(BroadleafExternalAuthenticationUserDetails)"
  })
  public void testParseAdminRoles_givenArrayListAddAdminRoleImpl_thenReturnEmpty() {
    // Arrange
    ArrayList<AdminRole> adminRoleList = new ArrayList<>();
    adminRoleList.add(new AdminRoleImpl());
    when(adminSecurityService.readAllAdminRoles()).thenReturn(adminRoleList);
    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());

    // Act
    HashSet<AdminRole> actualParseAdminRolesResult =
        adminUserProvisioningServiceImpl.parseAdminRoles(details);

    // Assert
    verify(adminSecurityService).readAllAdminRoles();
    assertTrue(actualParseAdminRolesResult.isEmpty());
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#parseAdminRoles(BroadleafExternalAuthenticationUserDetails)}.
   *
   * <ul>
   *   <li>Given {@link SimpleGrantedAuthority#SimpleGrantedAuthority(String)} with {@code Role}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#parseAdminRoles(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HashSet AdminUserProvisioningServiceImpl.parseAdminRoles(BroadleafExternalAuthenticationUserDetails)"
  })
  public void testParseAdminRoles_givenSimpleGrantedAuthorityWithRole() {
    // Arrange
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());

    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", authorities);

    // Act
    HashSet<AdminRole> actualParseAdminRolesResult =
        adminUserProvisioningServiceImpl.parseAdminRoles(details);

    // Assert
    verify(adminSecurityService).readAllAdminRoles();
    assertTrue(actualParseAdminRolesResult.isEmpty());
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#parseAdminRoles(BroadleafExternalAuthenticationUserDetails)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#parseAdminRoles(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HashSet AdminUserProvisioningServiceImpl.parseAdminRoles(BroadleafExternalAuthenticationUserDetails)"
  })
  public void testParseAdminRoles_thenReturnEmpty() {
    // Arrange
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());

    // Act
    HashSet<AdminRole> actualParseAdminRolesResult =
        adminUserProvisioningServiceImpl.parseAdminRoles(details);

    // Assert
    verify(adminSecurityService).readAllAdminRoles();
    assertTrue(actualParseAdminRolesResult.isEmpty());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#extractAdminUserAuthorities(HashSet)}.
   *
   * <ul>
   *   <li>Given {@link AdminUserProvisioningServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#extractAdminUserAuthorities(HashSet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdminUserProvisioningServiceImpl.extractAdminUserAuthorities(HashSet)"})
  public void testExtractAdminUserAuthorities_givenAdminUserProvisioningServiceImpl() {
    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl =
        new AdminUserProvisioningServiceImpl();

    // Act and Assert
    assertEquals(
        6, adminUserProvisioningServiceImpl.extractAdminUserAuthorities(new HashSet<>()).size());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#extractAdminUserAuthorities(HashSet)}.
   *
   * <ul>
   *   <li>Then calls {@link AdminSecurityHelper#addAllPermissionsToAuthorities(List, Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#extractAdminUserAuthorities(HashSet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdminUserProvisioningServiceImpl.extractAdminUserAuthorities(HashSet)"})
  public void testExtractAdminUserAuthorities_thenCallsAddAllPermissionsToAuthorities() {
    // Arrange
    doNothing()
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    LinkedHashSet<AdminRole> parsedRoles = new LinkedHashSet<>();
    parsedRoles.add(new AdminRoleImpl());

    // Act
    Set<SimpleGrantedAuthority> actualExtractAdminUserAuthoritiesResult =
        adminUserProvisioningServiceImpl.extractAdminUserAuthorities(parsedRoles);

    // Assert
    verify(adminSecurityHelper)
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    assertEquals(6, actualExtractAdminUserAuthoritiesResult.size());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#addPermissions(HashSet, List)}.
   *
   * <ul>
   *   <li>Given {@link AdminRoleImpl} (default constructor).
   *   <li>Then calls {@link AdminSecurityHelper#addAllPermissionsToAuthorities(List, Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserProvisioningServiceImpl#addPermissions(HashSet, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.addPermissions(HashSet, List)"})
  public void testAddPermissions_givenAdminRoleImpl_thenCallsAddAllPermissionsToAuthorities() {
    // Arrange
    doNothing()
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    LinkedHashSet<AdminRole> parsedRoles = new LinkedHashSet<>();
    parsedRoles.add(new AdminRoleImpl());
    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();

    // Act
    adminUserProvisioningServiceImpl.addPermissions(parsedRoles, adminUserAuthorities);

    // Assert
    verify(adminSecurityHelper)
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
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
   *
   * <ul>
   *   <li>Given {@link AdminUserProvisioningServiceImpl} (default constructor).
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserProvisioningServiceImpl#addPermissions(HashSet, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.addPermissions(HashSet, List)"})
  public void testAddPermissions_givenAdminUserProvisioningServiceImpl_whenHashSet() {
    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl =
        new AdminUserProvisioningServiceImpl();
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
   * Test {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}.
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole() {
    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl =
        new AdminUserProvisioningServiceImpl();

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
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole2() {
    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl =
        new AdminUserProvisioningServiceImpl();

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
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole3() {
    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl =
        new AdminUserProvisioningServiceImpl();

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
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole4() {
    // Arrange
    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities.add(new SimpleGrantedAuthority("PERMISSION_PERMISSION_PERMISSION_"));

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert
    assertEquals(3, adminUserAuthorities.size());
    SimpleGrantedAuthority getResult = adminUserAuthorities.get(1);
    assertEquals("ROLE_PERMISSION_PERMISSION_PERMISSION_", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_PERMISSION_PERMISSION_", getResult.toString());
    SimpleGrantedAuthority getResult2 = adminUserAuthorities.get(2);
    assertEquals("ROLE_ROLE_ROLE_", getResult2.getAuthority());
    assertEquals("ROLE_ROLE_ROLE_", getResult2.toString());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} second Authority is {@code ROLE_PERMISSION_}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole_thenArrayListSecondAuthorityIsRolePermission() {
    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl =
        new AdminUserProvisioningServiceImpl();

    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities.add(
        new SimpleGrantedAuthority(AdminUserDetailsServiceImpl.LEGACY_ROLE_PREFIX));
    adminUserAuthorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert
    assertEquals(4, adminUserAuthorities.size());
    SimpleGrantedAuthority getResult = adminUserAuthorities.get(1);
    assertEquals("ROLE_PERMISSION_", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_", getResult.toString());
    SimpleGrantedAuthority getResult2 = adminUserAuthorities.get(2);
    assertEquals(
        AdminUserDetailsServiceImpl.DEFAULT_SPRING_SECURITY_ROLE_PREFIX, getResult2.getAuthority());
    assertEquals(
        AdminUserDetailsServiceImpl.DEFAULT_SPRING_SECURITY_ROLE_PREFIX, getResult2.toString());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole_thenArrayListSizeIsOne() {
    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl =
        new AdminUserProvisioningServiceImpl();

    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert that nothing has changed
    assertEquals(1, adminUserAuthorities.size());
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole_thenArrayListSizeIsTwo() {
    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl =
        new AdminUserProvisioningServiceImpl();

    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities.add(
        new SimpleGrantedAuthority(
            AdminUserDetailsServiceImpl.DEFAULT_SPRING_SECURITY_ROLE_PREFIX));
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
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} third Authority is {@code ROLE_42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole_thenArrayListThirdAuthorityIsRole42() {
    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl =
        new AdminUserProvisioningServiceImpl();

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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserProvisioningServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole_whenArrayList_thenArrayListEmpty() {
    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl =
        new AdminUserProvisioningServiceImpl();
    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert that nothing has changed
    assertTrue(adminUserAuthorities.isEmpty());
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails,
   * HashSet)}.
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails,
   * HashSet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUser AdminUserProvisioningServiceImpl.getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)"
  })
  public void testGetAdminUser() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler =
        mock(AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(
            Mockito.<AdminUser>any(), Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy())
        .thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any()))
        .thenReturn(new AdminUserImpl());
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(adminUserImpl);
    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());

    // Act
    AdminUser actualAdminUser =
        adminUserProvisioningServiceImpl.getAdminUser(details, new HashSet<>());

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(adminExternalLoginExtensionHandler)
        .performAdditionalAuthenticationTasks(
            isA(AdminUser.class), isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName("janedoe");
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertSame(adminUserImpl, actualAdminUser);
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails,
   * HashSet)}.
   *
   * <ul>
   *   <li>Given {@link AdminRoleImpl} (default constructor).
   *   <li>When {@link HashSet#HashSet()} add {@link AdminRoleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails,
   * HashSet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUser AdminUserProvisioningServiceImpl.getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)"
  })
  public void testGetAdminUser_givenAdminRoleImpl_whenHashSetAddAdminRoleImpl() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler =
        mock(AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(
            Mockito.<AdminUser>any(), Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy())
        .thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any()))
        .thenReturn(new AdminUserImpl());
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(adminUserImpl);

    BroadleafExternalAuthenticationUserDetails details =
        mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getEmail()).thenReturn(" ");
    when(details.getFirstName()).thenReturn(" ");
    when(details.getLastName()).thenReturn(" ");
    when(details.getUsername()).thenReturn("janedoe");

    HashSet<AdminRole> parsedRoles = new HashSet<>();
    parsedRoles.add(new AdminRoleImpl());

    // Act
    AdminUser actualAdminUser = adminUserProvisioningServiceImpl.getAdminUser(details, parsedRoles);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(details).getEmail();
    verify(details).getFirstName();
    verify(details).getLastName();
    verify(adminExternalLoginExtensionHandler)
        .performAdditionalAuthenticationTasks(
            isA(AdminUser.class), isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName("janedoe");
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(details, atLeast(1)).getUsername();
    assertSame(adminUserImpl, actualAdminUser);
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails,
   * HashSet)}.
   *
   * <ul>
   *   <li>Given {@link AdminRoleImpl} (default constructor).
   *   <li>When {@link HashSet#HashSet()} add {@link AdminRoleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails,
   * HashSet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUser AdminUserProvisioningServiceImpl.getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)"
  })
  public void testGetAdminUser_givenAdminRoleImpl_whenHashSetAddAdminRoleImpl2() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler =
        mock(AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(
            Mockito.<AdminUser>any(), Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy())
        .thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any()))
        .thenReturn(new AdminUserImpl());
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(adminUserImpl);

    BroadleafExternalAuthenticationUserDetails details =
        mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getEmail()).thenReturn(" ");
    when(details.getFirstName()).thenReturn(" ");
    when(details.getLastName()).thenReturn(" ");
    when(details.getUsername()).thenReturn("janedoe");

    HashSet<AdminRole> parsedRoles = new HashSet<>();
    parsedRoles.add(new AdminRoleImpl());
    parsedRoles.add(new AdminRoleImpl());

    // Act
    AdminUser actualAdminUser = adminUserProvisioningServiceImpl.getAdminUser(details, parsedRoles);

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(details).getEmail();
    verify(details).getFirstName();
    verify(details).getLastName();
    verify(adminExternalLoginExtensionHandler)
        .performAdditionalAuthenticationTasks(
            isA(AdminUser.class), isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName("janedoe");
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(details, atLeast(1)).getUsername();
    assertSame(adminUserImpl, actualAdminUser);
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails,
   * HashSet)}.
   *
   * <ul>
   *   <li>Given {@link AdminSecurityService} {@link
   *       AdminSecurityService#readAdminUserByUserName(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails,
   * HashSet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUser AdminUserProvisioningServiceImpl.getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)"
  })
  public void testGetAdminUser_givenAdminSecurityServiceReadAdminUserByUserNameReturnNull() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler =
        mock(AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(
            Mockito.<AdminUser>any(), Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy())
        .thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(adminUserImpl);

    BroadleafExternalAuthenticationUserDetails details =
        mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getEmail()).thenReturn(" ");
    when(details.getFirstName()).thenReturn(" ");
    when(details.getLastName()).thenReturn(" ");
    when(details.getUsername()).thenReturn("janedoe");

    // Act
    AdminUser actualAdminUser =
        adminUserProvisioningServiceImpl.getAdminUser(details, new HashSet<>());

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(details).getEmail();
    verify(details).getFirstName();
    verify(details).getLastName();
    verify(adminExternalLoginExtensionHandler)
        .performAdditionalAuthenticationTasks(
            isA(AdminUser.class), isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName("janedoe");
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(details, atLeast(1)).getUsername();
    assertSame(adminUserImpl, actualAdminUser);
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails,
   * HashSet)}.
   *
   * <ul>
   *   <li>Given {@code Doe}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails,
   * HashSet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUser AdminUserProvisioningServiceImpl.getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)"
  })
  public void testGetAdminUser_givenDoe() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler =
        mock(AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(
            Mockito.<AdminUser>any(), Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy())
        .thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any()))
        .thenReturn(new AdminUserImpl());
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(adminUserImpl);

    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());
    details.setLastName("Doe");

    // Act
    AdminUser actualAdminUser =
        adminUserProvisioningServiceImpl.getAdminUser(details, new HashSet<>());

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(adminExternalLoginExtensionHandler)
        .performAdditionalAuthenticationTasks(
            isA(AdminUser.class), isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName("janedoe");
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertSame(adminUserImpl, actualAdminUser);
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails,
   * HashSet)}.
   *
   * <ul>
   *   <li>Given {@code Jane}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails,
   * HashSet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUser AdminUserProvisioningServiceImpl.getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)"
  })
  public void testGetAdminUser_givenJane() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler =
        mock(AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(
            Mockito.<AdminUser>any(), Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy())
        .thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any()))
        .thenReturn(new AdminUserImpl());
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(adminUserImpl);

    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());
    details.setFirstName("Jane");

    // Act
    AdminUser actualAdminUser =
        adminUserProvisioningServiceImpl.getAdminUser(details, new HashSet<>());

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(adminExternalLoginExtensionHandler)
        .performAdditionalAuthenticationTasks(
            isA(AdminUser.class), isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName("janedoe");
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertSame(adminUserImpl, actualAdminUser);
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails,
   * HashSet)}.
   *
   * <ul>
   *   <li>Given {@code jane.doe@example.org}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails,
   * HashSet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUser AdminUserProvisioningServiceImpl.getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)"
  })
  public void testGetAdminUser_givenJaneDoeExampleOrg() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler =
        mock(AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(
            Mockito.<AdminUser>any(), Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy())
        .thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any()))
        .thenReturn(new AdminUserImpl());
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(adminUserImpl);

    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());
    details.setEmail("jane.doe@example.org");

    // Act
    AdminUser actualAdminUser =
        adminUserProvisioningServiceImpl.getAdminUser(details, new HashSet<>());

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(adminExternalLoginExtensionHandler)
        .performAdditionalAuthenticationTasks(
            isA(AdminUser.class), isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName("janedoe");
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertSame(adminUserImpl, actualAdminUser);
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails,
   * HashSet)}.
   *
   * <ul>
   *   <li>Given space.
   *   <li>Then calls {@link BroadleafExternalAuthenticationUserDetails#getEmail()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#getAdminUser(BroadleafExternalAuthenticationUserDetails,
   * HashSet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUser AdminUserProvisioningServiceImpl.getAdminUser(BroadleafExternalAuthenticationUserDetails, HashSet)"
  })
  public void testGetAdminUser_givenSpace_thenCallsGetEmail() {
    // Arrange
    AdminExternalLoginExtensionHandler adminExternalLoginExtensionHandler =
        mock(AdminExternalLoginExtensionHandler.class);
    when(adminExternalLoginExtensionHandler.performAdditionalAuthenticationTasks(
            Mockito.<AdminUser>any(), Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminExternalLoginUserExtensionManager.getProxy())
        .thenReturn(adminExternalLoginExtensionHandler);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any()))
        .thenReturn(new AdminUserImpl());
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(adminUserImpl);

    BroadleafExternalAuthenticationUserDetails details =
        mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getEmail()).thenReturn(" ");
    when(details.getFirstName()).thenReturn(" ");
    when(details.getLastName()).thenReturn(" ");
    when(details.getUsername()).thenReturn("janedoe");

    // Act
    AdminUser actualAdminUser =
        adminUserProvisioningServiceImpl.getAdminUser(details, new HashSet<>());

    // Assert
    verify(adminExternalLoginUserExtensionManager).getProxy();
    verify(details).getEmail();
    verify(details).getFirstName();
    verify(details).getLastName();
    verify(adminExternalLoginExtensionHandler)
        .performAdditionalAuthenticationTasks(
            isA(AdminUser.class), isA(BroadleafExternalAuthenticationUserDetails.class));
    verify(adminSecurityService).readAdminUserByUserName("janedoe");
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(details, atLeast(1)).getUsername();
    assertSame(adminUserImpl, actualAdminUser);
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#createDetails(AdminUser,
   * BroadleafExternalAuthenticationUserDetails, Set)}.
   *
   * <p>Method under test: {@link AdminUserProvisioningServiceImpl#createDetails(AdminUser,
   * BroadleafExternalAuthenticationUserDetails, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUserDetails AdminUserProvisioningServiceImpl.createDetails(AdminUser, BroadleafExternalAuthenticationUserDetails, Set)"
  })
  public void testCreateDetails() {
    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl =
        new AdminUserProvisioningServiceImpl();
    AdminUserImpl adminUser = new AdminUserImpl();
    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());

    // Act
    AdminUserDetails actualCreateDetailsResult =
        adminUserProvisioningServiceImpl.createDetails(adminUser, details, new HashSet<>());

    // Assert
    assertEquals(details, actualCreateDetailsResult);
  }

  /**
   * Test {@link AdminUserProvisioningServiceImpl#createDetails(AdminUser,
   * BroadleafExternalAuthenticationUserDetails, Set)}.
   *
   * <p>Method under test: {@link AdminUserProvisioningServiceImpl#createDetails(AdminUser,
   * BroadleafExternalAuthenticationUserDetails, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminUserDetails AdminUserProvisioningServiceImpl.createDetails(AdminUser, BroadleafExternalAuthenticationUserDetails, Set)"
  })
  public void testCreateDetails2() {
    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl =
        new AdminUserProvisioningServiceImpl();
    AdminUserImpl adminUser = new AdminUserImpl();
    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("  ", "iloveyou", new ArrayList<>());

    LinkedHashSet<SimpleGrantedAuthority> adminUserAuthorities = new LinkedHashSet<>();
    adminUserAuthorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    AdminUserDetails actualCreateDetailsResult =
        adminUserProvisioningServiceImpl.createDetails(adminUser, details, adminUserAuthorities);

    // Assert
    assertEquals(details, actualCreateDetailsResult);
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}.
   *
   * <ul>
   *   <li>Given {@link AdminUserProvisioningServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HashSet AdminUserProvisioningServiceImpl.parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)"
  })
  public void testParseRolesFromUserDetails_givenAdminUserProvisioningServiceImpl() {
    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl =
        new AdminUserProvisioningServiceImpl();
    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());

    // Act and Assert
    assertTrue(adminUserProvisioningServiceImpl.parseRolesFromUserDetails(details).isEmpty());
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is array of {@link String} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HashSet AdminUserProvisioningServiceImpl.parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)"
  })
  public void testParseRolesFromUserDetails_givenHashMapFooIsArrayOfStringWithFoo() {
    // Arrange
    HashMap<String, String[]> roleNameSubstitutions = new HashMap<>();
    roleNameSubstitutions.put("foo", new String[] {"foo"});

    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl =
        new AdminUserProvisioningServiceImpl();
    adminUserProvisioningServiceImpl.setRoleNameSubstitutions(roleNameSubstitutions);
    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());

    // Act and Assert
    assertTrue(adminUserProvisioningServiceImpl.parseRolesFromUserDetails(details).isEmpty());
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HashSet AdminUserProvisioningServiceImpl.parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)"
  })
  public void testParseRolesFromUserDetails_thenReturnEmpty() {
    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl =
        new AdminUserProvisioningServiceImpl();
    adminUserProvisioningServiceImpl.setRoleNameSubstitutions(new HashMap<>());
    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());

    // Act and Assert
    assertTrue(adminUserProvisioningServiceImpl.parseRolesFromUserDetails(details).isEmpty());
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HashSet AdminUserProvisioningServiceImpl.parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)"
  })
  public void testParseRolesFromUserDetails_thenReturnSizeIsOne() {
    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl =
        new AdminUserProvisioningServiceImpl();

    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", authorities);

    // Act
    HashSet<String> actualParseRolesFromUserDetailsResult =
        adminUserProvisioningServiceImpl.parseRolesFromUserDetails(details);

    // Assert
    assertEquals(1, actualParseRolesFromUserDetailsResult.size());
    assertTrue(actualParseRolesFromUserDetailsResult.contains("Role"));
  }

  /**
   * Test {@link
   * AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HashSet AdminUserProvisioningServiceImpl.parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)"
  })
  public void testParseRolesFromUserDetails_thenReturnSizeIsOne2() {
    // Arrange
    HashMap<String, String[]> roleNameSubstitutions = new HashMap<>();
    roleNameSubstitutions.put("foo", new String[] {"foo"});

    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl =
        new AdminUserProvisioningServiceImpl();
    adminUserProvisioningServiceImpl.setRoleNameSubstitutions(roleNameSubstitutions);

    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    BroadleafExternalAuthenticationUserDetails details =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", authorities);

    // Act
    HashSet<String> actualParseRolesFromUserDetailsResult =
        adminUserProvisioningServiceImpl.parseRolesFromUserDetails(details);

    // Assert
    assertEquals(1, actualParseRolesFromUserDetailsResult.size());
    assertTrue(actualParseRolesFromUserDetailsResult.contains("Role"));
  }
}
