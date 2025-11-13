package org.broadleafcommerce.core.web.order.security;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class CartStateInterceptorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CartStateInterceptor}
   *   <li>{@link CartStateInterceptor#afterCompletion(WebRequest, Exception)}
   *   <li>{@link CartStateInterceptor#postHandle(WebRequest, ModelMap)}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CartStateInterceptor.<init>()",
    "void CartStateInterceptor.afterCompletion(WebRequest, Exception)",
    "void CartStateInterceptor.postHandle(WebRequest, ModelMap)"
  })
  public void testGettersAndSetters() throws Exception {
    // Arrange and Act
    CartStateInterceptor actualCartStateInterceptor = new CartStateInterceptor();
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    actualCartStateInterceptor.afterCompletion(request, new Exception());
    ServletWebRequest request2 = new ServletWebRequest(new MockHttpServletRequest());
    actualCartStateInterceptor.postHandle(request2, new ModelMap());

    // Assert
    assertNull(actualCartStateInterceptor.cartStateProcessor);
  }
}
