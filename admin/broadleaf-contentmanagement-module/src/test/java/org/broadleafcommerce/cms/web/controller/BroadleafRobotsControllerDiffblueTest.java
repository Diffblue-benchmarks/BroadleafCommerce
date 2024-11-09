/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.web.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class BroadleafRobotsControllerDiffblueTest {
  /**
   * Test {@link BroadleafRobotsController#isSecure(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} Secure is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRobotsController#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure_givenTrue_whenMockHttpServletRequestSecureIsTrue_thenReturnTrue() {
    // Arrange
    BroadleafRobotsController broadleafRobotsController = new BroadleafRobotsController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setSecure(true);

    // Act and Assert
    assertTrue(broadleafRobotsController.isSecure(request));
  }

  /**
   * Test {@link BroadleafRobotsController#isSecure(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRobotsController#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure_whenMockHttpServletRequest_thenReturnFalse() {
    // Arrange
    BroadleafRobotsController broadleafRobotsController = new BroadleafRobotsController();

    // Act and Assert
    assertFalse(broadleafRobotsController.isSecure(new MockHttpServletRequest()));
  }

  /**
   * Test {@link BroadleafRobotsController#isSecure(HttpServletRequest)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRobotsController#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BroadleafRobotsController()).isSecure(null));
  }

  /**
   * Test new {@link BroadleafRobotsController} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafRobotsController}
   */
  @Test
  public void testNewBroadleafRobotsController() {
    // Arrange, Act and Assert
    assertNull((new BroadleafRobotsController()).blcContextUtil);
  }
}
