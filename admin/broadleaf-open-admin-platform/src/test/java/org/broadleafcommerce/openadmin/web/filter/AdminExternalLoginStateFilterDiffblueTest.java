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
package org.broadleafcommerce.openadmin.web.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.security.BroadleafExternalAuthenticationUserDetails;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRole;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRoleImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {AdminExternalLoginStateFilter.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminExternalLoginStateFilterDiffblueTest {
  @Autowired
  private AdminExternalLoginStateFilter adminExternalLoginStateFilter;

  @MockBean(name = "blAdminSecurityService")
  private AdminSecurityService adminSecurityService;

  @MockBean(name = "blEntityConfiguration")
  private EntityConfiguration entityConfiguration;

  /**
   * Method under test:
   * {@link AdminExternalLoginStateFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter() throws IOException, ServletException {
    // Arrange
    JSCompatibilityRequestWrapper servletRequest = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse servletResponse = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    adminExternalLoginStateFilter.doFilter(servletRequest, servletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Method under test:
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}
   */
  @Test
  public void testSaveAdminUser() {
    // Arrange
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(new AdminUserImpl());
    BroadleafExternalAuthenticationUserDetails broadleafUser = new BroadleafExternalAuthenticationUserDetails("janedoe",
        "iloveyou", new ArrayList<>());

    AdminUserImpl user = new AdminUserImpl();

    // Act
    adminExternalLoginStateFilter.saveAdminUser(broadleafUser, user);

    // Assert
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertEquals("", user.getMainEntityName());
    assertEquals("", user.getName());
    assertEquals("iloveyou", user.getUnencodedPassword());
    assertEquals("janedoe", user.getLogin());
    assertNull(user.getEmail());
  }

  /**
   * Method under test:
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}
   */
  @Test
  public void testSaveAdminUser2() {
    // Arrange
    ArrayList<AdminRole> adminRoleList = new ArrayList<>();
    adminRoleList.add(new AdminRoleImpl());
    when(adminSecurityService.readAllAdminRoles()).thenReturn(adminRoleList);
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(new AdminUserImpl());
    BroadleafExternalAuthenticationUserDetails broadleafUser = new BroadleafExternalAuthenticationUserDetails("janedoe",
        "iloveyou", new ArrayList<>());

    AdminUserImpl user = new AdminUserImpl();

    // Act
    adminExternalLoginStateFilter.saveAdminUser(broadleafUser, user);

    // Assert
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertEquals("", user.getMainEntityName());
    assertEquals("", user.getName());
    assertEquals("iloveyou", user.getUnencodedPassword());
    assertEquals("janedoe", user.getLogin());
    assertNull(user.getEmail());
  }

  /**
   * Method under test:
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}
   */
  @Test
  public void testSaveAdminUser3() {
    // Arrange
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(new AdminUserImpl());

    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    BroadleafExternalAuthenticationUserDetails broadleafUser = new BroadleafExternalAuthenticationUserDetails("janedoe",
        "iloveyou", authorities);

    AdminUserImpl user = new AdminUserImpl();

    // Act
    adminExternalLoginStateFilter.saveAdminUser(broadleafUser, user);

    // Assert
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    assertEquals("", user.getMainEntityName());
    assertEquals("", user.getName());
    assertEquals("iloveyou", user.getUnencodedPassword());
    assertEquals("janedoe", user.getLogin());
    assertNull(user.getEmail());
  }

  /**
   * Method under test:
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}
   */
  @Test
  public void testSaveAdminUser4() {
    // Arrange
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(new AdminUserImpl());
    BroadleafExternalAuthenticationUserDetails broadleafUser = mock(BroadleafExternalAuthenticationUserDetails.class);
    when(broadleafUser.getEmail()).thenReturn("jane.doe@example.org");
    when(broadleafUser.getFirstName()).thenReturn("Jane");
    when(broadleafUser.getLastName()).thenReturn("Doe");
    when(broadleafUser.getPassword()).thenReturn("iloveyou");
    when(broadleafUser.getUsername()).thenReturn("janedoe");
    when(broadleafUser.getAuthorities()).thenReturn(new ArrayList<>());
    AdminUserImpl user = new AdminUserImpl();

    // Act
    adminExternalLoginStateFilter.saveAdminUser(broadleafUser, user);

    // Assert
    verify(broadleafUser).getEmail();
    verify(broadleafUser, atLeast(1)).getFirstName();
    verify(broadleafUser, atLeast(1)).getLastName();
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(broadleafUser).getAuthorities();
    verify(broadleafUser).getPassword();
    verify(broadleafUser).getUsername();
    assertEquals("Jane Doe", user.getMainEntityName());
    assertEquals("Jane Doe", user.getName());
    assertEquals("iloveyou", user.getUnencodedPassword());
    assertEquals("jane.doe@example.org", user.getEmail());
    assertEquals("janedoe", user.getLogin());
  }

  /**
   * Method under test:
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}
   */
  @Test
  public void testSaveAdminUser5() {
    // Arrange
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(new AdminUserImpl());
    BroadleafExternalAuthenticationUserDetails broadleafUser = mock(BroadleafExternalAuthenticationUserDetails.class);
    when(broadleafUser.getEmail()).thenReturn("jane.doe@example.org");
    when(broadleafUser.getFirstName()).thenReturn(" ");
    when(broadleafUser.getLastName()).thenReturn("Doe");
    when(broadleafUser.getPassword()).thenReturn("iloveyou");
    when(broadleafUser.getUsername()).thenReturn("janedoe");
    when(broadleafUser.getAuthorities()).thenReturn(new ArrayList<>());
    AdminUserImpl user = new AdminUserImpl();

    // Act
    adminExternalLoginStateFilter.saveAdminUser(broadleafUser, user);

    // Assert
    verify(broadleafUser).getEmail();
    verify(broadleafUser, atLeast(1)).getFirstName();
    verify(broadleafUser, atLeast(1)).getLastName();
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(broadleafUser).getAuthorities();
    verify(broadleafUser).getPassword();
    verify(broadleafUser).getUsername();
    assertEquals("Doe", user.getMainEntityName());
    assertEquals("Doe", user.getName());
    assertEquals("iloveyou", user.getUnencodedPassword());
    assertEquals("jane.doe@example.org", user.getEmail());
    assertEquals("janedoe", user.getLogin());
  }

  /**
   * Method under test:
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}
   */
  @Test
  public void testSaveAdminUser6() {
    // Arrange
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(new AdminUserImpl());
    BroadleafExternalAuthenticationUserDetails broadleafUser = mock(BroadleafExternalAuthenticationUserDetails.class);
    when(broadleafUser.getEmail()).thenReturn("jane.doe@example.org");
    when(broadleafUser.getFirstName()).thenReturn("Jane");
    when(broadleafUser.getLastName()).thenReturn(" ");
    when(broadleafUser.getPassword()).thenReturn("iloveyou");
    when(broadleafUser.getUsername()).thenReturn("janedoe");
    when(broadleafUser.getAuthorities()).thenReturn(new ArrayList<>());
    AdminUserImpl user = new AdminUserImpl();

    // Act
    adminExternalLoginStateFilter.saveAdminUser(broadleafUser, user);

    // Assert
    verify(broadleafUser).getEmail();
    verify(broadleafUser, atLeast(1)).getFirstName();
    verify(broadleafUser, atLeast(1)).getLastName();
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(broadleafUser).getAuthorities();
    verify(broadleafUser).getPassword();
    verify(broadleafUser).getUsername();
    assertEquals("Jane ", user.getMainEntityName());
    assertEquals("Jane ", user.getName());
    assertEquals("iloveyou", user.getUnencodedPassword());
    assertEquals("jane.doe@example.org", user.getEmail());
    assertEquals("janedoe", user.getLogin());
  }

  /**
   * Method under test:
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}
   */
  @Test
  public void testSaveAdminUser7() {
    // Arrange
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any())).thenReturn(new AdminUserImpl());
    BroadleafExternalAuthenticationUserDetails broadleafUser = mock(BroadleafExternalAuthenticationUserDetails.class);
    when(broadleafUser.getEmail()).thenReturn("jane.doe@example.org");
    when(broadleafUser.getFirstName()).thenReturn("Jane");
    when(broadleafUser.getLastName()).thenReturn("Doe");
    when(broadleafUser.getPassword()).thenReturn(null);
    when(broadleafUser.getUsername()).thenReturn("janedoe");
    when(broadleafUser.getAuthorities()).thenReturn(new ArrayList<>());
    AdminUserImpl user = new AdminUserImpl();

    // Act
    adminExternalLoginStateFilter.saveAdminUser(broadleafUser, user);

    // Assert
    verify(broadleafUser).getEmail();
    verify(broadleafUser, atLeast(1)).getFirstName();
    verify(broadleafUser, atLeast(1)).getLastName();
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(broadleafUser).getAuthorities();
    verify(broadleafUser).getPassword();
    verify(broadleafUser).getUsername();
    assertEquals("Jane Doe", user.getMainEntityName());
    assertEquals("Jane Doe", user.getName());
    assertEquals("jane.doe@example.org", user.getEmail());
    assertEquals("janedoe", user.getLogin());
    assertEquals("janedoe", user.getUnencodedPassword());
  }
}
