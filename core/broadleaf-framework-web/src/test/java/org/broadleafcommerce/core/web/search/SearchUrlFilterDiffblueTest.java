package org.broadleafcommerce.core.web.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {SearchUrlFilter.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SearchUrlFilterDiffblueTest {
  @Autowired private SearchUrlFilter searchUrlFilter;

  /**
   * Test {@link SearchUrlFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then throw {@link ServletException}.
   * </ul>
   *
   * <p>Method under test: {@link SearchUrlFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SearchUrlFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_thenThrowServletException()
      throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException())
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        ServletException.class,
        () ->
            searchUrlFilter.doFilterInternalUnlessIgnored(
                httpServletRequest, httpServletResponse, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link SearchUrlFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>When {@link FilterChain} {@link FilterChain#doFilter(ServletRequest, ServletResponse)}
   *       does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SearchUrlFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SearchUrlFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_whenFilterChainDoFilterDoesNothing()
      throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    searchUrlFilter.doFilterInternalUnlessIgnored(
        httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link SearchUrlFilter#wrapRequest(HttpServletRequest)}.
   *
   * <p>Method under test: {@link SearchUrlFilter#wrapRequest(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SearchRequestWrapper SearchUrlFilter.wrapRequest(HttpServletRequest)"})
  public void testWrapRequest() throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();

    // Act
    SearchRequestWrapper actualWrapRequestResult = searchUrlFilter.wrapRequest(httpServletRequest);

    // Assert
    Collection<Part> parts = actualWrapRequestResult.getParts();
    assertTrue(parts instanceof List);
    ServletRequest request = actualWrapRequestResult.getRequest();
    assertTrue(request instanceof MockHttpServletRequest);
    assertTrue(actualWrapRequestResult.getSession() instanceof MockHttpSession);
    assertTrue(actualWrapRequestResult.getServletContext() instanceof MockServletContext);
    assertEquals("", actualWrapRequestResult.getContextPath());
    assertEquals("", actualWrapRequestResult.getMethod());
    assertEquals("", actualWrapRequestResult.getRequestURI());
    assertEquals("", actualWrapRequestResult.getServletPath());
    assertEquals("HTTP/1.1", actualWrapRequestResult.getProtocol());
    assertEquals("http", actualWrapRequestResult.getScheme());
    assertEquals("localhost", actualWrapRequestResult.getLocalName());
    assertEquals("localhost", actualWrapRequestResult.getRemoteHost());
    assertEquals("localhost", actualWrapRequestResult.getServerName());
    assertNull(actualWrapRequestResult.getCharacterEncoding());
    assertNull(actualWrapRequestResult.getContentType());
    assertNull(actualWrapRequestResult.getAuthType());
    assertNull(actualWrapRequestResult.getPathInfo());
    assertNull(actualWrapRequestResult.getPathTranslated());
    assertNull(actualWrapRequestResult.getQueryString());
    assertNull(actualWrapRequestResult.getRemoteUser());
    assertNull(actualWrapRequestResult.getRequestedSessionId());
    assertNull(actualWrapRequestResult.getUserPrincipal());
    assertNull(actualWrapRequestResult.getAsyncContext());
    assertNull(actualWrapRequestResult.getCookies());
    assertEquals(-1, actualWrapRequestResult.getContentLength());
    assertEquals(-1L, actualWrapRequestResult.getContentLengthLong());
    assertEquals(80, actualWrapRequestResult.getLocalPort());
    assertEquals(80, actualWrapRequestResult.getRemotePort());
    assertEquals(80, actualWrapRequestResult.getServerPort());
    assertEquals(DispatcherType.REQUEST, actualWrapRequestResult.getDispatcherType());
    assertFalse(actualWrapRequestResult.isAsyncStarted());
    assertFalse(actualWrapRequestResult.isAsyncSupported());
    assertFalse(actualWrapRequestResult.isSecure());
    assertTrue(parts.isEmpty());
    assertTrue(actualWrapRequestResult.getParameterMap().isEmpty());
    assertTrue(actualWrapRequestResult.getTrailerFields().isEmpty());
    assertSame(httpServletRequest, request);
  }

  /**
   * Test {@link SearchUrlFilter#getOrder()}.
   *
   * <p>Method under test: {@link SearchUrlFilter#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SearchUrlFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(1000000, new SearchUrlFilter().getOrder());
  }
}
