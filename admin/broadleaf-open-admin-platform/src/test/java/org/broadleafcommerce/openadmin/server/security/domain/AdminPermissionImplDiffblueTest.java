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
package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AdminPermissionImplDiffblueTest {
  @Autowired
  private AdminPermissionImpl adminPermissionImpl;

  /**
   * Test {@link AdminPermissionImpl#getType()}.
   * <p>
   * Method under test: {@link AdminPermissionImpl#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PermissionType AdminPermissionImpl.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull((new AdminPermissionImpl()).getType());
  }

  /**
   * Test {@link AdminPermissionImpl#setType(PermissionType)}.
   * <ul>
   *   <li>Given {@link AdminPermissionImpl} (default constructor).</li>
   *   <li>When {@link PermissionType#ALL}.</li>
   *   <li>Then {@link AdminPermissionImpl} (default constructor) Type is {@link PermissionType#ALL} {@link PermissionType#ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPermissionImpl#setType(PermissionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminPermissionImpl.setType(PermissionType)"})
  public void testSetType_givenAdminPermissionImpl_whenAll_thenAdminPermissionImplTypeIsAllAll() {
    // Arrange
    AdminPermissionImpl adminPermissionImpl2 = new AdminPermissionImpl();
    PermissionType type = PermissionType.ALL;

    // Act
    adminPermissionImpl2.setType(type);

    // Assert
    assertEquals("ALL", adminPermissionImpl2.type);
    PermissionType expectedType = type.ALL;
    assertSame(expectedType, adminPermissionImpl2.getType());
  }

  /**
   * Test {@link AdminPermissionImpl#setType(PermissionType)}.
   * <ul>
   *   <li>Then {@link AdminPermissionImpl} (default constructor) Type Type is {@code ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPermissionImpl#setType(PermissionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminPermissionImpl.setType(PermissionType)"})
  public void testSetType_thenAdminPermissionImplTypeTypeIsAll() {
    // Arrange
    AdminPermissionImpl adminPermissionImpl2 = new AdminPermissionImpl();
    adminPermissionImpl2.setAllRoles(new HashSet<>());
    adminPermissionImpl2.setAllUsers(new HashSet<>());
    adminPermissionImpl2.setDescription("The characteristics of someone or something");
    adminPermissionImpl2.setId(1L);
    adminPermissionImpl2.setName("Name");
    adminPermissionImpl2.setQualifiedEntities(new ArrayList<>());
    adminPermissionImpl2.setType(PermissionType.ALL);

    // Act
    adminPermissionImpl2.setType(null);

    // Assert that nothing has changed
    PermissionType type = adminPermissionImpl2.getType();
    assertEquals("ALL", type.getType());
    assertEquals("ALL", adminPermissionImpl2.type);
    assertEquals("All", type.getFriendlyType());
  }

  /**
   * Test {@link AdminPermissionImpl#clone()}.
   * <ul>
   *   <li>Given {@link AdminPermissionImpl} (default constructor).</li>
   *   <li>Then return Id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPermissionImpl#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminPermission AdminPermissionImpl.clone()"})
  public void testClone_givenAdminPermissionImpl_thenReturnIdIsNull() {
    // Arrange and Act
    AdminPermission actualCloneResult = (new AdminPermissionImpl()).clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminPermissionImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getDescription());
    assertNull(actualCloneResult.getName());
    assertNull(((AdminPermissionImpl) actualCloneResult).type);
    assertNull(actualCloneResult.getType());
  }

  /**
   * Test {@link AdminPermissionImpl#clone()}.
   * <ul>
   *   <li>Then return QualifiedEntities size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPermissionImpl#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminPermission AdminPermissionImpl.clone()"})
  public void testClone_thenReturnQualifiedEntitiesSizeIsOne() {
    // Arrange
    ArrayList<AdminPermissionQualifiedEntity> qualifiedEntities = new ArrayList<>();
    qualifiedEntities.add(new AdminPermissionQualifiedEntityImpl());

    AdminPermissionImpl adminPermissionImpl2 = new AdminPermissionImpl();
    adminPermissionImpl2.setAllRoles(new HashSet<>());
    adminPermissionImpl2.setAllUsers(new HashSet<>());
    adminPermissionImpl2.setDescription("The characteristics of someone or something");
    adminPermissionImpl2.setId(1L);
    adminPermissionImpl2.setName("Name");
    adminPermissionImpl2.setType(PermissionType.ALL);
    adminPermissionImpl2.setQualifiedEntities(qualifiedEntities);

    // Act
    AdminPermission actualCloneResult = adminPermissionImpl2.clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminPermissionImpl);
    List<AdminPermissionQualifiedEntity> qualifiedEntities2 = actualCloneResult.getQualifiedEntities();
    assertEquals(1, qualifiedEntities2.size());
    AdminPermissionQualifiedEntity getResult = qualifiedEntities2.get(0);
    assertTrue(getResult instanceof AdminPermissionQualifiedEntityImpl);
    assertNull(getResult.getId());
    assertNull(getResult.getCeilingEntityFullyQualifiedName());
    assertSame(actualCloneResult, getResult.getAdminPermission());
  }

  /**
   * Test {@link AdminPermissionImpl#clone()}.
   * <ul>
   *   <li>Then return Type Type is {@code ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPermissionImpl#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminPermission AdminPermissionImpl.clone()"})
  public void testClone_thenReturnTypeTypeIsAll() {
    // Arrange
    AdminPermissionImpl adminPermissionImpl2 = new AdminPermissionImpl();
    adminPermissionImpl2.setAllRoles(new HashSet<>());
    adminPermissionImpl2.setAllUsers(new HashSet<>());
    adminPermissionImpl2.setDescription("The characteristics of someone or something");
    adminPermissionImpl2.setId(1L);
    adminPermissionImpl2.setName("Name");
    adminPermissionImpl2.setType(PermissionType.ALL);
    adminPermissionImpl2.setQualifiedEntities(null);

    // Act
    AdminPermission actualCloneResult = adminPermissionImpl2.clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminPermissionImpl);
    PermissionType type = actualCloneResult.getType();
    assertEquals("ALL", type.getType());
    assertEquals("ALL", ((AdminPermissionImpl) actualCloneResult).type);
    assertEquals("All", type.getFriendlyType());
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("The characteristics of someone or something", actualCloneResult.getDescription());
    assertEquals(1L, actualCloneResult.getId().longValue());
    assertTrue(actualCloneResult.getQualifiedEntities().isEmpty());
  }

  /**
   * Test {@link AdminPermissionImpl#getAllChildPermissions()}.
   * <p>
   * Method under test: {@link AdminPermissionImpl#getAllChildPermissions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminPermissionImpl.getAllChildPermissions()"})
  public void testGetAllChildPermissions() {
    // Arrange, Act and Assert
    assertTrue((new AdminPermissionImpl()).getAllChildPermissions().isEmpty());
  }

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminPermissionImpl.getAllParentPermissions()", "Set AdminPermissionImpl.getAllRoles()",
      "Set AdminPermissionImpl.getAllUsers()", "String AdminPermissionImpl.getDescription()",
      "Long AdminPermissionImpl.getId()", "String AdminPermissionImpl.getName()",
      "List AdminPermissionImpl.getQualifiedEntities()", "void AdminPermissionImpl.setAllRoles(Set)",
      "void AdminPermissionImpl.setAllUsers(Set)", "void AdminPermissionImpl.setDescription(String)",
      "void AdminPermissionImpl.setId(Long)", "void AdminPermissionImpl.setName(String)",
      "void AdminPermissionImpl.setQualifiedEntities(List)"})
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
   * <p>
   * Method under test: {@link AdminPermissionImpl#isFriendly()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean AdminPermissionImpl.isFriendly()"})
  public void testIsFriendly() {
    // Arrange, Act and Assert
    assertFalse((new AdminPermissionImpl()).isFriendly());
  }

  /**
   * Test new {@link AdminPermissionImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AdminPermissionImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
