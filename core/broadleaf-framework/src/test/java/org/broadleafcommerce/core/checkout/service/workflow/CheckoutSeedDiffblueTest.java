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
package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertSame;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.Test;

public class CheckoutSeedDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSeed#CheckoutSeed(Order, Map)}
   *   <li>{@link CheckoutSeed#setOrder(Order)}
   *   <li>{@link CheckoutSeed#getOrder()}
   *   <li>{@link CheckoutSeed#getUserDefinedFields()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    HashMap<String, Object> userDefinedFields = new HashMap<>();

    // Act
    CheckoutSeed actualCheckoutSeed = new CheckoutSeed(order, userDefinedFields);
    NullOrderImpl order2 = new NullOrderImpl();
    actualCheckoutSeed.setOrder(order2);
    Order actualOrder = actualCheckoutSeed.getOrder();

    // Assert that nothing has changed
    assertSame(userDefinedFields, actualCheckoutSeed.getUserDefinedFields());
    assertSame(order2, actualOrder);
  }
}