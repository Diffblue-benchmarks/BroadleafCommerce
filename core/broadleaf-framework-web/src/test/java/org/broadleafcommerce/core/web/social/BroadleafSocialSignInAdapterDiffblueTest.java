package org.broadleafcommerce.core.web.social;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
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

@RunWith(MockitoJUnitRunner.class)
public class BroadleafSocialSignInAdapterDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafSocialSignInAdapter.signIn(String, Connection, NativeWebRequest)"
  })
  public void testSignIn_thenReturnNull() throws UsernameNotFoundException {
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

    // Act
    String actualSignInResult =
        broadleafSocialSignInAdapter.signIn(
            "janedoe", connection, new ServletWebRequest(new MockHttpServletRequest()));

    // Assert
    verify(userDetailsService).loadUserByUsername("janedoe");
    assertNull(actualSignInResult);
  }
}
