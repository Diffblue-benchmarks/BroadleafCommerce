/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.security.ldap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.broadleafcommerce.common.security.BroadleafExternalAuthenticationUserDetails;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafActiveDirectoryUserDetailsMapper.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BroadleafActiveDirectoryUserDetailsMapperDiffblueTest {
  @Autowired
  private BroadleafActiveDirectoryUserDetailsMapper broadleafActiveDirectoryUserDetailsMapper;

  /**
   * Test {@link BroadleafActiveDirectoryUserDetailsMapper#mapUserFromContext(DirContextOperations, String, Collection)}.
   * <ul>
   *   <li>Then return Authorities Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafActiveDirectoryUserDetailsMapper#mapUserFromContext(DirContextOperations, String, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UserDetails BroadleafActiveDirectoryUserDetailsMapper.mapUserFromContext(DirContextOperations, String, Collection)"})
  public void testMapUserFromContext_thenReturnAuthoritiesEmpty() {
    // Arrange
    DirContextAdapter ctx = new DirContextAdapter();

    // Act
    UserDetails actualMapUserFromContextResult = broadleafActiveDirectoryUserDetailsMapper.mapUserFromContext(ctx,
        "janedoe", new ArrayList<>());

    // Assert
    Collection<? extends GrantedAuthority> authorities = actualMapUserFromContextResult.getAuthorities();
    assertTrue(authorities instanceof Set);
    assertTrue(actualMapUserFromContextResult instanceof BroadleafExternalAuthenticationUserDetails);
    assertEquals("janedoe", actualMapUserFromContextResult.getPassword());
    assertEquals("janedoe", actualMapUserFromContextResult.getUsername());
    assertNull(((BroadleafExternalAuthenticationUserDetails) actualMapUserFromContextResult).getEmail());
    assertNull(((BroadleafExternalAuthenticationUserDetails) actualMapUserFromContextResult).getFirstName());
    assertNull(((BroadleafExternalAuthenticationUserDetails) actualMapUserFromContextResult).getLastName());
    assertNull(((BroadleafExternalAuthenticationUserDetails) actualMapUserFromContextResult).getSite());
    assertTrue(authorities.isEmpty());
    assertTrue(actualMapUserFromContextResult.isAccountNonExpired());
    assertTrue(actualMapUserFromContextResult.isAccountNonLocked());
    assertTrue(actualMapUserFromContextResult.isCredentialsNonExpired());
    assertTrue(actualMapUserFromContextResult.isEnabled());
  }

  /**
   * Test new {@link BroadleafActiveDirectoryUserDetailsMapper} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BroadleafActiveDirectoryUserDetailsMapper}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafActiveDirectoryUserDetailsMapper.<init>()"})
  public void testNewBroadleafActiveDirectoryUserDetailsMapper() {
    // Arrange and Act
    BroadleafActiveDirectoryUserDetailsMapper actualBroadleafActiveDirectoryUserDetailsMapper = new BroadleafActiveDirectoryUserDetailsMapper();

    // Assert
    assertNull(actualBroadleafActiveDirectoryUserDetailsMapper.roleNameSubstitutions);
    assertFalse(actualBroadleafActiveDirectoryUserDetailsMapper.additiveRoleNameSubstitutions);
    assertTrue(actualBroadleafActiveDirectoryUserDetailsMapper.useEmailAddressAsUsername);
  }
}
