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
package org.broadleafcommerce.common.event;

import static org.junit.Assert.assertEquals;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;

public class OrderSubmittedEventDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderSubmittedEvent#getOrderId()}
   *   <li>{@link OrderSubmittedEvent#getOrderNumber()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OrderSubmittedEvent orderSubmittedEvent = new OrderSubmittedEvent(BLCFieldUtils.NULL_FIELD, 1L, "42");

    // Act
    Long actualOrderId = orderSubmittedEvent.getOrderId();

    // Assert
    assertEquals("42", orderSubmittedEvent.getOrderNumber());
    assertEquals(1L, actualOrderId.longValue());
  }
}