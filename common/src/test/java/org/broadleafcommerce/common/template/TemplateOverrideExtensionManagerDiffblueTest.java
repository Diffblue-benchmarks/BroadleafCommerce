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
package org.broadleafcommerce.common.template;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class TemplateOverrideExtensionManagerDiffblueTest {
  /**
   * Test {@link TemplateOverrideExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test:
   * {@link TemplateOverrideExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOverrideExtensionManager templateOverrideExtensionManager = new TemplateOverrideExtensionManager();
    templateOverrideExtensionManager.registerHandler(mock(TemplateOverrideExtensionHandler.class));

    // Act and Assert
    assertTrue(templateOverrideExtensionManager.continueOnHandled());
  }

  /**
   * Test {@link TemplateOverrideExtensionManager#continueOnHandled()}.
   * <ul>
   *   <li>Given {@link TemplateOverrideExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateOverrideExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled_givenTemplateOverrideExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new TemplateOverrideExtensionManager()).continueOnHandled());
  }
}
