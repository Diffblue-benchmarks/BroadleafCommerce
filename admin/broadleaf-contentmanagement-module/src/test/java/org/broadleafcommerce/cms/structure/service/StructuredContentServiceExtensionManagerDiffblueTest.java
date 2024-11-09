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
package org.broadleafcommerce.cms.structure.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class StructuredContentServiceExtensionManagerDiffblueTest {
  /**
   * Test {@link StructuredContentServiceExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceExtensionManager structuredContentServiceExtensionManager = new StructuredContentServiceExtensionManager();
    structuredContentServiceExtensionManager
        .registerHandler(mock(AbstractStructuredContentServiceExtensionHandler.class));

    // Act and Assert
    assertTrue(structuredContentServiceExtensionManager.continueOnHandled());
  }

  /**
   * Test {@link StructuredContentServiceExtensionManager#continueOnHandled()}.
   * <ul>
   *   <li>Given {@link StructuredContentServiceExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled_givenStructuredContentServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new StructuredContentServiceExtensionManager()).continueOnHandled());
  }
}
