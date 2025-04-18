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
package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderItemRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemRequest#OrderItemRequest()}
   *   <li>{@link OrderItemRequest#setItemName(String)}
   *   <li>{@link OrderItemRequest#getItemName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemRequest.<init>()", "String OrderItemRequest.getItemName()",
      "void OrderItemRequest.setItemName(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderItemRequest actualOrderItemRequest = new OrderItemRequest();
    actualOrderItemRequest.setItemName("Item Name");

    // Assert
    assertEquals("Item Name", actualOrderItemRequest.getItemName());
    assertNull(actualOrderItemRequest.getRetailPriceOverride());
    assertNull(actualOrderItemRequest.getSalePriceOverride());
    assertNull(actualOrderItemRequest.getCategory());
    assertNull(actualOrderItemRequest.getProduct());
    assertNull(actualOrderItemRequest.getSku());
    assertNull(actualOrderItemRequest.getOrder());
    assertNull(actualOrderItemRequest.getPersonalMessage());
    assertEquals(0, actualOrderItemRequest.getQuantity());
    assertTrue(actualOrderItemRequest.getAdditionalAttributes().isEmpty());
    assertTrue(actualOrderItemRequest.getItemAttributes().isEmpty());
  }

  /**
   * Test {@link OrderItemRequest#OrderItemRequest(AbstractOrderItemRequest)}.
   * <ul>
   *   <li>When {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.</li>
   *   <li>Then return ItemName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequest#OrderItemRequest(AbstractOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemRequest.<init>(AbstractOrderItemRequest)"})
  public void testNewOrderItemRequest_whenDiscreteOrderItemRequest_thenReturnItemNameIsNull() {
    // Arrange and Act
    OrderItemRequest actualOrderItemRequest = new OrderItemRequest(new DiscreteOrderItemRequest());

    // Assert
    assertNull(actualOrderItemRequest.getItemName());
    assertNull(actualOrderItemRequest.getRetailPriceOverride());
    assertNull(actualOrderItemRequest.getSalePriceOverride());
    assertNull(actualOrderItemRequest.getCategory());
    assertNull(actualOrderItemRequest.getProduct());
    assertNull(actualOrderItemRequest.getSku());
    assertNull(actualOrderItemRequest.getOrder());
    assertNull(actualOrderItemRequest.getPersonalMessage());
    assertEquals(0, actualOrderItemRequest.getQuantity());
    assertTrue(actualOrderItemRequest.getAdditionalAttributes().isEmpty());
    assertTrue(actualOrderItemRequest.getItemAttributes().isEmpty());
  }

  /**
   * Test {@link OrderItemRequest#clone()}.
   * <p>
   * Method under test: {@link OrderItemRequest#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItemRequest OrderItemRequest.clone()"})
  public void testClone() {
    // Arrange
    OrderItemRequest orderItemRequest = new OrderItemRequest();

    // Act and Assert
    assertEquals(orderItemRequest, orderItemRequest.clone());
  }
}
