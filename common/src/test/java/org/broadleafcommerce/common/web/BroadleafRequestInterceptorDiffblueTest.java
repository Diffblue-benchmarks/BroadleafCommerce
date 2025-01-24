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
package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertNull;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class BroadleafRequestInterceptorDiffblueTest {
  /**
   * Test {@link BroadleafRequestInterceptor#preHandle(WebRequest)}.
   * <p>
   * Method under test: {@link BroadleafRequestInterceptor#preHandle(WebRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPreHandle() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.web.BroadleafRequestInterceptor.preHandle(BroadleafRequestInterceptor.java:44)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BroadleafRequestInterceptor broadleafRequestInterceptor = new BroadleafRequestInterceptor();

    // Act
    broadleafRequestInterceptor
        .preHandle(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Test
   * {@link BroadleafRequestInterceptor#afterCompletion(WebRequest, Exception)}.
   * <p>
   * Method under test:
   * {@link BroadleafRequestInterceptor#afterCompletion(WebRequest, Exception)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAfterCompletion() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.web.BroadleafRequestInterceptor.afterCompletion(BroadleafRequestInterceptor.java:54)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BroadleafRequestInterceptor broadleafRequestInterceptor = new BroadleafRequestInterceptor();
    ServletWebRequest request = new ServletWebRequest(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    broadleafRequestInterceptor.afterCompletion(request, new Exception("foo"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafRequestInterceptor}
   *   <li>{@link BroadleafRequestInterceptor#postHandle(WebRequest, ModelMap)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws Exception {
    // Arrange and Act
    BroadleafRequestInterceptor actualBroadleafRequestInterceptor = new BroadleafRequestInterceptor();
    ServletWebRequest request = new ServletWebRequest(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    actualBroadleafRequestInterceptor.postHandle(request, new ModelMap());

    // Assert that nothing has changed
    assertNull(actualBroadleafRequestInterceptor.requestProcessor);
  }
}
