/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.order.dao;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class OrderDaoExtensionManagerDiffblueTest {
  /**
   * Test {@link OrderDaoExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test: {@link OrderDaoExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderDaoExtensionManager orderDaoExtensionManager = new OrderDaoExtensionManager();
    orderDaoExtensionManager.registerHandler(mock(AbstractOrderDaoExtensionHandler.class));

    // Act and Assert
    assertTrue(orderDaoExtensionManager.continueOnHandled());
  }

  /**
   * Test {@link OrderDaoExtensionManager#continueOnHandled()}.
   * <ul>
   *   <li>Given {@link OrderDaoExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderDaoExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled_givenOrderDaoExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OrderDaoExtensionManager()).continueOnHandled());
  }
}
