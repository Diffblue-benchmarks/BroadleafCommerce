package org.broadleafcommerce.common.web.filter;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class TranslationInterceptorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TranslationInterceptor}
   *   <li>{@link TranslationInterceptor#afterCompletion(WebRequest, Exception)}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TranslationInterceptor.<init>()",
    "void TranslationInterceptor.afterCompletion(WebRequest, Exception)"
  })
  public void testGettersAndSetters() throws Exception {
    // Arrange and Act
    TranslationInterceptor actualTranslationInterceptor = new TranslationInterceptor();
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    actualTranslationInterceptor.afterCompletion(request, new Exception());

    // Assert
    assertNull(actualTranslationInterceptor.translationRequestProcessor);
  }
}
