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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
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
public class AdminRoleImplDiffblueTest {
  @Autowired private AdminRoleImpl adminRoleImpl;

  /**
   * Test {@link AdminRoleImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link AdminRoleImpl} AllPermissions is {@code null}.
   *   <li>Then return AllPermissions Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminRoleImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminRole AdminRoleImpl.clone()"})
  public void testClone_givenAdminRoleImplAllPermissionsIsNull_thenReturnAllPermissionsEmpty() {
    // Arrange
    adminRoleImpl.setAllPermissions(null);

    // Act
    AdminRole actualCloneResult = adminRoleImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminRoleImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getDescription());
    assertNull(actualCloneResult.getName());
    assertNull(((AdminRoleImpl) actualCloneResult).getMainEntityName());
    assertTrue(actualCloneResult.getAllPermissions().isEmpty());
    assertTrue(((AdminRoleImpl) actualCloneResult).getAllUsers().isEmpty());
  }

  /**
   * Test {@link AdminRoleImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link AdminRoleImpl}.
   *   <li>Then return AllPermissions Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminRoleImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminRole AdminRoleImpl.clone()"})
  public void testClone_givenAdminRoleImpl_thenReturnAllPermissionsEmpty() {
    // Arrange and Act
    AdminRole actualCloneResult = adminRoleImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminRoleImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getDescription());
    assertNull(actualCloneResult.getName());
    assertNull(((AdminRoleImpl) actualCloneResult).getMainEntityName());
    assertTrue(actualCloneResult.getAllPermissions().isEmpty());
    assertTrue(((AdminRoleImpl) actualCloneResult).getAllUsers().isEmpty());
  }

  /**
   * Test {@link AdminRoleImpl#clone()}.
   *
   * <ul>
   *   <li>Then return AllPermissions size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminRoleImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminRole AdminRoleImpl.clone()"})
  public void testClone_thenReturnAllPermissionsSizeIsOne() {
    // Arrange
    LinkedHashSet<AdminPermission> allPermissions = new LinkedHashSet<>();
    allPermissions.add(new AdminPermissionImpl());
    adminRoleImpl.setAllPermissions(allPermissions);

    // Act
    AdminRole actualCloneResult = adminRoleImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminRoleImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getDescription());
    assertNull(actualCloneResult.getName());
    assertNull(((AdminRoleImpl) actualCloneResult).getMainEntityName());
    assertEquals(1, actualCloneResult.getAllPermissions().size());
    assertTrue(((AdminRoleImpl) actualCloneResult).getAllUsers().isEmpty());
  }

  /**
   * Test {@link AdminRoleImpl#getMainEntityName()}.
   *
   * <p>Method under test: {@link AdminRoleImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminRoleImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull(adminRoleImpl.getMainEntityName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminRoleImpl.<init>()",
    "Set AdminRoleImpl.getAllPermissions()",
    "Set AdminRoleImpl.getAllUsers()",
    "String AdminRoleImpl.getDescription()",
    "Long AdminRoleImpl.getId()",
    "String AdminRoleImpl.getName()",
    "void AdminRoleImpl.setAllPermissions(Set)",
    "void AdminRoleImpl.setDescription(String)",
    "void AdminRoleImpl.setId(Long)",
    "void AdminRoleImpl.setName(String)"
  })
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

    // Assert
    assertEquals("Name", actualAdminRoleImpl.getName());
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAllPermissions.isEmpty());
    assertTrue(actualAllUsers.isEmpty());
    assertSame(allPermissions, actualAllPermissions);
  }
}
