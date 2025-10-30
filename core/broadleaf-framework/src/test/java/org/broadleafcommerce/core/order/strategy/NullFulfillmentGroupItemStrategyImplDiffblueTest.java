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
package org.broadleafcommerce.core.order.strategy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NullFulfillmentGroupItemStrategyImplDiffblueTest {
  @InjectMocks
  private NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl;

  @Mock
  private FulfillmentGroupService fulfillmentGroupService;

  /**
   * Test {@link NullFulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   * <p>
   * Method under test: {@link NullFulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest NullFulfillmentGroupItemStrategyImpl.onItemAdded(CartOperationRequest)"})
  public void testOnItemAdded() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertSame(request, nullFulfillmentGroupItemStrategyImpl.onItemAdded(request));
  }

  /**
   * Test {@link NullFulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}.
   * <p>
   * Method under test: {@link NullFulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest NullFulfillmentGroupItemStrategyImpl.onItemUpdated(CartOperationRequest)"})
  public void testOnItemUpdated() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertSame(request, nullFulfillmentGroupItemStrategyImpl.onItemUpdated(request));
  }

  /**
   * Test {@link NullFulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}.
   * <ul>
   *   <li>Then AddedOrderItem return {@link BundleOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullFulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest NullFulfillmentGroupItemStrategyImpl.onItemRemoved(CartOperationRequest)"})
  public void testOnItemRemoved_thenAddedOrderItemReturnBundleOrderItemImpl() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    request.setOrderItem(orderItem);

    // Act
    CartOperationRequest actualOnItemRemovedResult = nullFulfillmentGroupItemStrategyImpl.onItemRemoved(request);

    // Assert
    OrderItem addedOrderItem = actualOnItemRemovedResult.getAddedOrderItem();
    assertTrue(addedOrderItem instanceof BundleOrderItemImpl);
    assertSame(orderItem, addedOrderItem);
    assertSame(orderItem, actualOnItemRemovedResult.getOrderItem());
  }

  /**
   * Test {@link NullFulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}.
   * <ul>
   *   <li>Then Order return {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullFulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest NullFulfillmentGroupItemStrategyImpl.onItemRemoved(CartOperationRequest)"})
  public void testOnItemRemoved_thenOrderReturnNullOrderImpl() {
    // Arrange
    when(fulfillmentGroupService.getFulfillmentGroupItemsForOrderItem(Mockito.<Order>any(), Mockito.<OrderItem>any()))
        .thenReturn(new ArrayList<>());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    CartOperationRequest actualOnItemRemovedResult = nullFulfillmentGroupItemStrategyImpl
        .onItemRemoved(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Assert
    verify(fulfillmentGroupService).getFulfillmentGroupItemsForOrderItem(isA(Order.class), isNull());
    assertTrue(actualOnItemRemovedResult.getOrder() instanceof NullOrderImpl);
    assertNull(actualOnItemRemovedResult.getAddedOrderItem());
    assertNull(actualOnItemRemovedResult.getOrderItem());
  }

  /**
   * Test {@link NullFulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   * <p>
   * Method under test: {@link NullFulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CartOperationRequest NullFulfillmentGroupItemStrategyImpl.verify(CartOperationRequest)"})
  public void testVerify() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertSame(request, nullFulfillmentGroupItemStrategyImpl.verify(request));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NullFulfillmentGroupItemStrategyImpl}
   *   <li>{@link NullFulfillmentGroupItemStrategyImpl#isRemoveEmptyFulfillmentGroups()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NullFulfillmentGroupItemStrategyImpl.<init>()",
      "boolean NullFulfillmentGroupItemStrategyImpl.isRemoveEmptyFulfillmentGroups()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse((new NullFulfillmentGroupItemStrategyImpl()).isRemoveEmptyFulfillmentGroups());
  }
}
