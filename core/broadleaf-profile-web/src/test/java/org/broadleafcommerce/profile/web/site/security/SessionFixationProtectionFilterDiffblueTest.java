package org.broadleafcommerce.profile.web.site.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.encryption.EncryptionModule;
import org.broadleafcommerce.common.security.util.CookieUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {SessionFixationProtectionFilter.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
class SessionFixationProtectionFilterDiffblueTest {
  @MockBean(name = "blCookieUtils")
  private CookieUtils cookieUtils;

  @MockBean(name = "blSessionFixationEncryptionModule")
  private EncryptionModule encryptionModule;

  @Autowired private SessionFixationProtectionFilter sessionFixationProtectionFilter;

  /**
   * Test {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link MockHttpSession#MockHttpSession()}.
   * </ul>
   *
   * <p>Method under test: {@link SessionFixationProtectionFilter#doFilter(ServletRequest,
   * ServletResponse, FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilter(ServletRequest, ServletResponse, FilterChain); given MockHttpSession()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SessionFixationProtectionFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  void testDoFilter_givenMockHttpSession() throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest sRequest = new MockHttpServletRequest();
    sRequest.setSession(new MockHttpSession());
    MockHttpServletResponse sResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    sessionFixationProtectionFilter.doFilter(sRequest, sResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link MockHttpSession#MockHttpSession()} Attribute {@code SFP-ActiveID} is {@code
   *       Value}.
   * </ul>
   *
   * <p>Method under test: {@link SessionFixationProtectionFilter#doFilter(ServletRequest,
   * ServletResponse, FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilter(ServletRequest, ServletResponse, FilterChain); given MockHttpSession() Attribute 'SFP-ActiveID' is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SessionFixationProtectionFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  void testDoFilter_givenMockHttpSessionAttributeSfpActiveIDIsValue()
      throws IOException, ServletException {
    // Arrange
    MockHttpSession session = new MockHttpSession();
    session.setAttribute("SFP-ActiveID", "Value");

    MockHttpServletRequest sRequest = new MockHttpServletRequest();
    sRequest.setSession(session);
    MockHttpServletResponse sResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    sessionFixationProtectionFilter.doFilter(sRequest, sResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link ServletException#ServletException()}.
   *   <li>Then throw {@link ServletException}.
   * </ul>
   *
   * <p>Method under test: {@link SessionFixationProtectionFilter#doFilter(ServletRequest,
   * ServletResponse, FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilter(ServletRequest, ServletResponse, FilterChain); given ServletException(); then throw ServletException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SessionFixationProtectionFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  void testDoFilter_givenServletException_thenThrowServletException()
      throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest sRequest = new MockHttpServletRequest();
    MockHttpServletResponse sResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doThrow(new ServletException())
        .when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        ServletException.class,
        () -> sessionFixationProtectionFilter.doFilter(sRequest, sResponse, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link SessionFixationProtectionFilter#doFilter(ServletRequest,
   * ServletResponse, FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilter(ServletRequest, ServletResponse, FilterChain); when MockHttpServletRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SessionFixationProtectionFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  void testDoFilter_whenMockHttpServletRequest() throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest sRequest = new MockHttpServletRequest();
    MockHttpServletResponse sResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    sessionFixationProtectionFilter.doFilter(sRequest, sResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link SessionFixationProtectionFilter#abortUser(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link SessionFixationProtectionFilter#abortUser(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName("Test abortUser(HttpServletRequest, HttpServletResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SessionFixationProtectionFilter.abortUser(HttpServletRequest, HttpServletResponse)"
  })
  void testAbortUser() throws IOException {
    // Arrange
    doNothing()
        .when(cookieUtils)
        .invalidateCookie(Mockito.<HttpServletResponse>any(), Mockito.<String>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    sessionFixationProtectionFilter.abortUser(request, response);

    // Assert
    verify(cookieUtils).invalidateCookie(isA(HttpServletResponse.class), eq("ActiveID"));
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("/", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }
}
