package org.broadleafcommerce.common.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {LocalRedirectStrategy.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class LocalRedirectStrategyDiffblueTest {
  @Autowired private LocalRedirectStrategy localRedirectStrategy;

  /**
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect() throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    localRedirectStrategy.sendRedirect(request, response, "https://example.org/example");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/example", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) RedirectedUrl is empty string.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect_thenMockHttpServletResponseRedirectedUrlIsEmptyString()
      throws IOException {
    // Arrange
    localRedirectStrategy.setEnforcePortMatch(false);
    localRedirectStrategy.setContextRelative(true);

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setContextPath("");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    localRedirectStrategy.sendRedirect(request, response, "http://");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) RedirectedUrl is {@code
   *       example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect_thenMockHttpServletResponseRedirectedUrlIsExampleOrgExample()
      throws IOException {
    // Arrange
    LocalRedirectStrategy localRedirectStrategy = new LocalRedirectStrategy();
    localRedirectStrategy.setContextRelative(true);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    localRedirectStrategy.sendRedirect(request, response, "https://example.org/example");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("example.org/example", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) RedirectedUrl is {@code
   *       http://}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect_thenMockHttpServletResponseRedirectedUrlIsHttp() throws IOException {
    // Arrange
    localRedirectStrategy.setEnforcePortMatch(false);
    localRedirectStrategy.setContextRelative(false);

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setContextPath("");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    localRedirectStrategy.sendRedirect(request, response, "http://");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("http://", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) RedirectedUrl is {@code
   *       http://}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect_thenMockHttpServletResponseRedirectedUrlIsHttp2()
      throws IOException {
    // Arrange
    localRedirectStrategy.setEnforcePortMatch(false);
    localRedirectStrategy.setContextRelative(false);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("successUrl", "Request");
    request.addParameter("failureUrl", "Request");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    localRedirectStrategy.sendRedirect(request, response, "http://");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("http://", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code
   *       failureUrl} and {@code http://}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect_whenMockHttpServletRequestAddParameterFailureUrlAndHttp()
      throws IOException {
    // Arrange
    LocalRedirectStrategy localRedirectStrategy = new LocalRedirectStrategy();
    localRedirectStrategy.setEnforcePortMatch(false);
    localRedirectStrategy.setContextRelative(false);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("successUrl", "Request");
    request.addParameter("failureUrl", "http://");

    // Act and Assert
    assertThrows(
        MalformedURLException.class,
        () ->
            localRedirectStrategy.sendRedirect(request, new MockHttpServletResponse(), "http://"));
  }

  /**
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code
   *       successUrl} and {@code http://}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect_whenMockHttpServletRequestAddParameterSuccessUrlAndHttp()
      throws IOException {
    // Arrange
    LocalRedirectStrategy localRedirectStrategy = new LocalRedirectStrategy();
    localRedirectStrategy.setEnforcePortMatch(false);
    localRedirectStrategy.setContextRelative(false);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("successUrl", "http://");
    request.addParameter("failureUrl", "Request");

    // Act and Assert
    assertThrows(
        MalformedURLException.class,
        () ->
            localRedirectStrategy.sendRedirect(request, new MockHttpServletResponse(), "http://"));
  }

  /**
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then {@link MockHttpServletResponse} (default constructor) RedirectedUrl is {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect_whenSlash_thenMockHttpServletResponseRedirectedUrlIsSlash()
      throws IOException {
    // Arrange
    localRedirectStrategy.setEnforcePortMatch(false);
    localRedirectStrategy.setContextRelative(false);

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setContextPath("");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    localRedirectStrategy.sendRedirect(request, response, "/");

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
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then {@link MockHttpServletResponse} (default constructor) RedirectedUrl is {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect_whenSlash_thenMockHttpServletResponseRedirectedUrlIsSlash2()
      throws IOException {
    // Arrange
    localRedirectStrategy.setEnforcePortMatch(false);
    localRedirectStrategy.setContextRelative(true);

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setContextPath("");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    localRedirectStrategy.sendRedirect(request, response, "/");

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
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code e.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_thenReturnEOrgExample() {
    // Arrange
    LocalRedirectStrategy localRedirectStrategy = new LocalRedirectStrategy();
    localRedirectStrategy.setContextRelative(true);

    // Act and Assert
    assertEquals(
        "e.org/example",
        localRedirectStrategy.calculateRedirectUrl("http://", "https://example.org/example"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code example}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_thenReturnExample() {
    // Arrange
    LocalRedirectStrategy localRedirectStrategy = new LocalRedirectStrategy();
    localRedirectStrategy.setContextRelative(true);

    // Act and Assert
    assertEquals(
        "example",
        localRedirectStrategy.calculateRedirectUrl("Context Path", "https://example.org/example"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code http://}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_thenReturnHttp() {
    // Arrange
    localRedirectStrategy.setContextRelative(false);

    // Act and Assert
    assertEquals(
        "http://",
        localRedirectStrategy.calculateRedirectUrl("https://example.org/example", "http://"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example",
        localRedirectStrategy.calculateRedirectUrl(
            "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example://}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_thenReturnHttpsExampleOrgExample2() {
    // Arrange
    localRedirectStrategy.setContextRelative(false);

    // Act and Assert
    assertEquals(
        "https://example.org/example://",
        localRedirectStrategy.calculateRedirectUrl("https://example.org/example", "://"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_thenReturnHttpsExampleOrgExample3() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example",
        localRedirectStrategy.calculateRedirectUrl("http://", "https://example.org/example"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>When {@code ://}.
   *   <li>Then return {@code ://}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_whenColonSlashSlash_thenReturnColonSlashSlash() {
    // Arrange
    localRedirectStrategy.setContextRelative(true);

    // Act and Assert
    assertEquals(
        "://", localRedirectStrategy.calculateRedirectUrl("https://example.org/example", "://"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>When {@code Context Path}.
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_whenContextPath_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example",
        localRedirectStrategy.calculateRedirectUrl("Context Path", "https://example.org/example"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_whenSlash_thenReturnEmptyString() {
    // Arrange
    localRedirectStrategy.setContextRelative(true);

    // Act and Assert
    assertEquals("", localRedirectStrategy.calculateRedirectUrl("/", "http://"));
  }
}
