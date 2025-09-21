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
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.security.BroadleafExternalAuthenticationUserDetails;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRole;
import org.broadleafcommerce.openadmin.server.security.domain.AdminRoleImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class AdminExternalLoginStateFilterDiffblueTest {
  @Autowired private AdminExternalLoginStateFilter adminExternalLoginStateFilter;

  @MockBean(name = "blAdminSecurityService")
  private AdminSecurityService adminSecurityService;

  @MockBean(name = "blEntityConfiguration")
  private EntityConfiguration entityConfiguration;

  /**
   * Test {@link AdminExternalLoginStateFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminExternalLoginStateFilter#doFilter(ServletRequest,
   * ServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminExternalLoginStateFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  public void testDoFilter_givenIOException_thenThrowIOException()
      throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse servletResponse = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new IOException())
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> adminExternalLoginStateFilter.doFilter(servletRequest, servletResponse, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link AdminExternalLoginStateFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminExternalLoginStateFilter#doFilter(ServletRequest,
   * ServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminExternalLoginStateFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  public void testDoFilter_thenCallsDoFilter() throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse servletResponse = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    adminExternalLoginStateFilter.doFilter(servletRequest, servletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link
   * AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails,
   * AdminUser)}.
   *
   * <p>Method under test: {@link
   * AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails,
   * AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminExternalLoginStateFilter.saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)"
  })
  public void testSaveAdminUser() {
    // Arrange
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any()))
        .thenReturn(new AdminUserImpl());
    BroadleafExternalAuthenticationUserDetails broadleafUser =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());
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
  }

  /**
   * Test {@link
   * AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails,
   * AdminUser)}.
   *
   * <p>Method under test: {@link
   * AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails,
   * AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminExternalLoginStateFilter.saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)"
  })
  public void testSaveAdminUser2() {
    // Arrange
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any()))
        .thenReturn(new AdminUserImpl());

    BroadleafExternalAuthenticationUserDetails broadleafUser =
        mock(BroadleafExternalAuthenticationUserDetails.class);
    when(broadleafUser.getFirstName()).thenReturn("");
    when(broadleafUser.getLastName()).thenReturn(null);
    when(broadleafUser.getEmail()).thenReturn("jane.doe@example.org");
    when(broadleafUser.getPassword()).thenReturn("iloveyou");
    when(broadleafUser.getUsername()).thenReturn("janedoe");
    when(broadleafUser.getAuthorities()).thenReturn(new ArrayList<>());

    AdminUser user = mock(AdminUser.class);
    doNothing().when(user).setAllRoles(Mockito.<Set<AdminRole>>any());
    when(user.getUnencodedPassword()).thenReturn(null);
    when(user.getAllRoles()).thenReturn(null);
    when(user.getLogin()).thenReturn("Login");
    doNothing().when(user).setEmail(Mockito.<String>any());
    doNothing().when(user).setLogin(Mockito.<String>any());
    doNothing().when(user).setName(Mockito.<String>any());
    doNothing().when(user).setUnencodedPassword(Mockito.<String>any());

    // Act
    adminExternalLoginStateFilter.saveAdminUser(broadleafUser, user);

    // Assert
    verify(broadleafUser).getEmail();
    verify(broadleafUser, atLeast(1)).getFirstName();
    verify(broadleafUser).getLastName();
    verify(user).getAllRoles();
    verify(user).getLogin();
    verify(user).getUnencodedPassword();
    verify(user).setAllRoles(isA(Set.class));
    verify(user).setEmail("jane.doe@example.org");
    verify(user).setLogin("janedoe");
    verify(user).setName("");
    verify(user, atLeast(1)).setUnencodedPassword(Mockito.<String>any());
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(broadleafUser).getAuthorities();
    verify(broadleafUser).getPassword();
    verify(broadleafUser).getUsername();
  }

  /**
   * Test {@link
   * AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails,
   * AdminUser)}.
   *
   * <p>Method under test: {@link
   * AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails,
   * AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminExternalLoginStateFilter.saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)"
  })
  public void testSaveAdminUser3() {
    // Arrange
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any()))
        .thenReturn(new AdminUserImpl());

    BroadleafExternalAuthenticationUserDetails broadleafUser =
        mock(BroadleafExternalAuthenticationUserDetails.class);
    when(broadleafUser.getFirstName()).thenReturn(null);
    when(broadleafUser.getLastName()).thenReturn("");
    when(broadleafUser.getEmail()).thenReturn("jane.doe@example.org");
    when(broadleafUser.getPassword()).thenReturn("iloveyou");
    when(broadleafUser.getUsername()).thenReturn("janedoe");
    when(broadleafUser.getAuthorities()).thenReturn(new ArrayList<>());

    AdminUser user = mock(AdminUser.class);
    doNothing().when(user).setAllRoles(Mockito.<Set<AdminRole>>any());
    when(user.getUnencodedPassword()).thenReturn(null);
    when(user.getAllRoles()).thenReturn(null);
    when(user.getLogin()).thenReturn("Login");
    doNothing().when(user).setEmail(Mockito.<String>any());
    doNothing().when(user).setLogin(Mockito.<String>any());
    doNothing().when(user).setName(Mockito.<String>any());
    doNothing().when(user).setUnencodedPassword(Mockito.<String>any());

    // Act
    adminExternalLoginStateFilter.saveAdminUser(broadleafUser, user);

    // Assert
    verify(broadleafUser).getEmail();
    verify(broadleafUser).getFirstName();
    verify(broadleafUser, atLeast(1)).getLastName();
    verify(user).getAllRoles();
    verify(user).getLogin();
    verify(user).getUnencodedPassword();
    verify(user).setAllRoles(isA(Set.class));
    verify(user).setEmail("jane.doe@example.org");
    verify(user).setLogin("janedoe");
    verify(user).setName("");
    verify(user, atLeast(1)).setUnencodedPassword(Mockito.<String>any());
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(broadleafUser).getAuthorities();
    verify(broadleafUser).getPassword();
    verify(broadleafUser).getUsername();
  }

  /**
   * Test {@link
   * AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails,
   * AdminUser)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminRoleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails,
   * AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminExternalLoginStateFilter.saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)"
  })
  public void testSaveAdminUser_givenArrayListAddAdminRoleImpl() {
    // Arrange
    ArrayList<AdminRole> adminRoleList = new ArrayList<>();
    adminRoleList.add(new AdminRoleImpl());
    when(adminSecurityService.readAllAdminRoles()).thenReturn(adminRoleList);
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any()))
        .thenReturn(new AdminUserImpl());
    BroadleafExternalAuthenticationUserDetails broadleafUser =
        new BroadleafExternalAuthenticationUserDetails("janedoe", "iloveyou", new ArrayList<>());
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
  }

  /**
   * Test {@link
   * AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails,
   * AdminUser)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       SimpleGrantedAuthority#SimpleGrantedAuthority(String)} with {@code Role}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails,
   * AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminExternalLoginStateFilter.saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)"
  })
  public void testSaveAdminUser_givenArrayListAddSimpleGrantedAuthorityWithRole() {
    // Arrange
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any()))
        .thenReturn(new AdminUserImpl());

    ArrayList<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
    grantedAuthorityList.add(new SimpleGrantedAuthority("Role"));

    BroadleafExternalAuthenticationUserDetails broadleafUser =
        mock(BroadleafExternalAuthenticationUserDetails.class);
    when(broadleafUser.getFirstName()).thenReturn(null);
    when(broadleafUser.getLastName()).thenReturn(null);
    when(broadleafUser.getEmail()).thenReturn("jane.doe@example.org");
    when(broadleafUser.getPassword()).thenReturn("iloveyou");
    when(broadleafUser.getUsername()).thenReturn("janedoe");
    when(broadleafUser.getAuthorities()).thenReturn(grantedAuthorityList);
    AdminUserImpl user = new AdminUserImpl();

    // Act
    adminExternalLoginStateFilter.saveAdminUser(broadleafUser, user);

    // Assert
    verify(broadleafUser).getEmail();
    verify(broadleafUser).getFirstName();
    verify(broadleafUser).getLastName();
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(broadleafUser).getAuthorities();
    verify(broadleafUser).getPassword();
    verify(broadleafUser).getUsername();
    assertEquals("", user.getMainEntityName());
    assertEquals("", user.getName());
    assertEquals("iloveyou", user.getUnencodedPassword());
    assertEquals("jane.doe@example.org", user.getEmail());
    assertEquals("janedoe", user.getLogin());
  }

  /**
   * Test {@link
   * AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails,
   * AdminUser)}.
   *
   * <ul>
   *   <li>Given {@code Jane}.
   *   <li>Then {@link AdminUserImpl} (default constructor) MainEntityName is {@code Jane Doe}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails,
   * AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminExternalLoginStateFilter.saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)"
  })
  public void testSaveAdminUser_givenJane_thenAdminUserImplMainEntityNameIsJaneDoe() {
    // Arrange
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any()))
        .thenReturn(new AdminUserImpl());

    BroadleafExternalAuthenticationUserDetails broadleafUser =
        mock(BroadleafExternalAuthenticationUserDetails.class);
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
   * Test {@link
   * AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails,
   * AdminUser)}.
   *
   * <ul>
   *   <li>Given {@code Login}.
   *   <li>Then calls {@link AdminUser#getAllRoles()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails,
   * AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminExternalLoginStateFilter.saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)"
  })
  public void testSaveAdminUser_givenLogin_thenCallsGetAllRoles() {
    // Arrange
    when(adminSecurityService.readAllAdminRoles()).thenReturn(new ArrayList<>());
    when(adminSecurityService.saveAdminUser(Mockito.<AdminUser>any()))
        .thenReturn(new AdminUserImpl());

    BroadleafExternalAuthenticationUserDetails broadleafUser =
        mock(BroadleafExternalAuthenticationUserDetails.class);
    when(broadleafUser.getFirstName()).thenReturn(null);
    when(broadleafUser.getLastName()).thenReturn(null);
    when(broadleafUser.getEmail()).thenReturn("jane.doe@example.org");
    when(broadleafUser.getPassword()).thenReturn("iloveyou");
    when(broadleafUser.getUsername()).thenReturn("janedoe");
    when(broadleafUser.getAuthorities()).thenReturn(new ArrayList<>());

    AdminUser user = mock(AdminUser.class);
    doNothing().when(user).setAllRoles(Mockito.<Set<AdminRole>>any());
    when(user.getUnencodedPassword()).thenReturn(null);
    when(user.getAllRoles()).thenReturn(null);
    when(user.getLogin()).thenReturn("Login");
    doNothing().when(user).setEmail(Mockito.<String>any());
    doNothing().when(user).setLogin(Mockito.<String>any());
    doNothing().when(user).setName(Mockito.<String>any());
    doNothing().when(user).setUnencodedPassword(Mockito.<String>any());

    // Act
    adminExternalLoginStateFilter.saveAdminUser(broadleafUser, user);

    // Assert
    verify(broadleafUser).getEmail();
    verify(broadleafUser).getFirstName();
    verify(broadleafUser).getLastName();
    verify(user).getAllRoles();
    verify(user).getLogin();
    verify(user).getUnencodedPassword();
    verify(user).setAllRoles(isA(Set.class));
    verify(user).setEmail("jane.doe@example.org");
    verify(user).setLogin("janedoe");
    verify(user).setName("");
    verify(user, atLeast(1)).setUnencodedPassword(Mockito.<String>any());
    verify(adminSecurityService).readAllAdminRoles();
    verify(adminSecurityService).saveAdminUser(isA(AdminUser.class));
    verify(broadleafUser).getAuthorities();
    verify(broadleafUser).getPassword();
    verify(broadleafUser).getUsername();
  }
}
