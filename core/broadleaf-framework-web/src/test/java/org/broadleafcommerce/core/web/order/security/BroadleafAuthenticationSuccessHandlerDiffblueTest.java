package org.broadleafcommerce.core.web.order.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;

class BroadleafAuthenticationSuccessHandlerDiffblueTest {
  /**
   * Test
   * {@link BroadleafAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
   * with {@code request}, {@code response}, {@code authentication}.
   * <p>
   * Method under test:
   * {@link BroadleafAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  @DisplayName("Test onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication) with 'request', 'response', 'authentication'")
  void testOnAuthenticationSuccessWithRequestResponseAuthentication() throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationSuccessHandler broadleafAuthenticationSuccessHandler = new BroadleafAuthenticationSuccessHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationSuccessHandler.onAuthenticationSuccess(request, response,
        new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("/", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test new {@link BroadleafAuthenticationSuccessHandler} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafAuthenticationSuccessHandler}
   */
  @Test
  @DisplayName("Test new BroadleafAuthenticationSuccessHandler (default constructor)")
  void testNewBroadleafAuthenticationSuccessHandler() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     AbstractAuthenticationTargetUrlRequestHandler.logger
    //     AbstractAuthenticationTargetUrlRequestHandler.useReferer
    //     SavedRequestAwareAuthenticationSuccessHandler.logger
    //     SavedRequestAwareAuthenticationSuccessHandler.requestCache

    // Arrange and Act
    new BroadleafAuthenticationSuccessHandler();
  }
}
