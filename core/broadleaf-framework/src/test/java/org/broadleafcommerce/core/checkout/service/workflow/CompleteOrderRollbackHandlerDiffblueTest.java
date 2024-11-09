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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.workflow.Activity;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.state.RollbackFailureException;
import org.junit.Test;

public class CompleteOrderRollbackHandlerDiffblueTest {
  /**
   * Test
   * {@link CompleteOrderRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   * <ul>
   *   <li>Then {@link DefaultProcessContextImpl} (default constructor) SeedData
   * Order {@link OrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CompleteOrderRollbackHandler#rollbackState(Activity, ProcessContext, Map)}
   */
  @Test
  public void testRollbackState_thenDefaultProcessContextImplSeedDataOrderOrderImpl() throws RollbackFailureException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CompleteOrderRollbackHandler completeOrderRollbackHandler = new CompleteOrderRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    OrderImpl order = new OrderImpl();
    processContext.setSeedData(new CheckoutSeed(order, new HashMap<>()));

    // Act
    completeOrderRollbackHandler.rollbackState(activity, processContext, new HashMap<>());

    // Assert
    Order order2 = processContext.getSeedData().getOrder();
    assertTrue(order2 instanceof OrderImpl);
    OrderStatus status = order2.getStatus();
    assertEquals("IN_PROCESS", status.getType());
    assertEquals("In Process", status.getFriendlyType());
    assertTrue(status.isEditable());
  }
}
