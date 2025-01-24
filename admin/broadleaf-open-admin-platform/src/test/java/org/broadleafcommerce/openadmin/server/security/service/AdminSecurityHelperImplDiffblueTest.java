package org.broadleafcommerce.openadmin.server.security.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.broadleafcommerce.openadmin.server.security.domain.AdminPermission;
import org.broadleafcommerce.openadmin.server.security.domain.AdminPermissionImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminPermissionQualifiedEntity;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRole;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.service.type.PermissionType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminSecurityHelperImplDiffblueTest {
  @Autowired
  private AdminSecurityHelperImpl adminSecurityHelperImpl;

  /**
   * Test
   * {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}.
   * <p>
   * Method under test:
   * {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddAllPermissionsToAuthorities() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.security.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1243 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.security.service.AdminSecurityHelperImpl adminSecurityHelperImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminSecurityHelperImpl adminSecurityHelperImpl2 = new AdminSecurityHelperImpl();
    ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();

    // Act
    adminSecurityHelperImpl2.addAllPermissionsToAuthorities(grantedAuthorities, new ArrayList<>());
  }

  /**
   * Test
   * {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Authority is
   * {@code Admin Permissions}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}
   */
  @Test
  public void testAddAllPermissionsToAuthorities_thenArrayListFirstAuthorityIsAdminPermissions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityHelperImpl adminSecurityHelperImpl = new AdminSecurityHelperImpl();
    ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();

    AdminPermissionImpl adminPermissionImpl = new AdminPermissionImpl();
    adminPermissionImpl.setAllRoles(new HashSet<>());
    adminPermissionImpl.setAllUsers(new HashSet<>());
    adminPermissionImpl.setDescription("The characteristics of someone or something");
    adminPermissionImpl.setId(1L);
    adminPermissionImpl.setQualifiedEntities(new ArrayList<>());
    adminPermissionImpl.setType(PermissionType.ALL);
    adminPermissionImpl.setName("Admin Permissions");

    LinkedHashSet<AdminPermission> adminPermissions = new LinkedHashSet<>();
    adminPermissions.add(adminPermissionImpl);

    // Act
    adminSecurityHelperImpl.addAllPermissionsToAuthorities(grantedAuthorities, adminPermissions);

    // Assert
    assertEquals(1, grantedAuthorities.size());
    SimpleGrantedAuthority getResult = grantedAuthorities.get(0);
    assertEquals("Admin Permissions", getResult.getAuthority());
    assertEquals("Admin Permissions", getResult.toString());
  }

  /**
   * Test
   * {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}
   */
  @Test
  public void testAddAllPermissionsToAuthorities_thenArrayListSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityHelperImpl adminSecurityHelperImpl = new AdminSecurityHelperImpl();
    ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
    AdminPermissionImpl adminPermissionImpl = mock(AdminPermissionImpl.class);
    when(adminPermissionImpl.getAllChildPermissions()).thenReturn(new ArrayList<>());
    when(adminPermissionImpl.isFriendly()).thenReturn(true);
    when(adminPermissionImpl.getName()).thenReturn("Name");
    doNothing().when(adminPermissionImpl).setAllRoles(Mockito.<Set<AdminRole>>any());
    doNothing().when(adminPermissionImpl).setAllUsers(Mockito.<Set<AdminUser>>any());
    doNothing().when(adminPermissionImpl).setDescription(Mockito.<String>any());
    doNothing().when(adminPermissionImpl).setId(Mockito.<Long>any());
    doNothing().when(adminPermissionImpl).setName(Mockito.<String>any());
    doNothing().when(adminPermissionImpl).setQualifiedEntities(Mockito.<List<AdminPermissionQualifiedEntity>>any());
    doNothing().when(adminPermissionImpl).setType(Mockito.<PermissionType>any());
    adminPermissionImpl.setAllRoles(new HashSet<>());
    adminPermissionImpl.setAllUsers(new HashSet<>());
    adminPermissionImpl.setDescription("The characteristics of someone or something");
    adminPermissionImpl.setId(1L);
    adminPermissionImpl.setQualifiedEntities(new ArrayList<>());
    adminPermissionImpl.setType(PermissionType.ALL);
    adminPermissionImpl.setName(null);

    LinkedHashSet<AdminPermission> adminPermissions = new LinkedHashSet<>();
    adminPermissions.add(adminPermissionImpl);

    // Act
    adminSecurityHelperImpl.addAllPermissionsToAuthorities(grantedAuthorities, adminPermissions);

    // Assert
    verify(adminPermissionImpl).getAllChildPermissions();
    verify(adminPermissionImpl).getName();
    verify(adminPermissionImpl).isFriendly();
    verify(adminPermissionImpl).setAllRoles(isA(Set.class));
    verify(adminPermissionImpl).setAllUsers(isA(Set.class));
    verify(adminPermissionImpl).setDescription(eq("The characteristics of someone or something"));
    verify(adminPermissionImpl).setId(eq(1L));
    verify(adminPermissionImpl).setName(isNull());
    verify(adminPermissionImpl).setQualifiedEntities(isA(List.class));
    verify(adminPermissionImpl).setType(isA(PermissionType.class));
    assertEquals(1, grantedAuthorities.size());
    SimpleGrantedAuthority getResult = grantedAuthorities.get(0);
    assertEquals("Name", getResult.getAuthority());
    assertEquals("Name", getResult.toString());
  }

  /**
   * Test
   * {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}
   */
  @Test
  public void testAddAllPermissionsToAuthorities_thenArrayListSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityHelperImpl adminSecurityHelperImpl = new AdminSecurityHelperImpl();
    ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
    AdminPermissionImpl adminPermissionImpl = mock(AdminPermissionImpl.class);
    when(adminPermissionImpl.getName()).thenReturn("Name");

    ArrayList<AdminPermission> adminPermissionList = new ArrayList<>();
    adminPermissionList.add(adminPermissionImpl);
    AdminPermissionImpl adminPermissionImpl2 = mock(AdminPermissionImpl.class);
    when(adminPermissionImpl2.getAllChildPermissions()).thenReturn(adminPermissionList);
    when(adminPermissionImpl2.isFriendly()).thenReturn(true);
    when(adminPermissionImpl2.getName()).thenReturn("Name");
    doNothing().when(adminPermissionImpl2).setAllRoles(Mockito.<Set<AdminRole>>any());
    doNothing().when(adminPermissionImpl2).setAllUsers(Mockito.<Set<AdminUser>>any());
    doNothing().when(adminPermissionImpl2).setDescription(Mockito.<String>any());
    doNothing().when(adminPermissionImpl2).setId(Mockito.<Long>any());
    doNothing().when(adminPermissionImpl2).setName(Mockito.<String>any());
    doNothing().when(adminPermissionImpl2).setQualifiedEntities(Mockito.<List<AdminPermissionQualifiedEntity>>any());
    doNothing().when(adminPermissionImpl2).setType(Mockito.<PermissionType>any());
    adminPermissionImpl2.setAllRoles(new HashSet<>());
    adminPermissionImpl2.setAllUsers(new HashSet<>());
    adminPermissionImpl2.setDescription("The characteristics of someone or something");
    adminPermissionImpl2.setId(1L);
    adminPermissionImpl2.setQualifiedEntities(new ArrayList<>());
    adminPermissionImpl2.setType(PermissionType.ALL);
    adminPermissionImpl2.setName(null);

    LinkedHashSet<AdminPermission> adminPermissions = new LinkedHashSet<>();
    adminPermissions.add(adminPermissionImpl2);

    // Act
    adminSecurityHelperImpl.addAllPermissionsToAuthorities(grantedAuthorities, adminPermissions);

    // Assert
    verify(adminPermissionImpl2).getAllChildPermissions();
    verify(adminPermissionImpl2).getName();
    verify(adminPermissionImpl).getName();
    verify(adminPermissionImpl2).isFriendly();
    verify(adminPermissionImpl2).setAllRoles(isA(Set.class));
    verify(adminPermissionImpl2).setAllUsers(isA(Set.class));
    verify(adminPermissionImpl2).setDescription(eq("The characteristics of someone or something"));
    verify(adminPermissionImpl2).setId(eq(1L));
    verify(adminPermissionImpl2).setName(isNull());
    verify(adminPermissionImpl2).setQualifiedEntities(isA(List.class));
    verify(adminPermissionImpl2).setType(isA(PermissionType.class));
    assertEquals(2, grantedAuthorities.size());
    SimpleGrantedAuthority getResult = grantedAuthorities.get(0);
    assertEquals("Name", getResult.getAuthority());
    assertEquals("Name", getResult.toString());
    assertEquals(getResult, grantedAuthorities.get(1));
  }

  /**
   * Test
   * {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}
   */
  @Test
  public void testAddAllPermissionsToAuthorities_whenArrayList_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSecurityHelperImpl adminSecurityHelperImpl = new AdminSecurityHelperImpl();
    ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();

    // Act
    adminSecurityHelperImpl.addAllPermissionsToAuthorities(grantedAuthorities, new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(grantedAuthorities.isEmpty());
  }
}
