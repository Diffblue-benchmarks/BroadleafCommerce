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
package org.broadleafcommerce.core.order.service.workflow;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;

public class AbstractCheckAvailabilityActivityDiffblueTest {
  /**
   * Test {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}
   */
  @Test
  public void testShouldExecute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckAddAvailabilityActivity checkAddAvailabilityActivity = new CheckAddAvailabilityActivity();
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setOrder(new NullOrderImpl());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertTrue(checkAddAvailabilityActivity.shouldExecute((ProcessContext<CartOperationRequest>) context));
  }

  /**
   * Test {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link ProcessContext#getSeedData()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}
   */
  @Test
  public void testShouldExecute_thenCallsGetSeedData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckAddAvailabilityActivity checkAddAvailabilityActivity = new CheckAddAvailabilityActivity();
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    NullOrderImpl order = new NullOrderImpl();
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act
    boolean actualShouldExecuteResult = checkAddAvailabilityActivity.shouldExecute(context);

    // Assert
    verify(context).getSeedData();
    assertTrue(actualShouldExecuteResult);
  }

  /**
   * Test {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}
   */
  @Test
  public void testShouldExecute_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckAddAvailabilityActivity checkAddAvailabilityActivity = new CheckAddAvailabilityActivity();
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setOrder(null);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertFalse(checkAddAvailabilityActivity.shouldExecute((ProcessContext<CartOperationRequest>) context));
  }
}
