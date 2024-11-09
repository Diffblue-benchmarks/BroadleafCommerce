/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.security.ldap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import javax.naming.NamingException;
import org.broadleafcommerce.common.security.BroadleafExternalAuthenticationUserDetails;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafActiveDirectoryUserDetailsMapper.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafActiveDirectoryUserDetailsMapperDiffblueTest {
  @Autowired
  private BroadleafActiveDirectoryUserDetailsMapper broadleafActiveDirectoryUserDetailsMapper;

  /**
   * Test
   * {@link BroadleafActiveDirectoryUserDetailsMapper#mapUserFromContext(DirContextOperations, String, Collection)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then calls
   * {@link DirContextAdapter#addAttributeValue(String, Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafActiveDirectoryUserDetailsMapper#mapUserFromContext(DirContextOperations, String, Collection)}
   */
  @Test
  public void testMapUserFromContext_givenNull_field_thenCallsAddAttributeValue() throws NamingException {
    // Arrange
    DirContextAdapter ctx = mock(DirContextAdapter.class);
    when(ctx.addToEnvironment(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);
    when(ctx.getObjectAttribute(Mockito.<String>any())).thenReturn(null);
    when(ctx.getNameInNamespace()).thenReturn("Name In Namespace");
    doNothing().when(ctx).addAttributeValue(Mockito.<String>any(), Mockito.<Object>any());
    ctx.addToEnvironment("Prop Name", BLCFieldUtils.NULL_FIELD);
    ctx.addAttributeValue("mail", BLCFieldUtils.NULL_FIELD);

    // Act
    UserDetails actualMapUserFromContextResult = broadleafActiveDirectoryUserDetailsMapper.mapUserFromContext(ctx,
        "janedoe", new ArrayList<>());

    // Assert
    verify(ctx).addAttributeValue(eq("mail"), isA(Object.class));
    verify(ctx).addToEnvironment(eq("Prop Name"), isA(Object.class));
    verify(ctx).getNameInNamespace();
    verify(ctx, atLeast(1)).getObjectAttribute(Mockito.<String>any());
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
   * Test
   * {@link BroadleafActiveDirectoryUserDetailsMapper#mapUserFromContext(DirContextOperations, String, Collection)}.
   * <ul>
   *   <li>When {@link DirContextAdapter#DirContextAdapter()}.</li>
   *   <li>Then Authorities return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafActiveDirectoryUserDetailsMapper#mapUserFromContext(DirContextOperations, String, Collection)}
   */
  @Test
  public void testMapUserFromContext_whenDirContextAdapter_thenAuthoritiesReturnSet() {
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
   * Test new {@link BroadleafActiveDirectoryUserDetailsMapper} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafActiveDirectoryUserDetailsMapper}
   */
  @Test
  public void testNewBroadleafActiveDirectoryUserDetailsMapper() {
    // Arrange and Act
    BroadleafActiveDirectoryUserDetailsMapper actualBroadleafActiveDirectoryUserDetailsMapper = new BroadleafActiveDirectoryUserDetailsMapper();

    // Assert
    assertNull(actualBroadleafActiveDirectoryUserDetailsMapper.roleNameSubstitutions);
    assertFalse(actualBroadleafActiveDirectoryUserDetailsMapper.additiveRoleNameSubstitutions);
    assertTrue(actualBroadleafActiveDirectoryUserDetailsMapper.useEmailAddressAsUsername);
  }
}
