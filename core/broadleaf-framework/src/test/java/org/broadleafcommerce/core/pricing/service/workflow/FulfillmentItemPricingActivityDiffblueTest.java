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
package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class FulfillmentItemPricingActivityDiffblueTest {
  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#getCurrency(FulfillmentGroup)}
   */
  @Test
  public void testGetCurrency() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    when(fg.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    BroadleafCurrency actualCurrency = fulfillmentItemPricingActivity.getCurrency(fg);

    // Assert
    verify(fg).getOrder();
    assertNull(actualCurrency);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  public void testGetOrderSavingsToDistribute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();

    // Act
    Money actualOrderSavingsToDistribute = fulfillmentItemPricingActivity
        .getOrderSavingsToDistribute(new NullOrderImpl());

    // Assert
    assertSame(actualOrderSavingsToDistribute.ZERO, actualOrderSavingsToDistribute);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  public void testGetOrderSavingsToDistribute2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
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
    Money subTotal = new Money();
    order.setSubTotal(subTotal);
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);

    // Act and Assert
    assertEquals(subTotal, fulfillmentItemPricingActivity.getOrderSavingsToDistribute(order));
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  public void testGetOrderSavingsToDistribute3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();

    // Act
    Money actualOrderSavingsToDistribute = fulfillmentItemPricingActivity.getOrderSavingsToDistribute(new OrderImpl());

    // Assert
    assertEquals(actualOrderSavingsToDistribute.ZERO, actualOrderSavingsToDistribute);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  public void testGetOrderSavingsToDistribute4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Order order = mock(Order.class);
    when(order.getSubTotal()).thenReturn(new Money());
    Money money = new Money();
    when(order.getOrderAdjustmentsValue()).thenReturn(money);

    // Act
    Money actualOrderSavingsToDistribute = fulfillmentItemPricingActivity.getOrderSavingsToDistribute(order);

    // Assert
    verify(order, atLeast(1)).getOrderAdjustmentsValue();
    verify(order).getSubTotal();
    assertSame(money, actualOrderSavingsToDistribute);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  public void testGetOrderSavingsToDistribute5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(null);
    when(order.getOrderAdjustmentsValue()).thenReturn(null);

    // Act
    Money actualOrderSavingsToDistribute = fulfillmentItemPricingActivity.getOrderSavingsToDistribute(order);

    // Assert
    verify(order).getCurrency();
    verify(order).getOrderAdjustmentsValue();
    assertEquals(actualOrderSavingsToDistribute.ZERO, actualOrderSavingsToDistribute);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getHasOrderAdjustments()).thenReturn(true);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    when(nullOrderImpl.getOrderAdjustmentsValue()).thenReturn(new Money());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentItemPricingActivity.execute(context);

    // Assert
    verify(nullOrderImpl, atLeast(1)).getCurrency();
    verify(nullOrderImpl, atLeast(1)).getFulfillmentGroups();
    verify(nullOrderImpl).getHasOrderAdjustments();
    verify(nullOrderImpl, atLeast(1)).getOrderAdjustmentsValue();
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getHasOrderAdjustments()).thenReturn(false);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    when(nullOrderImpl.getOrderAdjustmentsValue()).thenReturn(new Money());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentItemPricingActivity.execute(context);

    // Assert
    verify(nullOrderImpl, atLeast(1)).getCurrency();
    verify(nullOrderImpl, atLeast(1)).getFulfillmentGroups();
    verify(nullOrderImpl).getHasOrderAdjustments();
    verify(nullOrderImpl).getOrderAdjustmentsValue();
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute3() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getHasOrderAdjustments()).thenReturn(true);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    when(nullOrderImpl.getOrderAdjustmentsValue()).thenReturn(new Money());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentItemPricingActivity.execute(context);

    // Assert
    verify(nullOrderImpl, atLeast(1)).getCurrency();
    verify(nullOrderImpl, atLeast(1)).getFulfillmentGroups();
    verify(nullOrderImpl).getHasOrderAdjustments();
    verify(nullOrderImpl, atLeast(1)).getOrderAdjustmentsValue();
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute4() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money());
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getHasOrderAdjustments()).thenReturn(true);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(nullOrderImpl.getCurrency()).thenReturn(broadleafCurrencyImpl);
    when(nullOrderImpl.getOrderAdjustmentsValue()).thenReturn(money);
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentItemPricingActivity.execute(context);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(money).getAmount();
    verify(money).subtract(isA(Money.class));
    verify(nullOrderImpl, atLeast(1)).getCurrency();
    verify(nullOrderImpl, atLeast(1)).getFulfillmentGroups();
    verify(nullOrderImpl).getHasOrderAdjustments();
    verify(nullOrderImpl, atLeast(1)).getOrderAdjustmentsValue();
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute5() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money(10.0d));
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getHasOrderAdjustments()).thenReturn(true);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(nullOrderImpl.getCurrency()).thenReturn(broadleafCurrencyImpl);
    when(nullOrderImpl.getOrderAdjustmentsValue()).thenReturn(money);
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentItemPricingActivity.execute(context);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(money).getAmount();
    verify(money).subtract(isA(Money.class));
    verify(nullOrderImpl, atLeast(1)).getCurrency();
    verify(nullOrderImpl, atLeast(1)).getFulfillmentGroups();
    verify(nullOrderImpl).getHasOrderAdjustments();
    verify(nullOrderImpl, atLeast(1)).getOrderAdjustmentsValue();
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute6() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(1L);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(new NullOrderImpl());
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getTotalItemAmount()).thenReturn(new Money());
    doNothing().when(fulfillmentGroupItem).setTotalItemAmount(Mockito.<Money>any());
    when(fulfillmentGroupItem.getQuantity()).thenReturn(1);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(orderItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(nullOrderImpl.getCurrency()).thenReturn(broadleafCurrencyImpl);
    ProcessContext<Order> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(nullOrderImpl);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> fulfillmentItemPricingActivity.execute(context));
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(fulfillmentGroupItem).getOrderItem();
    verify(fulfillmentGroupItem).getQuantity();
    verify(fulfillmentGroupItem).getTotalItemAmount();
    verify(fulfillmentGroupItem).setTotalItemAmount(isA(Money.class));
    verify(nullOrderImpl).getCurrency();
    verify(nullOrderImpl, atLeast(1)).getFulfillmentGroups();
    verify(context).getSeedData();
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#populateItemTotalAmount(Order, Map)}
   */
  @Test
  public void testPopulateItemTotalAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());

    // Act
    fulfillmentItemPricingActivity.populateItemTotalAmount(order, new HashMap<>());

    // Assert
    verify(order).getFulfillmentGroups();
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#populateItemTotalAmount(Order, Map)}
   */
  @Test
  public void testPopulateItemTotalAmount2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    fulfillmentItemPricingActivity.populateItemTotalAmount(order, new HashMap<>());

    // Assert
    verify(order).getFulfillmentGroups();
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}
   */
  @Test
  public void testFixItemTotalRoundingIssues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getTotalPrice()).thenReturn(new Money());

    HashMap<OrderItem, List<FulfillmentGroupItem>> partialOrderItemMap = new HashMap<>();
    partialOrderItemMap.put(bundleOrderItemImpl, new ArrayList<>());

    // Act
    fulfillmentItemPricingActivity.fixItemTotalRoundingIssues(order, partialOrderItemMap);

    // Assert
    verify(bundleOrderItemImpl).getTotalPrice();
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}
   */
  @Test
  public void testFixItemTotalRoundingIssues2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    Money money = mock(Money.class);
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getTotalPrice()).thenReturn(money);

    HashMap<OrderItem, List<FulfillmentGroupItem>> partialOrderItemMap = new HashMap<>();
    partialOrderItemMap.put(bundleOrderItemImpl, new ArrayList<>());

    // Act
    fulfillmentItemPricingActivity.fixItemTotalRoundingIssues(order, partialOrderItemMap);

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(money).subtract(isA(Money.class));
    verify(bundleOrderItemImpl).getTotalPrice();
    verify(order).getCurrency();
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}
   */
  @Test
  public void testFixItemTotalRoundingIssues3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    Money money = mock(Money.class);
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money(10.0d));
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getTotalPrice()).thenReturn(money);

    HashMap<OrderItem, List<FulfillmentGroupItem>> partialOrderItemMap = new HashMap<>();
    partialOrderItemMap.put(bundleOrderItemImpl, new ArrayList<>());

    // Act
    fulfillmentItemPricingActivity.fixItemTotalRoundingIssues(order, partialOrderItemMap);

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(money).subtract(isA(Money.class));
    verify(bundleOrderItemImpl).getTotalPrice();
    verify(order).getCurrency();
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#calculateTotalPriceForAllFulfillmentItems(Order)}
   */
  @Test
  public void testCalculateTotalPriceForAllFulfillmentItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();

    // Act
    Money actualCalculateTotalPriceForAllFulfillmentItemsResult = fulfillmentItemPricingActivity
        .calculateTotalPriceForAllFulfillmentItems(new OrderImpl());

    // Assert
    assertEquals(actualCalculateTotalPriceForAllFulfillmentItemsResult.ZERO,
        actualCalculateTotalPriceForAllFulfillmentItemsResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#calculateTotalPriceForAllFulfillmentItems(Order)}
   */
  @Test
  public void testCalculateTotalPriceForAllFulfillmentItems2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);

    // Act
    Money actualCalculateTotalPriceForAllFulfillmentItemsResult = fulfillmentItemPricingActivity
        .calculateTotalPriceForAllFulfillmentItems(order);

    // Assert
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    assertEquals(actualCalculateTotalPriceForAllFulfillmentItemsResult.ZERO,
        actualCalculateTotalPriceForAllFulfillmentItemsResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}
   */
  @Test
  public void testDistributeOrderSavingsToItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    OrderImpl order = new OrderImpl();

    // Act
    Money actualDistributeOrderSavingsToItemsResult = fulfillmentItemPricingActivity
        .distributeOrderSavingsToItems(order, new BigDecimal("2.3"));

    // Assert
    assertEquals(actualDistributeOrderSavingsToItemsResult.ZERO, actualDistributeOrderSavingsToItemsResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}
   */
  @Test
  public void testDistributeOrderSavingsToItems2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    when(order.getOrderAdjustmentsValue()).thenReturn(money);

    // Act
    Money actualDistributeOrderSavingsToItemsResult = fulfillmentItemPricingActivity
        .distributeOrderSavingsToItems(order, new BigDecimal("2.3"));

    // Assert
    verify(money).getAmount();
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getOrderAdjustmentsValue();
    assertEquals(actualDistributeOrderSavingsToItemsResult.ZERO, actualDistributeOrderSavingsToItemsResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}
   */
  @Test
  public void testDistributeOrderSavingsToItems3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);
    when(order.getOrderAdjustmentsValue()).thenReturn(money);

    // Act
    Money actualDistributeOrderSavingsToItemsResult = fulfillmentItemPricingActivity
        .distributeOrderSavingsToItems(order, new BigDecimal("2.3"));

    // Assert
    verify(money).getAmount();
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getOrderAdjustmentsValue();
    assertEquals(actualDistributeOrderSavingsToItemsResult.ZERO, actualDistributeOrderSavingsToItemsResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  public void testFixOrderSavingsRoundingIssues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustmentsValue()).thenReturn(new Money());
    when(order.getHasOrderAdjustments()).thenReturn(true);

    // Act
    fulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(order, new Money());

    // Assert
    verify(order).getHasOrderAdjustments();
    verify(order).getOrderAdjustmentsValue();
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  public void testFixOrderSavingsRoundingIssues2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustmentsValue()).thenReturn(new Money(10.0d));
    when(order.getHasOrderAdjustments()).thenReturn(true);

    // Act
    fulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(order, new Money());

    // Assert
    verify(order).getFulfillmentGroups();
    verify(order).getHasOrderAdjustments();
    verify(order).getOrderAdjustmentsValue();
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  public void testFixOrderSavingsRoundingIssues3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getOrderAdjustmentsValue()).thenReturn(new Money(10.0d));
    when(order.getHasOrderAdjustments()).thenReturn(true);

    // Act
    fulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(order, new Money());

    // Assert
    verify(order).getFulfillmentGroups();
    verify(order).getHasOrderAdjustments();
    verify(order).getOrderAdjustmentsValue();
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  public void testFixOrderSavingsRoundingIssues4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustmentsValue()).thenReturn(new Money(-0.5d));
    when(order.getHasOrderAdjustments()).thenReturn(true);

    // Act
    fulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(order, new Money());

    // Assert
    verify(order).getFulfillmentGroups();
    verify(order).getHasOrderAdjustments();
    verify(order).getOrderAdjustmentsValue();
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  public void testFixOrderSavingsRoundingIssues5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Money money = mock(Money.class);
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustmentsValue()).thenReturn(money);
    when(order.getHasOrderAdjustments()).thenReturn(true);

    // Act
    fulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(order, new Money());

    // Assert
    verify(money).subtract(isA(Money.class));
    verify(order).getHasOrderAdjustments();
    verify(order).getOrderAdjustmentsValue();
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  public void testUpdateTaxableAmountsOnItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);

    // Act
    fulfillmentItemPricingActivity.updateTaxableAmountsOnItems(order);

    // Assert
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  public void testUpdateTaxableAmountsOnItems2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getProratedOrderAdjustmentAmount()).thenReturn(new Money());
    when(fulfillmentGroupItem.getTotalItemAmount()).thenReturn(new Money());
    doNothing().when(fulfillmentGroupItem).setTotalItemTaxableAmount(Mockito.<Money>any());
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);

    // Act
    fulfillmentItemPricingActivity.updateTaxableAmountsOnItems(order);

    // Assert
    verify(fulfillmentGroupItem).getOrderItem();
    verify(fulfillmentGroupItem).getProratedOrderAdjustmentAmount();
    verify(fulfillmentGroupItem).getTotalItemAmount();
    verify(fulfillmentGroupItem).setTotalItemTaxableAmount(isA(Money.class));
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  public void testUpdateTaxableAmountsOnItems3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getProratedOrderAdjustmentAmount()).thenReturn(null);
    when(fulfillmentGroupItem.getTotalItemAmount()).thenReturn(new Money());
    doNothing().when(fulfillmentGroupItem).setTotalItemTaxableAmount(Mockito.<Money>any());
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);

    // Act
    fulfillmentItemPricingActivity.updateTaxableAmountsOnItems(order);

    // Assert
    verify(fulfillmentGroupItem).getOrderItem();
    verify(fulfillmentGroupItem).getProratedOrderAdjustmentAmount();
    verify(fulfillmentGroupItem).getTotalItemAmount();
    verify(fulfillmentGroupItem).setTotalItemTaxableAmount(isA(Money.class));
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  public void testUpdateTaxableAmountsOnItems4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Money money = mock(Money.class);
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money());
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getProratedOrderAdjustmentAmount()).thenReturn(mock(Money.class));
    when(fulfillmentGroupItem.getTotalItemAmount()).thenReturn(money);
    doNothing().when(fulfillmentGroupItem).setTotalItemTaxableAmount(Mockito.<Money>any());
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);

    // Act
    fulfillmentItemPricingActivity.updateTaxableAmountsOnItems(order);

    // Assert
    verify(money).subtract(isA(Money.class));
    verify(fulfillmentGroupItem).getOrderItem();
    verify(fulfillmentGroupItem).getProratedOrderAdjustmentAmount();
    verify(fulfillmentGroupItem).getTotalItemAmount();
    verify(fulfillmentGroupItem).setTotalItemTaxableAmount(isA(Money.class));
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  public void testUpdateTaxableAmountsOnItems5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.isTaxable()).thenReturn(false);
    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    doNothing().when(fulfillmentGroupItem).setTotalItemTaxableAmount(Mockito.<Money>any());
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(bundleOrderItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);

    // Act
    fulfillmentItemPricingActivity.updateTaxableAmountsOnItems(order);

    // Assert
    verify(bundleOrderItemImpl).isTaxable();
    verify(fulfillmentGroupItem).getOrderItem();
    verify(fulfillmentGroupItem).setTotalItemTaxableAmount(isA(Money.class));
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#sumItemAmount(List, Order)}
   */
  @Test
  public void testSumItemAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    ArrayList<FulfillmentGroupItem> items = new ArrayList<>();

    // Act
    Money actualSumItemAmountResult = fulfillmentItemPricingActivity.sumItemAmount(items, new NullOrderImpl());

    // Assert
    assertEquals(actualSumItemAmountResult.ZERO, actualSumItemAmountResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#sumTaxAmount(List, Order)}
   */
  @Test
  public void testSumTaxAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    ArrayList<FulfillmentGroupItem> items = new ArrayList<>();

    // Act
    Money actualSumTaxAmountResult = fulfillmentItemPricingActivity.sumTaxAmount(items, new NullOrderImpl());

    // Assert
    assertEquals(actualSumTaxAmountResult.ZERO, actualSumTaxAmountResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#countNumberOfUnits(Money)}
   */
  @Test
  public void testCountNumberOfUnits() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();

    // Act and Assert
    assertEquals(0L, fulfillmentItemPricingActivity.countNumberOfUnits(new Money()));
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#getUnitAmount(Money)}
   */
  @Test
  public void testGetUnitAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Money difference = new Money();

    // Act
    Money actualUnitAmount = fulfillmentItemPricingActivity.getUnitAmount(difference);

    // Assert
    Currency currency = actualUnitAmount.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.01");
    assertEquals(expectedAmount, actualUnitAmount.getAmount());
    assertEquals(difference, actualUnitAmount.zero());
    assertEquals(actualUnitAmount, actualUnitAmount.abs());
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#getUnitAmount(Money)}
   */
  @Test
  public void testGetUnitAmount2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();

    // Act
    Money actualUnitAmount = fulfillmentItemPricingActivity.getUnitAmount(new Money(-0.5d));

    // Assert
    Currency currency = actualUnitAmount.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("-0.01");
    assertEquals(expectedAmount, actualUnitAmount.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("0.01");
    Money absResult = actualUnitAmount.abs();
    assertEquals(expectedAmount2, absResult.getAmount());
    assertEquals(absResult.abs(), absResult.abs());
    Money money = actualUnitAmount.ZERO;
    assertEquals(money, absResult.zero());
    assertEquals(money, actualUnitAmount.zero());
    assertSame(currency, absResult.getCurrency());
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#applyDifferenceToAmount(FulfillmentGroupItem, long, Money)}
   */
  @Test
  public void testApplyDifferenceToAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    FulfillmentGroupItemImpl fgItem = mock(FulfillmentGroupItemImpl.class);
    when(fgItem.getQuantity()).thenReturn(1);
    when(fgItem.getTotalItemAmount()).thenReturn(new Money());
    doNothing().when(fgItem).setTotalItemAmount(Mockito.<Money>any());
    fgItem.setTotalItemAmount(mock(Money.class));

    // Act
    long actualApplyDifferenceToAmountResult = fulfillmentItemPricingActivity.applyDifferenceToAmount(fgItem, 1L,
        new Money());

    // Assert
    verify(fgItem).getQuantity();
    verify(fgItem).getTotalItemAmount();
    verify(fgItem, atLeast(1)).setTotalItemAmount(Mockito.<Money>any());
    assertEquals(1L, actualApplyDifferenceToAmountResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#applyDifferenceToAmount(FulfillmentGroupItem, long, Money)}
   */
  @Test
  public void testApplyDifferenceToAmount2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Money money = mock(Money.class);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());
    FulfillmentGroupItemImpl fgItem = mock(FulfillmentGroupItemImpl.class);
    when(fgItem.getQuantity()).thenReturn(1);
    when(fgItem.getTotalItemAmount()).thenReturn(money);
    doNothing().when(fgItem).setTotalItemAmount(Mockito.<Money>any());
    fgItem.setTotalItemAmount(mock(Money.class));

    // Act
    long actualApplyDifferenceToAmountResult = fulfillmentItemPricingActivity.applyDifferenceToAmount(fgItem, 1L,
        new Money());

    // Assert
    verify(money).add(isA(Money.class));
    verify(fgItem).getQuantity();
    verify(fgItem).getTotalItemAmount();
    verify(fgItem, atLeast(1)).setTotalItemAmount(Mockito.<Money>any());
    assertEquals(1L, actualApplyDifferenceToAmountResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#applyDifferenceToAmount(FulfillmentGroupItem, long, Money)}
   */
  @Test
  public void testApplyDifferenceToAmount3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Money money = mock(Money.class);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());
    FulfillmentGroupItemImpl fgItem = mock(FulfillmentGroupItemImpl.class);
    when(fgItem.getQuantity()).thenReturn(1);
    when(fgItem.getTotalItemAmount()).thenReturn(money);
    doNothing().when(fgItem).setTotalItemAmount(Mockito.<Money>any());
    fgItem.setTotalItemAmount(mock(Money.class));
    Money unitAmount = mock(Money.class);
    when(unitAmount.multiply(Mockito.<BigDecimal>any())).thenReturn(new Money());

    // Act
    long actualApplyDifferenceToAmountResult = fulfillmentItemPricingActivity.applyDifferenceToAmount(fgItem, 1L,
        unitAmount);

    // Assert
    verify(money).add(isA(Money.class));
    verify(unitAmount).multiply(isA(BigDecimal.class));
    verify(fgItem).getQuantity();
    verify(fgItem).getTotalItemAmount();
    verify(fgItem, atLeast(1)).setTotalItemAmount(Mockito.<Money>any());
    assertEquals(1L, actualApplyDifferenceToAmountResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#applyDifferenceToProratedAdj(FulfillmentGroupItem, long, Money)}
   */
  @Test
  public void testApplyDifferenceToProratedAdj() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    FulfillmentGroupItemImpl fgItem = mock(FulfillmentGroupItemImpl.class);
    when(fgItem.getQuantity()).thenReturn(1);
    when(fgItem.getProratedOrderAdjustmentAmount()).thenReturn(new Money());
    doNothing().when(fgItem).setProratedOrderAdjustmentAmount(Mockito.<Money>any());
    fgItem.setProratedOrderAdjustmentAmount(mock(Money.class));

    // Act
    long actualApplyDifferenceToProratedAdjResult = fulfillmentItemPricingActivity.applyDifferenceToProratedAdj(fgItem,
        1L, new Money());

    // Assert
    verify(fgItem).getProratedOrderAdjustmentAmount();
    verify(fgItem).getQuantity();
    verify(fgItem, atLeast(1)).setProratedOrderAdjustmentAmount(Mockito.<Money>any());
    assertEquals(1L, actualApplyDifferenceToProratedAdjResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#applyDifferenceToProratedAdj(FulfillmentGroupItem, long, Money)}
   */
  @Test
  public void testApplyDifferenceToProratedAdj2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Money money = mock(Money.class);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());
    FulfillmentGroupItemImpl fgItem = mock(FulfillmentGroupItemImpl.class);
    when(fgItem.getQuantity()).thenReturn(1);
    when(fgItem.getProratedOrderAdjustmentAmount()).thenReturn(money);
    doNothing().when(fgItem).setProratedOrderAdjustmentAmount(Mockito.<Money>any());
    fgItem.setProratedOrderAdjustmentAmount(mock(Money.class));

    // Act
    long actualApplyDifferenceToProratedAdjResult = fulfillmentItemPricingActivity.applyDifferenceToProratedAdj(fgItem,
        1L, new Money());

    // Assert
    verify(money).add(isA(Money.class));
    verify(fgItem).getProratedOrderAdjustmentAmount();
    verify(fgItem).getQuantity();
    verify(fgItem, atLeast(1)).setProratedOrderAdjustmentAmount(Mockito.<Money>any());
    assertEquals(1L, actualApplyDifferenceToProratedAdjResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#applyDifferenceToProratedAdj(FulfillmentGroupItem, long, Money)}
   */
  @Test
  public void testApplyDifferenceToProratedAdj3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Money money = mock(Money.class);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());
    FulfillmentGroupItemImpl fgItem = mock(FulfillmentGroupItemImpl.class);
    when(fgItem.getQuantity()).thenReturn(1);
    when(fgItem.getProratedOrderAdjustmentAmount()).thenReturn(money);
    doNothing().when(fgItem).setProratedOrderAdjustmentAmount(Mockito.<Money>any());
    fgItem.setProratedOrderAdjustmentAmount(mock(Money.class));
    Money unitAmount = mock(Money.class);
    when(unitAmount.multiply(Mockito.<BigDecimal>any())).thenReturn(new Money());

    // Act
    long actualApplyDifferenceToProratedAdjResult = fulfillmentItemPricingActivity.applyDifferenceToProratedAdj(fgItem,
        1L, unitAmount);

    // Assert
    verify(money).add(isA(Money.class));
    verify(unitAmount).multiply(isA(BigDecimal.class));
    verify(fgItem).getProratedOrderAdjustmentAmount();
    verify(fgItem).getQuantity();
    verify(fgItem, atLeast(1)).setProratedOrderAdjustmentAmount(Mockito.<Money>any());
    assertEquals(1L, actualApplyDifferenceToProratedAdjResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#applyTaxDifference(FulfillmentGroupItem, long, Money)}
   */
  @Test
  public void testApplyTaxDifference() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    FulfillmentGroupItemImpl fgItem = mock(FulfillmentGroupItemImpl.class);
    when(fgItem.getQuantity()).thenReturn(1);
    when(fgItem.getTotalItemTaxableAmount()).thenReturn(new Money());
    doNothing().when(fgItem).setTotalItemTaxableAmount(Mockito.<Money>any());
    fgItem.setTotalItemTaxableAmount(mock(Money.class));

    // Act
    long actualApplyTaxDifferenceResult = fulfillmentItemPricingActivity.applyTaxDifference(fgItem, 1L, new Money());

    // Assert
    verify(fgItem).getQuantity();
    verify(fgItem).getTotalItemTaxableAmount();
    verify(fgItem, atLeast(1)).setTotalItemTaxableAmount(Mockito.<Money>any());
    assertEquals(1L, actualApplyTaxDifferenceResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#applyTaxDifference(FulfillmentGroupItem, long, Money)}
   */
  @Test
  public void testApplyTaxDifference2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Money money = mock(Money.class);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());
    FulfillmentGroupItemImpl fgItem = mock(FulfillmentGroupItemImpl.class);
    when(fgItem.getQuantity()).thenReturn(1);
    when(fgItem.getTotalItemTaxableAmount()).thenReturn(money);
    doNothing().when(fgItem).setTotalItemTaxableAmount(Mockito.<Money>any());
    fgItem.setTotalItemTaxableAmount(mock(Money.class));

    // Act
    long actualApplyTaxDifferenceResult = fulfillmentItemPricingActivity.applyTaxDifference(fgItem, 1L, new Money());

    // Assert
    verify(money).add(isA(Money.class));
    verify(fgItem).getQuantity();
    verify(fgItem).getTotalItemTaxableAmount();
    verify(fgItem, atLeast(1)).setTotalItemTaxableAmount(Mockito.<Money>any());
    assertEquals(1L, actualApplyTaxDifferenceResult);
  }

  /**
   * Method under test:
   * {@link FulfillmentItemPricingActivity#applyTaxDifference(FulfillmentGroupItem, long, Money)}
   */
  @Test
  public void testApplyTaxDifference3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Money money = mock(Money.class);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());
    FulfillmentGroupItemImpl fgItem = mock(FulfillmentGroupItemImpl.class);
    when(fgItem.getQuantity()).thenReturn(1);
    when(fgItem.getTotalItemTaxableAmount()).thenReturn(money);
    doNothing().when(fgItem).setTotalItemTaxableAmount(Mockito.<Money>any());
    fgItem.setTotalItemTaxableAmount(mock(Money.class));
    Money unitAmount = mock(Money.class);
    when(unitAmount.multiply(Mockito.<BigDecimal>any())).thenReturn(new Money());

    // Act
    long actualApplyTaxDifferenceResult = fulfillmentItemPricingActivity.applyTaxDifference(fgItem, 1L, unitAmount);

    // Assert
    verify(money).add(isA(Money.class));
    verify(unitAmount).multiply(isA(BigDecimal.class));
    verify(fgItem).getQuantity();
    verify(fgItem).getTotalItemTaxableAmount();
    verify(fgItem, atLeast(1)).setTotalItemTaxableAmount(Mockito.<Money>any());
    assertEquals(1L, actualApplyTaxDifferenceResult);
  }
}
