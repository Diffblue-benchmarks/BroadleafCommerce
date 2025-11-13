package org.broadleafcommerce.common.web;

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

public class BroadleafRequestInterceptorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafRequestInterceptor}
   *   <li>{@link BroadleafRequestInterceptor#postHandle(WebRequest, ModelMap)}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafRequestInterceptor.<init>()",
    "void BroadleafRequestInterceptor.postHandle(WebRequest, ModelMap)"
  })
  public void testGettersAndSetters() throws Exception {
    // Arrange and Act
    BroadleafRequestInterceptor actualBroadleafRequestInterceptor =
        new BroadleafRequestInterceptor();
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    actualBroadleafRequestInterceptor.postHandle(request, new ModelMap());

    // Assert
    assertNull(actualBroadleafRequestInterceptor.requestProcessor);
  }
}
