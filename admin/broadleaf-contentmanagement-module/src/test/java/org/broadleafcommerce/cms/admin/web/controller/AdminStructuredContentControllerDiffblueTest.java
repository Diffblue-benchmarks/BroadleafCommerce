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
package org.broadleafcommerce.cms.admin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;

public class AdminStructuredContentControllerDiffblueTest {
  /**
   * Method under test:
   * {@link AdminStructuredContentController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminStructuredContentController adminStructuredContentController = new AdminStructuredContentController();

    // Act and Assert
    assertEquals("structured-content", adminStructuredContentController.getSectionKey(new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link AdminStructuredContentController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminStructuredContentController adminStructuredContentController = new AdminStructuredContentController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminStructuredContentController.getSectionKey(pathVars));
  }

  /**
   * Method under test:
   * {@link AdminStructuredContentController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminStructuredContentController adminStructuredContentController = new AdminStructuredContentController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.computeIfPresent("sectionKey", mock(BiFunction.class));
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminStructuredContentController.getSectionKey(pathVars));
  }
}
