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
package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class BroadleafTemplateViewResolverExtensionManagerDiffblueTest {
  /**
   * Test {@link BroadleafTemplateViewResolverExtensionManager#getHandlers()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafTemplateViewResolverExtensionManager#getHandlers()}
   */
  @Test
  public void testGetHandlers_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new BroadleafTemplateViewResolverExtensionManager()).getHandlers().isEmpty());
  }

  /**
   * Test {@link BroadleafTemplateViewResolverExtensionManager#getHandlers()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafTemplateViewResolverExtensionManager#getHandlers()}
   */
  @Test
  public void testGetHandlers_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafTemplateViewResolverExtensionManager broadleafTemplateViewResolverExtensionManager = new BroadleafTemplateViewResolverExtensionManager();
    broadleafTemplateViewResolverExtensionManager
        .registerHandler(mock(BroadleafTemplateViewResolverExtensionHandler.class));

    // Act and Assert
    assertEquals(1, broadleafTemplateViewResolverExtensionManager.getHandlers().size());
  }

  /**
   * Test
   * {@link BroadleafTemplateViewResolverExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test:
   * {@link BroadleafTemplateViewResolverExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafTemplateViewResolverExtensionManager broadleafTemplateViewResolverExtensionManager = new BroadleafTemplateViewResolverExtensionManager();
    broadleafTemplateViewResolverExtensionManager
        .registerHandler(mock(BroadleafTemplateViewResolverExtensionHandler.class));

    // Act and Assert
    assertTrue(broadleafTemplateViewResolverExtensionManager.continueOnHandled());
  }

  /**
   * Test
   * {@link BroadleafTemplateViewResolverExtensionManager#continueOnHandled()}.
   * <ul>
   *   <li>Given {@link BroadleafTemplateViewResolverExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafTemplateViewResolverExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled_givenBroadleafTemplateViewResolverExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new BroadleafTemplateViewResolverExtensionManager()).continueOnHandled());
  }
}
