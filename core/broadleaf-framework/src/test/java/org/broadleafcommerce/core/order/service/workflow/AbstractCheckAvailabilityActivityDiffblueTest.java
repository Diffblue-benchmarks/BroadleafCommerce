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
package org.broadleafcommerce.core.order.service.workflow;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.inventory.service.ContextualInventoryService;
import org.broadleafcommerce.core.inventory.service.InventoryUnavailableException;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AbstractCheckAvailabilityActivityDiffblueTest {
  @InjectMocks private CheckAddAvailabilityActivity checkAddAvailabilityActivity;

  @Mock private ContextualInventoryService contextualInventoryService;

  /**
   * Test {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCheckAvailabilityActivity.shouldExecute(ProcessContext)"})
  public void testShouldExecute_thenReturnFalse() {
    // Arrange
    CheckAddAvailabilityActivity checkAddAvailabilityActivity = new CheckAddAvailabilityActivity();
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setOrder(null);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertFalse(checkAddAvailabilityActivity.shouldExecute(context));
  }

  /**
   * Test {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCheckAvailabilityActivity.shouldExecute(ProcessContext)"})
  public void testShouldExecute_thenReturnTrue() {
    // Arrange
    CheckAddAvailabilityActivity checkAddAvailabilityActivity = new CheckAddAvailabilityActivity();
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setOrder(new NullOrderImpl());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertTrue(checkAddAvailabilityActivity.shouldExecute(context));
  }

  /**
   * Test {@link AbstractCheckAvailabilityActivity#checkSkuAvailability(Order, Sku, Integer)}.
   *
   * <ul>
   *   <li>Then calls {@link ContextualInventoryService#checkSkuAvailability(Order, Sku, Integer)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCheckAvailabilityActivity#checkSkuAvailability(Order, Sku,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractCheckAvailabilityActivity.checkSkuAvailability(Order, Sku, Integer)"
  })
  public void testCheckSkuAvailability_thenCallsCheckSkuAvailability()
      throws InventoryUnavailableException {
    // Arrange
    doNothing()
        .when(contextualInventoryService)
        .checkSkuAvailability(Mockito.<Order>any(), Mockito.<Sku>any(), Mockito.<Integer>any());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    checkAddAvailabilityActivity.checkSkuAvailability(order, new SkuImpl(), 1);

    // Assert
    verify(contextualInventoryService)
        .checkSkuAvailability(isA(Order.class), isA(Sku.class), eq(1));
  }
}
