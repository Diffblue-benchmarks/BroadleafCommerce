package org.broadleafcommerce.common.security.ldap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafActiveDirectoryUserDetailsMapperDiffblueTest {
  @Autowired
  private BroadleafActiveDirectoryUserDetailsMapper broadleafActiveDirectoryUserDetailsMapper;

  /**
   * Test {@link BroadleafActiveDirectoryUserDetailsMapper#mapUserFromContext(DirContextOperations,
   * String, Collection)}.
   *
   * <ul>
   *   <li>Then return Authorities Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafActiveDirectoryUserDetailsMapper#mapUserFromContext(DirContextOperations, String,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserDetails BroadleafActiveDirectoryUserDetailsMapper.mapUserFromContext(DirContextOperations, String, Collection)"
  })
  public void testMapUserFromContext_thenReturnAuthoritiesEmpty() {
    // Arrange
    DirContextAdapter ctx = new DirContextAdapter();

    // Act
    UserDetails actualMapUserFromContextResult =
        broadleafActiveDirectoryUserDetailsMapper.mapUserFromContext(
            ctx, "janedoe", new ArrayList<>());

    // Assert
    Collection<? extends GrantedAuthority> authorities =
        actualMapUserFromContextResult.getAuthorities();
    assertTrue(authorities instanceof Set);
    assertTrue(
        actualMapUserFromContextResult instanceof BroadleafExternalAuthenticationUserDetails);
    assertEquals("janedoe", actualMapUserFromContextResult.getPassword());
    assertEquals("janedoe", actualMapUserFromContextResult.getUsername());
    assertNull(
        ((BroadleafExternalAuthenticationUserDetails) actualMapUserFromContextResult).getEmail());
    assertNull(
        ((BroadleafExternalAuthenticationUserDetails) actualMapUserFromContextResult)
            .getFirstName());
    assertNull(
        ((BroadleafExternalAuthenticationUserDetails) actualMapUserFromContextResult)
            .getLastName());
    assertNull(
        ((BroadleafExternalAuthenticationUserDetails) actualMapUserFromContextResult).getSite());
    assertTrue(authorities.isEmpty());
    assertTrue(actualMapUserFromContextResult.isAccountNonExpired());
    assertTrue(actualMapUserFromContextResult.isAccountNonLocked());
    assertTrue(actualMapUserFromContextResult.isCredentialsNonExpired());
    assertTrue(actualMapUserFromContextResult.isEnabled());
  }

  /**
   * Test new {@link BroadleafActiveDirectoryUserDetailsMapper} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * BroadleafActiveDirectoryUserDetailsMapper}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafActiveDirectoryUserDetailsMapper.<init>()"})
  public void testNewBroadleafActiveDirectoryUserDetailsMapper() {
    // Arrange and Act
    BroadleafActiveDirectoryUserDetailsMapper actualBroadleafActiveDirectoryUserDetailsMapper =
        new BroadleafActiveDirectoryUserDetailsMapper();

    // Assert
    assertNull(actualBroadleafActiveDirectoryUserDetailsMapper.roleNameSubstitutions);
    assertFalse(actualBroadleafActiveDirectoryUserDetailsMapper.additiveRoleNameSubstitutions);
    assertTrue(actualBroadleafActiveDirectoryUserDetailsMapper.useEmailAddressAsUsername);
  }
}
