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
   * Test
   * {@link AdminExternalLoginStateFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then calls
   * {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminExternalLoginStateFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter_thenCallsDoFilter() throws IOException, ServletException {
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
   * Test
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminRoleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}
   */
  @Test
  public void testSaveAdminUser_givenArrayListAddAdminRoleImpl() {
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
    assertNull(user.getEmail());
  }

  /**
   * Test
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}.
   * <ul>
   *   <li>Given {@code Jane}.</li>
   *   <li>Then {@link AdminUserImpl} (default constructor) MainEntityName is
   * {@code Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}
   */
  @Test
  public void testSaveAdminUser_givenJane_thenAdminUserImplMainEntityNameIsJaneDoe() {
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
  }

  /**
   * Test
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link AdminUserImpl} (default constructor) UnencodedPassword is
   * {@code janedoe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}
   */
  @Test
  public void testSaveAdminUser_givenNull_thenAdminUserImplUnencodedPasswordIsJanedoe() {
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
    assertEquals("janedoe", user.getUnencodedPassword());
  }

  /**
   * Test
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}.
   * <ul>
   *   <li>Given {@link SimpleGrantedAuthority#SimpleGrantedAuthority(String)} with
   * {@code Role}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}
   */
  @Test
  public void testSaveAdminUser_givenSimpleGrantedAuthorityWithRole() {
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
    assertNull(user.getEmail());
  }

  /**
   * Test
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}.
   * <ul>
   *   <li>Then {@link AdminUserImpl} (default constructor) MainEntityName is
   * {@code Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}
   */
  @Test
  public void testSaveAdminUser_thenAdminUserImplMainEntityNameIsDoe() {
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
  }

  /**
   * Test
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}.
   * <ul>
   *   <li>Then {@link AdminUserImpl} (default constructor) MainEntityName is empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}
   */
  @Test
  public void testSaveAdminUser_thenAdminUserImplMainEntityNameIsEmptyString() {
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
    assertNull(user.getEmail());
  }

  /**
   * Test
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}.
   * <ul>
   *   <li>Then {@link AdminUserImpl} (default constructor) MainEntityName is
   * {@code Jane}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminExternalLoginStateFilter#saveAdminUser(BroadleafExternalAuthenticationUserDetails, AdminUser)}
   */
  @Test
  public void testSaveAdminUser_thenAdminUserImplMainEntityNameIsJane() {
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
  }
}
