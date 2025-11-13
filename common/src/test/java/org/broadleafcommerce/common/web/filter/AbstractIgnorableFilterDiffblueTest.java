package org.broadleafcommerce.common.web.filter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.api.common.web.filter.StatelessSessionFilter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {StatelessSessionFilter.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class AbstractIgnorableFilterDiffblueTest {
  @Autowired private AbstractIgnorableFilter abstractIgnorableFilter;

  /**
   * Test {@link AbstractIgnorableFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>When {@link FilterChain} {@link FilterChain#doFilter(ServletRequest, ServletResponse)}
   *       does nothing.
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractIgnorableFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractIgnorableFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  public void testDoFilter_whenFilterChainDoFilterDoesNothing_thenCallsDoFilter()
      throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    abstractIgnorableFilter.doFilter(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link AbstractIgnorableFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractIgnorableFilter#isIgnored(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractIgnorableFilter.isIgnored(HttpServletRequest, HttpServletResponse)"
  })
  public void testIsIgnored_givenTrue_thenReturnTrue() {
    // Arrange
    SessionlessHttpServletRequestWrapper httpServletRequest =
        mock(SessionlessHttpServletRequestWrapper.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualIsIgnoredResult =
        abstractIgnorableFilter.isIgnored(httpServletRequest, new MockHttpServletResponse());

    // Assert
    verify(httpServletRequest).getAttribute("blUriIsFilterIgnored");
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Test {@link AbstractIgnorableFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractIgnorableFilter#isIgnored(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractIgnorableFilter.isIgnored(HttpServletRequest, HttpServletResponse)"
  })
  public void testIsIgnored_whenMockHttpServletRequest_thenReturnFalse() {
    // Arrange
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(
        abstractIgnorableFilter.isIgnored(httpServletRequest, new MockHttpServletResponse()));
  }
}
