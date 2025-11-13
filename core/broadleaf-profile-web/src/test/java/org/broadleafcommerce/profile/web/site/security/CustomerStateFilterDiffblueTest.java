package org.broadleafcommerce.profile.web.site.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.profile.web.core.security.CustomerStateRequestProcessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {CustomerStateFilter.class})
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
class CustomerStateFilterDiffblueTest {
  @Autowired private CustomerStateFilter customerStateFilter;

  @MockBean(name = "blCustomerStateRequestProcessor")
  private CustomerStateRequestProcessor customerStateRequestProcessor;

  /**
   * Test {@link CustomerStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse,
   * FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerStateFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  void testDoFilterInternalUnlessIgnored_givenIOException_thenThrowIOException()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(customerStateRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(customerStateRequestProcessor).process(Mockito.<WebRequest>any());
    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doThrow(new IOException())
        .when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> customerStateFilter.doFilterInternalUnlessIgnored(baseRequest, baseResponse, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(customerStateRequestProcessor).postProcess(isA(WebRequest.class));
    verify(customerStateRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CustomerStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>When {@link FilterChain} {@link FilterChain#doFilter(ServletRequest, ServletResponse)}
   *       does nothing.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerStateFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse,
   * FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); when FilterChain doFilter(ServletRequest, ServletResponse) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerStateFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  void testDoFilterInternalUnlessIgnored_whenFilterChainDoFilterDoesNothing()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(customerStateRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(customerStateRequestProcessor).process(Mockito.<WebRequest>any());
    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    customerStateFilter.doFilterInternalUnlessIgnored(baseRequest, baseResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(customerStateRequestProcessor).postProcess(isA(WebRequest.class));
    verify(customerStateRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerStateFilter#isIgnored(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName("Test isIgnored(HttpServletRequest, HttpServletResponse); given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerStateFilter.isIgnored(HttpServletRequest, HttpServletResponse)"
  })
  void testIsIgnored_givenFalse() {
    // Arrange
    DefaultMultipartHttpServletRequest httpServletRequest =
        mock(DefaultMultipartHttpServletRequest.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualIsIgnoredResult =
        customerStateFilter.isIgnored(httpServletRequest, new MockHttpServletResponse());

    // Assert
    verify(httpServletRequest, atLeast(1)).getAttribute(Mockito.<String>any());
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Test {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerStateFilter#isIgnored(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName("Test isIgnored(HttpServletRequest, HttpServletResponse); given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerStateFilter.isIgnored(HttpServletRequest, HttpServletResponse)"
  })
  void testIsIgnored_givenTrue() {
    // Arrange
    DefaultMultipartHttpServletRequest httpServletRequest =
        mock(DefaultMultipartHttpServletRequest.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualIsIgnoredResult =
        customerStateFilter.isIgnored(httpServletRequest, new MockHttpServletResponse());

    // Assert
    verify(httpServletRequest).getAttribute("blUriIsFilterIgnored");
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Test {@link CustomerStateFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerStateFilter#isIgnored(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName(
      "Test isIgnored(HttpServletRequest, HttpServletResponse); when MockHttpServletRequest(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerStateFilter.isIgnored(HttpServletRequest, HttpServletResponse)"
  })
  void testIsIgnored_whenMockHttpServletRequest_thenReturnFalse() {
    // Arrange
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(customerStateFilter.isIgnored(httpServletRequest, new MockHttpServletResponse()));
  }

  /**
   * Test {@link CustomerStateFilter#getOrder()}.
   *
   * <p>Method under test: {@link CustomerStateFilter#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CustomerStateFilter.getOrder()"})
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(10050, customerStateFilter.getOrder());
  }

  /**
   * Test {@link CustomerStateFilter#shouldNotFilterErrorDispatch()}.
   *
   * <p>Method under test: {@link CustomerStateFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  @DisplayName("Test shouldNotFilterErrorDispatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerStateFilter.shouldNotFilterErrorDispatch()"})
  void testShouldNotFilterErrorDispatch() {
    // Arrange, Act and Assert
    assertFalse(customerStateFilter.shouldNotFilterErrorDispatch());
  }
}
