/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultURLHandlerFilterExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultURLHandlerFilterExtensionHandlerDiffblueTest {
  @Autowired
  private DefaultURLHandlerFilterExtensionHandler defaultURLHandlerFilterExtensionHandler;

  /**
   * Test {@link DefaultURLHandlerFilterExtensionHandler#processPreRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <p>Method under test: {@link
   * DefaultURLHandlerFilterExtensionHandler#processPreRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType DefaultURLHandlerFilterExtensionHandler.processPreRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testProcessPreRedirect() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        defaultURLHandlerFilterExtensionHandler.processPreRedirect(
            request, new MockHttpServletResponse(), "https://example.org/example"));
  }

  /**
   * Test new {@link DefaultURLHandlerFilterExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * DefaultURLHandlerFilterExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultURLHandlerFilterExtensionHandler.<init>()"})
  public void testNewDefaultURLHandlerFilterExtensionHandler() {
    // Arrange and Act
    DefaultURLHandlerFilterExtensionHandler actualDefaultURLHandlerFilterExtensionHandler =
        new DefaultURLHandlerFilterExtensionHandler();

    // Assert
    assertEquals(0, actualDefaultURLHandlerFilterExtensionHandler.getPriority());
    assertTrue(actualDefaultURLHandlerFilterExtensionHandler.isEnabled());
  }
}
