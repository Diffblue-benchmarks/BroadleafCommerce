package org.broadleafcommerce.core.web.social;

import static org.mockito.Mockito.mock;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.support.OAuth1Connection;
import org.springframework.social.oauth1.GenericOAuth1ServiceProvider;
import org.springframework.social.oauth1.OAuth1Version;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class BroadleafSocialSignInAdapterDiffblueTest {
  @Autowired
  private BroadleafSocialSignInAdapter broadleafSocialSignInAdapter;

  /**
   * Test
   * {@link BroadleafSocialSignInAdapter#signIn(String, Connection, NativeWebRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafSocialSignInAdapter#signIn(String, Connection, NativeWebRequest)}
   */
  @Test
  @DisplayName("Test signIn(String, Connection, NativeWebRequest)")
  @Disabled("TODO: Complete this test")
  void testSignIn() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.social;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4994 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.social.BroadleafSocialSignInAdapter broadleafSocialSignInAdapter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BroadleafSocialSignInAdapter broadleafSocialSignInAdapter2 = new BroadleafSocialSignInAdapter();
    ConnectionData data = new ConnectionData("42", "42", "Display Name", "https://example.org/example",
        "https://example.org/example", "ABC123", "Secret", "ABC123", 1L);

    OAuth1Connection<?> connection = new OAuth1Connection<>(data,
        new GenericOAuth1ServiceProvider("Consumer Key", "Consumer Secret", "https://example.org/example",
            "https://example.org/example", "https://example.org/example", "https://example.org/example",
            OAuth1Version.CORE_10),
        mock(ApiAdapter.class));

    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    broadleafSocialSignInAdapter2.signIn("janedoe", connection,
        new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }
}
