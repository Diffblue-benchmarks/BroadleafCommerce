package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class AdminPermissionImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminPermissionImpl#setAllRoles(Set)}
   *   <li>{@link AdminPermissionImpl#setAllUsers(Set)}
   *   <li>{@link AdminPermissionImpl#setDescription(String)}
   *   <li>{@link AdminPermissionImpl#setId(Long)}
   *   <li>{@link AdminPermissionImpl#setName(String)}
   *   <li>{@link AdminPermissionImpl#setQualifiedEntities(List)}
   *   <li>{@link AdminPermissionImpl#getAllParentPermissions()}
   *   <li>{@link AdminPermissionImpl#getAllRoles()}
   *   <li>{@link AdminPermissionImpl#getAllUsers()}
   *   <li>{@link AdminPermissionImpl#getDescription()}
   *   <li>{@link AdminPermissionImpl#getId()}
   *   <li>{@link AdminPermissionImpl#getName()}
   *   <li>{@link AdminPermissionImpl#getQualifiedEntities()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AdminPermissionImpl adminPermissionImpl = new AdminPermissionImpl();
    HashSet<AdminRole> allRoles = new HashSet<>();

    // Act
    adminPermissionImpl.setAllRoles(allRoles);
    HashSet<AdminUser> allUsers = new HashSet<>();
    adminPermissionImpl.setAllUsers(allUsers);
    adminPermissionImpl.setDescription("The characteristics of someone or something");
    adminPermissionImpl.setId(1L);
    adminPermissionImpl.setName("Name");
    ArrayList<AdminPermissionQualifiedEntity> qualifiedEntities = new ArrayList<>();
    adminPermissionImpl.setQualifiedEntities(qualifiedEntities);
    List<AdminPermission> actualAllParentPermissions = adminPermissionImpl.getAllParentPermissions();
    Set<AdminRole> actualAllRoles = adminPermissionImpl.getAllRoles();
    Set<AdminUser> actualAllUsers = adminPermissionImpl.getAllUsers();
    String actualDescription = adminPermissionImpl.getDescription();
    Long actualId = adminPermissionImpl.getId();
    String actualName = adminPermissionImpl.getName();
    List<AdminPermissionQualifiedEntity> actualQualifiedEntities = adminPermissionImpl.getQualifiedEntities();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAllParentPermissions.isEmpty());
    assertTrue(actualQualifiedEntities.isEmpty());
    assertTrue(actualAllRoles.isEmpty());
    assertTrue(actualAllUsers.isEmpty());
    assertSame(qualifiedEntities, actualQualifiedEntities);
    assertSame(allRoles, actualAllRoles);
    assertSame(allUsers, actualAllUsers);
  }
}
