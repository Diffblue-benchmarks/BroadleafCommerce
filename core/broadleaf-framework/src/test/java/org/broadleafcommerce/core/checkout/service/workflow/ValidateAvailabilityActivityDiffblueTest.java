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
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;

public class ValidateAvailabilityActivityDiffblueTest {
  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAvailabilityActivity validateAvailabilityActivity = new ValidateAvailabilityActivity();
    NullOrderImpl order = new NullOrderImpl();

    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    checkoutSeed.setOrder(null);

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertSame(context, validateAvailabilityActivity.execute((ProcessContext<CheckoutSeed>) context));
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_thenReturnProcessContext() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAvailabilityActivity validateAvailabilityActivity = new ValidateAvailabilityActivity();
    ProcessContext<CheckoutSeed> context = mock(ProcessContext.class);
    OrderImpl order = new OrderImpl();
    when(context.getSeedData()).thenReturn(new CheckoutSeed(order, new HashMap<>()));

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult = validateAvailabilityActivity.execute(context);

    // Assert
    verify(context).getSeedData();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_thenThrowIllegalArgumentException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAvailabilityActivity validateAvailabilityActivity = new ValidateAvailabilityActivity();
    Order order = mock(Order.class);
    when(order.getOrderItems()).thenThrow(new IllegalArgumentException("foo"));
    ProcessContext<CheckoutSeed> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CheckoutSeed(order, new HashMap<>()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAvailabilityActivity.execute(context));
    verify(order).getOrderItems();
    verify(context).getSeedData();
  }
}
