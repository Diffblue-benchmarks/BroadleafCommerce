package org.broadleafcommerce.common.web.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {BroadleafAuthenticationFailureRedirectStrategy.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafAuthenticationFailureRedirectStrategyDiffblueTest {
  @Autowired
  private BroadleafAuthenticationFailureRedirectStrategy
      broadleafAuthenticationFailureRedirectStrategy;

  /**
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect() throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureRedirectStrategy.sendRedirect(
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
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect2() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getContextPath()).thenReturn("https://example.org/example");
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureRedirectStrategy.sendRedirect(request, response, "?");

    // Assert
    verify(request).getContextPath();
    verify(request).getHeader("X-Requested-With");
    verify(request).getParameter("blcAjax");
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/example?", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect3() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getContextPath()).thenReturn("https://example.org/example");
    when(request.getHeader(Mockito.<String>any())).thenReturn("XMLHttpRequest");
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureRedirectStrategy.sendRedirect(request, response, "?");

    // Assert
    verify(request).getContextPath();
    verify(request).getHeader("X-Requested-With");
    verify(request).getParameter("blcAjax");
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/example??blcAjax=true", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect4() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getContextPath()).thenReturn("https://example.org/example");
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");
    when(request.getParameter(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureRedirectStrategy.sendRedirect(request, response, "?");

    // Assert
    verify(request).getContextPath();
    verify(request).getHeader("X-Requested-With");
    verify(request).getParameter("blcAjax");
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/example??blcAjax=true", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect5() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getContextPath()).thenReturn("https://example.org/example");
    when(request.getHeader(Mockito.<String>any())).thenReturn("XMLHttpRequest");
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureRedirectStrategy.sendRedirect(request, response, null);

    // Assert
    verify(request).getContextPath();
    verify(request).getHeader("X-Requested-With");
    verify(request).getParameter("blcAjax");
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/examplenull?blcAjax=true", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect6() throws IOException {
    // Arrange
    BroadleafAuthenticationFailureRedirectStrategy broadleafAuthenticationFailureRedirectStrategy =
        new BroadleafAuthenticationFailureRedirectStrategy();
    broadleafAuthenticationFailureRedirectStrategy.setRedirectStrategy(
        new BroadleafAuthenticationFailureRedirectStrategy());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureRedirectStrategy.sendRedirect(
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
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect7() throws IOException {
    // Arrange
    BroadleafAuthenticationFailureRedirectStrategy broadleafAuthenticationFailureRedirectStrategy =
        new BroadleafAuthenticationFailureRedirectStrategy();
    broadleafAuthenticationFailureRedirectStrategy.setRedirectStrategy(
        new BroadleafAuthenticationSuccessRedirectStrategy());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureRedirectStrategy.sendRedirect(
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
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect8() throws IOException {
    // Arrange
    BroadleafAuthenticationFailureRedirectStrategy broadleafAuthenticationFailureRedirectStrategy =
        new BroadleafAuthenticationFailureRedirectStrategy();
    broadleafAuthenticationFailureRedirectStrategy.setRedirectStrategy(
        new BroadleafAuthenticationFailureRedirectStrategy());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("blcAjax", Boolean.TRUE.toString());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureRedirectStrategy.sendRedirect(
        request, response, "https://example.org/example");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals(
        "https://example.org/example?blcAjax=true&blcAjax=true", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect9() throws IOException {
    // Arrange
    BroadleafAuthenticationSuccessRedirectStrategy redirectStrategy =
        new BroadleafAuthenticationSuccessRedirectStrategy();
    redirectStrategy.setRedirectStrategy(new BroadleafAuthenticationFailureRedirectStrategy());

    BroadleafAuthenticationFailureRedirectStrategy broadleafAuthenticationFailureRedirectStrategy =
        new BroadleafAuthenticationFailureRedirectStrategy();
    broadleafAuthenticationFailureRedirectStrategy.setRedirectStrategy(redirectStrategy);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureRedirectStrategy.sendRedirect(
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
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAuthenticationFailureRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect10() throws IOException {
    // Arrange
    BroadleafAuthenticationSuccessRedirectStrategy redirectStrategy =
        new BroadleafAuthenticationSuccessRedirectStrategy();
    redirectStrategy.setRedirectStrategy(new BroadleafAuthenticationSuccessRedirectStrategy());

    BroadleafAuthenticationFailureRedirectStrategy broadleafAuthenticationFailureRedirectStrategy =
        new BroadleafAuthenticationFailureRedirectStrategy();
    broadleafAuthenticationFailureRedirectStrategy.setRedirectStrategy(redirectStrategy);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureRedirectStrategy.sendRedirect(
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
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#updateUrlForAjax(String)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example?blcAjax=true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureRedirectStrategy#updateUrlForAjax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAuthenticationFailureRedirectStrategy.updateUrlForAjax(String)"
  })
  public void testUpdateUrlForAjax_thenReturnHttpsExampleOrgExampleBlcAjaxTrue() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example?blcAjax=true",
        broadleafAuthenticationFailureRedirectStrategy.updateUrlForAjax(
            "https://example.org/example"));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#updateUrlForAjax(String)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example?&blcAjax=true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureRedirectStrategy#updateUrlForAjax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAuthenticationFailureRedirectStrategy.updateUrlForAjax(String)"
  })
  public void testUpdateUrlForAjax_thenReturnHttpsExampleOrgExampleBlcAjaxTrue2() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example?&blcAjax=true",
        broadleafAuthenticationFailureRedirectStrategy.updateUrlForAjax(
            "https://example.org/example?"));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#updateUrlForAjax(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null?blcAjax=true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAuthenticationFailureRedirectStrategy#updateUrlForAjax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAuthenticationFailureRedirectStrategy.updateUrlForAjax(String)"
  })
  public void testUpdateUrlForAjax_whenNull_thenReturnNullBlcAjaxTrue() {
    // Arrange, Act and Assert
    assertEquals(
        "null?blcAjax=true", broadleafAuthenticationFailureRedirectStrategy.updateUrlForAjax(null));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       BroadleafAuthenticationFailureRedirectStrategy#setRedirectStrategy(RedirectStrategy)}
   *   <li>{@link BroadleafAuthenticationFailureRedirectStrategy#getRedirectStrategy()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RedirectStrategy BroadleafAuthenticationFailureRedirectStrategy.getRedirectStrategy()",
    "void BroadleafAuthenticationFailureRedirectStrategy.setRedirectStrategy(RedirectStrategy)"
  })
  public void testGettersAndSetters() {
    // Arrange
    BroadleafAuthenticationFailureRedirectStrategy broadleafAuthenticationFailureRedirectStrategy =
        new BroadleafAuthenticationFailureRedirectStrategy();
    BroadleafAuthenticationFailureRedirectStrategy redirectStrategy =
        new BroadleafAuthenticationFailureRedirectStrategy();

    // Act
    broadleafAuthenticationFailureRedirectStrategy.setRedirectStrategy(redirectStrategy);
    RedirectStrategy actualRedirectStrategy =
        broadleafAuthenticationFailureRedirectStrategy.getRedirectStrategy();

    // Assert
    assertTrue(actualRedirectStrategy instanceof BroadleafAuthenticationFailureRedirectStrategy);
    assertSame(redirectStrategy, actualRedirectStrategy);
  }
}
