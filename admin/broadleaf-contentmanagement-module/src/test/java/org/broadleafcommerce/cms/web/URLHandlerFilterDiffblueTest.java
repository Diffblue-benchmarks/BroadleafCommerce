package org.broadleafcommerce.cms.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.cms.url.service.URLHandlerService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {URLHandlerFilter.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class URLHandlerFilterDiffblueTest {
  @Autowired private URLHandlerFilter uRLHandlerFilter;

  @MockBean(name = "blURLHandlerFilterExtensionManager")
  private URLHandlerFilterExtensionManager uRLHandlerFilterExtensionManager;

  @MockBean(name = "blURLHandlerService")
  private URLHandlerService uRLHandlerService;

  /**
   * Test {@link URLHandlerFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then throw {@link ServletException}.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void URLHandlerFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_thenThrowServletException()
      throws IOException, ServletException {
    // Arrange
    when(uRLHandlerService.findURLHandlerByURI(Mockito.<String>any())).thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException())
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        ServletException.class,
        () -> uRLHandlerFilter.doFilterInternalUnlessIgnored(request, response, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(uRLHandlerService).findURLHandlerByURI("");
  }

  /**
   * Test {@link URLHandlerFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>When {@link FilterChain} {@link FilterChain#doFilter(ServletRequest, ServletResponse)}
   *       does nothing.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void URLHandlerFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_whenFilterChainDoFilterDoesNothing()
      throws IOException, ServletException {
    // Arrange
    when(uRLHandlerService.findURLHandlerByURI(Mockito.<String>any())).thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    uRLHandlerFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(uRLHandlerService).findURLHandlerByURI("");
  }

  /**
   * Test {@link URLHandlerFilter#getExistingQueryParams(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerFilter#getExistingQueryParams(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set URLHandlerFilter.getExistingQueryParams(String)"})
  public void testGetExistingQueryParams_whenHttpsExampleOrgExample_thenReturnEmpty()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Set<String> actualExistingQueryParams =
        URLHandlerFilter.getExistingQueryParams("https://example.org/example");

    // Assert
    assertTrue(actualExistingQueryParams.isEmpty());
  }

  /**
   * Test {@link URLHandlerFilter#getExistingQueryParams(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example?}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerFilter#getExistingQueryParams(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set URLHandlerFilter.getExistingQueryParams(String)"})
  public void testGetExistingQueryParams_whenHttpsExampleOrgExample_thenReturnSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Set<String> actualExistingQueryParams =
        URLHandlerFilter.getExistingQueryParams("https://example.org/example?");

    // Assert
    assertEquals(1, actualExistingQueryParams.size());
    assertTrue(actualExistingQueryParams.contains("?"));
  }

  /**
   * Test {@link URLHandlerFilter#getOrder()}.
   *
   * <p>Method under test: {@link URLHandlerFilter#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int URLHandlerFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(1000000, new URLHandlerFilter().getOrder());
  }
}
