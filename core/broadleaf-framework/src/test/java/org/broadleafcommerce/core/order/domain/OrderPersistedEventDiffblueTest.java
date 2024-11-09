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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class OrderPersistedEventDiffblueTest {
  /**
   * Test {@link OrderPersistedEvent#OrderPersistedEvent(Order)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>Then return Source is {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPersistedEvent#OrderPersistedEvent(Order)}
   */
  @Test
  public void testNewOrderPersistedEvent_givenMoney_thenReturnSourceIsOrderImpl() {
    // Arrange
    OrderImpl order = new OrderImpl();
    order.setSubTotal(new Money());

    // Act
    OrderPersistedEvent actualOrderPersistedEvent = new OrderPersistedEvent(order);

    // Assert
    assertSame(order, actualOrderPersistedEvent.getSource());
    assertSame(order, actualOrderPersistedEvent.getOrder());
  }

  /**
   * Test {@link OrderPersistedEvent#OrderPersistedEvent(Order)}.
   * <ul>
   *   <li>When {@link NullOrderFactoryImpl#NULL_ORDER}.</li>
   *   <li>Then return Source is {@link NullOrderFactoryImpl#NULL_ORDER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPersistedEvent#OrderPersistedEvent(Order)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is
   * {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   *   <li>Then return {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPersistedEvent#getOrder()}
   */
  @Test
  public void testGetOrder_givenAuditableCreatedByIsSerialVersionUID_thenReturnOrderImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    assertSame(order, (new OrderPersistedEvent(order)).getOrder());
  }

  /**
   * Test {@link OrderPersistedEvent#getOrder()}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPersistedEvent#getOrder()}
   */
  @Test
  public void testGetOrder_thenReturnNullOrderImpl() {
    // Arrange and Act
    Order actualOrder = (new OrderPersistedEvent(NullOrderFactoryImpl.NULL_ORDER)).getOrder();

    // Assert
    assertTrue(actualOrder instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualOrder.getOrderAdjustmentsValue();
    Currency currency = orderAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
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
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertFalse(actualOrder.getHasOrderAdjustments());
    assertFalse(actualOrder.getTaxOverride());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, orderAdjustmentsValue.getAmount());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualOrder.getSubTotal());
  }
}
