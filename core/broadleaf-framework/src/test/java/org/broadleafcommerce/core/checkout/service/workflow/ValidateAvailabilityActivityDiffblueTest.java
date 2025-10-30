/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidateAvailabilityActivityDiffblueTest {
  @InjectMocks
  private ValidateAvailabilityActivity validateAvailabilityActivity;

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    checkoutSeed.setOrder(null);

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertSame(context, validateAvailabilityActivity.execute(context));
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then SeedData Order return {@link OrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_thenSeedDataOrderReturnOrderImpl() throws Exception {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    OrderImpl order2 = new OrderImpl();
    checkoutSeed.setOrder(order2);

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult = validateAvailabilityActivity.execute(context);

    // Assert
    Order order3 = actualExecuteResult.getSeedData().getOrder();
    assertTrue(order3 instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(order2, order3);
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    Order order = mock(Order.class);
    when(order.getOrderItems()).thenThrow(new IllegalArgumentException("foo"));
    NullOrderImpl order2 = new NullOrderImpl();

    CheckoutSeed checkoutSeed = new CheckoutSeed(order2, new HashMap<>());
    checkoutSeed.setOrder(order);

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAvailabilityActivity.execute(context));
    verify(order).getOrderItems();
  }
}
