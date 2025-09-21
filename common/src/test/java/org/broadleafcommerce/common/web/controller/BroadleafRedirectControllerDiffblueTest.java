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
package org.broadleafcommerce.common.web.controller;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

public class BroadleafRedirectControllerDiffblueTest {
  /**
   * Test {@link BroadleafRedirectController#redirect(HttpServletRequest, HttpServletResponse,
   * Model)}.
   *
   * <ul>
   *   <li>Then return {@code ajaxredirect:}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRedirectController#redirect(HttpServletRequest,
   * HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String BroadleafRedirectController.redirect(HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testRedirect_thenReturnAjaxredirect() {
    // Arrange
    BroadleafRedirectController broadleafRedirectController = new BroadleafRedirectController();
    HttpServletRequestWrapper request = new HttpServletRequestWrapper(new MockHttpServletRequest());
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act and Assert
    assertEquals(
        "ajaxredirect:",
        broadleafRedirectController.redirect(request, response, new ConcurrentModel()));
  }
}
