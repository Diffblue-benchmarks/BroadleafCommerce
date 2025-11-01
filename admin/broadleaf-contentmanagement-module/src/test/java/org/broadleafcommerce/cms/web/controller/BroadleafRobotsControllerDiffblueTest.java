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
package org.broadleafcommerce.cms.web.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class BroadleafRobotsControllerDiffblueTest {
  /**
   * Method under test:
   * {@link BroadleafRobotsController#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure() {
    // Arrange
    BroadleafRobotsController broadleafRobotsController = new BroadleafRobotsController();

    // Act and Assert
    assertFalse(broadleafRobotsController.isSecure(new MockHttpServletRequest()));
  }

  /**
   * Method under test:
   * {@link BroadleafRobotsController#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure2() {
    // Arrange, Act and Assert
    assertFalse((new BroadleafRobotsController()).isSecure(null));
  }

  /**
   * Method under test:
   * {@link BroadleafRobotsController#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure3() {
    // Arrange
    BroadleafRobotsController broadleafRobotsController = new BroadleafRobotsController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setSecure(true);

    // Act and Assert
    assertTrue(broadleafRobotsController.isSecure(request));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link BroadleafRobotsController}
   */
  @Test
  public void testNewBroadleafRobotsController() {
    // Arrange, Act and Assert
    assertNull((new BroadleafRobotsController()).blcContextUtil);
  }
}
