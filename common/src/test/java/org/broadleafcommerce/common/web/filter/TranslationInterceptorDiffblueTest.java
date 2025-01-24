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
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class TranslationInterceptorDiffblueTest {
  /**
   * Test {@link TranslationInterceptor#preHandle(WebRequest)}.
   * <p>
   * Method under test: {@link TranslationInterceptor#preHandle(WebRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPreHandle() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.web.filter.TranslationInterceptor.preHandle(TranslationInterceptor.java:38)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TranslationInterceptor translationInterceptor = new TranslationInterceptor();

    // Act
    translationInterceptor
        .preHandle(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Test {@link TranslationInterceptor#postHandle(WebRequest, ModelMap)}.
   * <ul>
   *   <li>When {@link ModelMap#ModelMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationInterceptor#postHandle(WebRequest, ModelMap)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPostHandle_whenModelMap() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.web.filter.TranslationInterceptor.postHandle(TranslationInterceptor.java:43)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TranslationInterceptor translationInterceptor = new TranslationInterceptor();
    ServletWebRequest request = new ServletWebRequest(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    translationInterceptor.postHandle(request, new ModelMap());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TranslationInterceptor}
   *   <li>{@link TranslationInterceptor#afterCompletion(WebRequest, Exception)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws Exception {
    // Arrange and Act
    TranslationInterceptor actualTranslationInterceptor = new TranslationInterceptor();
    ServletWebRequest request = new ServletWebRequest(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    actualTranslationInterceptor.afterCompletion(request, new Exception("foo"));

    // Assert that nothing has changed
    assertNull(actualTranslationInterceptor.translationRequestProcessor);
  }
}
