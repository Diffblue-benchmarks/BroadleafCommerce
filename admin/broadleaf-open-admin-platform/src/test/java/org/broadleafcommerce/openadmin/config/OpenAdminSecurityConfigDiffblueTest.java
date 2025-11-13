package org.broadleafcommerce.openadmin.config;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.security.crypto.password.PasswordEncoder;

@RunWith(MockitoJUnitRunner.class)
public class OpenAdminSecurityConfigDiffblueTest {
  @InjectMocks private OpenAdminSecurityConfig openAdminSecurityConfig;

  @Mock private PasswordEncoder passwordEncoder;

  /**
   * Test {@link OpenAdminSecurityConfig#blAdminAuthenticationProvider()}.
   *
   * <p>Method under test: {@link OpenAdminSecurityConfig#blAdminAuthenticationProvider()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AuthenticationProvider OpenAdminSecurityConfig.blAdminAuthenticationProvider()"
  })
  public void testBlAdminAuthenticationProvider() {
    // Arrange and Act
    AuthenticationProvider actualBlAdminAuthenticationProviderResult =
        openAdminSecurityConfig.blAdminAuthenticationProvider();

    // Assert
    assertTrue(actualBlAdminAuthenticationProviderResult instanceof DaoAuthenticationProvider);
    assertTrue(
        ((DaoAuthenticationProvider) actualBlAdminAuthenticationProviderResult).getUserCache()
            instanceof NullUserCache);
    assertFalse(
        ((DaoAuthenticationProvider) actualBlAdminAuthenticationProviderResult)
            .isForcePrincipalAsString());
    assertTrue(
        ((DaoAuthenticationProvider) actualBlAdminAuthenticationProviderResult)
            .isHideUserNotFoundExceptions());
  }
}
