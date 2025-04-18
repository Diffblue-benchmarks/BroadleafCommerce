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
package org.broadleafcommerce.openadmin.server.security.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
  @Autowired
  private AdminSecurityHelperImpl adminSecurityHelperImpl;

  /**
   * Test {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityHelperImpl.addAllPermissionsToAuthorities(List, Collection)"})
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
   * Test {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityHelperImpl.addAllPermissionsToAuthorities(List, Collection)"})
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSecurityHelperImpl#addAllPermissionsToAuthorities(List, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSecurityHelperImpl.addAllPermissionsToAuthorities(List, Collection)"})
  public void testAddAllPermissionsToAuthorities_whenArrayList_thenArrayListEmpty() {
    // Arrange
    ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();

    // Act
    adminSecurityHelperImpl.addAllPermissionsToAuthorities(grantedAuthorities, new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(grantedAuthorities.isEmpty());
  }
}
