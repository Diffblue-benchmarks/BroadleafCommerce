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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class CartOperationRequestDiffblueTest {
  /**
   * Test
   * {@link CartOperationRequest#CartOperationRequest(Order, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Then return ItemRequest ChildOrderItems is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartOperationRequest#CartOperationRequest(Order, OrderItemRequestDTO, boolean)}
   */
  @Test
  public void testNewCartOperationRequest_thenReturnItemRequestChildOrderItemsIsArrayList() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setChildOrderItems(null);

    ArrayList<OrderItemRequestDTO> childOrderItems = new ArrayList<>();
    childOrderItems.add(orderItemRequestDTO);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setChildOrderItems(childOrderItems);

    // Act and Assert
    assertSame(childOrderItems,
        (new CartOperationRequest(order, itemRequest, true)).getItemRequest().getChildOrderItems());
  }

  /**
   * Test
   * {@link CartOperationRequest#CartOperationRequest(Order, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Then return Order is {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartOperationRequest#CartOperationRequest(Order, OrderItemRequestDTO, boolean)}
   */
  @Test
  public void testNewCartOperationRequest_thenReturnOrderIsOrderImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertSame(order, (new CartOperationRequest(order, new OrderItemRequestDTO(), true)).getOrder());
  }

  /**
   * Test
   * {@link CartOperationRequest#CartOperationRequest(Order, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then Order return {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartOperationRequest#CartOperationRequest(Order, OrderItemRequestDTO, boolean)}
   */
  @Test
  public void testNewCartOperationRequest_whenOrderItemRequestDTO_thenOrderReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertTrue((new CartOperationRequest(order, new OrderItemRequestDTO(), true)).getOrder() instanceof NullOrderImpl);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

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
    List<Long[]> actualMultishipOptionsToDelete = cartOperationRequest.getMultishipOptionsToDelete();
    List<OrderItem> actualOisToDelete = cartOperationRequest.getOisToDelete();
    Order actualOrder = cartOperationRequest.getOrder();
    OrderItem actualOrderItem = cartOperationRequest.getOrderItem();
    Integer actualOrderItemQuantityDelta = cartOperationRequest.getOrderItemQuantityDelta();
    boolean actualIsPriceOrderResult = cartOperationRequest.isPriceOrder();

    // Assert that nothing has changed
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
