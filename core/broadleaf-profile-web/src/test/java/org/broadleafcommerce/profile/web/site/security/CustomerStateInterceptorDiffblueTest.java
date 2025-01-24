package org.broadleafcommerce.profile.web.site.security;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

class CustomerStateInterceptorDiffblueTest {
  /**
   * Test {@link CustomerStateInterceptor#preHandle(WebRequest)}.
   * <p>
   * Method under test: {@link CustomerStateInterceptor#preHandle(WebRequest)}
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
    //       at org.broadleafcommerce.profile.web.site.security.CustomerStateInterceptor.preHandle(CustomerStateInterceptor.java:47)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    CustomerStateInterceptor customerStateInterceptor = new CustomerStateInterceptor();

    // Act
    customerStateInterceptor.preHandle(new ServletWebRequest(new MockHttpServletRequest()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomerStateInterceptor}
   *   <li>{@link CustomerStateInterceptor#afterCompletion(WebRequest, Exception)}
   *   <li>{@link CustomerStateInterceptor#postHandle(WebRequest, ModelMap)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws Exception {
    // Arrange and Act
    CustomerStateInterceptor actualCustomerStateInterceptor = new CustomerStateInterceptor();
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    actualCustomerStateInterceptor.afterCompletion(request, new Exception("foo"));
    ServletWebRequest request2 = new ServletWebRequest(new MockHttpServletRequest());
    actualCustomerStateInterceptor.postHandle(request2, new ModelMap());

    // Assert that nothing has changed
    assertNull(actualCustomerStateInterceptor.customerStateProcessor);
  }
}
