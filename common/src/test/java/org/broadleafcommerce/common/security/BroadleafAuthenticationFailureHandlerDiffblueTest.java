package org.broadleafcommerce.common.security;

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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafAuthenticationFailureHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafAuthenticationFailureHandlerDiffblueTest {
  @Autowired private BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler;

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#BroadleafAuthenticationFailureHandler()}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#BroadleafAuthenticationFailureHandler()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafAuthenticationFailureHandler.<init>()"})
  public void testNewBroadleafAuthenticationFailureHandler() {
    // Arrange, Act and Assert
    assertNull(
        new BroadleafAuthenticationFailureHandler()
            .validateUrlParam("https://example.org/example"));
  }

  /**
   * Test {@link
   * BroadleafAuthenticationFailureHandler#BroadleafAuthenticationFailureHandler(String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#BroadleafAuthenticationFailureHandler(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafAuthenticationFailureHandler.<init>(String)"})
  public void testNewBroadleafAuthenticationFailureHandler2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertNull(
        new BroadleafAuthenticationFailureHandler("https://example.org/example")
            .validateUrlParam("https://example.org/example"));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure() throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler =
        new BroadleafAuthenticationFailureHandler("https://example.org/example");
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(
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
   * Test {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure2() throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler =
        new BroadleafAuthenticationFailureHandler("https://example.org/example");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("successUrl", "failureUrl");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(
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
   * Test {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure3() throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler =
        new BroadleafAuthenticationFailureHandler("https://example.org/example");
    broadleafAuthenticationFailureHandler.setRedirectStrategy(new LocalRedirectStrategy());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(
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
   * Test {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure4() throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler =
        new BroadleafAuthenticationFailureHandler("https://example.org/example");
    broadleafAuthenticationFailureHandler.setRedirectStrategy(new LocalRedirectStrategy());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("successUrl", "failureUrl");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(
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
   * Test {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then {@link MockHttpServletResponse} (default constructor) RedirectedUrl is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure_given42_thenMockHttpServletResponseRedirectedUrlIs42()
      throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler =
        new BroadleafAuthenticationFailureHandler();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("failureUrl", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(
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
   * Test {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <ul>
   *   <li>Given {@link MockHttpServletRequest#DEFAULT_SCHEME}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure_givenDefault_scheme()
      throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler =
        new BroadleafAuthenticationFailureHandler();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("failureUrl", MockHttpServletRequest.DEFAULT_SCHEME);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(
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
   * Test {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <ul>
   *   <li>Given {@code [ \r\n]}.
   *   <li>Then {@link MockHttpServletResponse} (default constructor) RedirectedUrl is {@code
   *       [\r\n]}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure_givenRN_thenMockHttpServletResponseRedirectedUrlIsRN()
      throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler =
        new BroadleafAuthenticationFailureHandler();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("failureUrl", "[ \\r\\n]");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(
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
   * Test {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <ul>
   *   <li>Given space.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure_givenSpace() throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler =
        new BroadleafAuthenticationFailureHandler();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("failureUrl", " ");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(
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
   * Test {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <ul>
   *   <li>Given {@code www}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure_givenWww() throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler =
        new BroadleafAuthenticationFailureHandler();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("failureUrl", "www");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(
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
   * Test {@link BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure_whenMockHttpServletRequest()
      throws IOException, ServletException {
    // Arrange
    BroadleafAuthenticationFailureHandler broadleafAuthenticationFailureHandler =
        new BroadleafAuthenticationFailureHandler();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureHandler.onAuthenticationFailure(
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
   * Test {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafAuthenticationFailureHandler.validateUrlParam(String)"})
  public void testValidateUrlParam_whenDot_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(broadleafAuthenticationFailureHandler.validateUrlParam("."));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafAuthenticationFailureHandler.validateUrlParam(String)"})
  public void testValidateUrlParam_whenHttpsExampleOrgExample_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        broadleafAuthenticationFailureHandler.validateUrlParam("https://example.org/example"));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafAuthenticationFailureHandler.validateUrlParam(String)"})
  public void testValidateUrlParam_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(broadleafAuthenticationFailureHandler.validateUrlParam(null));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}.
   *
   * <ul>
   *   <li>When {@code Url}.
   *   <li>Then return {@code Url}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafAuthenticationFailureHandler.validateUrlParam(String)"})
  public void testValidateUrlParam_whenUrl_thenReturnUrl() {
    // Arrange, Act and Assert
    assertEquals("Url", broadleafAuthenticationFailureHandler.validateUrlParam("Url"));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}.
   *
   * <ul>
   *   <li>When {@code www}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAuthenticationFailureHandler#validateUrlParam(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafAuthenticationFailureHandler.validateUrlParam(String)"})
  public void testValidateUrlParam_whenWww_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(broadleafAuthenticationFailureHandler.validateUrlParam("www"));
  }
}
