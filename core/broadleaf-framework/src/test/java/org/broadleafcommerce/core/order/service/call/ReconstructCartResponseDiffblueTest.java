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
package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertSame;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;

public class ReconstructCartResponseDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ReconstructCartResponse}
   *   <li>{@link ReconstructCartResponse#setOrder(Order)}
   *   <li>{@link ReconstructCartResponse#setRemovedItems(List)}
   *   <li>{@link ReconstructCartResponse#getOrder()}
   *   <li>{@link ReconstructCartResponse#getRemovedItems()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ReconstructCartResponse actualReconstructCartResponse = new ReconstructCartResponse();
    NullOrderImpl order = new NullOrderImpl();
    actualReconstructCartResponse.setOrder(order);
    ArrayList<OrderItem> removedItems = new ArrayList<>();
    actualReconstructCartResponse.setRemovedItems(removedItems);
    Order actualOrder = actualReconstructCartResponse.getOrder();

    // Assert that nothing has changed
    assertSame(removedItems, actualReconstructCartResponse.getRemovedItems());
    assertSame(order, actualOrder);
  }
}
