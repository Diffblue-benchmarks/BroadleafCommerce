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
package org.broadleafcommerce.openadmin.server.security.external;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class BroadleafAdminLdapUserDetailsMapperDiffblueTest {
  /**
   * Test
   * {@link BroadleafAdminLdapUserDetailsMapper#determineSite(DirContextOperations, String, Collection)}.
   * <ul>
   *   <li>Given {@link SimpleGrantedAuthority#SimpleGrantedAuthority(String)} with
   * {@code Role}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAdminLdapUserDetailsMapper#determineSite(DirContextOperations, String, Collection)}
   */
  @Test
  public void testDetermineSite_givenSimpleGrantedAuthorityWithRole() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminLdapUserDetailsMapper broadleafAdminLdapUserDetailsMapper = new BroadleafAdminLdapUserDetailsMapper();
    DirContextAdapter ctx = new DirContextAdapter();

    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act and Assert
    assertNull(broadleafAdminLdapUserDetailsMapper.determineSite(ctx, "janedoe", authorities));
  }

  /**
   * Test
   * {@link BroadleafAdminLdapUserDetailsMapper#determineSite(DirContextOperations, String, Collection)}.
   * <ul>
   *   <li>Given {@link SimpleGrantedAuthority#SimpleGrantedAuthority(String)} with
   * {@code Role}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAdminLdapUserDetailsMapper#determineSite(DirContextOperations, String, Collection)}
   */
  @Test
  public void testDetermineSite_givenSimpleGrantedAuthorityWithRole2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminLdapUserDetailsMapper broadleafAdminLdapUserDetailsMapper = new BroadleafAdminLdapUserDetailsMapper();
    DirContextAdapter ctx = new DirContextAdapter();

    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act and Assert
    assertNull(broadleafAdminLdapUserDetailsMapper.determineSite(ctx, "janedoe", authorities));
  }

  /**
   * Test
   * {@link BroadleafAdminLdapUserDetailsMapper#determineSite(DirContextOperations, String, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAdminLdapUserDetailsMapper#determineSite(DirContextOperations, String, Collection)}
   */
  @Test
  public void testDetermineSite_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminLdapUserDetailsMapper broadleafAdminLdapUserDetailsMapper = new BroadleafAdminLdapUserDetailsMapper();
    DirContextAdapter ctx = new DirContextAdapter();

    // Act and Assert
    assertNull(broadleafAdminLdapUserDetailsMapper.determineSite(ctx, "janedoe", new ArrayList<>()));
  }

  /**
   * Test
   * {@link BroadleafAdminLdapUserDetailsMapper#determineSite(DirContextOperations, String, Collection)}.
   * <ul>
   *   <li>When {@link DirContextAdapter}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAdminLdapUserDetailsMapper#determineSite(DirContextOperations, String, Collection)}
   */
  @Test
  public void testDetermineSite_whenDirContextAdapter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminLdapUserDetailsMapper broadleafAdminLdapUserDetailsMapper = new BroadleafAdminLdapUserDetailsMapper();
    DirContextAdapter ctx = mock(DirContextAdapter.class);

    // Act and Assert
    assertNull(broadleafAdminLdapUserDetailsMapper.determineSite(ctx, "janedoe", new ArrayList<>()));
  }

  /**
   * Test new {@link BroadleafAdminLdapUserDetailsMapper} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafAdminLdapUserDetailsMapper}
   */
  @Test
  public void testNewBroadleafAdminLdapUserDetailsMapper() {
    // Arrange and Act
    BroadleafAdminLdapUserDetailsMapper actualBroadleafAdminLdapUserDetailsMapper = new BroadleafAdminLdapUserDetailsMapper();

    // Assert
    assertNull(actualBroadleafAdminLdapUserDetailsMapper.securityService);
    assertNull(actualBroadleafAdminLdapUserDetailsMapper.provisioningService);
  }
}
