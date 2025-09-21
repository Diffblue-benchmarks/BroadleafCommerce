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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CartOperationRequestDiffblueTest {
  /**
   * Test {@link CartOperationRequest#CartOperationRequest(Order, OrderItemRequestDTO, boolean)}.
   *
   * <p>Method under test: {@link CartOperationRequest#CartOperationRequest(Order,
   * OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CartOperationRequest.<init>(Order, OrderItemRequestDTO, boolean)"})
  public void testNewCartOperationRequest() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();

    // Act
    CartOperationRequest actualCartOperationRequest =
        new CartOperationRequest(order, itemRequest, true);

    // Assert
    Order order2 = actualCartOperationRequest.getOrder();
    assertTrue(order2 instanceof NullOrderImpl);
    Money orderAdjustmentsValue = order2.getOrderAdjustmentsValue();
    Money actualAbsResult = orderAdjustmentsValue.abs();
    assertEquals(orderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = orderAdjustmentsValue.zero();
    assertEquals(orderAdjustmentsValue, actualZeroResult);
    assertEquals(orderAdjustmentsValue, order2.getSubTotal());
    assertSame(itemRequest, actualCartOperationRequest.getItemRequest());
  }

  /**
   * Test {@link CartOperationRequest#CartOperationRequest(Order, OrderItemRequestDTO, boolean)}.
   *
   * <p>Method under test: {@link CartOperationRequest#CartOperationRequest(Order,
   * OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CartOperationRequest.<init>(Order, OrderItemRequestDTO, boolean)"})
  public void testNewCartOperationRequest2() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    ArrayList<OrderItemRequestDTO> childOrderItems = new ArrayList<>();
    childOrderItems.add(new OrderItemRequestDTO());

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO.setChildOrderItems(childOrderItems);

    ArrayList<OrderItemRequestDTO> childOrderItems2 = new ArrayList<>();
    childOrderItems2.add(orderItemRequestDTO);

    OrderItemRequestDTO orderItemRequestDTO2 = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO2.setChildOrderItems(childOrderItems2);

    ArrayList<OrderItemRequestDTO> childOrderItems3 = new ArrayList<>();
    childOrderItems3.add(orderItemRequestDTO2);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setChildOrderItems(childOrderItems3);

    // Act
    CartOperationRequest actualCartOperationRequest =
        new CartOperationRequest(order, itemRequest, true);

    // Assert
    List<OrderItemRequestDTO> childOrderItems4 =
        actualCartOperationRequest.getItemRequest().getChildOrderItems();
    assertEquals(1, childOrderItems4.size());
    List<OrderItemRequestDTO> childOrderItems5 = childOrderItems4.get(0).getChildOrderItems();
    assertEquals(1, childOrderItems5.size());
    assertSame(childOrderItems, childOrderItems5.get(0).getChildOrderItems());
  }

  /**
   * Test {@link CartOperationRequest#CartOperationRequest(Order, OrderItemRequestDTO, boolean)}.
   *
   * <p>Method under test: {@link CartOperationRequest#CartOperationRequest(Order,
   * OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CartOperationRequest.<init>(Order, OrderItemRequestDTO, boolean)"})
  public void testNewCartOperationRequest3() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO.setChildOrderItems(null);

    ArrayList<OrderItemRequestDTO> childOrderItems = new ArrayList<>();
    childOrderItems.add(orderItemRequestDTO);

    OrderItemRequestDTO orderItemRequestDTO2 = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO2.setChildOrderItems(childOrderItems);

    ArrayList<OrderItemRequestDTO> childOrderItems2 = new ArrayList<>();
    childOrderItems2.add(orderItemRequestDTO2);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setChildOrderItems(childOrderItems2);

    // Act
    CartOperationRequest actualCartOperationRequest =
        new CartOperationRequest(order, itemRequest, true);

    // Assert
    assertTrue(actualCartOperationRequest.getOrder() instanceof NullOrderImpl);
    List<OrderItemRequestDTO> childOrderItems3 =
        actualCartOperationRequest.getItemRequest().getChildOrderItems();
    assertEquals(1, childOrderItems3.size());
    List<OrderItemRequestDTO> childOrderItems4 = childOrderItems3.get(0).getChildOrderItems();
    assertEquals(1, childOrderItems4.size());
    assertNull(childOrderItems4.get(0).getChildOrderItems());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CartOperationRequest#setAddedOrderItem(OrderItem)}
   *   <li>{@link CartOperationRequest#setFgisToDelete(List)}
   *   <li>{@link CartOperationRequest#setItemRequest(OrderItemRequestDTO)}
   *   <li>{@link CartOperationRequest#setMultishipOptionsToDelete(List)}
   *   <li>{@link CartOperationRequest#setOisToDelete(List)}
   *   <li>{@link CartOperationRequest#setOrder(Order)}
   *   <li>{@link CartOperationRequest#setOrderItem(OrderItem)}
   *   <li>{@link CartOperationRequest#setOrderItemQuantityDelta(Integer)}
   *   <li>{@link CartOperationRequest#setPriceOrder(boolean)}
   *   <li>{@link CartOperationRequest#getAddedOrderItem()}
   *   <li>{@link CartOperationRequest#getFgisToDelete()}
   *   <li>{@link CartOperationRequest#getItemRequest()}
   *   <li>{@link CartOperationRequest#getMultishipOptionsToDelete()}
   *   <li>{@link CartOperationRequest#getOisToDelete()}
   *   <li>{@link CartOperationRequest#getOrder()}
   *   <li>{@link CartOperationRequest#getOrderItem()}
   *   <li>{@link CartOperationRequest#getOrderItemQuantityDelta()}
   *   <li>{@link CartOperationRequest#isPriceOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem CartOperationRequest.getAddedOrderItem()",
    "List CartOperationRequest.getFgisToDelete()",
    "OrderItemRequestDTO CartOperationRequest.getItemRequest()",
    "List CartOperationRequest.getMultishipOptionsToDelete()",
    "List CartOperationRequest.getOisToDelete()",
    "Order CartOperationRequest.getOrder()",
    "OrderItem CartOperationRequest.getOrderItem()",
    "Integer CartOperationRequest.getOrderItemQuantityDelta()",
    "boolean CartOperationRequest.isPriceOrder()",
    "void CartOperationRequest.setAddedOrderItem(OrderItem)",
    "void CartOperationRequest.setFgisToDelete(List)",
    "void CartOperationRequest.setItemRequest(OrderItemRequestDTO)",
    "void CartOperationRequest.setMultishipOptionsToDelete(List)",
    "void CartOperationRequest.setOisToDelete(List)",
    "void CartOperationRequest.setOrder(Order)",
    "void CartOperationRequest.setOrderItem(OrderItem)",
    "void CartOperationRequest.setOrderItemQuantityDelta(Integer)",
    "void CartOperationRequest.setPriceOrder(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act
    cartOperationRequest.setAddedOrderItem(new BundleOrderItemImpl());
    ArrayList<FulfillmentGroupItem> fgisToDelete = new ArrayList<>();
    cartOperationRequest.setFgisToDelete(fgisToDelete);
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    cartOperationRequest.setItemRequest(itemRequest);
    ArrayList<Long[]> multishipOptionsToDelete = new ArrayList<>();
    cartOperationRequest.setMultishipOptionsToDelete(multishipOptionsToDelete);
    ArrayList<OrderItem> oisToDelete = new ArrayList<>();
    cartOperationRequest.setOisToDelete(oisToDelete);
    NullOrderImpl order2 = new NullOrderImpl();
    cartOperationRequest.setOrder(order2);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    cartOperationRequest.setOrderItem(orderItem);
    cartOperationRequest.setOrderItemQuantityDelta(2);
    cartOperationRequest.setPriceOrder(true);
    OrderItem actualAddedOrderItem = cartOperationRequest.getAddedOrderItem();
    List<FulfillmentGroupItem> actualFgisToDelete = cartOperationRequest.getFgisToDelete();
    OrderItemRequestDTO actualItemRequest = cartOperationRequest.getItemRequest();
    List<Long[]> actualMultishipOptionsToDelete =
        cartOperationRequest.getMultishipOptionsToDelete();
    List<OrderItem> actualOisToDelete = cartOperationRequest.getOisToDelete();
    Order actualOrder = cartOperationRequest.getOrder();
    OrderItem actualOrderItem = cartOperationRequest.getOrderItem();
    Integer actualOrderItemQuantityDelta = cartOperationRequest.getOrderItemQuantityDelta();
    boolean actualIsPriceOrderResult = cartOperationRequest.isPriceOrder();

    // Assert
    assertEquals(2, actualOrderItemQuantityDelta.intValue());
    assertTrue(actualFgisToDelete.isEmpty());
    assertTrue(actualMultishipOptionsToDelete.isEmpty());
    assertTrue(actualOisToDelete.isEmpty());
    assertTrue(actualIsPriceOrderResult);
    assertSame(fgisToDelete, actualFgisToDelete);
    assertSame(multishipOptionsToDelete, actualMultishipOptionsToDelete);
    assertSame(oisToDelete, actualOisToDelete);
    assertSame(orderItem, actualAddedOrderItem);
    assertSame(orderItem, actualOrderItem);
    assertSame(order2, actualOrder);
    assertSame(itemRequest, actualItemRequest);
  }
}
