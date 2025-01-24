package org.broadleafcommerce.openadmin.security;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafAdminAuthenticationFailureHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafAdminAuthenticationFailureHandlerDiffblueTest {
  @Autowired
  private BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler;

  /**
   * Test
   * {@link BroadleafAdminAuthenticationFailureHandler#BroadleafAdminAuthenticationFailureHandler()}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminAuthenticationFailureHandler#BroadleafAdminAuthenticationFailureHandler()}
   */
  @Test
  public void testNewBroadleafAdminAuthenticationFailureHandler() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     BroadleafAdminAuthenticationFailureHandler.defaultFailureUrl
    //     SimpleUrlAuthenticationFailureHandler.defaultFailureUrl
    //     SimpleUrlAuthenticationFailureHandler.logger

    // Arrange and Act
    new BroadleafAdminAuthenticationFailureHandler();
  }

  /**
   * Test
   * {@link BroadleafAdminAuthenticationFailureHandler#BroadleafAdminAuthenticationFailureHandler(String)}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminAuthenticationFailureHandler#BroadleafAdminAuthenticationFailureHandler(String)}
   */
  @Test
  public void testNewBroadleafAdminAuthenticationFailureHandler2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    new BroadleafAdminAuthenticationFailureHandler("https://example.org/example");
  }

  /**
   * Test
   * {@link BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}
   */
  @Test
  public void testOnAuthenticationFailure() throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler = new BroadleafAdminAuthenticationFailureHandler();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(request, response,
        new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    HttpSession session = request.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals("Unauthorized", response.getErrorMessage());
    assertNull(response.getRedirectedUrl());
    assertEquals(0, session.getValueNames().length);
    assertEquals(401, response.getStatus());
    assertTrue(headerNames.isEmpty());
  }

  /**
   * Test
   * {@link BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}.
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) HeaderNames
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}
   */
  @Test
  public void testOnAuthenticationFailure_thenMockHttpServletResponseHeaderNamesSizeIsOne()
      throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler = new BroadleafAdminAuthenticationFailureHandler(
        "https://example.org/example");
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(request, response,
        new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    HttpSession session = request.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals("https://example.org/example", response.getRedirectedUrl());
    assertNull(response.getErrorMessage());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertArrayEquals(new String[]{"SPRING_SECURITY_LAST_EXCEPTION"}, session.getValueNames());
  }
}
