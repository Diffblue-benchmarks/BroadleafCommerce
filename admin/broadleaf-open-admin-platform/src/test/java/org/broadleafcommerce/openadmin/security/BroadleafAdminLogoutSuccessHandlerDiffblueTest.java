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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafAdminLogoutSuccessHandler.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafAdminLogoutSuccessHandlerDiffblueTest {
  @Autowired private BroadleafAdminLogoutSuccessHandler broadleafAdminLogoutSuccessHandler;

  /**
   * Test {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse,
   * Authentication)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminLogoutSuccessHandler.onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testOnLogoutSuccess_givenEmptyString() throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setQueryString("");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(
        request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("/", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
  }

  /**
   * Test {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)}.
   *
   * <ul>
   *   <li>Given {@code UUU://xx}.
   *   <li>Then {@link MockHttpServletResponse} (default constructor) RedirectedUrl is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse,
   * Authentication)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminLogoutSuccessHandler.onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testOnLogoutSuccess_givenUuuXx_thenMockHttpServletResponseRedirectedUrlIsNull()
      throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setQueryString("UUU://xx");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(
        request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    assertNull(response.getRedirectedUrl());
    assertEquals(403, response.getStatus());
    assertTrue(headerNames.isEmpty());
  }

  /**
   * Test {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) RedirectedUrl is {@code
   *       /adminxx}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse,
   * Authentication)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminLogoutSuccessHandler.onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testOnLogoutSuccess_thenMockHttpServletResponseRedirectedUrlIsAdminxx()
      throws IOException, ServletException {
    // Arrange
    BroadleafAdminLogoutSuccessHandler broadleafAdminLogoutSuccessHandler =
        new BroadleafAdminLogoutSuccessHandler();
    broadleafAdminLogoutSuccessHandler.setDefaultTargetUrl("/adminxx");
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(
        request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("/adminxx", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
  }

  /**
   * Test {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) RedirectedUrl is {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse,
   * Authentication)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminLogoutSuccessHandler.onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testOnLogoutSuccess_thenMockHttpServletResponseRedirectedUrlIsSlash()
      throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(
        request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("/", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
  }
}
