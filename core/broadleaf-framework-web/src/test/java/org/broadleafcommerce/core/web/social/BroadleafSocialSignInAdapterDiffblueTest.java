/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.social;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.ldap.userdetails.InetOrgPerson;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.support.OAuth1Connection;
import org.springframework.social.oauth1.GenericOAuth1ServiceProvider;
import org.springframework.social.oauth1.OAuth1Version;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;

@ExtendWith(MockitoExtension.class)
class BroadleafSocialSignInAdapterDiffblueTest {
  @InjectMocks private BroadleafSocialSignInAdapter broadleafSocialSignInAdapter;

  @Mock private UserDetailsService userDetailsService;

  /**
   * Test {@link BroadleafSocialSignInAdapter#signIn(String, Connection, NativeWebRequest)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafSocialSignInAdapter#signIn(String, Connection,
   * NativeWebRequest)}
   */
  @Test
  @DisplayName("Test signIn(String, Connection, NativeWebRequest); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafSocialSignInAdapter.signIn(String, Connection, NativeWebRequest)"
  })
  void testSignIn_thenReturnNull() throws UsernameNotFoundException {
    // Arrange
    when(userDetailsService.loadUserByUsername(Mockito.<String>any()))
        .thenReturn(new InetOrgPerson());
    ConnectionData data =
        new ConnectionData(
            "42",
            "42",
            "Display Name",
            "https://example.org/example",
            "https://example.org/example",
            "ABC123",
            "Secret",
            "ABC123",
            1L);
    GenericOAuth1ServiceProvider serviceProvider =
        new GenericOAuth1ServiceProvider(
            "Consumer Key",
            "Consumer Secret",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            OAuth1Version.CORE_10);

    OAuth1Connection<?> connection =
        new OAuth1Connection<>(data, serviceProvider, mock(ApiAdapter.class));
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act
    String actualSignInResult =
        broadleafSocialSignInAdapter.signIn("janedoe", connection, new ServletWebRequest(request));

    // Assert
    verify(userDetailsService).loadUserByUsername("janedoe");
    assertNull(actualSignInResult);
  }
}
