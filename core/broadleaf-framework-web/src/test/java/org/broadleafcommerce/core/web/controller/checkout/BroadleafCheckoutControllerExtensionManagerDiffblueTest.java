/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.controller.checkout;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BroadleafCheckoutControllerExtensionManagerDiffblueTest {
  /**
   * Test {@link BroadleafCheckoutControllerExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutControllerExtensionManager#continueOnHandled()}
   */
  @Test
  @DisplayName("Test continueOnHandled()")
  void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager = new BroadleafCheckoutControllerExtensionManager();
    broadleafCheckoutControllerExtensionManager
        .registerHandler(mock(BroadleafCheckoutControllerExtensionHandler.class));

    // Act and Assert
    assertTrue(broadleafCheckoutControllerExtensionManager.continueOnHandled());
  }

  /**
   * Test {@link BroadleafCheckoutControllerExtensionManager#continueOnHandled()}.
   * <ul>
   *   <li>Given {@link BroadleafCheckoutControllerExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutControllerExtensionManager#continueOnHandled()}
   */
  @Test
  @DisplayName("Test continueOnHandled(); given BroadleafCheckoutControllerExtensionManager (default constructor)")
  void testContinueOnHandled_givenBroadleafCheckoutControllerExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new BroadleafCheckoutControllerExtensionManager()).continueOnHandled());
  }
}
