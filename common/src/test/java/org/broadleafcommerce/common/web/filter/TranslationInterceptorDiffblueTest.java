/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.web.filter;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequestWrapper;
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
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);
    actualTranslationInterceptor.afterCompletion(request2, new Exception());

    // Assert
    assertNull(actualTranslationInterceptor.translationRequestProcessor);
  }
}
