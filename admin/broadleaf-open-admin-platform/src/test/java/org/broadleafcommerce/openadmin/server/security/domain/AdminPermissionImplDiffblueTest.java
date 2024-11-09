/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.broadleafcommerce.openadmin.server.security.service.type.PermissionType;
import org.junit.Test;

public class AdminPermissionImplDiffblueTest {
  /**
   * Test {@link AdminPermissionImpl#getType()}.
   * <ul>
   *   <li>Given {@link AdminPermissionImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPermissionImpl#getType()}
   */
  @Test
  public void testGetType_givenAdminPermissionImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminPermissionImpl()).getType());
  }

  /**
   * Test {@link AdminPermissionImpl#setType(PermissionType)}.
   * <ul>
   *   <li>Given {@link AdminPermissionImpl} (default constructor).</li>
   *   <li>When {@link PermissionType#ALL}.</li>
   *   <li>Then {@link AdminPermissionImpl} (default constructor) Type is
   * {@link PermissionType#ALL} {@link PermissionType#ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPermissionImpl#setType(PermissionType)}
   */
  @Test
  public void testSetType_givenAdminPermissionImpl_whenAll_thenAdminPermissionImplTypeIsAllAll() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionImpl adminPermissionImpl = new AdminPermissionImpl();
    PermissionType type = PermissionType.ALL;

    // Act
    adminPermissionImpl.setType(type);

    // Assert
    assertEquals("ALL", adminPermissionImpl.type);
    PermissionType expectedType = type.ALL;
    assertSame(expectedType, adminPermissionImpl.getType());
  }

  /**
   * Test {@link AdminPermissionImpl#setType(PermissionType)}.
   * <ul>
   *   <li>Then {@link AdminPermissionImpl} (default constructor) Type Type is
   * {@code ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPermissionImpl#setType(PermissionType)}
   */
  @Test
  public void testSetType_thenAdminPermissionImplTypeTypeIsAll() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionImpl adminPermissionImpl = new AdminPermissionImpl();
    adminPermissionImpl.setAllRoles(new HashSet<>());
    adminPermissionImpl.setAllUsers(new HashSet<>());
    adminPermissionImpl.setDescription("The characteristics of someone or something");
    adminPermissionImpl.setId(1L);
    adminPermissionImpl.setName("Name");
    adminPermissionImpl.setQualifiedEntities(new ArrayList<>());
    adminPermissionImpl.setType(PermissionType.ALL);

    // Act
    adminPermissionImpl.setType(null);

    // Assert that nothing has changed
    PermissionType type = adminPermissionImpl.getType();
    assertEquals("ALL", type.getType());
    assertEquals("ALL", adminPermissionImpl.type);
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
  public void testClone_givenAdminPermissionImpl_thenReturnIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testClone_thenReturnQualifiedEntitiesSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testClone_thenReturnTypeTypeIsAll() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionImpl adminPermissionImpl = new AdminPermissionImpl();
    adminPermissionImpl.setAllRoles(new HashSet<>());
    adminPermissionImpl.setAllUsers(new HashSet<>());
    adminPermissionImpl.setDescription("The characteristics of someone or something");
    adminPermissionImpl.setId(1L);
    adminPermissionImpl.setName("Name");
    adminPermissionImpl.setType(PermissionType.ALL);
    adminPermissionImpl.setQualifiedEntities(null);

    // Act
    AdminPermission actualCloneResult = adminPermissionImpl.clone();

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
   * <ul>
   *   <li>Given {@link AdminPermissionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPermissionImpl#getAllChildPermissions()}
   */
  @Test
  public void testGetAllChildPermissions_givenAdminPermissionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new AdminPermissionImpl()).getAllChildPermissions().isEmpty());
  }

  /**
   * Test {@link AdminPermissionImpl#getAllChildPermissions()}.
   * <ul>
   *   <li>Given {@link PermissionType} {@link PermissionType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link PermissionType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPermissionImpl#getAllChildPermissions()}
   */
  @Test
  public void testGetAllChildPermissions_givenPermissionTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PermissionType type = mock(PermissionType.class);
    when(type.getType()).thenReturn("Type");

    AdminPermissionImpl adminPermissionImpl = new AdminPermissionImpl();
    adminPermissionImpl.setType(type);

    // Act
    List<AdminPermission> actualAllChildPermissions = adminPermissionImpl.getAllChildPermissions();

    // Assert
    verify(type).getType();
    assertTrue(actualAllChildPermissions.isEmpty());
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

  /**
   * Test {@link AdminPermissionImpl#isFriendly()}.
   * <ul>
   *   <li>Given {@link AdminPermissionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPermissionImpl#isFriendly()}
   */
  @Test
  public void testIsFriendly_givenAdminPermissionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new AdminPermissionImpl()).isFriendly());
  }

  /**
   * Test {@link AdminPermissionImpl#isFriendly()}.
   * <ul>
   *   <li>Given {@link PermissionType} {@link PermissionType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link PermissionType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPermissionImpl#isFriendly()}
   */
  @Test
  public void testIsFriendly_givenPermissionTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PermissionType type = mock(PermissionType.class);
    when(type.getType()).thenReturn("Type");

    AdminPermissionImpl adminPermissionImpl = new AdminPermissionImpl();
    adminPermissionImpl.setType(type);

    // Act
    Boolean actualIsFriendlyResult = adminPermissionImpl.isFriendly();

    // Assert
    verify(type).getType();
    assertFalse(actualIsFriendlyResult);
  }

  /**
   * Test new {@link AdminPermissionImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AdminPermissionImpl}
   */
  @Test
  public void testNewAdminPermissionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
