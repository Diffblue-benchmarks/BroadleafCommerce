package org.broadleafcommerce.openadmin.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.owasp.esapi.filters.SecurityWrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafAdminLogoutSuccessHandlerDiffblueTest {
  @Autowired
  private BroadleafAdminLogoutSuccessHandler broadleafAdminLogoutSuccessHandler;

  /**
   * Test
   * {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  public void testOnLogoutSuccess() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminLogoutSuccessHandler broadleafAdminLogoutSuccessHandler = new BroadleafAdminLogoutSuccessHandler();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServerPort()).thenReturn(8080);
    when(request.getScheme()).thenReturn("Scheme");
    when(request.getServerName()).thenReturn("Server Name");
    when(request.getQueryString()).thenReturn("https://example.org/example");
    when(request.getSession()).thenReturn(new MockHttpSession());
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(request2, response,
        new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(request).getScheme();
    verify(request).getServerName();
    verify(request).getServerPort();
    verify(request).getQueryString();
    verify(request).getSession();
    HttpSession session = request2.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals(403, response.getStatus());
    assertTrue(response.isCommitted());
    assertTrue(((MockHttpSession) session).isInvalid());
  }

  /**
   * Test
   * {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  public void testOnLogoutSuccess2() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminLogoutSuccessHandler broadleafAdminLogoutSuccessHandler = new BroadleafAdminLogoutSuccessHandler();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getContextPath()).thenReturn("https://example.org/example");
    when(request.getServerPort()).thenReturn(8080);
    when(request.getScheme()).thenReturn("Scheme");
    when(request.getServerName()).thenReturn("Server Name");
    when(request.getQueryString()).thenReturn("");
    when(request.getSession()).thenReturn(new MockHttpSession());
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(request2, response,
        new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(request).getScheme();
    verify(request).getServerName();
    verify(request).getServerPort();
    verify(request).getContextPath();
    verify(request).getQueryString();
    verify(request).getSession();
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    HttpSession session = request2.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals("https://example.org/example/", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(((MockHttpSession) session).isInvalid());
  }

  /**
   * Test
   * {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  public void testOnLogoutSuccess3() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminLogoutSuccessHandler broadleafAdminLogoutSuccessHandler = new BroadleafAdminLogoutSuccessHandler();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServerPort()).thenReturn(8080);
    when(request.getScheme()).thenReturn("Scheme");
    when(request.getServerName()).thenReturn("Server Name");
    when(request.getQueryString()).thenReturn("https://example.org/example");
    when(request.getSession()).thenReturn(new MockHttpSession());
    SecurityWrapperResponse response = new SecurityWrapperResponse(new MockHttpServletResponse(), "Mode");

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(request, response,
        new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(request).getScheme();
    verify(request).getServerName();
    verify(request).getServerPort();
    verify(request).getQueryString();
    verify(request).getSession();
    Collection<String> headerNames = response.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("HTTP error code: 403", ((MockHttpServletResponse) response2).getErrorMessage());
    assertNull(((MockHttpServletResponse) response2).getRedirectedUrl());
    assertEquals(200, response.getStatus());
    assertEquals(200, ((MockHttpServletResponse) response2).getStatus());
    assertTrue(headerNames.isEmpty());
    assertTrue(response2.isCommitted());
    assertTrue(response.isCommitted());
  }

  /**
   * Test
   * {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  public void testOnLogoutSuccess4() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminLogoutSuccessHandler broadleafAdminLogoutSuccessHandler = new BroadleafAdminLogoutSuccessHandler();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getContextPath()).thenReturn("/adminU");
    when(request.getServerPort()).thenReturn(8080);
    when(request.getScheme()).thenReturn("Scheme");
    when(request.getServerName()).thenReturn("Server Name");
    when(request.getQueryString()).thenReturn("");
    when(request.getSession()).thenReturn(new MockHttpSession());
    SecurityWrapperResponse response = new SecurityWrapperResponse(new MockHttpServletResponse(), "Mode");

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(request, response,
        new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(request).getScheme();
    verify(request).getServerName();
    verify(request).getServerPort();
    verify(request).getContextPath();
    verify(request).getQueryString();
    verify(request).getSession();
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("/adminU/", ((MockHttpServletResponse) response2).getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertEquals(302, ((MockHttpServletResponse) response2).getStatus());
    assertTrue(headerNames.contains("Location"));
  }

  /**
   * Test
   * {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOnLogoutSuccess5() throws IOException, ServletException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass320 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.security.BroadleafAdminLogoutSuccessHandler broadleafAdminLogoutSuccessHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BroadleafAdminLogoutSuccessHandler broadleafAdminLogoutSuccessHandler2 = new BroadleafAdminLogoutSuccessHandler();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminLogoutSuccessHandler2.onLogoutSuccess(request, response,
        new TestingAuthenticationToken("Principal", "Credentials"));
  }

  /**
   * Test
   * {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)}.
   * <ul>
   *   <li>Given {@code Request}.</li>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} QueryString
   * is {@code Request}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  public void testOnLogoutSuccess_givenRequest_whenMockHttpServletRequestQueryStringIsRequest()
      throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminLogoutSuccessHandler broadleafAdminLogoutSuccessHandler = new BroadleafAdminLogoutSuccessHandler();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setQueryString("Request");

    MockHttpServletResponse response = new MockHttpServletResponse();
    response.setCommitted(false);

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(request, response,
        new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    assertNull(response.getRedirectedUrl());
    assertEquals(403, response.getStatus());
    assertTrue(headerNames.isEmpty());
    assertTrue(response.isCommitted());
  }

  /**
   * Test
   * {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) Status is two
   * hundred.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  public void testOnLogoutSuccess_givenTrue_thenMockHttpServletResponseStatusIsTwoHundred()
      throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminLogoutSuccessHandler broadleafAdminLogoutSuccessHandler = new BroadleafAdminLogoutSuccessHandler();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);

    MockHttpServletResponse response = new MockHttpServletResponse();
    response.setCommitted(true);

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(request, response,
        new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    assertNull(response.getRedirectedUrl());
    assertEquals(200, response.getStatus());
    assertTrue(headerNames.isEmpty());
    assertTrue(response.isCommitted());
  }

  /**
   * Test
   * {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)}.
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) RedirectedUrl
   * is {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  public void testOnLogoutSuccess_thenMockHttpServletResponseRedirectedUrlIsSlash()
      throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminLogoutSuccessHandler broadleafAdminLogoutSuccessHandler = new BroadleafAdminLogoutSuccessHandler();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(request, response,
        new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("/", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
  }
}
