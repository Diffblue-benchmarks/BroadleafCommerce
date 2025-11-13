package org.broadleafcommerce.openadmin.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.security.web.savedrequest.DefaultSavedRequest.Builder;
import org.springframework.security.web.savedrequest.RequestCache;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafAdminAuthenticationSuccessHandlerDiffblueTest {
  @InjectMocks
  private BroadleafAdminAuthenticationSuccessHandler broadleafAdminAuthenticationSuccessHandler;

  @Mock private RequestCache requestCache;

  @Mock private SecurityVerifier securityVerifier;

  /**
   * Test {@link
   * BroadleafAdminAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)} with {@code request}, {@code response}, {@code
   * authentication}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationSuccessHandler.onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testOnAuthenticationSuccessWithRequestResponseAuthentication()
      throws IOException, ServletException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());

    Builder setContextPathResult = new Builder().setContextPath("Context Path");

    Builder setCookiesResult = setContextPathResult.setCookies(new ArrayList<>());

    Builder setMethodResult =
        setCookiesResult
            .setLocales(new ArrayList<>())
            .setMatchingRequestParameterName("Matching Request Parameter Name")
            .setMethod("Method");
    when(requestCache.getRequest(
            Mockito.<HttpServletRequest>any(), Mockito.<HttpServletResponse>any()))
        .thenReturn(
            setMethodResult
                .setParameters(new HashMap<>())
                .setPathInfo("Path Info")
                .setQueryString("Query String")
                .setRequestURI("Request URI")
                .setRequestURL("https://example.org/example")
                .setScheme("Scheme")
                .setServerName("Server Name")
                .setServerPort(8080)
                .setServletPath("Servlet Path")
                .build());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationSuccessHandler.onAuthenticationSuccess(
        request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(requestCache).getRequest(isA(HttpServletRequest.class), isA(HttpServletResponse.class));
    Collection<String> headerNames = response.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    assertNull(response.getRedirectedUrl());
    assertEquals(403, response.getStatus());
    assertTrue(headerNames.isEmpty());
  }

  /**
   * Test {@link
   * BroadleafAdminAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)} with {@code request}, {@code response}, {@code
   * authentication}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationSuccessHandler.onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testOnAuthenticationSuccessWithRequestResponseAuthentication2()
      throws IOException, ServletException {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getLastUsedSandBoxId()).thenReturn(1L);
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);

    Builder setContextPathResult = new Builder().setContextPath("Context Path");

    Builder setCookiesResult = setContextPathResult.setCookies(new ArrayList<>());

    Builder setMethodResult =
        setCookiesResult
            .setLocales(new ArrayList<>())
            .setMatchingRequestParameterName("Matching Request Parameter Name")
            .setMethod("Method");
    when(requestCache.getRequest(
            Mockito.<HttpServletRequest>any(), Mockito.<HttpServletResponse>any()))
        .thenReturn(
            setMethodResult
                .setParameters(new HashMap<>())
                .setPathInfo("Path Info")
                .setQueryString("Query String")
                .setRequestURI("Request URI")
                .setRequestURL("https://example.org/example")
                .setScheme("Scheme")
                .setServerName("Server Name")
                .setServerPort(8080)
                .setServletPath("Servlet Path")
                .build());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setSession(new MockHttpSession());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationSuccessHandler.onAuthenticationSuccess(
        request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(adminUser, atLeast(1)).getLastUsedSandBoxId();
    verify(securityVerifier).getPersistentAdminUser();
    verify(requestCache).getRequest(isA(HttpServletRequest.class), isA(HttpServletResponse.class));
    Collection<String> headerNames = response.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    assertNull(response.getRedirectedUrl());
    assertEquals(403, response.getStatus());
    assertTrue(headerNames.isEmpty());
  }

  /**
   * Test {@link
   * BroadleafAdminAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)} with {@code request}, {@code response}, {@code
   * authentication}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationSuccessHandler.onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testOnAuthenticationSuccessWithRequestResponseAuthentication3()
      throws IOException, ServletException {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getLastUsedSandBoxId()).thenReturn(1L);
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);

    Builder setContextPathResult = new Builder().setContextPath("Context Path");

    Builder setCookiesResult = setContextPathResult.setCookies(new ArrayList<>());

    Builder setMethodResult =
        setCookiesResult
            .setLocales(new ArrayList<>())
            .setMatchingRequestParameterName("Matching Request Parameter Name")
            .setMethod("Method");
    when(requestCache.getRequest(
            Mockito.<HttpServletRequest>any(), Mockito.<HttpServletResponse>any()))
        .thenReturn(
            setMethodResult
                .setParameters(new HashMap<>())
                .setPathInfo("Path Info")
                .setQueryString("Query String")
                .setRequestURI("Request URI")
                .setRequestURL("https://example.org/example")
                .setScheme("/adminxx")
                .setServerName("Server Name")
                .setServerPort(8080)
                .setServletPath("Servlet Path")
                .build());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setSession(new MockHttpSession());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationSuccessHandler.onAuthenticationSuccess(
        request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(adminUser, atLeast(1)).getLastUsedSandBoxId();
    verify(securityVerifier).getPersistentAdminUser();
    verify(requestCache).getRequest(isA(HttpServletRequest.class), isA(HttpServletResponse.class));
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals(
        "/adminxx://Server NameRequest URI?Query String&Matching Request Parameter Name",
        response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
  }

  /**
   * Test {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminAuthenticationSuccessHandler.removeLoginSegment(String)"
  })
  public void testRemoveLoginSegment_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example",
        new BroadleafAdminAuthenticationSuccessHandler()
            .removeLoginSegment("https://example.org/example"));
  }

  /**
   * Test {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminAuthenticationSuccessHandler.removeLoginSegment(String)"
  })
  public void testRemoveLoginSegment_whenEmptyString_thenReturnSlash() {
    // Arrange, Act and Assert
    assertEquals("/", new BroadleafAdminAuthenticationSuccessHandler().removeLoginSegment(""));
  }

  /**
   * Test {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}.
   *
   * <ul>
   *   <li>When {@code /login}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminAuthenticationSuccessHandler.removeLoginSegment(String)"
  })
  public void testRemoveLoginSegment_whenLogin_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new BroadleafAdminAuthenticationSuccessHandler().removeLoginSegment("/login"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafAdminAuthenticationSuccessHandler#setLoginUri(String)}
   *   <li>{@link BroadleafAdminAuthenticationSuccessHandler#getLoginUri()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafAdminAuthenticationSuccessHandler.getLoginUri()",
    "void BroadleafAdminAuthenticationSuccessHandler.setLoginUri(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    BroadleafAdminAuthenticationSuccessHandler broadleafAdminAuthenticationSuccessHandler =
        new BroadleafAdminAuthenticationSuccessHandler();

    // Act
    broadleafAdminAuthenticationSuccessHandler.setLoginUri("Login Uri");

    // Assert
    assertEquals("Login Uri", broadleafAdminAuthenticationSuccessHandler.getLoginUri());
  }

  /**
   * Test new {@link BroadleafAdminAuthenticationSuccessHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * BroadleafAdminAuthenticationSuccessHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafAdminAuthenticationSuccessHandler.<init>()"})
  public void testNewBroadleafAdminAuthenticationSuccessHandler() {
    // Arrange and Act
    BroadleafAdminAuthenticationSuccessHandler actualBroadleafAdminAuthenticationSuccessHandler =
        new BroadleafAdminAuthenticationSuccessHandler();

    // Assert
    assertEquals("/login", actualBroadleafAdminAuthenticationSuccessHandler.getLoginUri());
    assertNull(actualBroadleafAdminAuthenticationSuccessHandler.adminRemoteSecurityService);
  }
}
