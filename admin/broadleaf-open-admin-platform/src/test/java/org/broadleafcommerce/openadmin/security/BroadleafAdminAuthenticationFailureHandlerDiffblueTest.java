package org.broadleafcommerce.openadmin.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
import org.broadleafcommerce.common.security.LocalRedirectStrategy;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.AuthenticationException;

public class BroadleafAdminAuthenticationFailureHandlerDiffblueTest {
  /**
   * Test {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure() throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler =
        new BroadleafAdminAuthenticationFailureHandler();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(
        request, response, new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    assertEquals("Unauthorized", response.getErrorMessage());
    assertNull(response.getRedirectedUrl());
    assertEquals(401, response.getStatus());
    assertTrue(headerNames.isEmpty());
  }

  /**
   * Test {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure2() throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler =
        new BroadleafAdminAuthenticationFailureHandler("https://example.org/example");
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(
        request, response, new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/example", response.getRedirectedUrl());
    assertNull(response.getErrorMessage());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
  }

  /**
   * Test {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure3() throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler =
        new BroadleafAdminAuthenticationFailureHandler("https://example.org/example");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("successUrl", "failureUrl");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(
        request, response, new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/example?successUrl=failureUrl", response.getRedirectedUrl());
    assertNull(response.getErrorMessage());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
  }

  /**
   * Test {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure4() throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler =
        new BroadleafAdminAuthenticationFailureHandler("https://example.org/example");
    broadleafAdminAuthenticationFailureHandler.setRedirectStrategy(new LocalRedirectStrategy());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(
        request, response, new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/example", response.getRedirectedUrl());
    assertNull(response.getErrorMessage());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
  }

  /**
   * Test {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure5() throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler =
        new BroadleafAdminAuthenticationFailureHandler("https://example.org/example");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("successUrl", "successUrl");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(
        request, response, new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/example?successUrl", response.getRedirectedUrl());
    assertNull(response.getErrorMessage());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
  }

  /**
   * Test {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure6() throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler =
        new BroadleafAdminAuthenticationFailureHandler("https://example.org/example");
    broadleafAdminAuthenticationFailureHandler.setRedirectStrategy(new LocalRedirectStrategy());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("successUrl", "failureUrl");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(
        request, response, new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/example?successUrl=failureUrl", response.getRedirectedUrl());
    assertNull(response.getErrorMessage());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
  }

  /**
   * Test {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then {@link MockHttpServletResponse} (default constructor) RedirectedUrl is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure_given42_thenMockHttpServletResponseRedirectedUrlIs42()
      throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler =
        new BroadleafAdminAuthenticationFailureHandler();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("failureUrl", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(
        request, response, new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("42", response.getRedirectedUrl());
    assertNull(response.getErrorMessage());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
  }

  /**
   * Test {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <ul>
   *   <li>Given {@code [ \r\n]}.
   *   <li>Then {@link MockHttpServletResponse} (default constructor) RedirectedUrl is {@code
   *       [\r\n]}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure_givenRN_thenMockHttpServletResponseRedirectedUrlIsRN()
      throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler =
        new BroadleafAdminAuthenticationFailureHandler();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("failureUrl", "[ \\r\\n]");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(
        request, response, new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("[\\r\\n]", response.getRedirectedUrl());
    assertNull(response.getErrorMessage());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
  }

  /**
   * Test {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <ul>
   *   <li>Given space.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure_givenSpace() throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler =
        new BroadleafAdminAuthenticationFailureHandler();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("failureUrl", " ");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(
        request, response, new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    assertEquals("Unauthorized", response.getErrorMessage());
    assertNull(response.getRedirectedUrl());
    assertEquals(401, response.getStatus());
    assertTrue(headerNames.isEmpty());
  }
}
