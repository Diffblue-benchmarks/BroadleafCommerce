package org.broadleafcommerce.core.web.order.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;

public class BroadleafAuthenticationSuccessHandlerDiffblueTest {
  /**
   * Test {@link BroadleafAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)} with {@code request}, {@code response}, {@code
   * authentication}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationSuccessHandler.onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testOnAuthenticationSuccessWithRequestResponseAuthentication()
      throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationSuccessHandler broadleafAuthenticationSuccessHandler =
        new BroadleafAuthenticationSuccessHandler();
    broadleafAuthenticationSuccessHandler.setTargetUrlParameter("https://example.org/example");
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationSuccessHandler.onAuthenticationSuccess(
        request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("/", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }
}
