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
package org.broadleafcommerce.openadmin.server.security.external;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.broadleafcommerce.common.security.BroadleafExternalAuthenticationUserDetails;
import org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService;
import org.broadleafcommerce.openadmin.server.security.service.user.AdminUserDetails;
import org.broadleafcommerce.openadmin.server.security.service.user.AdminUserProvisioningService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafAdminLdapUserDetailsMapperDiffblueTest {
  @Mock
  private AdminSecurityService adminSecurityService;

  @Mock
  private AdminUserProvisioningService adminUserProvisioningService;

  @InjectMocks
  private BroadleafAdminLdapUserDetailsMapper broadleafAdminLdapUserDetailsMapper;

  /**
   * Test {@link BroadleafAdminLdapUserDetailsMapper#mapUserFromContext(DirContextOperations, String, Collection)}.
   * <p>
   * Method under test: {@link BroadleafAdminLdapUserDetailsMapper#mapUserFromContext(DirContextOperations, String, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UserDetails BroadleafAdminLdapUserDetailsMapper.mapUserFromContext(DirContextOperations, String, Collection)"})
  public void testMapUserFromContext() {
    // Arrange
    AdminUserDetails adminUserDetails = new AdminUserDetails(1L, "janedoe", "iloveyou", new ArrayList<>());

    when(adminUserProvisioningService.provisionAdminUser(Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(adminUserDetails);
    DirContextAdapter ctx = new DirContextAdapter();

    // Act
    UserDetails actualMapUserFromContextResult = broadleafAdminLdapUserDetailsMapper.mapUserFromContext(ctx, "janedoe",
        new ArrayList<>());

    // Assert
    verify(adminUserProvisioningService).provisionAdminUser(isA(BroadleafExternalAuthenticationUserDetails.class));
    assertSame(adminUserDetails, actualMapUserFromContextResult);
  }

  /**
   * Test {@link BroadleafAdminLdapUserDetailsMapper#mapUserFromContext(DirContextOperations, String, Collection)}.
   * <ul>
   *   <li>Given {@link SimpleGrantedAuthority#SimpleGrantedAuthority(String)} with {@code Role}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminLdapUserDetailsMapper#mapUserFromContext(DirContextOperations, String, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UserDetails BroadleafAdminLdapUserDetailsMapper.mapUserFromContext(DirContextOperations, String, Collection)"})
  public void testMapUserFromContext_givenSimpleGrantedAuthorityWithRole() {
    // Arrange
    AdminUserDetails adminUserDetails = new AdminUserDetails(1L, "janedoe", "iloveyou", new ArrayList<>());

    when(adminUserProvisioningService.provisionAdminUser(Mockito.<BroadleafExternalAuthenticationUserDetails>any()))
        .thenReturn(adminUserDetails);
    DirContextAdapter ctx = new DirContextAdapter();

    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    authorities.add(new SimpleGrantedAuthority("mail"));

    // Act
    UserDetails actualMapUserFromContextResult = broadleafAdminLdapUserDetailsMapper.mapUserFromContext(ctx, "janedoe",
        authorities);

    // Assert
    verify(adminUserProvisioningService).provisionAdminUser(isA(BroadleafExternalAuthenticationUserDetails.class));
    assertSame(adminUserDetails, actualMapUserFromContextResult);
  }

  /**
   * Test {@link BroadleafAdminLdapUserDetailsMapper#determineSite(DirContextOperations, String, Collection)}.
   * <ul>
   *   <li>Given {@link SimpleGrantedAuthority#SimpleGrantedAuthority(String)} with {@code Role}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminLdapUserDetailsMapper#determineSite(DirContextOperations, String, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.site.domain.Site BroadleafAdminLdapUserDetailsMapper.determineSite(DirContextOperations, String, Collection)"})
  public void testDetermineSite_givenSimpleGrantedAuthorityWithRole() {
    // Arrange
    DirContextAdapter ctx = new DirContextAdapter();

    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act and Assert
    assertNull(broadleafAdminLdapUserDetailsMapper.determineSite(ctx, "janedoe", authorities));
  }

  /**
   * Test {@link BroadleafAdminLdapUserDetailsMapper#determineSite(DirContextOperations, String, Collection)}.
   * <ul>
   *   <li>Given {@link SimpleGrantedAuthority#SimpleGrantedAuthority(String)} with {@code Role}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminLdapUserDetailsMapper#determineSite(DirContextOperations, String, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.site.domain.Site BroadleafAdminLdapUserDetailsMapper.determineSite(DirContextOperations, String, Collection)"})
  public void testDetermineSite_givenSimpleGrantedAuthorityWithRole2() {
    // Arrange
    DirContextAdapter ctx = new DirContextAdapter();

    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("Role"));
    authorities.add(new SimpleGrantedAuthority("Role"));

    // Act and Assert
    assertNull(broadleafAdminLdapUserDetailsMapper.determineSite(ctx, "janedoe", authorities));
  }

  /**
   * Test {@link BroadleafAdminLdapUserDetailsMapper#determineSite(DirContextOperations, String, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminLdapUserDetailsMapper#determineSite(DirContextOperations, String, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.site.domain.Site BroadleafAdminLdapUserDetailsMapper.determineSite(DirContextOperations, String, Collection)"})
  public void testDetermineSite_whenArrayList() {
    // Arrange
    DirContextAdapter ctx = new DirContextAdapter();

    // Act and Assert
    assertNull(broadleafAdminLdapUserDetailsMapper.determineSite(ctx, "janedoe", new ArrayList<>()));
  }

  /**
   * Test new {@link BroadleafAdminLdapUserDetailsMapper} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BroadleafAdminLdapUserDetailsMapper}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminLdapUserDetailsMapper.<init>()"})
  public void testNewBroadleafAdminLdapUserDetailsMapper() {
    // Arrange and Act
    BroadleafAdminLdapUserDetailsMapper actualBroadleafAdminLdapUserDetailsMapper = new BroadleafAdminLdapUserDetailsMapper();

    // Assert
    assertNull(actualBroadleafAdminLdapUserDetailsMapper.securityService);
    assertNull(actualBroadleafAdminLdapUserDetailsMapper.provisioningService);
  }
}
