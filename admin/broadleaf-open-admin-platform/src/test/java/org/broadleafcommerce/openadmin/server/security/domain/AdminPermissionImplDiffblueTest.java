package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.broadleafcommerce.openadmin.server.security.service.type.PermissionType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-open-admin-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminPermissionImplDiffblueTest {
  @Autowired private AdminPermissionImpl adminPermissionImpl;

  /**
   * Test {@link AdminPermissionImpl#getType()}.
   *
   * <p>Method under test: {@link AdminPermissionImpl#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionType AdminPermissionImpl.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull(adminPermissionImpl.getType());
  }

  /**
   * Test {@link AdminPermissionImpl#setType(PermissionType)}.
   *
   * <ul>
   *   <li>When {@link PermissionType#ALL}.
   *   <li>Then {@link AdminPermissionImpl} {@link AdminPermissionImpl#type} is {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionImpl#setType(PermissionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminPermissionImpl.setType(PermissionType)"})
  public void testSetType_whenAll_thenAdminPermissionImplTypeIsAll() {
    // Arrange and Act
    adminPermissionImpl.setType(PermissionType.ALL);

    // Assert
    assertEquals("ALL", adminPermissionImpl.type);
    assertSame(PermissionType.ALL, adminPermissionImpl.getType());
  }

  /**
   * Test {@link AdminPermissionImpl#setType(PermissionType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link AdminPermissionImpl} {@link AdminPermissionImpl#type} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionImpl#setType(PermissionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminPermissionImpl.setType(PermissionType)"})
  public void testSetType_whenNull_thenAdminPermissionImplTypeIsNull() {
    // Arrange and Act
    adminPermissionImpl.setType(null);

    // Assert that nothing has changed
    assertNull(adminPermissionImpl.type);
    assertNull(adminPermissionImpl.getType());
  }

  /**
   * Test {@link AdminPermissionImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link AdminPermissionImpl} (default constructor) AllRoles is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminPermission AdminPermissionImpl.clone()"})
  public void testClone_givenAdminPermissionImplAllRolesIsHashSet() {
    // Arrange
    ArrayList<AdminPermissionQualifiedEntity> qualifiedEntities = new ArrayList<>();
    qualifiedEntities.add(new AdminPermissionQualifiedEntityImpl());

    AdminPermissionImpl adminPermissionImpl = new AdminPermissionImpl();
    adminPermissionImpl.setAllRoles(new HashSet<>());
    adminPermissionImpl.setAllUsers(new HashSet<>());
    adminPermissionImpl.setDescription("The characteristics of someone or something");
    adminPermissionImpl.setId(1L);
    adminPermissionImpl.setName("Name");
    adminPermissionImpl.setType(PermissionType.ALL);
    adminPermissionImpl.setQualifiedEntities(qualifiedEntities);

    // Act
    AdminPermission actualCloneResult = adminPermissionImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminPermissionImpl);
    List<AdminPermissionQualifiedEntity> qualifiedEntities2 =
        actualCloneResult.getQualifiedEntities();
    assertEquals(1, qualifiedEntities2.size());
    AdminPermissionQualifiedEntity getResult = qualifiedEntities2.get(0);
    assertTrue(getResult instanceof AdminPermissionQualifiedEntityImpl);
    assertNull(getResult.getId());
    assertNull(getResult.getCeilingEntityFullyQualifiedName());
    assertSame(actualCloneResult, getResult.getAdminPermission());
  }

  /**
   * Test {@link AdminPermissionImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link AdminPermissionImpl} QualifiedEntities is {@code null}.
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminPermission AdminPermissionImpl.clone()"})
  public void testClone_givenAdminPermissionImplQualifiedEntitiesIsNull_thenReturnIdIsNull() {
    // Arrange
    adminPermissionImpl.setQualifiedEntities(null);

    // Act
    AdminPermission actualCloneResult = adminPermissionImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminPermissionImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getDescription());
    assertNull(actualCloneResult.getName());
    assertNull(((AdminPermissionImpl) actualCloneResult).type);
    assertNull(actualCloneResult.getType());
    assertFalse(((AdminPermissionImpl) actualCloneResult).isFriendly);
    assertTrue(actualCloneResult.getAllChildPermissions().isEmpty());
    assertTrue(actualCloneResult.getAllParentPermissions().isEmpty());
    assertTrue(actualCloneResult.getQualifiedEntities().isEmpty());
    assertTrue(((AdminPermissionImpl) actualCloneResult).allChildPermissions.isEmpty());
    assertTrue(actualCloneResult.getAllRoles().isEmpty());
    assertTrue(actualCloneResult.getAllUsers().isEmpty());
  }

  /**
   * Test {@link AdminPermissionImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link AdminPermissionImpl}.
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminPermission AdminPermissionImpl.clone()"})
  public void testClone_givenAdminPermissionImpl_thenReturnIdIsNull() {
    // Arrange and Act
    AdminPermission actualCloneResult = adminPermissionImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminPermissionImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getDescription());
    assertNull(actualCloneResult.getName());
    assertNull(((AdminPermissionImpl) actualCloneResult).type);
    assertNull(actualCloneResult.getType());
    assertFalse(((AdminPermissionImpl) actualCloneResult).isFriendly);
    assertTrue(actualCloneResult.getAllChildPermissions().isEmpty());
    assertTrue(actualCloneResult.getAllParentPermissions().isEmpty());
    assertTrue(actualCloneResult.getQualifiedEntities().isEmpty());
    assertTrue(((AdminPermissionImpl) actualCloneResult).allChildPermissions.isEmpty());
    assertTrue(actualCloneResult.getAllRoles().isEmpty());
    assertTrue(actualCloneResult.getAllUsers().isEmpty());
  }

  /**
   * Test {@link AdminPermissionImpl#clone()}.
   *
   * <ul>
   *   <li>Then return QualifiedEntities size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminPermissionImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminPermission AdminPermissionImpl.clone()"})
  public void testClone_thenReturnQualifiedEntitiesSizeIsOne() {
    // Arrange
    ArrayList<AdminPermissionQualifiedEntity> qualifiedEntities = new ArrayList<>();
    qualifiedEntities.add(new AdminPermissionQualifiedEntityImpl());
    adminPermissionImpl.setQualifiedEntities(qualifiedEntities);

    // Act
    AdminPermission actualCloneResult = adminPermissionImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminPermissionImpl);
    List<AdminPermissionQualifiedEntity> qualifiedEntities2 =
        actualCloneResult.getQualifiedEntities();
    assertEquals(1, qualifiedEntities2.size());
    AdminPermissionQualifiedEntity getResult = qualifiedEntities2.get(0);
    assertTrue(getResult instanceof AdminPermissionQualifiedEntityImpl);
    assertNull(getResult.getId());
    assertNull(getResult.getCeilingEntityFullyQualifiedName());
    assertSame(actualCloneResult, getResult.getAdminPermission());
  }

  /**
   * Test {@link AdminPermissionImpl#getAllChildPermissions()}.
   *
   * <p>Method under test: {@link AdminPermissionImpl#getAllChildPermissions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdminPermissionImpl.getAllChildPermissions()"})
  public void testGetAllChildPermissions() {
    // Arrange, Act and Assert
    assertTrue(adminPermissionImpl.getAllChildPermissions().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminPermissionImpl.getAllParentPermissions()",
    "Set AdminPermissionImpl.getAllRoles()",
    "Set AdminPermissionImpl.getAllUsers()",
    "String AdminPermissionImpl.getDescription()",
    "Long AdminPermissionImpl.getId()",
    "String AdminPermissionImpl.getName()",
    "List AdminPermissionImpl.getQualifiedEntities()",
    "void AdminPermissionImpl.setAllRoles(Set)",
    "void AdminPermissionImpl.setAllUsers(Set)",
    "void AdminPermissionImpl.setDescription(String)",
    "void AdminPermissionImpl.setId(Long)",
    "void AdminPermissionImpl.setName(String)",
    "void AdminPermissionImpl.setQualifiedEntities(List)"
  })
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
    List<AdminPermission> actualAllParentPermissions =
        adminPermissionImpl.getAllParentPermissions();
    Set<AdminRole> actualAllRoles = adminPermissionImpl.getAllRoles();
    Set<AdminUser> actualAllUsers = adminPermissionImpl.getAllUsers();
    String actualDescription = adminPermissionImpl.getDescription();
    Long actualId = adminPermissionImpl.getId();
    String actualName = adminPermissionImpl.getName();
    List<AdminPermissionQualifiedEntity> actualQualifiedEntities =
        adminPermissionImpl.getQualifiedEntities();

    // Assert
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

  /**
   * Test {@link AdminPermissionImpl#isFriendly()}.
   *
   * <p>Method under test: {@link AdminPermissionImpl#isFriendly()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AdminPermissionImpl.isFriendly()"})
  public void testIsFriendly() {
    // Arrange, Act and Assert
    assertFalse(adminPermissionImpl.isFriendly());
  }

  /**
   * Test new {@link AdminPermissionImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link AdminPermissionImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminPermissionImpl.<init>()"})
  public void testNewAdminPermissionImpl() {
    // Arrange and Act
    AdminPermissionImpl actualAdminPermissionImpl = new AdminPermissionImpl();

    // Assert
    assertNull(actualAdminPermissionImpl.getId());
    assertNull(actualAdminPermissionImpl.getDescription());
    assertNull(actualAdminPermissionImpl.getName());
    assertNull(actualAdminPermissionImpl.type);
    assertNull(actualAdminPermissionImpl.getType());
    assertFalse(actualAdminPermissionImpl.isFriendly);
    assertTrue(actualAdminPermissionImpl.getAllChildPermissions().isEmpty());
    assertTrue(actualAdminPermissionImpl.getAllParentPermissions().isEmpty());
    assertTrue(actualAdminPermissionImpl.getQualifiedEntities().isEmpty());
    assertTrue(actualAdminPermissionImpl.allChildPermissions.isEmpty());
    assertTrue(actualAdminPermissionImpl.getAllRoles().isEmpty());
    assertTrue(actualAdminPermissionImpl.getAllUsers().isEmpty());
  }
}
