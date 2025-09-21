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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderPersistedEventDiffblueTest {
  /**
   * Test {@link OrderPersistedEvent#OrderPersistedEvent(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemQualifierImpl#serialVersionUID}.
   *   <li>Then Order return {@link OrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPersistedEvent#OrderPersistedEvent(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderPersistedEvent.<init>(Order)"})
  public void testNewOrderPersistedEvent_givenSerialVersionUID_thenOrderReturnOrderImpl() {
    // Arrange
    OrderImpl order = new OrderImpl();
    order.setId(OrderItemQualifierImpl.serialVersionUID);

    // Act
    OrderPersistedEvent actualOrderPersistedEvent = new OrderPersistedEvent(order);

    // Assert
    Order order2 = actualOrderPersistedEvent.getOrder();
    assertTrue(order2 instanceof OrderImpl);
    assertSame(order, actualOrderPersistedEvent.getSource());
    assertSame(order, order2);
  }

  /**
   * Test {@link OrderPersistedEvent#OrderPersistedEvent(Order)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then return Source is {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderPersistedEvent#OrderPersistedEvent(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderPersistedEvent.<init>(Order)"})
  public void testNewOrderPersistedEvent_whenNullOrderImpl_thenReturnSourceIsNullOrderImpl() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    OrderPersistedEvent actualOrderPersistedEvent = new OrderPersistedEvent(order);

    // Assert
    assertSame(order, actualOrderPersistedEvent.getSource());
    assertSame(order, actualOrderPersistedEvent.getOrder());
  }

  /**
   * Test {@link OrderPersistedEvent#OrderPersistedEvent(Order)}.
   *
   * <ul>
   *   <li>When {@link NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return Source is {@link NullOrderFactoryImpl#NULL_ORDER}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPersistedEvent#OrderPersistedEvent(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderPersistedEvent.<init>(Order)"})
  public void testNewOrderPersistedEvent_whenNull_order_thenReturnSourceIsNull_order() {
    // Arrange
    Order order = NullOrderFactoryImpl.NULL_ORDER;

    // Act
    OrderPersistedEvent actualOrderPersistedEvent = new OrderPersistedEvent(order);

    // Assert
    assertSame(order, actualOrderPersistedEvent.getSource());
    assertSame(order, actualOrderPersistedEvent.getOrder());
  }

  /**
   * Test {@link OrderPersistedEvent#getOrder()}.
   *
   * <p>Method under test: {@link OrderPersistedEvent#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order OrderPersistedEvent.getOrder()"})
  public void testGetOrder() {
    // Arrange and Act
    Order actualOrder = new OrderPersistedEvent(NullOrderFactoryImpl.NULL_ORDER).getOrder();

    // Assert
    assertTrue(actualOrder instanceof NullOrderImpl);
    assertNull(actualOrder.getBroadleafAccountId());
    assertNull(actualOrder.getId());
    assertNull(actualOrder.getEmailAddress());
    assertNull(actualOrder.getFulfillmentStatus());
    assertNull(actualOrder.getName());
    assertNull(actualOrder.getOrderNumber());
    assertNull(actualOrder.getSubmitDate());
    assertNull(actualOrder.getAllFutureCreditAdjustments());
    assertNull(actualOrder.getCandidateOrderOffers());
    assertNull(actualOrder.getAddedOfferCodes());
    assertNull(actualOrder.getFutureCreditOrderAdjustments());
    assertNull(actualOrder.getOrderAdjustments());
    assertNull(actualOrder.getDiscreteOrderItems());
    assertNull(actualOrder.getFulfillmentGroups());
    assertNull(actualOrder.getNonDiscreteOrderItems());
    assertNull(actualOrder.getOrderItems());
    assertNull(actualOrder.getOrderMessages());
    assertNull(actualOrder.getPayments());
    assertNull(actualOrder.getOrderAttributes());
    assertNull(actualOrder.getAdditionalOfferInformation());
    assertNull(actualOrder.getAuditable());
    assertNull(actualOrder.getCurrency());
    assertNull(actualOrder.getLocale());
    assertNull(actualOrder.getFulfillmentGroupAdjustmentsValue());
    assertNull(actualOrder.getFutureCreditFulfillmentGroupAdjustmentsValue());
    assertNull(actualOrder.getFutureCreditItemAdjustmentsValue());
    assertNull(actualOrder.getFutureCreditOrderAdjustmentsValue());
    assertNull(actualOrder.getItemAdjustmentsValue());
    assertNull(actualOrder.getTotal());
    assertNull(actualOrder.getTotalAdjustmentsValue());
    assertNull(actualOrder.getTotalAfterAppliedPayments());
    assertNull(actualOrder.getTotalFulfillmentCharges());
    assertNull(actualOrder.getTotalFutureCreditAdjustmentsValue());
    assertNull(actualOrder.getTotalShipping());
    assertNull(actualOrder.getTotalTax());
    assertNull(actualOrder.getStatus());
    assertNull(actualOrder.getCustomer());
    assertEquals(0, actualOrder.getItemCount());
    assertFalse(actualOrder.getHasOrderAdjustments());
    assertFalse(actualOrder.getTaxOverride());
  }
}
