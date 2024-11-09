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
package org.broadleafcommerce.common.sitemap.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class BroadleafSiteMapControllerDiffblueTest {
  /**
   * Test
   * {@link BroadleafSiteMapController#getRequestURIWithoutContext(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafSiteMapController#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  public void testGetRequestURIWithoutContext() {
    // Arrange
    BroadleafSiteMapController broadleafSiteMapController = new BroadleafSiteMapController();

    // Act and Assert
    assertEquals("", broadleafSiteMapController
        .getRequestURIWithoutContext(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Test
   * {@link BroadleafSiteMapController#getRequestURIWithoutContext(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafSiteMapController#getRequestURIWithoutContext(HttpServletRequest)}
   */
  @Test
  public void testGetRequestURIWithoutContext_givenNull() {
    // Arrange
    BroadleafSiteMapController broadleafSiteMapController = new BroadleafSiteMapController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setContextPath(null);

    // Act and Assert
    assertEquals("", broadleafSiteMapController.getRequestURIWithoutContext(request));
  }

  /**
   * Test new {@link BroadleafSiteMapController} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafSiteMapController}
   */
  @Test
  public void testNewBroadleafSiteMapController() {
    // Arrange, Act and Assert
    assertNull((new BroadleafSiteMapController()).siteMapService);
  }
}
