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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;

public class AdminRoleImplDiffblueTest {
  /**
   * Test {@link AdminRoleImpl#clone()}.
   * <ul>
   *   <li>Given {@link AdminPermissionImpl} {@link AdminPermissionImpl#clone()}
   * return {@link AdminPermissionImpl} (default constructor).</li>
   *   <li>Then calls {@link AdminPermissionImpl#clone()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRoleImpl#clone()}
   */
  @Test
  public void testClone_givenAdminPermissionImplCloneReturnAdminPermissionImpl_thenCallsClone() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPermissionImpl adminPermissionImpl = mock(AdminPermissionImpl.class);
    when(adminPermissionImpl.clone()).thenReturn(new AdminPermissionImpl());

    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(adminPermissionImpl);

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    // Act
    AdminRole actualCloneResult = adminRoleImpl.clone();

    // Assert
    verify(adminPermissionImpl).clone();
    assertTrue(actualCloneResult instanceof AdminRoleImpl);
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Name", ((AdminRoleImpl) actualCloneResult).getMainEntityName());
    assertEquals("The characteristics of someone or something", actualCloneResult.getDescription());
    assertEquals(1, actualCloneResult.getAllPermissions().size());
    assertEquals(1L, actualCloneResult.getId().longValue());
  }

  /**
   * Test {@link AdminRoleImpl#clone()}.
   * <ul>
   *   <li>Given {@link AdminRoleImpl} (default constructor) AllPermissions is
   * {@code null}.</li>
   *   <li>Then return AllPermissions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRoleImpl#clone()}
   */
  @Test
  public void testClone_givenAdminRoleImplAllPermissionsIsNull_thenReturnAllPermissionsEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(null);

    // Act
    AdminRole actualCloneResult = adminRoleImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminRoleImpl);
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Name", ((AdminRoleImpl) actualCloneResult).getMainEntityName());
    assertEquals("The characteristics of someone or something", actualCloneResult.getDescription());
    assertEquals(1L, actualCloneResult.getId().longValue());
    assertTrue(actualCloneResult.getAllPermissions().isEmpty());
  }

  /**
   * Test {@link AdminRoleImpl#clone()}.
   * <ul>
   *   <li>Given {@link AdminRoleImpl} (default constructor).</li>
   *   <li>Then return Id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRoleImpl#clone()}
   */
  @Test
  public void testClone_givenAdminRoleImpl_thenReturnIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    AdminRole actualCloneResult = (new AdminRoleImpl()).clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminRoleImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getDescription());
    assertNull(actualCloneResult.getName());
    assertNull(((AdminRoleImpl) actualCloneResult).getMainEntityName());
  }

  /**
   * Test {@link AdminRoleImpl#clone()}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add
   * {@link AdminPermissionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRoleImpl#clone()}
   */
  @Test
  public void testClone_givenLinkedHashSetAddAdminPermissionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());

    AdminRoleImpl adminRoleImpl = new AdminRoleImpl();
    adminRoleImpl.setDescription("The characteristics of someone or something");
    adminRoleImpl.setId(1L);
    adminRoleImpl.setName("Name");
    adminRoleImpl.setAllPermissions(allPermissions);

    // Act
    AdminRole actualCloneResult = adminRoleImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminRoleImpl);
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Name", ((AdminRoleImpl) actualCloneResult).getMainEntityName());
    assertEquals("The characteristics of someone or something", actualCloneResult.getDescription());
    assertEquals(1, actualCloneResult.getAllPermissions().size());
    assertEquals(1L, actualCloneResult.getId().longValue());
  }

  /**
   * Test {@link AdminRoleImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link AdminRoleImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminRoleImpl()).getMainEntityName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminRoleImpl}
   *   <li>{@link AdminRoleImpl#setAllPermissions(Set)}
   *   <li>{@link AdminRoleImpl#setDescription(String)}
   *   <li>{@link AdminRoleImpl#setId(Long)}
   *   <li>{@link AdminRoleImpl#setName(String)}
   *   <li>{@link AdminRoleImpl#getAllPermissions()}
   *   <li>{@link AdminRoleImpl#getAllUsers()}
   *   <li>{@link AdminRoleImpl#getDescription()}
   *   <li>{@link AdminRoleImpl#getId()}
   *   <li>{@link AdminRoleImpl#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminRoleImpl actualAdminRoleImpl = new AdminRoleImpl();
    HashSet<AdminPermission> allPermissions = new HashSet<>();
    actualAdminRoleImpl.setAllPermissions(allPermissions);
    actualAdminRoleImpl.setDescription("The characteristics of someone or something");
    actualAdminRoleImpl.setId(1L);
    actualAdminRoleImpl.setName("Name");
    Set<AdminPermission> actualAllPermissions = actualAdminRoleImpl.getAllPermissions();
    Set<AdminUser> actualAllUsers = actualAdminRoleImpl.getAllUsers();
    String actualDescription = actualAdminRoleImpl.getDescription();
    Long actualId = actualAdminRoleImpl.getId();

    // Assert that nothing has changed
    assertEquals("Name", actualAdminRoleImpl.getName());
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAllPermissions.isEmpty());
    assertTrue(actualAllUsers.isEmpty());
    assertSame(allPermissions, actualAllPermissions);
  }
}
