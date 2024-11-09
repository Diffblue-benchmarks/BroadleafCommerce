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
package org.broadleafcommerce.common.web.controller;

import static org.junit.Assert.assertFalse;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class BroadleafControllerUtilityDiffblueTest {
  /**
   * Test {@link BroadleafControllerUtility#isAjaxRequest(HttpServletRequest)}
   * with {@code HttpServletRequest}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafControllerUtility#isAjaxRequest(HttpServletRequest)}
   */
  @Test
  public void testIsAjaxRequestWithHttpServletRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BroadleafControllerUtility
        .isAjaxRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Test {@link BroadleafControllerUtility#isAjaxRequest(WebRequest)} with
   * {@code WebRequest}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafControllerUtility#isAjaxRequest(WebRequest)}
   */
  @Test
  public void testIsAjaxRequestWithWebRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BroadleafControllerUtility
        .isAjaxRequest(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
  }
}
