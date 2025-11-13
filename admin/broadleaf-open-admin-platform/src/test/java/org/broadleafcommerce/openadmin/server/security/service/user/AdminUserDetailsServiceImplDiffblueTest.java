package org.broadleafcommerce.openadmin.server.security.service.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao;
import org.broadleafcommerce.openadmin.server.security.domain.AdminPermission;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRole;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRoleImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.service.AdminSecurityHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class AdminUserDetailsServiceImplDiffblueTest {
  @Mock private AdminSecurityHelper adminSecurityHelper;

  @Mock private AdminUserDao adminUserDao;

  @InjectMocks private AdminUserDetailsServiceImpl adminUserDetailsServiceImpl;

  /**
   * Test {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}.
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.loadUserByUsername(String)"})
  public void testLoadUserByUsername() throws DataAccessException, UsernameNotFoundException {
    // Arrange
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any()))
        .thenReturn(new AdminUserImpl());

    // Act and Assert
    assertThrows(
        UsernameNotFoundException.class,
        () -> adminUserDetailsServiceImpl.loadUserByUsername("janedoe"));
    verify(adminUserDao).readAdminUserByUserName("janedoe");
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}.
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.loadUserByUsername(String)"})
  public void testLoadUserByUsername2() throws DataAccessException, UsernameNotFoundException {
    // Arrange
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any()))
        .thenThrow(new UsernameNotFoundException("The user was not found"));

    // Act and Assert
    assertThrows(
        UsernameNotFoundException.class,
        () -> adminUserDetailsServiceImpl.loadUserByUsername("janedoe"));
    verify(adminUserDao).readAdminUserByUserName("janedoe");
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}.
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.loadUserByUsername(String)"})
  public void testLoadUserByUsername3() throws DataAccessException, UsernameNotFoundException {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getActiveStatusFlag())
        .thenThrow(new UsernameNotFoundException("The user was not found"));
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUser);

    // Act and Assert
    assertThrows(
        UsernameNotFoundException.class,
        () -> adminUserDetailsServiceImpl.loadUserByUsername("janedoe"));
    verify(adminUserDao).readAdminUserByUserName("janedoe");
    verify(adminUser).getActiveStatusFlag();
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}.
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.loadUserByUsername(String)"})
  public void testLoadUserByUsername4() throws DataAccessException, UsernameNotFoundException {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getAllRoles())
        .thenThrow(new UsernameNotFoundException(AdminUserDetailsServiceImpl.LEGACY_ROLE_PREFIX));
    when(adminUser.getActiveStatusFlag()).thenReturn(true);
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUser);

    // Act and Assert
    assertThrows(
        UsernameNotFoundException.class,
        () -> adminUserDetailsServiceImpl.loadUserByUsername("janedoe"));
    verify(adminUserDao).readAdminUserByUserName("janedoe");
    verify(adminUser, atLeast(1)).getActiveStatusFlag();
    verify(adminUser).getAllRoles();
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}.
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.loadUserByUsername(String)"})
  public void testLoadUserByUsername5() throws DataAccessException, UsernameNotFoundException {
    // Arrange
    doThrow(new UsernameNotFoundException(AdminUserDetailsServiceImpl.LEGACY_ROLE_PREFIX))
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getAllPermissions()).thenReturn(new HashSet<>());
    when(adminUser.getAllRoles()).thenReturn(new HashSet<>());
    when(adminUser.getActiveStatusFlag()).thenReturn(true);
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUser);

    // Act and Assert
    assertThrows(
        UsernameNotFoundException.class,
        () -> adminUserDetailsServiceImpl.loadUserByUsername("janedoe"));
    verify(adminUserDao).readAdminUserByUserName("janedoe");
    verify(adminUser, atLeast(1)).getActiveStatusFlag();
    verify(adminUser).getAllPermissions();
    verify(adminUser).getAllRoles();
    verify(adminSecurityHelper)
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}.
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.loadUserByUsername(String)"})
  public void testLoadUserByUsername6() throws DataAccessException, UsernameNotFoundException {
    // Arrange
    AdminRoleImpl adminRoleImpl = mock(AdminRoleImpl.class);
    when(adminRoleImpl.getAllPermissions())
        .thenThrow(new UsernameNotFoundException(AdminUserDetailsServiceImpl.LEGACY_ROLE_PREFIX));
    when(adminRoleImpl.getName()).thenReturn("Name");

    HashSet<AdminRole> adminRoleSet = new HashSet<>();
    adminRoleSet.add(adminRoleImpl);

    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getAllRoles()).thenReturn(adminRoleSet);
    when(adminUser.getActiveStatusFlag()).thenReturn(true);
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUser);

    // Act and Assert
    assertThrows(
        UsernameNotFoundException.class,
        () -> adminUserDetailsServiceImpl.loadUserByUsername("janedoe"));
    verify(adminUserDao).readAdminUserByUserName("janedoe");
    verify(adminRoleImpl).getAllPermissions();
    verify(adminRoleImpl).getName();
    verify(adminUser, atLeast(1)).getActiveStatusFlag();
    verify(adminUser).getAllRoles();
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}.
   *
   * <ul>
   *   <li>Given {@link AdminUserDao} {@link AdminUserDao#readAdminUserByUserName(String)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.loadUserByUsername(String)"})
  public void testLoadUserByUsername_givenAdminUserDaoReadAdminUserByUserNameReturnNull()
      throws DataAccessException, UsernameNotFoundException {
    // Arrange
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        UsernameNotFoundException.class,
        () -> adminUserDetailsServiceImpl.loadUserByUsername("janedoe"));
    verify(adminUserDao).readAdminUserByUserName("janedoe");
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}.
   *
   * <ul>
   *   <li>Given {@link AdminUser} {@link AdminUser#getActiveStatusFlag()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.loadUserByUsername(String)"})
  public void testLoadUserByUsername_givenAdminUserGetActiveStatusFlagReturnFalse()
      throws DataAccessException, UsernameNotFoundException {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getActiveStatusFlag()).thenReturn(false);
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUser);

    // Act and Assert
    assertThrows(
        UsernameNotFoundException.class,
        () -> adminUserDetailsServiceImpl.loadUserByUsername("janedoe"));
    verify(adminUserDao).readAdminUserByUserName("janedoe");
    verify(adminUser, atLeast(1)).getActiveStatusFlag();
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}.
   *
   * <ul>
   *   <li>Then return Authorities size is nine.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.loadUserByUsername(String)"})
  public void testLoadUserByUsername_thenReturnAuthoritiesSizeIsNine()
      throws DataAccessException, UsernameNotFoundException {
    // Arrange
    doNothing()
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    AdminRoleImpl adminRoleImpl = mock(AdminRoleImpl.class);
    when(adminRoleImpl.getAllPermissions()).thenReturn(new HashSet<>());
    when(adminRoleImpl.getName()).thenReturn(AdminUserDetailsServiceImpl.LEGACY_ROLE_PREFIX);

    HashSet<AdminRole> adminRoleSet = new HashSet<>();
    adminRoleSet.add(adminRoleImpl);

    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getId()).thenReturn(1L);
    when(adminUser.getPassword()).thenReturn("iloveyou");
    when(adminUser.getAllPermissions()).thenReturn(new HashSet<>());
    when(adminUser.getAllRoles()).thenReturn(adminRoleSet);
    when(adminUser.getActiveStatusFlag()).thenReturn(true);
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUser);

    // Act
    UserDetails actualLoadUserByUsernameResult =
        adminUserDetailsServiceImpl.loadUserByUsername("janedoe");

    // Assert
    verify(adminUserDao).readAdminUserByUserName("janedoe");
    verify(adminRoleImpl).getAllPermissions();
    verify(adminRoleImpl).getName();
    verify(adminUser, atLeast(1)).getActiveStatusFlag();
    verify(adminUser).getAllPermissions();
    verify(adminUser).getAllRoles();
    verify(adminUser).getId();
    verify(adminUser).getPassword();
    verify(adminSecurityHelper, atLeast(1))
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    Collection<? extends GrantedAuthority> authorities =
        actualLoadUserByUsernameResult.getAuthorities();
    assertEquals(9, authorities.size());
    assertTrue(authorities instanceof Set);
    assertTrue(actualLoadUserByUsernameResult instanceof AdminUserDetails);
    assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
    assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
    assertEquals(1L, ((AdminUserDetails) actualLoadUserByUsernameResult).getId().longValue());
    assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
    assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
    assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
    assertTrue(actualLoadUserByUsernameResult.isEnabled());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}.
   *
   * <ul>
   *   <li>Then return Authorities size is seven.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.loadUserByUsername(String)"})
  public void testLoadUserByUsername_thenReturnAuthoritiesSizeIsSeven()
      throws DataAccessException, UsernameNotFoundException {
    // Arrange
    doNothing()
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    AdminRoleImpl adminRoleImpl = mock(AdminRoleImpl.class);
    when(adminRoleImpl.getAllPermissions()).thenReturn(new HashSet<>());
    when(adminRoleImpl.getName()).thenReturn("Name");

    HashSet<AdminRole> adminRoleSet = new HashSet<>();
    adminRoleSet.add(adminRoleImpl);

    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getId()).thenReturn(1L);
    when(adminUser.getPassword()).thenReturn("iloveyou");
    when(adminUser.getAllPermissions()).thenReturn(new HashSet<>());
    when(adminUser.getAllRoles()).thenReturn(adminRoleSet);
    when(adminUser.getActiveStatusFlag()).thenReturn(true);
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUser);

    // Act
    UserDetails actualLoadUserByUsernameResult =
        adminUserDetailsServiceImpl.loadUserByUsername("janedoe");

    // Assert
    verify(adminUserDao).readAdminUserByUserName("janedoe");
    verify(adminRoleImpl).getAllPermissions();
    verify(adminRoleImpl).getName();
    verify(adminUser, atLeast(1)).getActiveStatusFlag();
    verify(adminUser).getAllPermissions();
    verify(adminUser).getAllRoles();
    verify(adminUser).getId();
    verify(adminUser).getPassword();
    verify(adminSecurityHelper, atLeast(1))
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    Collection<? extends GrantedAuthority> authorities =
        actualLoadUserByUsernameResult.getAuthorities();
    assertEquals(7, authorities.size());
    assertTrue(authorities instanceof Set);
    assertTrue(actualLoadUserByUsernameResult instanceof AdminUserDetails);
    assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
    assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
    assertEquals(1L, ((AdminUserDetails) actualLoadUserByUsernameResult).getId().longValue());
    assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
    assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
    assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
    assertTrue(actualLoadUserByUsernameResult.isEnabled());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}.
   *
   * <ul>
   *   <li>Then return Authorities size is six.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#loadUserByUsername(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.loadUserByUsername(String)"})
  public void testLoadUserByUsername_thenReturnAuthoritiesSizeIsSix()
      throws DataAccessException, UsernameNotFoundException {
    // Arrange
    doNothing()
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getId()).thenReturn(1L);
    when(adminUser.getPassword()).thenReturn("iloveyou");
    when(adminUser.getAllPermissions()).thenReturn(new HashSet<>());
    when(adminUser.getAllRoles()).thenReturn(new HashSet<>());
    when(adminUser.getActiveStatusFlag()).thenReturn(true);
    when(adminUserDao.readAdminUserByUserName(Mockito.<String>any())).thenReturn(adminUser);

    // Act
    UserDetails actualLoadUserByUsernameResult =
        adminUserDetailsServiceImpl.loadUserByUsername("janedoe");

    // Assert
    verify(adminUserDao).readAdminUserByUserName("janedoe");
    verify(adminUser, atLeast(1)).getActiveStatusFlag();
    verify(adminUser).getAllPermissions();
    verify(adminUser).getAllRoles();
    verify(adminUser).getId();
    verify(adminUser).getPassword();
    verify(adminSecurityHelper)
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    Collection<? extends GrantedAuthority> authorities =
        actualLoadUserByUsernameResult.getAuthorities();
    assertEquals(6, authorities.size());
    assertTrue(authorities instanceof Set);
    assertTrue(actualLoadUserByUsernameResult instanceof AdminUserDetails);
    assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
    assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
    assertEquals(1L, ((AdminUserDetails) actualLoadUserByUsernameResult).getId().longValue());
    assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
    assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
    assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
    assertTrue(actualLoadUserByUsernameResult.isEnabled());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}.
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.buildDetails(String, AdminUser)"})
  public void testBuildDetails() {
    // Arrange
    doThrow(new UsernameNotFoundException(AdminUserDetailsServiceImpl.LEGACY_ROLE_PREFIX))
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    // Act and Assert
    assertThrows(
        UsernameNotFoundException.class,
        () -> adminUserDetailsServiceImpl.buildDetails("janedoe", new AdminUserImpl()));
    verify(adminSecurityHelper)
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}.
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.buildDetails(String, AdminUser)"})
  public void testBuildDetails2() {
    // Arrange
    doNothing()
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setAllPermissions(new HashSet<>());
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName(
        "PERMISSION_org.broadleafcommerce.openadmin.server.security.domain.AdminRoleImpl");

    LinkedHashSet<AdminRole> adminRoleSet = new LinkedHashSet<>();
    adminRoleSet.add(adminRoleImpl);

    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getAllRoles()).thenReturn(adminRoleSet);
    when(adminUser.getId()).thenReturn(1L);
    when(adminUser.getPassword()).thenReturn("iloveyou");
    when(adminUser.getAllPermissions()).thenReturn(new HashSet<>());

    // Act
    UserDetails actualBuildDetailsResult =
        adminUserDetailsServiceImpl.buildDetails("janedoe", adminUser);

    // Assert
    verify(adminUser).getAllPermissions();
    verify(adminUser).getAllRoles();
    verify(adminUser).getId();
    verify(adminUser).getPassword();
    verify(adminSecurityHelper, atLeast(1))
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    Collection<? extends GrantedAuthority> authorities = actualBuildDetailsResult.getAuthorities();
    assertEquals(9, authorities.size());
    assertTrue(authorities instanceof Set);
    assertTrue(actualBuildDetailsResult instanceof AdminUserDetails);
    assertEquals("iloveyou", actualBuildDetailsResult.getPassword());
    assertEquals("janedoe", actualBuildDetailsResult.getUsername());
    assertEquals(1L, ((AdminUserDetails) actualBuildDetailsResult).getId().longValue());
    assertTrue(actualBuildDetailsResult.isAccountNonExpired());
    assertTrue(actualBuildDetailsResult.isAccountNonLocked());
    assertTrue(actualBuildDetailsResult.isCredentialsNonExpired());
    assertTrue(actualBuildDetailsResult.isEnabled());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}.
   *
   * <ul>
   *   <li>Given {@link AdminRoleImpl} (default constructor) Name is {@link
   *       AdminUserDetailsServiceImpl#LEGACY_ROLE_PREFIX}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.buildDetails(String, AdminUser)"})
  public void testBuildDetails_givenAdminRoleImplNameIsLegacy_role_prefix() {
    // Arrange
    doNothing()
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setAllPermissions(new HashSet<>());
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName(AdminUserDetailsServiceImpl.LEGACY_ROLE_PREFIX);

    LinkedHashSet<AdminRole> adminRoleSet = new LinkedHashSet<>();
    adminRoleSet.add(adminRoleImpl);

    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getAllRoles()).thenReturn(adminRoleSet);
    when(adminUser.getId()).thenReturn(1L);
    when(adminUser.getPassword()).thenReturn("iloveyou");
    when(adminUser.getAllPermissions()).thenReturn(new HashSet<>());

    // Act
    UserDetails actualBuildDetailsResult =
        adminUserDetailsServiceImpl.buildDetails("janedoe", adminUser);

    // Assert
    verify(adminUser).getAllPermissions();
    verify(adminUser).getAllRoles();
    verify(adminUser).getId();
    verify(adminUser).getPassword();
    verify(adminSecurityHelper, atLeast(1))
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    Collection<? extends GrantedAuthority> authorities = actualBuildDetailsResult.getAuthorities();
    assertEquals(9, authorities.size());
    assertTrue(authorities instanceof Set);
    assertTrue(actualBuildDetailsResult instanceof AdminUserDetails);
    assertEquals("iloveyou", actualBuildDetailsResult.getPassword());
    assertEquals("janedoe", actualBuildDetailsResult.getUsername());
    assertEquals(1L, ((AdminUserDetails) actualBuildDetailsResult).getId().longValue());
    assertTrue(actualBuildDetailsResult.isAccountNonExpired());
    assertTrue(actualBuildDetailsResult.isAccountNonLocked());
    assertTrue(actualBuildDetailsResult.isCredentialsNonExpired());
    assertTrue(actualBuildDetailsResult.isEnabled());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}.
   *
   * <ul>
   *   <li>Given {@link AdminRoleImpl} (default constructor) Name is {@code PERMISSION_42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.buildDetails(String, AdminUser)"})
  public void testBuildDetails_givenAdminRoleImplNameIsPermission42() {
    // Arrange
    doNothing()
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setAllPermissions(new HashSet<>());
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("PERMISSION_42");

    LinkedHashSet<AdminRole> adminRoleSet = new LinkedHashSet<>();
    adminRoleSet.add(adminRoleImpl);

    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getAllRoles()).thenReturn(adminRoleSet);
    when(adminUser.getId()).thenReturn(1L);
    when(adminUser.getPassword()).thenReturn("iloveyou");
    when(adminUser.getAllPermissions()).thenReturn(new HashSet<>());

    // Act
    UserDetails actualBuildDetailsResult =
        adminUserDetailsServiceImpl.buildDetails("janedoe", adminUser);

    // Assert
    verify(adminUser).getAllPermissions();
    verify(adminUser).getAllRoles();
    verify(adminUser).getId();
    verify(adminUser).getPassword();
    verify(adminSecurityHelper, atLeast(1))
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    Collection<? extends GrantedAuthority> authorities = actualBuildDetailsResult.getAuthorities();
    assertEquals(9, authorities.size());
    assertTrue(authorities instanceof Set);
    assertTrue(actualBuildDetailsResult instanceof AdminUserDetails);
    assertEquals("iloveyou", actualBuildDetailsResult.getPassword());
    assertEquals("janedoe", actualBuildDetailsResult.getUsername());
    assertEquals(1L, ((AdminUserDetails) actualBuildDetailsResult).getId().longValue());
    assertTrue(actualBuildDetailsResult.isAccountNonExpired());
    assertTrue(actualBuildDetailsResult.isAccountNonLocked());
    assertTrue(actualBuildDetailsResult.isCredentialsNonExpired());
    assertTrue(actualBuildDetailsResult.isEnabled());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}.
   *
   * <ul>
   *   <li>Given {@link AdminRoleImpl} (default constructor) Name is {@code PERMISSION_Name}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.buildDetails(String, AdminUser)"})
  public void testBuildDetails_givenAdminRoleImplNameIsPermissionName() {
    // Arrange
    doNothing()
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setAllPermissions(new HashSet<>());
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("PERMISSION_Name");

    LinkedHashSet<AdminRole> adminRoleSet = new LinkedHashSet<>();
    adminRoleSet.add(adminRoleImpl);

    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getAllRoles()).thenReturn(adminRoleSet);
    when(adminUser.getId()).thenReturn(1L);
    when(adminUser.getPassword()).thenReturn("iloveyou");
    when(adminUser.getAllPermissions()).thenReturn(new HashSet<>());

    // Act
    UserDetails actualBuildDetailsResult =
        adminUserDetailsServiceImpl.buildDetails("janedoe", adminUser);

    // Assert
    verify(adminUser).getAllPermissions();
    verify(adminUser).getAllRoles();
    verify(adminUser).getId();
    verify(adminUser).getPassword();
    verify(adminSecurityHelper, atLeast(1))
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    Collection<? extends GrantedAuthority> authorities = actualBuildDetailsResult.getAuthorities();
    assertEquals(9, authorities.size());
    assertTrue(authorities instanceof Set);
    assertTrue(actualBuildDetailsResult instanceof AdminUserDetails);
    assertEquals("iloveyou", actualBuildDetailsResult.getPassword());
    assertEquals("janedoe", actualBuildDetailsResult.getUsername());
    assertEquals(1L, ((AdminUserDetails) actualBuildDetailsResult).getId().longValue());
    assertTrue(actualBuildDetailsResult.isAccountNonExpired());
    assertTrue(actualBuildDetailsResult.isAccountNonLocked());
    assertTrue(actualBuildDetailsResult.isCredentialsNonExpired());
    assertTrue(actualBuildDetailsResult.isEnabled());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}.
   *
   * <ul>
   *   <li>Given {@link AdminRoleImpl} (default constructor) Name is {@code
   *       PERMISSION_org.broadleafcommerce}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.buildDetails(String, AdminUser)"})
  public void testBuildDetails_givenAdminRoleImplNameIsPermissionOrgBroadleafcommerce() {
    // Arrange
    doNothing()
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setAllPermissions(new HashSet<>());
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("PERMISSION_org.broadleafcommerce");

    LinkedHashSet<AdminRole> adminRoleSet = new LinkedHashSet<>();
    adminRoleSet.add(adminRoleImpl);

    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getAllRoles()).thenReturn(adminRoleSet);
    when(adminUser.getId()).thenReturn(1L);
    when(adminUser.getPassword()).thenReturn("iloveyou");
    when(adminUser.getAllPermissions()).thenReturn(new HashSet<>());

    // Act
    UserDetails actualBuildDetailsResult =
        adminUserDetailsServiceImpl.buildDetails("janedoe", adminUser);

    // Assert
    verify(adminUser).getAllPermissions();
    verify(adminUser).getAllRoles();
    verify(adminUser).getId();
    verify(adminUser).getPassword();
    verify(adminSecurityHelper, atLeast(1))
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    Collection<? extends GrantedAuthority> authorities = actualBuildDetailsResult.getAuthorities();
    assertEquals(9, authorities.size());
    assertTrue(authorities instanceof Set);
    assertTrue(actualBuildDetailsResult instanceof AdminUserDetails);
    assertEquals("iloveyou", actualBuildDetailsResult.getPassword());
    assertEquals("janedoe", actualBuildDetailsResult.getUsername());
    assertEquals(1L, ((AdminUserDetails) actualBuildDetailsResult).getId().longValue());
    assertTrue(actualBuildDetailsResult.isAccountNonExpired());
    assertTrue(actualBuildDetailsResult.isAccountNonLocked());
    assertTrue(actualBuildDetailsResult.isCredentialsNonExpired());
    assertTrue(actualBuildDetailsResult.isEnabled());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}.
   *
   * <ul>
   *   <li>Given {@link AdminRoleImpl} (default constructor) Name is {@code PERMISSION_PERMISSION_}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.buildDetails(String, AdminUser)"})
  public void testBuildDetails_givenAdminRoleImplNameIsPermissionPermission() {
    // Arrange
    doNothing()
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setAllPermissions(new HashSet<>());
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("PERMISSION_PERMISSION_");

    LinkedHashSet<AdminRole> adminRoleSet = new LinkedHashSet<>();
    adminRoleSet.add(adminRoleImpl);

    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getAllRoles()).thenReturn(adminRoleSet);
    when(adminUser.getId()).thenReturn(1L);
    when(adminUser.getPassword()).thenReturn("iloveyou");
    when(adminUser.getAllPermissions()).thenReturn(new HashSet<>());

    // Act
    UserDetails actualBuildDetailsResult =
        adminUserDetailsServiceImpl.buildDetails("janedoe", adminUser);

    // Assert
    verify(adminUser).getAllPermissions();
    verify(adminUser).getAllRoles();
    verify(adminUser).getId();
    verify(adminUser).getPassword();
    verify(adminSecurityHelper, atLeast(1))
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    Collection<? extends GrantedAuthority> authorities = actualBuildDetailsResult.getAuthorities();
    assertEquals(9, authorities.size());
    assertTrue(authorities instanceof Set);
    assertTrue(actualBuildDetailsResult instanceof AdminUserDetails);
    assertEquals("iloveyou", actualBuildDetailsResult.getPassword());
    assertEquals("janedoe", actualBuildDetailsResult.getUsername());
    assertEquals(1L, ((AdminUserDetails) actualBuildDetailsResult).getId().longValue());
    assertTrue(actualBuildDetailsResult.isAccountNonExpired());
    assertTrue(actualBuildDetailsResult.isAccountNonLocked());
    assertTrue(actualBuildDetailsResult.isCredentialsNonExpired());
    assertTrue(actualBuildDetailsResult.isEnabled());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}.
   *
   * <ul>
   *   <li>Given {@link AdminRoleImpl} (default constructor) Name is {@code PERMISSION_ROLE_}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.buildDetails(String, AdminUser)"})
  public void testBuildDetails_givenAdminRoleImplNameIsPermissionRole() {
    // Arrange
    doNothing()
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setAllPermissions(new HashSet<>());
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("PERMISSION_ROLE_");

    LinkedHashSet<AdminRole> adminRoleSet = new LinkedHashSet<>();
    adminRoleSet.add(adminRoleImpl);

    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getAllRoles()).thenReturn(adminRoleSet);
    when(adminUser.getId()).thenReturn(1L);
    when(adminUser.getPassword()).thenReturn("iloveyou");
    when(adminUser.getAllPermissions()).thenReturn(new HashSet<>());

    // Act
    UserDetails actualBuildDetailsResult =
        adminUserDetailsServiceImpl.buildDetails("janedoe", adminUser);

    // Assert
    verify(adminUser).getAllPermissions();
    verify(adminUser).getAllRoles();
    verify(adminUser).getId();
    verify(adminUser).getPassword();
    verify(adminSecurityHelper, atLeast(1))
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    Collection<? extends GrantedAuthority> authorities = actualBuildDetailsResult.getAuthorities();
    assertEquals(9, authorities.size());
    assertTrue(authorities instanceof Set);
    assertTrue(actualBuildDetailsResult instanceof AdminUserDetails);
    assertEquals("iloveyou", actualBuildDetailsResult.getPassword());
    assertEquals("janedoe", actualBuildDetailsResult.getUsername());
    assertEquals(1L, ((AdminUserDetails) actualBuildDetailsResult).getId().longValue());
    assertTrue(actualBuildDetailsResult.isAccountNonExpired());
    assertTrue(actualBuildDetailsResult.isAccountNonLocked());
    assertTrue(actualBuildDetailsResult.isCredentialsNonExpired());
    assertTrue(actualBuildDetailsResult.isEnabled());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When empty string.
   *   <li>Then throw {@link UsernameNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.buildDetails(String, AdminUser)"})
  public void testBuildDetails_givenTrue_whenEmptyString_thenThrowUsernameNotFoundException() {
    // Arrange
    doThrow(new UsernameNotFoundException(AdminUserDetailsServiceImpl.LEGACY_ROLE_PREFIX))
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setAllPermissions(new HashSet<>());
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("not blank");

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setAllPermissions(new HashSet<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    adminUser.setPassword("Admin User");

    // Act and Assert
    assertThrows(
        UsernameNotFoundException.class,
        () -> adminUserDetailsServiceImpl.buildDetails("", adminUser));
    verify(adminSecurityHelper)
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}.
   *
   * <ul>
   *   <li>Given {@link UsernameNotFoundException#UsernameNotFoundException(String)} with {@code
   *       Msg}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.buildDetails(String, AdminUser)"})
  public void testBuildDetails_givenUsernameNotFoundExceptionWithMsg() {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getAllRoles()).thenThrow(new UsernameNotFoundException("Msg"));

    // Act and Assert
    assertThrows(
        UsernameNotFoundException.class,
        () -> adminUserDetailsServiceImpl.buildDetails("janedoe", adminUser));
    verify(adminUser).getAllRoles();
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}.
   *
   * <ul>
   *   <li>Then return Authorities size is seven.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#buildDetails(String, AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserDetails AdminUserDetailsServiceImpl.buildDetails(String, AdminUser)"})
  public void testBuildDetails_thenReturnAuthoritiesSizeIsSeven() {
    // Arrange
    doNothing()
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setAllPermissions(new HashSet<>());
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("not blank");

    LinkedHashSet<AdminRole> adminRoleSet = new LinkedHashSet<>();
    adminRoleSet.add(adminRoleImpl);

    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getAllRoles()).thenReturn(adminRoleSet);
    when(adminUser.getId()).thenReturn(1L);
    when(adminUser.getPassword()).thenReturn("iloveyou");
    when(adminUser.getAllPermissions()).thenReturn(new HashSet<>());

    // Act
    UserDetails actualBuildDetailsResult =
        adminUserDetailsServiceImpl.buildDetails("janedoe", adminUser);

    // Assert
    verify(adminUser).getAllPermissions();
    verify(adminUser).getAllRoles();
    verify(adminUser).getId();
    verify(adminUser).getPassword();
    verify(adminSecurityHelper, atLeast(1))
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    Collection<? extends GrantedAuthority> authorities = actualBuildDetailsResult.getAuthorities();
    assertEquals(7, authorities.size());
    assertTrue(authorities instanceof Set);
    assertTrue(actualBuildDetailsResult instanceof AdminUserDetails);
    assertEquals("iloveyou", actualBuildDetailsResult.getPassword());
    assertEquals("janedoe", actualBuildDetailsResult.getUsername());
    assertEquals(1L, ((AdminUserDetails) actualBuildDetailsResult).getId().longValue());
    assertTrue(actualBuildDetailsResult.isAccountNonExpired());
    assertTrue(actualBuildDetailsResult.isAccountNonLocked());
    assertTrue(actualBuildDetailsResult.isCredentialsNonExpired());
    assertTrue(actualBuildDetailsResult.isEnabled());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#addRoles(AdminUser, List)}.
   *
   * <ul>
   *   <li>Given {@link SimpleGrantedAuthority#SimpleGrantedAuthority(String)} with {@code Role}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#addRoles(AdminUser, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserDetailsServiceImpl.addRoles(AdminUser, List)"})
  public void testAddRoles_givenSimpleGrantedAuthorityWithRole_thenArrayListSizeIsTwo() {
    // Arrange
    AdminUserImpl adminUser = new AdminUserImpl();

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    adminUserDetailsServiceImpl.addRoles(adminUser, authorities);

    // Assert that nothing has changed
    assertEquals(2, authorities.size());
    SimpleGrantedAuthority getResult = authorities.get(0);
    assertEquals("Role", getResult.getAuthority());
    assertEquals("Role", getResult.toString());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#addRoles(AdminUser, List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#addRoles(AdminUser, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserDetailsServiceImpl.addRoles(AdminUser, List)"})
  public void testAddRoles_thenArrayListSizeIsOne() {
    // Arrange
    doNothing()
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setAllPermissions(new HashSet<>());
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("not blank");

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setAllPermissions(new HashSet<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);
    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();

    // Act
    adminUserDetailsServiceImpl.addRoles(adminUser, authorities);

    // Assert
    verify(adminSecurityHelper)
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    assertEquals(1, authorities.size());
    SimpleGrantedAuthority getResult = authorities.get(0);
    assertEquals("not blank", getResult.getAuthority());
    assertEquals("not blank", getResult.toString());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#addRoles(AdminUser, List)}.
   *
   * <ul>
   *   <li>Then throw {@link UsernameNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#addRoles(AdminUser, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserDetailsServiceImpl.addRoles(AdminUser, List)"})
  public void testAddRoles_thenThrowUsernameNotFoundException() {
    // Arrange
    doThrow(new UsernameNotFoundException("Msg"))
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setAllPermissions(new HashSet<>());
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("not blank");

    LinkedHashSet<AdminRole> allRoles = new LinkedHashSet<>();
    allRoles.add(adminRoleImpl);

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setAllPermissions(new HashSet<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPassword("iloveyou");
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setAllRoles(allRoles);

    // Act and Assert
    assertThrows(
        UsernameNotFoundException.class,
        () -> adminUserDetailsServiceImpl.addRoles(adminUser, new ArrayList<>()));
    verify(adminSecurityHelper)
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#addRoles(AdminUser, List)}.
   *
   * <ul>
   *   <li>When {@link AdminUserImpl} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#addRoles(AdminUser, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserDetailsServiceImpl.addRoles(AdminUser, List)"})
  public void testAddRoles_whenAdminUserImpl_thenArrayListEmpty() {
    // Arrange
    AdminUserImpl adminUser = new AdminUserImpl();
    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();

    // Act
    adminUserDetailsServiceImpl.addRoles(adminUser, authorities);

    // Assert that nothing has changed
    assertTrue(authorities.isEmpty());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#addPermissions(AdminUser, List)}.
   *
   * <ul>
   *   <li>Given {@link SimpleGrantedAuthority#SimpleGrantedAuthority(String)} with {@code Role}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#addPermissions(AdminUser, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserDetailsServiceImpl.addPermissions(AdminUser, List)"})
  public void testAddPermissions_givenSimpleGrantedAuthorityWithRole() {
    // Arrange
    doThrow(new UsernameNotFoundException("Msg"))
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());
    AdminUserImpl adminUser = new AdminUserImpl();

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act and Assert
    assertThrows(
        UsernameNotFoundException.class,
        () -> adminUserDetailsServiceImpl.addPermissions(adminUser, authorities));
    verify(adminSecurityHelper)
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#addPermissions(AdminUser, List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#addPermissions(AdminUser, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserDetailsServiceImpl.addPermissions(AdminUser, List)"})
  public void testAddPermissions_thenArrayListSizeIsTwo() {
    // Arrange
    doNothing()
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());
    AdminUserImpl adminUser = new AdminUserImpl();
    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();

    // Act
    adminUserDetailsServiceImpl.addPermissions(adminUser, authorities);

    // Assert
    verify(adminSecurityHelper)
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
    assertEquals(2, authorities.size());
    SimpleGrantedAuthority getResult = authorities.get(1);
    assertEquals("PERMISSION_ALL_USER_SANDBOX", getResult.getAuthority());
    assertEquals("PERMISSION_ALL_USER_SANDBOX", getResult.toString());
    SimpleGrantedAuthority getResult2 = authorities.get(0);
    assertEquals("PERMISSION_OTHER_DEFAULT", getResult2.getAuthority());
    assertEquals("PERMISSION_OTHER_DEFAULT", getResult2.toString());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#addPermissions(AdminUser, List)}.
   *
   * <ul>
   *   <li>Then throw {@link UsernameNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#addPermissions(AdminUser, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserDetailsServiceImpl.addPermissions(AdminUser, List)"})
  public void testAddPermissions_thenThrowUsernameNotFoundException() {
    // Arrange
    doThrow(new UsernameNotFoundException("Msg"))
        .when(adminSecurityHelper)
        .addAllPermissionsToAuthorities(
            Mockito.<List<SimpleGrantedAuthority>>any(),
            Mockito.<Collection<AdminPermission>>any());
    AdminUserImpl adminUser = new AdminUserImpl();

    // Act and Assert
    assertThrows(
        UsernameNotFoundException.class,
        () -> adminUserDetailsServiceImpl.addPermissions(adminUser, new ArrayList<>()));
    verify(adminSecurityHelper)
        .addAllPermissionsToAuthorities(isA(List.class), isA(Collection.class));
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}.
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserDetailsServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole() {
    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("PERMISSION_PERMISSION_"));

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert
    assertEquals(3, authorities.size());
    SimpleGrantedAuthority getResult = authorities.get(1);
    assertEquals("ROLE_PERMISSION_PERMISSION_", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_PERMISSION_", getResult.toString());
    SimpleGrantedAuthority getResult2 = authorities.get(2);
    assertEquals("ROLE_ROLE_", getResult2.getAuthority());
    assertEquals("ROLE_ROLE_", getResult2.toString());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}.
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserDetailsServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole2() {
    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("PERMISSION_Role"));

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert
    assertEquals(3, authorities.size());
    SimpleGrantedAuthority getResult = authorities.get(1);
    assertEquals("ROLE_PERMISSION_Role", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_Role", getResult.toString());
    SimpleGrantedAuthority getResult2 = authorities.get(2);
    assertEquals("ROLE_Role", getResult2.getAuthority());
    assertEquals("ROLE_Role", getResult2.toString());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}.
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserDetailsServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole3() {
    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("PERMISSION_ROLE_"));
    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("Role");
    authorities.add(simpleGrantedAuthority);

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert
    assertEquals(4, authorities.size());
    SimpleGrantedAuthority getResult = authorities.get(1);
    assertEquals("ROLE_PERMISSION_ROLE_", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_ROLE_", getResult.toString());
    assertSame(simpleGrantedAuthority, authorities.get(3));
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}.
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserDetailsServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole4() {
    // Arrange
    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("PERMISSION_PERMISSION_PERMISSION_"));

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert
    assertEquals(3, authorities.size());
    SimpleGrantedAuthority getResult = authorities.get(1);
    assertEquals("ROLE_PERMISSION_PERMISSION_PERMISSION_", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_PERMISSION_PERMISSION_", getResult.toString());
    SimpleGrantedAuthority getResult2 = authorities.get(2);
    assertEquals("ROLE_ROLE_ROLE_", getResult2.getAuthority());
    assertEquals("ROLE_ROLE_ROLE_", getResult2.toString());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} second Authority is {@code ROLE_PERMISSION_}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserDetailsServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole_thenArrayListSecondAuthorityIsRolePermission() {
    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(AdminUserDetailsServiceImpl.LEGACY_ROLE_PREFIX));
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert
    assertEquals(4, authorities.size());
    SimpleGrantedAuthority getResult = authorities.get(1);
    assertEquals("ROLE_PERMISSION_", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_", getResult.toString());
    SimpleGrantedAuthority getResult2 = authorities.get(2);
    assertEquals(
        AdminUserDetailsServiceImpl.DEFAULT_SPRING_SECURITY_ROLE_PREFIX, getResult2.getAuthority());
    assertEquals(
        AdminUserDetailsServiceImpl.DEFAULT_SPRING_SECURITY_ROLE_PREFIX, getResult2.toString());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserDetailsServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole_thenArrayListSizeIsOne() {
    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert that nothing has changed
    assertEquals(1, authorities.size());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserDetailsServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole_thenArrayListSizeIsTwo() {
    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(
        new SimpleGrantedAuthority(
            AdminUserDetailsServiceImpl.DEFAULT_SPRING_SECURITY_ROLE_PREFIX));
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert that nothing has changed
    assertEquals(2, authorities.size());
    SimpleGrantedAuthority getResult = authorities.get(1);
    assertEquals("Role", getResult.getAuthority());
    assertEquals("Role", getResult.toString());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} third Authority is {@code ROLE_42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserDetailsServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole_thenArrayListThirdAuthorityIsRole42() {
    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("PERMISSION_42"));

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert
    assertEquals(3, authorities.size());
    SimpleGrantedAuthority getResult = authorities.get(2);
    assertEquals("ROLE_42", getResult.getAuthority());
    assertEquals("ROLE_42", getResult.toString());
    SimpleGrantedAuthority getResult2 = authorities.get(1);
    assertEquals("ROLE_PERMISSION_42", getResult2.getAuthority());
    assertEquals("ROLE_PERMISSION_42", getResult2.toString());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserDetailsServiceImpl.convertPermissionPrefixToRole(List)"})
  public void testConvertPermissionPrefixToRole_whenArrayList_thenArrayListEmpty() {
    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();
    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert that nothing has changed
    assertTrue(authorities.isEmpty());
  }

  /**
   * Test {@link AdminUserDetailsServiceImpl#createDetails(String, AdminUser, List)}.
   *
   * <ul>
   *   <li>Then return Authorities size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserDetailsServiceImpl#createDetails(String, AdminUser,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserDetails AdminUserDetailsServiceImpl.createDetails(String, AdminUser, List)"
  })
  public void testCreateDetails_thenReturnAuthoritiesSizeIsOne() {
    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setAllPermissions(new HashSet<>());
    adminUser.setAllRoles(new HashSet<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setPassword("Admin User");

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    UserDetails actualCreateDetailsResult =
        adminUserDetailsServiceImpl.createDetails("  ", adminUser, authorities);

    // Assert
    Collection<? extends GrantedAuthority> authorities2 =
        actualCreateDetailsResult.getAuthorities();
    assertEquals(1, authorities2.size());
    assertTrue(authorities2 instanceof Set);
    assertTrue(actualCreateDetailsResult instanceof AdminUserDetails);
    assertEquals("  ", actualCreateDetailsResult.getUsername());
    assertEquals("Admin User", actualCreateDetailsResult.getPassword());
    assertEquals(1L, ((AdminUserDetails) actualCreateDetailsResult).getId().longValue());
    assertTrue(actualCreateDetailsResult.isAccountNonExpired());
    assertTrue(actualCreateDetailsResult.isAccountNonLocked());
    assertTrue(actualCreateDetailsResult.isCredentialsNonExpired());
    assertTrue(actualCreateDetailsResult.isEnabled());
  }
}
