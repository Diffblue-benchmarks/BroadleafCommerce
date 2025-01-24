package org.broadleafcommerce.core.web.order.security;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

class CartStateInterceptorDiffblueTest {
  /**
   * Test {@link CartStateInterceptor#preHandle(WebRequest)}.
   * <p>
   * Method under test: {@link CartStateInterceptor#preHandle(WebRequest)}
   */
  @Test
  @DisplayName("Test preHandle(WebRequest)")
  @Disabled("TODO: Complete this test")
  void testPreHandle() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.order.security.CartStateInterceptor.preHandle(CartStateInterceptor.java:47)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    CartStateInterceptor cartStateInterceptor = new CartStateInterceptor();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    cartStateInterceptor.preHandle(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CartStateInterceptor}
   *   <li>{@link CartStateInterceptor#afterCompletion(WebRequest, Exception)}
   *   <li>{@link CartStateInterceptor#postHandle(WebRequest, ModelMap)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws Exception {
    // Arrange and Act
    CartStateInterceptor actualCartStateInterceptor = new CartStateInterceptor();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    ServletWebRequest request = new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
    actualCartStateInterceptor.afterCompletion(request, new Exception("foo"));
    MockHttpServletRequest servletRequest2 = new MockHttpServletRequest();
    ServletWebRequest request2 = new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest2,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
    actualCartStateInterceptor.postHandle(request2, new ModelMap());

    // Assert that nothing has changed
    assertNull(actualCartStateInterceptor.cartStateProcessor);
  }
}
