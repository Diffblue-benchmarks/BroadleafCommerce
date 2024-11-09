/*-
 * #%L
 * BroadleafCommerce Profile
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
package org.broadleafcommerce.profile.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.profile.core.domain.CustomerRole;
import org.broadleafcommerce.profile.core.domain.CustomerRoleImpl;
import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserDetailsServiceImplDiffblueTest {
  /**
   * Test {@link UserDetailsServiceImpl#createGrantedAuthorities(List)}.
   * <ul>
   *   <li>Given {@link CustomerRoleImpl} {@link CustomerRoleImpl#getRoleName()}
   * return {@code ROLE_USER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserDetailsServiceImpl#createGrantedAuthorities(List)}
   */
  @Test
  public void testCreateGrantedAuthorities_givenCustomerRoleImplGetRoleNameReturnRoleUser() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserDetailsServiceImpl userDetailsServiceImpl = new UserDetailsServiceImpl();
    CustomerRoleImpl customerRoleImpl = mock(CustomerRoleImpl.class);
    when(customerRoleImpl.getRoleName()).thenReturn("ROLE_USER");

    ArrayList<CustomerRole> customerRoles = new ArrayList<>();
    customerRoles.add(customerRoleImpl);

    // Act
    List<GrantedAuthority> actualCreateGrantedAuthoritiesResult = userDetailsServiceImpl
        .createGrantedAuthorities(customerRoles);

    // Assert
    verify(customerRoleImpl, atLeast(1)).getRoleName();
    assertEquals(1, actualCreateGrantedAuthoritiesResult.size());
    GrantedAuthority getResult = actualCreateGrantedAuthoritiesResult.get(0);
    assertTrue(getResult instanceof SimpleGrantedAuthority);
    assertEquals("ROLE_USER", getResult.toString());
    assertEquals("ROLE_USER", getResult.getAuthority());
  }

  /**
   * Test {@link UserDetailsServiceImpl#createGrantedAuthorities(List)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserDetailsServiceImpl#createGrantedAuthorities(List)}
   */
  @Test
  public void testCreateGrantedAuthorities_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserDetailsServiceImpl userDetailsServiceImpl = new UserDetailsServiceImpl();
    CustomerRoleImpl customerRoleImpl = mock(CustomerRoleImpl.class);
    when(customerRoleImpl.getRoleName()).thenReturn("Role Name");

    ArrayList<CustomerRole> customerRoles = new ArrayList<>();
    customerRoles.add(customerRoleImpl);

    // Act
    List<GrantedAuthority> actualCreateGrantedAuthoritiesResult = userDetailsServiceImpl
        .createGrantedAuthorities(customerRoles);

    // Assert
    verify(customerRoleImpl, atLeast(1)).getRoleName();
    assertEquals(2, actualCreateGrantedAuthoritiesResult.size());
    GrantedAuthority getResult = actualCreateGrantedAuthoritiesResult.get(0);
    assertTrue(getResult instanceof SimpleGrantedAuthority);
    GrantedAuthority getResult2 = actualCreateGrantedAuthoritiesResult.get(1);
    assertTrue(getResult2 instanceof SimpleGrantedAuthority);
    assertEquals("ROLE_USER", getResult2.toString());
    assertEquals("ROLE_USER", getResult2.getAuthority());
    assertEquals("Role Name", getResult.toString());
    assertEquals("Role Name", getResult.getAuthority());
  }

  /**
   * Test {@link UserDetailsServiceImpl#createGrantedAuthorities(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserDetailsServiceImpl#createGrantedAuthorities(List)}
   */
  @Test
  public void testCreateGrantedAuthorities_whenArrayList_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserDetailsServiceImpl userDetailsServiceImpl = new UserDetailsServiceImpl();

    // Act
    List<GrantedAuthority> actualCreateGrantedAuthoritiesResult = userDetailsServiceImpl
        .createGrantedAuthorities(new ArrayList<>());

    // Assert
    assertEquals(1, actualCreateGrantedAuthoritiesResult.size());
    GrantedAuthority getResult = actualCreateGrantedAuthoritiesResult.get(0);
    assertTrue(getResult instanceof SimpleGrantedAuthority);
    assertEquals("ROLE_USER", getResult.toString());
    assertEquals("ROLE_USER", getResult.getAuthority());
  }
}
