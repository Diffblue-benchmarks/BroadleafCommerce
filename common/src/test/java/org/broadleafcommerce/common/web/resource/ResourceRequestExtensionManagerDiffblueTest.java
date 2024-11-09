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
package org.broadleafcommerce.common.web.resource;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class ResourceRequestExtensionManagerDiffblueTest {
  /**
   * Test {@link ResourceRequestExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test:
   * {@link ResourceRequestExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceRequestExtensionManager resourceRequestExtensionManager = new ResourceRequestExtensionManager();
    resourceRequestExtensionManager.registerHandler(mock(AbstractResourceRequestExtensionHandler.class));

    // Act and Assert
    assertFalse(resourceRequestExtensionManager.continueOnHandled());
  }

  /**
   * Test {@link ResourceRequestExtensionManager#continueOnHandled()}.
   * <ul>
   *   <li>Given {@link ResourceRequestExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceRequestExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled_givenResourceRequestExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ResourceRequestExtensionManager()).continueOnHandled());
  }
}
