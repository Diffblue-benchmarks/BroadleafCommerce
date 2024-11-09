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
package org.broadleafcommerce.core.order.service.legacy;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.AddToCartException;
import org.junit.Test;

public class LegacyCartServiceImplDiffblueTest {
  /**
   * Test
   * {@link LegacyCartServiceImpl#addItem(Long, OrderItemRequestDTO, boolean)}.
   * <p>
   * Method under test:
   * {@link LegacyCartServiceImpl#addItem(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  public void testAddItem() throws AddToCartException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyCartServiceImpl legacyCartServiceImpl = new LegacyCartServiceImpl();

    // Act and Assert
    assertNull(legacyCartServiceImpl.addItem(1L, new OrderItemRequestDTO(), true));
  }

  /**
   * Test new {@link LegacyCartServiceImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link LegacyCartServiceImpl}
   */
  @Test
  public void testNewLegacyCartServiceImpl() {
    // Arrange and Act
    LegacyCartServiceImpl actualLegacyCartServiceImpl = new LegacyCartServiceImpl();

    // Assert
    assertNull(actualLegacyCartServiceImpl.getFulfillmentGroupDao());
    assertNull(actualLegacyCartServiceImpl.getFulfillmentGroupItemDao());
    assertNull(actualLegacyCartServiceImpl.getOrderDao());
    assertNull(actualLegacyCartServiceImpl.getOrderItemService());
    assertNull(actualLegacyCartServiceImpl.getPaymentInfoDao());
    assertTrue(actualLegacyCartServiceImpl.isDeleteEmptyNamedOrders());
    assertTrue(actualLegacyCartServiceImpl.isMoveNamedOrderItems());
  }
}
