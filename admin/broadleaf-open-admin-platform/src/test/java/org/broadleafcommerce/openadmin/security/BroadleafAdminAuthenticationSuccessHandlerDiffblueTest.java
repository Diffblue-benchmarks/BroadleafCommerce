package org.broadleafcommerce.openadmin.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.security.LocalRedirectStrategy;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafAdminAuthenticationSuccessHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafAdminAuthenticationSuccessHandlerDiffblueTest {
  @Autowired
  private BroadleafAdminAuthenticationSuccessHandler broadleafAdminAuthenticationSuccessHandler;

  @MockBean
  private SecurityVerifier securityVerifier;

  /**
   * Test
   * {@link BroadleafAdminAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
   * with {@code request}, {@code response}, {@code authentication}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOnAuthenticationSuccessWithRequestResponseAuthentication() throws IOException, ServletException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.openadmin.security.BroadleafAdminAuthenticationSuccessHandler.onAuthenticationSuccess(BroadleafAdminAuthenticationSuccessHandler.java:54)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BroadleafAdminAuthenticationSuccessHandler broadleafAdminAuthenticationSuccessHandler = new BroadleafAdminAuthenticationSuccessHandler();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationSuccessHandler.onAuthenticationSuccess(request, response,
        new TestingAuthenticationToken("Principal", "Credentials"));
  }

  /**
   * Test
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}
   */
  @Test
  public void testRemoveLoginSegment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminAuthenticationSuccessHandler broadleafAdminAuthenticationSuccessHandler = new BroadleafAdminAuthenticationSuccessHandler();
    broadleafAdminAuthenticationSuccessHandler.setRedirectStrategy(mock(LocalRedirectStrategy.class));

    // Act and Assert
    assertEquals("https://example.org/example",
        broadleafAdminAuthenticationSuccessHandler.removeLoginSegment("https://example.org/example"));
  }

  /**
   * Test
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveLoginSegment2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.security;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.security.BroadleafAdminAuthenticationSuccessHandler.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass319 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.security.BroadleafAdminAuthenticationSuccessHandler broadleafAdminAuthenticationSuccessHandler;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    broadleafAdminAuthenticationSuccessHandler.removeLoginSegment("https://example.org/example");
  }

  /**
   * Test
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}
   */
  @Test
  public void testRemoveLoginSegment_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("https://example.org/example",
        (new BroadleafAdminAuthenticationSuccessHandler()).removeLoginSegment("https://example.org/example"));
  }

  /**
   * Test
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}.
   * <ul>
   *   <li>When {@code /login}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}
   */
  @Test
  public void testRemoveLoginSegment_whenLogin_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new BroadleafAdminAuthenticationSuccessHandler()).removeLoginSegment("/login"));
  }

  /**
   * Test
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}
   */
  @Test
  public void testRemoveLoginSegment_whenNull_thenReturnSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/", (new BroadleafAdminAuthenticationSuccessHandler()).removeLoginSegment(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafAdminAuthenticationSuccessHandler#setLoginUri(String)}
   *   <li>{@link BroadleafAdminAuthenticationSuccessHandler#getLoginUri()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BroadleafAdminAuthenticationSuccessHandler broadleafAdminAuthenticationSuccessHandler = new BroadleafAdminAuthenticationSuccessHandler();

    // Act
    broadleafAdminAuthenticationSuccessHandler.setLoginUri("Login Uri");

    // Assert that nothing has changed
    assertEquals("Login Uri", broadleafAdminAuthenticationSuccessHandler.getLoginUri());
  }

  /**
   * Test new {@link BroadleafAdminAuthenticationSuccessHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafAdminAuthenticationSuccessHandler}
   */
  @Test
  public void testNewBroadleafAdminAuthenticationSuccessHandler() {
    // Arrange and Act
    BroadleafAdminAuthenticationSuccessHandler actualBroadleafAdminAuthenticationSuccessHandler = new BroadleafAdminAuthenticationSuccessHandler();

    // Assert
    assertEquals("/login", actualBroadleafAdminAuthenticationSuccessHandler.getLoginUri());
    assertNull(actualBroadleafAdminAuthenticationSuccessHandler.adminRemoteSecurityService);
  }
}
