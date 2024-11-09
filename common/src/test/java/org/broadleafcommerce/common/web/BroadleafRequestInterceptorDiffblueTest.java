/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class BroadleafRequestInterceptorDiffblueTest {
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
