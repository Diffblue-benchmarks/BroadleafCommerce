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
package org.broadleafcommerce.openadmin.config;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
  @InjectMocks
  private OpenAdminSecurityConfig openAdminSecurityConfig;

  @Mock
  private PasswordEncoder passwordEncoder;

  /**
   * Test {@link OpenAdminSecurityConfig#blAdminAuthenticationProvider()}.
   * <p>
   * Method under test: {@link OpenAdminSecurityConfig#blAdminAuthenticationProvider()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationProvider OpenAdminSecurityConfig.blAdminAuthenticationProvider()"})
  public void testBlAdminAuthenticationProvider() {
    // Arrange and Act
    AuthenticationProvider actualBlAdminAuthenticationProviderResult = openAdminSecurityConfig
        .blAdminAuthenticationProvider();

    // Assert
    assertTrue(actualBlAdminAuthenticationProviderResult instanceof DaoAuthenticationProvider);
    assertTrue(((DaoAuthenticationProvider) actualBlAdminAuthenticationProviderResult)
        .getUserCache() instanceof NullUserCache);
    assertFalse(((DaoAuthenticationProvider) actualBlAdminAuthenticationProviderResult).isForcePrincipalAsString());
    assertTrue(((DaoAuthenticationProvider) actualBlAdminAuthenticationProviderResult).isHideUserNotFoundExceptions());
  }
}
