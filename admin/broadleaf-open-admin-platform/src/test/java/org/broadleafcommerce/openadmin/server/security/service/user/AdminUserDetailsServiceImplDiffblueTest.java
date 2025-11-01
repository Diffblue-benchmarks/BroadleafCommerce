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
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AdminUserDetailsServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link AdminUserDetailsServiceImpl#addRoles(AdminUser, List)}
   */
  @Test
  public void testAddRoles() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();
    AdminUserImpl adminUser = mock(AdminUserImpl.class);
    when(adminUser.getAllRoles()).thenReturn(new HashSet<>());

    // Act
    adminUserDetailsServiceImpl.addRoles(adminUser, new ArrayList<>());

    // Assert
    verify(adminUser).getAllRoles();
  }

  /**
   * Method under test:
   * {@link AdminUserDetailsServiceImpl#addRoles(AdminUser, List)}
   */
  @Test
  public void testAddRoles2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();
    AdminUserImpl adminUser = mock(AdminUserImpl.class);
    when(adminUser.getAllRoles()).thenReturn(new HashSet<>());

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    adminUserDetailsServiceImpl.addRoles(adminUser, authorities);

    // Assert
    verify(adminUser).getAllRoles();
  }

  /**
   * Method under test:
   * {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  public void testConvertPermissionPrefixToRole() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();
    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert that nothing has changed
    assertTrue(authorities.isEmpty());
  }

  /**
   * Method under test:
   * {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  public void testConvertPermissionPrefixToRole2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert that nothing has changed
    assertEquals(1, authorities.size());
  }

  /**
   * Method under test:
   * {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  public void testConvertPermissionPrefixToRole3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(AdminUserDetailsServiceImpl.LEGACY_ROLE_PREFIX));
    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("Role");
    authorities.add(simpleGrantedAuthority);

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert
    assertEquals(4, authorities.size());
    SimpleGrantedAuthority getResult = authorities.get(1);
    assertEquals("ROLE_PERMISSION_", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_", getResult.toString());
    SimpleGrantedAuthority getResult2 = authorities.get(2);
    assertEquals(AdminUserDetailsServiceImpl.DEFAULT_SPRING_SECURITY_ROLE_PREFIX, getResult2.getAuthority());
    assertEquals(AdminUserDetailsServiceImpl.DEFAULT_SPRING_SECURITY_ROLE_PREFIX, getResult2.toString());
    assertSame(simpleGrantedAuthority, authorities.get(3));
  }

  /**
   * Method under test:
   * {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  public void testConvertPermissionPrefixToRole4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(AdminUserDetailsServiceImpl.DEFAULT_SPRING_SECURITY_ROLE_PREFIX));
    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("Role");
    authorities.add(simpleGrantedAuthority);

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert that nothing has changed
    assertEquals(2, authorities.size());
    assertSame(simpleGrantedAuthority, authorities.get(1));
  }

  /**
   * Method under test:
   * {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  public void testConvertPermissionPrefixToRole5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("PERMISSION_PERMISSION_"));

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert
    assertEquals(3, authorities.size());
    SimpleGrantedAuthority getResult = authorities.get(1);
    assertEquals("ROLE_PERMISSION_PERMISSION_", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_PERMISSION_", getResult.toString());
    SimpleGrantedAuthority getResult2 = authorities.get(2);
    assertEquals("ROLE_ROLE_", getResult2.getAuthority());
    assertEquals("ROLE_ROLE_", getResult2.toString());
  }

  /**
   * Method under test:
   * {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  public void testConvertPermissionPrefixToRole6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("PERMISSION_Role"));

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert
    assertEquals(3, authorities.size());
    SimpleGrantedAuthority getResult = authorities.get(1);
    assertEquals("ROLE_PERMISSION_Role", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_Role", getResult.toString());
    SimpleGrantedAuthority getResult2 = authorities.get(2);
    assertEquals("ROLE_Role", getResult2.getAuthority());
    assertEquals("ROLE_Role", getResult2.toString());
  }

  /**
   * Method under test:
   * {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  public void testConvertPermissionPrefixToRole7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("PERMISSION_ROLE_"));
    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("Role");
    authorities.add(simpleGrantedAuthority);

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert
    assertEquals(4, authorities.size());
    SimpleGrantedAuthority getResult = authorities.get(1);
    assertEquals("ROLE_PERMISSION_ROLE_", getResult.getAuthority());
    assertEquals("ROLE_PERMISSION_ROLE_", getResult.toString());
    SimpleGrantedAuthority getResult2 = authorities.get(2);
    assertEquals("ROLE_ROLE_", getResult2.getAuthority());
    assertEquals("ROLE_ROLE_", getResult2.toString());
    assertSame(simpleGrantedAuthority, authorities.get(3));
  }

  /**
   * Method under test:
   * {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  public void testConvertPermissionPrefixToRole8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("PERMISSION_42"));

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert
    assertEquals(3, authorities.size());
    SimpleGrantedAuthority getResult = authorities.get(2);
    assertEquals("ROLE_42", getResult.getAuthority());
    assertEquals("ROLE_42", getResult.toString());
    SimpleGrantedAuthority getResult2 = authorities.get(1);
    assertEquals("ROLE_PERMISSION_42", getResult2.getAuthority());
    assertEquals("ROLE_PERMISSION_42", getResult2.toString());
  }

  /**
   * Method under test:
   * {@link AdminUserDetailsServiceImpl#convertPermissionPrefixToRole(List)}
   */
  @Test
  public void testConvertPermissionPrefixToRole9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserImpl adminUser = mock(AdminUserImpl.class);
    when(adminUser.getAllRoles()).thenReturn(new HashSet<>());

    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();
    adminUserDetailsServiceImpl.addRoles(adminUser, new ArrayList<>());
    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();

    // Act
    adminUserDetailsServiceImpl.convertPermissionPrefixToRole(authorities);

    // Assert that nothing has changed
    verify(adminUser).getAllRoles();
    assertTrue(authorities.isEmpty());
  }

  /**
   * Method under test:
   * {@link AdminUserDetailsServiceImpl#createDetails(String, AdminUser, List)}
   */
  @Test
  public void testCreateDetails() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();

    AdminUserImpl adminUser = new AdminUserImpl();
    adminUser.setActiveStatusFlag(true);
    adminUser.setAdditionalFields(new HashMap<>());
    adminUser.setAllPermissions(new HashSet<>());
    adminUser.setAllRoles(new HashSet<>());
    adminUser.setEmail("jane.doe@example.org");
    adminUser.setId(1L);
    adminUser.setLogin("Login");
    adminUser.setName("Name");
    adminUser.setOverrideSandBox(new SandBoxImpl());
    adminUser.setPhoneNumber("6625550144");
    adminUser.setUnencodedPassword("secret");
    adminUser.setPassword("Admin User");

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    UserDetails actualCreateDetailsResult = adminUserDetailsServiceImpl.createDetails("janedoe", adminUser,
        authorities);

    // Assert
    Collection<? extends GrantedAuthority> authorities2 = actualCreateDetailsResult.getAuthorities();
    assertEquals(1, authorities2.size());
    assertTrue(authorities2 instanceof Set);
    assertTrue(actualCreateDetailsResult instanceof AdminUserDetails);
    assertEquals("Admin User", actualCreateDetailsResult.getPassword());
    assertEquals("janedoe", actualCreateDetailsResult.getUsername());
    assertEquals(1L, ((AdminUserDetails) actualCreateDetailsResult).getId().longValue());
    assertTrue(actualCreateDetailsResult.isAccountNonExpired());
    assertTrue(actualCreateDetailsResult.isAccountNonLocked());
    assertTrue(actualCreateDetailsResult.isCredentialsNonExpired());
    assertTrue(actualCreateDetailsResult.isEnabled());
  }

  /**
   * Method under test:
   * {@link AdminUserDetailsServiceImpl#createDetails(String, AdminUser, List)}
   */
  @Test
  public void testCreateDetails2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();
    AdminUserImpl adminUser = mock(AdminUserImpl.class);
    when(adminUser.getId()).thenReturn(1L);
    when(adminUser.getPassword()).thenReturn("iloveyou");

    // Act
    UserDetails actualCreateDetailsResult = adminUserDetailsServiceImpl.createDetails("janedoe", adminUser,
        new ArrayList<>());

    // Assert
    verify(adminUser).getId();
    verify(adminUser).getPassword();
    Collection<? extends GrantedAuthority> authorities = actualCreateDetailsResult.getAuthorities();
    assertTrue(authorities instanceof Set);
    assertTrue(actualCreateDetailsResult instanceof AdminUserDetails);
    assertEquals("iloveyou", actualCreateDetailsResult.getPassword());
    assertEquals("janedoe", actualCreateDetailsResult.getUsername());
    assertEquals(1L, ((AdminUserDetails) actualCreateDetailsResult).getId().longValue());
    assertTrue(authorities.isEmpty());
    assertTrue(actualCreateDetailsResult.isAccountNonExpired());
    assertTrue(actualCreateDetailsResult.isAccountNonLocked());
    assertTrue(actualCreateDetailsResult.isCredentialsNonExpired());
    assertTrue(actualCreateDetailsResult.isEnabled());
  }

  /**
   * Method under test:
   * {@link AdminUserDetailsServiceImpl#createDetails(String, AdminUser, List)}
   */
  @Test
  public void testCreateDetails3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserDetailsServiceImpl adminUserDetailsServiceImpl = new AdminUserDetailsServiceImpl();
    AdminUserImpl adminUser = mock(AdminUserImpl.class);
    when(adminUser.getId()).thenReturn(1L);
    when(adminUser.getPassword()).thenReturn("iloveyou");

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act
    UserDetails actualCreateDetailsResult = adminUserDetailsServiceImpl.createDetails("janedoe", adminUser,
        authorities);

    // Assert
    verify(adminUser).getId();
    verify(adminUser).getPassword();
    Collection<? extends GrantedAuthority> authorities2 = actualCreateDetailsResult.getAuthorities();
    assertEquals(1, authorities2.size());
    assertTrue(authorities2 instanceof Set);
    assertTrue(actualCreateDetailsResult instanceof AdminUserDetails);
    assertEquals("iloveyou", actualCreateDetailsResult.getPassword());
    assertEquals("janedoe", actualCreateDetailsResult.getUsername());
    assertEquals(1L, ((AdminUserDetails) actualCreateDetailsResult).getId().longValue());
    assertTrue(actualCreateDetailsResult.isAccountNonExpired());
    assertTrue(actualCreateDetailsResult.isAccountNonLocked());
    assertTrue(actualCreateDetailsResult.isCredentialsNonExpired());
    assertTrue(actualCreateDetailsResult.isEnabled());
  }
}
