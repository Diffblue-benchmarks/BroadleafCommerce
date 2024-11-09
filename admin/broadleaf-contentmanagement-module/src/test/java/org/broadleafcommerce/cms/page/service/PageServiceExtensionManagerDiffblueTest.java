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
package org.broadleafcommerce.cms.page.service;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class PageServiceExtensionManagerDiffblueTest {
  /**
   * Test {@link PageServiceExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test: {@link PageServiceExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceExtensionManager pageServiceExtensionManager = new PageServiceExtensionManager();
    pageServiceExtensionManager.registerHandler(mock(PageServiceExtensionHandler.class));

    // Act and Assert
    assertFalse(pageServiceExtensionManager.continueOnHandled());
  }

  /**
   * Test {@link PageServiceExtensionManager#continueOnHandled()}.
   * <ul>
   *   <li>Given {@link PageServiceExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled_givenPageServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PageServiceExtensionManager()).continueOnHandled());
  }
}
