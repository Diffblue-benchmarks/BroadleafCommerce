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
package org.broadleafcommerce.openadmin.server.security.service.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.broadleafcommerce.common.security.BroadleafExternalAuthenticationUserDetails;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRole;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class AdminUserProvisioningServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#extractAdminUserAuthorities(HashSet)}
   */
  @Test
  public void testExtractAdminUserAuthorities() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();

    // Act and Assert
    assertEquals(6, adminUserProvisioningServiceImpl.extractAdminUserAuthorities(new HashSet<>()).size());
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#addPermissions(HashSet, List)}
   */
  @Test
  public void testAddPermissions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();
    HashSet<AdminRole> parsedRoles = new HashSet<>();
    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();

    // Act
    adminUserProvisioningServiceImpl.addPermissions(parsedRoles, adminUserAuthorities);

    // Assert
    assertEquals(2, adminUserAuthorities.size());
    SimpleGrantedAuthority getResult = adminUserAuthorities.get(1);
    assertEquals("PERMISSION_ALL_USER_SANDBOX", getResult.getAuthority());
    assertEquals("PERMISSION_ALL_USER_SANDBOX", getResult.toString());
    SimpleGrantedAuthority getResult2 = adminUserAuthorities.get(0);
    assertEquals("PERMISSION_OTHER_DEFAULT", getResult2.getAuthority());
    assertEquals("PERMISSION_OTHER_DEFAULT", getResult2.toString());
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  public void testConvertPermissionPrefixToRole() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();
    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert that nothing has changed
    assertTrue(adminUserAuthorities.isEmpty());
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  public void testConvertPermissionPrefixToRole2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();

    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert that nothing has changed
    assertEquals(1, adminUserAuthorities.size());
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  public void testConvertPermissionPrefixToRole3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();

    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities.add(new SimpleGrantedAuthority(AdminUserDetailsServiceImpl.LEGACY_ROLE_PREFIX));
    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("Role");
    adminUserAuthorities.add(simpleGrantedAuthority);

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert
    assertEquals(4, adminUserAuthorities.size());
    SimpleGrantedAuthority getResult = adminUserAuthorities.get(1);
    assertEquals("ROLE_PERMISSION_", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_", getResult.toString());
    SimpleGrantedAuthority getResult2 = adminUserAuthorities.get(2);
    assertEquals(AdminUserDetailsServiceImpl.DEFAULT_SPRING_SECURITY_ROLE_PREFIX, getResult2.getAuthority());
    assertEquals(AdminUserDetailsServiceImpl.DEFAULT_SPRING_SECURITY_ROLE_PREFIX, getResult2.toString());
    assertSame(simpleGrantedAuthority, adminUserAuthorities.get(3));
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  public void testConvertPermissionPrefixToRole4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();

    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities
        .add(new SimpleGrantedAuthority(AdminUserDetailsServiceImpl.DEFAULT_SPRING_SECURITY_ROLE_PREFIX));
    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("Role");
    adminUserAuthorities.add(simpleGrantedAuthority);

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert that nothing has changed
    assertEquals(2, adminUserAuthorities.size());
    assertSame(simpleGrantedAuthority, adminUserAuthorities.get(1));
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  public void testConvertPermissionPrefixToRole5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();

    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities.add(new SimpleGrantedAuthority("PERMISSION_PERMISSION_"));

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert
    assertEquals(3, adminUserAuthorities.size());
    SimpleGrantedAuthority getResult = adminUserAuthorities.get(1);
    assertEquals("ROLE_PERMISSION_PERMISSION_", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_PERMISSION_", getResult.toString());
    SimpleGrantedAuthority getResult2 = adminUserAuthorities.get(2);
    assertEquals("ROLE_ROLE_", getResult2.getAuthority());
    assertEquals("ROLE_ROLE_", getResult2.toString());
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  public void testConvertPermissionPrefixToRole6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();

    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities.add(new SimpleGrantedAuthority("PERMISSION_Role"));

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert
    assertEquals(3, adminUserAuthorities.size());
    SimpleGrantedAuthority getResult = adminUserAuthorities.get(1);
    assertEquals("ROLE_PERMISSION_Role", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_Role", getResult.toString());
    SimpleGrantedAuthority getResult2 = adminUserAuthorities.get(2);
    assertEquals("ROLE_Role", getResult2.getAuthority());
    assertEquals("ROLE_Role", getResult2.toString());
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  public void testConvertPermissionPrefixToRole7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();

    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities.add(new SimpleGrantedAuthority("PERMISSION_ROLE_"));
    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("Role");
    adminUserAuthorities.add(simpleGrantedAuthority);

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert
    assertEquals(4, adminUserAuthorities.size());
    SimpleGrantedAuthority getResult = adminUserAuthorities.get(1);
    assertEquals("ROLE_PERMISSION_ROLE_", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_ROLE_", getResult.toString());
    SimpleGrantedAuthority getResult2 = adminUserAuthorities.get(2);
    assertEquals("ROLE_ROLE_", getResult2.getAuthority());
    assertEquals("ROLE_ROLE_", getResult2.toString());
    assertSame(simpleGrantedAuthority, adminUserAuthorities.get(3));
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  public void testConvertPermissionPrefixToRole8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();

    ArrayList<SimpleGrantedAuthority> adminUserAuthorities = new ArrayList<>();
    adminUserAuthorities.add(new SimpleGrantedAuthority("PERMISSION_42"));

    // Act
    adminUserProvisioningServiceImpl.convertPermissionPrefixToRole(adminUserAuthorities);

    // Assert
    assertEquals(3, adminUserAuthorities.size());
    SimpleGrantedAuthority getResult = adminUserAuthorities.get(2);
    assertEquals("ROLE_42", getResult.getAuthority());
    assertEquals("ROLE_42", getResult.toString());
    SimpleGrantedAuthority getResult2 = adminUserAuthorities.get(1);
    assertEquals("ROLE_PERMISSION_42", getResult2.getAuthority());
    assertEquals("ROLE_PERMISSION_42", getResult2.toString());
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#createDetails(AdminUser, BroadleafExternalAuthenticationUserDetails, Set)}
   */
  @Test
  public void testCreateDetails() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();
    AdminUserImpl adminUser = new AdminUserImpl();
    BroadleafExternalAuthenticationUserDetails details = new BroadleafExternalAuthenticationUserDetails("janedoe",
        "iloveyou", new ArrayList<>());

    // Act and Assert
    assertEquals(details, adminUserProvisioningServiceImpl.createDetails(adminUser, details, new HashSet<>()));
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#createDetails(AdminUser, BroadleafExternalAuthenticationUserDetails, Set)}
   */
  @Test
  public void testCreateDetails2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();
    AdminUserImpl adminUser = mock(AdminUserImpl.class);
    when(adminUser.getId()).thenReturn(1L);
    BroadleafExternalAuthenticationUserDetails details = new BroadleafExternalAuthenticationUserDetails("janedoe",
        "iloveyou", new ArrayList<>());

    // Act
    AdminUserDetails actualCreateDetailsResult = adminUserProvisioningServiceImpl.createDetails(adminUser, details,
        new HashSet<>());

    // Assert
    verify(adminUser).getId();
    assertEquals(details, actualCreateDetailsResult);
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#createDetails(AdminUser, BroadleafExternalAuthenticationUserDetails, Set)}
   */
  @Test
  public void testCreateDetails3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();
    AdminUserImpl adminUser = mock(AdminUserImpl.class);
    when(adminUser.getId()).thenReturn(1L);
    BroadleafExternalAuthenticationUserDetails details = mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getUsername()).thenReturn("janedoe");

    HashSet<SimpleGrantedAuthority> adminUserAuthorities = new HashSet<>();
    adminUserAuthorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    AdminUserDetails actualCreateDetailsResult = adminUserProvisioningServiceImpl.createDetails(adminUser, details,
        adminUserAuthorities);

    // Assert
    verify(adminUser).getId();
    verify(details).getUsername();
    Collection<GrantedAuthority> authorities = actualCreateDetailsResult.getAuthorities();
    assertEquals(1, authorities.size());
    assertTrue(authorities instanceof Set);
    assertEquals("", actualCreateDetailsResult.getPassword());
    assertEquals("janedoe", actualCreateDetailsResult.getUsername());
    assertEquals(1L, actualCreateDetailsResult.getId().longValue());
    assertTrue(actualCreateDetailsResult.isAccountNonExpired());
    assertTrue(actualCreateDetailsResult.isAccountNonLocked());
    assertTrue(actualCreateDetailsResult.isCredentialsNonExpired());
    assertTrue(actualCreateDetailsResult.isEnabled());
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  public void testParseRolesFromUserDetails() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();

    // Act and Assert
    assertTrue(
        adminUserProvisioningServiceImpl
            .parseRolesFromUserDetails(
                new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>()))
            .isEmpty());
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  public void testParseRolesFromUserDetails2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();

    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    HashSet<String> actualParseRolesFromUserDetailsResult = adminUserProvisioningServiceImpl
        .parseRolesFromUserDetails(new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", authorities));

    // Assert
    assertEquals(1, actualParseRolesFromUserDetailsResult.size());
    assertTrue(actualParseRolesFromUserDetailsResult.contains("Role"));
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  public void testParseRolesFromUserDetails3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();
    BroadleafExternalAuthenticationUserDetails details = mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getAuthorities()).thenReturn(new ArrayList<>());

    // Act
    HashSet<String> actualParseRolesFromUserDetailsResult = adminUserProvisioningServiceImpl
        .parseRolesFromUserDetails(details);

    // Assert
    verify(details).getAuthorities();
    assertTrue(actualParseRolesFromUserDetailsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  public void testParseRolesFromUserDetails4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();
    adminUserProvisioningServiceImpl.setRoleNameSubstitutions(new HashMap<>());
    BroadleafExternalAuthenticationUserDetails details = mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getAuthorities()).thenReturn(new ArrayList<>());

    // Act
    HashSet<String> actualParseRolesFromUserDetailsResult = adminUserProvisioningServiceImpl
        .parseRolesFromUserDetails(details);

    // Assert
    verify(details).getAuthorities();
    assertTrue(actualParseRolesFromUserDetailsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  public void testParseRolesFromUserDetails5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, String[]> roleNameSubstitutions = new HashMap<>();
    roleNameSubstitutions.put("foo", new String[]{"foo"});

    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();
    adminUserProvisioningServiceImpl.setRoleNameSubstitutions(roleNameSubstitutions);
    BroadleafExternalAuthenticationUserDetails details = mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getAuthorities()).thenReturn(new ArrayList<>());

    // Act
    HashSet<String> actualParseRolesFromUserDetailsResult = adminUserProvisioningServiceImpl
        .parseRolesFromUserDetails(details);

    // Assert
    verify(details).getAuthorities();
    assertTrue(actualParseRolesFromUserDetailsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AdminUserProvisioningServiceImpl#parseRolesFromUserDetails(BroadleafExternalAuthenticationUserDetails)}
   */
  @Test
  public void testParseRolesFromUserDetails6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, String[]> roleNameSubstitutions = new HashMap<>();
    roleNameSubstitutions.put("foo", new String[]{"foo"});

    AdminUserProvisioningServiceImpl adminUserProvisioningServiceImpl = new AdminUserProvisioningServiceImpl();
    adminUserProvisioningServiceImpl.setRoleNameSubstitutions(roleNameSubstitutions);

    ArrayList<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
    grantedAuthorityList.add(new SimpleGrantedAuthority("Role"));
    BroadleafExternalAuthenticationUserDetails details = mock(BroadleafExternalAuthenticationUserDetails.class);
    when(details.getAuthorities()).thenReturn(grantedAuthorityList);

    // Act
    HashSet<String> actualParseRolesFromUserDetailsResult = adminUserProvisioningServiceImpl
        .parseRolesFromUserDetails(details);

    // Assert
    verify(details).getAuthorities();
    assertEquals(1, actualParseRolesFromUserDetailsResult.size());
    assertTrue(actualParseRolesFromUserDetailsResult.contains("Role"));
  }
}
