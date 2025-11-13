package org.broadleafcommerce.common.web.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
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
import org.springframework.security.web.RedirectStrategy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafAuthenticationSuccessRedirectStrategy.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafAuthenticationSuccessRedirectStrategyDiffblueTest {
  @Autowired
  private BroadleafAuthenticationSuccessRedirectStrategy
      broadleafAuthenticationSuccessRedirectStrategy;

  /**
   * Test {@link BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationSuccessRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect() throws IOException {
    // Arrange
    BroadleafAuthenticationSuccessRedirectStrategy broadleafAuthenticationSuccessRedirectStrategy =
        new BroadleafAuthenticationSuccessRedirectStrategy();
    broadleafAuthenticationSuccessRedirectStrategy.setRedirectStrategy(
        new BroadleafAuthenticationFailureRedirectStrategy());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationSuccessRedirectStrategy.sendRedirect(
        request, response, "https://example.org/example");

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
   * Test {@link BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationSuccessRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect2() throws IOException {
    // Arrange
    BroadleafAuthenticationSuccessRedirectStrategy broadleafAuthenticationSuccessRedirectStrategy =
        new BroadleafAuthenticationSuccessRedirectStrategy();
    broadleafAuthenticationSuccessRedirectStrategy.setRedirectStrategy(
        new BroadleafAuthenticationSuccessRedirectStrategy());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationSuccessRedirectStrategy.sendRedirect(
        request, response, "https://example.org/example");

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
   * Test {@link BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationSuccessRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect3() throws IOException {
    // Arrange
    BroadleafAuthenticationFailureRedirectStrategy redirectStrategy =
        new BroadleafAuthenticationFailureRedirectStrategy();
    redirectStrategy.setRedirectStrategy(new BroadleafAuthenticationFailureRedirectStrategy());

    BroadleafAuthenticationSuccessRedirectStrategy broadleafAuthenticationSuccessRedirectStrategy =
        new BroadleafAuthenticationSuccessRedirectStrategy();
    broadleafAuthenticationSuccessRedirectStrategy.setRedirectStrategy(redirectStrategy);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationSuccessRedirectStrategy.sendRedirect(
        request, response, "https://example.org/example");

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
   * Test {@link BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationSuccessRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect4() throws IOException {
    // Arrange
    BroadleafAuthenticationFailureRedirectStrategy redirectStrategy =
        new BroadleafAuthenticationFailureRedirectStrategy();
    redirectStrategy.setRedirectStrategy(new BroadleafAuthenticationSuccessRedirectStrategy());

    BroadleafAuthenticationSuccessRedirectStrategy broadleafAuthenticationSuccessRedirectStrategy =
        new BroadleafAuthenticationSuccessRedirectStrategy();
    broadleafAuthenticationSuccessRedirectStrategy.setRedirectStrategy(redirectStrategy);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationSuccessRedirectStrategy.sendRedirect(
        request, response, "https://example.org/example");

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
   * Test {@link BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafAuthenticationSuccessRedirectStrategy}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationSuccessRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect_givenBroadleafAuthenticationSuccessRedirectStrategy()
      throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationSuccessRedirectStrategy.sendRedirect(
        request, response, "https://example.org/example");

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
   * Test {@link BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <ul>
   *   <li>Given {@code UUU://xx}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationSuccessRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect_givenUuuXx() throws IOException {
    // Arrange
    BroadleafAuthenticationSuccessRedirectStrategy broadleafAuthenticationSuccessRedirectStrategy =
        new BroadleafAuthenticationSuccessRedirectStrategy();
    broadleafAuthenticationSuccessRedirectStrategy.setRedirectStrategy(
        new BroadleafAuthenticationFailureRedirectStrategy());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("blcAjax", "UUU://xx");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationSuccessRedirectStrategy.sendRedirect(
        request, response, "https://example.org/example");

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
   * Test {@link BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) RedirectedUrl is {@code
   *       /redirect?blcAjax=true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationSuccessRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect_thenMockHttpServletResponseRedirectedUrlIsRedirectBlcAjaxTrue()
      throws IOException {
    // Arrange
    BroadleafAuthenticationSuccessRedirectStrategy broadleafAuthenticationSuccessRedirectStrategy =
        new BroadleafAuthenticationSuccessRedirectStrategy();
    broadleafAuthenticationSuccessRedirectStrategy.setRedirectStrategy(
        new BroadleafAuthenticationFailureRedirectStrategy());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("blcAjax", Boolean.TRUE.toString());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationSuccessRedirectStrategy.sendRedirect(
        request, response, "https://example.org/example");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("/redirect?blcAjax=true", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAuthenticationSuccessRedirectStrategy#updateLoginErrorUrlForAjax(String)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example?blcAjax=true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationSuccessRedirectStrategy#updateLoginErrorUrlForAjax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAuthenticationSuccessRedirectStrategy.updateLoginErrorUrlForAjax(String)"
  })
  public void testUpdateLoginErrorUrlForAjax_thenReturnHttpsExampleOrgExampleBlcAjaxTrue() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example?blcAjax=true",
        broadleafAuthenticationSuccessRedirectStrategy.updateLoginErrorUrlForAjax(
            "https://example.org/example"));
  }

  /**
   * Test {@link BroadleafAuthenticationSuccessRedirectStrategy#updateLoginErrorUrlForAjax(String)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example?&blcAjax=true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationSuccessRedirectStrategy#updateLoginErrorUrlForAjax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAuthenticationSuccessRedirectStrategy.updateLoginErrorUrlForAjax(String)"
  })
  public void testUpdateLoginErrorUrlForAjax_thenReturnHttpsExampleOrgExampleBlcAjaxTrue2() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example?&blcAjax=true",
        broadleafAuthenticationSuccessRedirectStrategy.updateLoginErrorUrlForAjax(
            "https://example.org/example?"));
  }

  /**
   * Test {@link BroadleafAuthenticationSuccessRedirectStrategy#updateLoginErrorUrlForAjax(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null?blcAjax=true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationSuccessRedirectStrategy#updateLoginErrorUrlForAjax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAuthenticationSuccessRedirectStrategy.updateLoginErrorUrlForAjax(String)"
  })
  public void testUpdateLoginErrorUrlForAjax_whenNull_thenReturnNullBlcAjaxTrue() {
    // Arrange, Act and Assert
    assertEquals(
        "null?blcAjax=true",
        broadleafAuthenticationSuccessRedirectStrategy.updateLoginErrorUrlForAjax(null));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafAuthenticationSuccessRedirectStrategy#setRedirectPath(String)}
   *   <li>{@link
   *       BroadleafAuthenticationSuccessRedirectStrategy#setRedirectStrategy(RedirectStrategy)}
   *   <li>{@link BroadleafAuthenticationSuccessRedirectStrategy#getRedirectPath()}
   *   <li>{@link BroadleafAuthenticationSuccessRedirectStrategy#getRedirectStrategy()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAuthenticationSuccessRedirectStrategy.getRedirectPath()",
    "RedirectStrategy BroadleafAuthenticationSuccessRedirectStrategy.getRedirectStrategy()",
    "void BroadleafAuthenticationSuccessRedirectStrategy.setRedirectPath(String)",
    "void BroadleafAuthenticationSuccessRedirectStrategy.setRedirectStrategy(RedirectStrategy)"
  })
  public void testGettersAndSetters() {
    // Arrange
    BroadleafAuthenticationSuccessRedirectStrategy broadleafAuthenticationSuccessRedirectStrategy =
        new BroadleafAuthenticationSuccessRedirectStrategy();

    // Act
    broadleafAuthenticationSuccessRedirectStrategy.setRedirectPath("Redirect Path");
    BroadleafAuthenticationFailureRedirectStrategy redirectStrategy =
        new BroadleafAuthenticationFailureRedirectStrategy();
    broadleafAuthenticationSuccessRedirectStrategy.setRedirectStrategy(redirectStrategy);
    String actualRedirectPath = broadleafAuthenticationSuccessRedirectStrategy.getRedirectPath();
    RedirectStrategy actualRedirectStrategy =
        broadleafAuthenticationSuccessRedirectStrategy.getRedirectStrategy();

    // Assert
    assertTrue(actualRedirectStrategy instanceof BroadleafAuthenticationFailureRedirectStrategy);
    assertEquals("Redirect Path", actualRedirectPath);
    assertSame(redirectStrategy, actualRedirectStrategy);
  }
}
