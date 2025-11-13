package org.broadleafcommerce.profile.web.site.security;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

class CustomerStateInterceptorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomerStateInterceptor}
   *   <li>{@link CustomerStateInterceptor#afterCompletion(WebRequest, Exception)}
   *   <li>{@link CustomerStateInterceptor#postHandle(WebRequest, ModelMap)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerStateInterceptor.<init>()",
    "void CustomerStateInterceptor.afterCompletion(WebRequest, Exception)",
    "void CustomerStateInterceptor.postHandle(WebRequest, ModelMap)"
  })
  void testGettersAndSetters() throws Exception {
    // Arrange and Act
    CustomerStateInterceptor actualCustomerStateInterceptor = new CustomerStateInterceptor();
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    actualCustomerStateInterceptor.afterCompletion(request, new Exception());
    ServletWebRequest request2 = new ServletWebRequest(new MockHttpServletRequest());
    actualCustomerStateInterceptor.postHandle(request2, new ModelMap());

    // Assert
    assertNull(actualCustomerStateInterceptor.customerStateProcessor);
  }
}
