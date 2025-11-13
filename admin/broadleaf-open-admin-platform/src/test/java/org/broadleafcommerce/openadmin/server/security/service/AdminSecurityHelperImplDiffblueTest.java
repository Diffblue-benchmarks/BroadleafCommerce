package org.broadleafcommerce.openadmin.server.security.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import org.broadleafcommerce.openadmin.server.security.domain.AdminPermission;
import org.broadleafcommerce.openadmin.server.security.domain.AdminPermissionImpl;
import org.broadleafcommerce.openadmin.server.security.service.type.PermissionType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AdminSecurityHelperImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminSecurityHelperImplDiffblueTest {
  @Autowired private AdminSecurityHelperImpl adminSecurityHelperImpl;

  /**
   * Test {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityHelperImpl.addAllPermissionsToAuthorities(List, Collection)"
  })
  public void testAddAllPermissionsToAuthorities_thenArrayListSizeIsOne() {
    // Arrange
    ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();

    AdminPermissionImpl adminPermissionImpl = new AdminPermissionImpl();
    adminPermissionImpl.setAllRoles(new HashSet<>());
    adminPermissionImpl.setAllUsers(new HashSet<>());
    adminPermissionImpl.setDescription("The characteristics of someone or something");
    adminPermissionImpl.setId(1L);
    adminPermissionImpl.setQualifiedEntities(new ArrayList<>());
    adminPermissionImpl.setType(PermissionType.ALL);
    adminPermissionImpl.setName("not blank");

    LinkedHashSet<AdminPermission> adminPermissions = new LinkedHashSet<>();
    adminPermissions.add(adminPermissionImpl);

    // Act
    adminSecurityHelperImpl.addAllPermissionsToAuthorities(grantedAuthorities, adminPermissions);

    // Assert
    assertEquals(1, grantedAuthorities.size());
    SimpleGrantedAuthority getResult = grantedAuthorities.get(0);
    assertEquals("not blank", getResult.getAuthority());
    assertEquals("not blank", getResult.toString());
  }

  /**
   * Test {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityHelperImpl.addAllPermissionsToAuthorities(List, Collection)"
  })
  public void testAddAllPermissionsToAuthorities_thenArrayListSizeIsTwo() {
    // Arrange
    ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
    grantedAuthorities.add(new SimpleGrantedAuthority("Role"));
    grantedAuthorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    adminSecurityHelperImpl.addAllPermissionsToAuthorities(grantedAuthorities, new ArrayList<>());

    // Assert that nothing has changed
    assertEquals(2, grantedAuthorities.size());
    SimpleGrantedAuthority getResult = grantedAuthorities.get(0);
    assertEquals("Role", getResult.getAuthority());
    assertEquals("Role", getResult.toString());
  }

  /**
   * Test {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityHelperImpl.addAllPermissionsToAuthorities(List, Collection)"
  })
  public void testAddAllPermissionsToAuthorities_whenArrayList_thenArrayListEmpty() {
    // Arrange
    ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();

    // Act
    adminSecurityHelperImpl.addAllPermissionsToAuthorities(grantedAuthorities, new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(grantedAuthorities.isEmpty());
  }
}
