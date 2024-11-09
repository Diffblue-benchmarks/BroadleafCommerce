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
package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class FulfillmentItemPricingActivityDiffblueTest {
  /**
   * Test {@link FulfillmentItemPricingActivity#getCurrency(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#getCurrency(FulfillmentGroup)}
   */
  @Test
  public void testGetCurrency_givenNullOrderImpl_thenReturnNull() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}.
   * <ul>
   *   <li>Then calls {@link Order#getCurrency()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  public void testGetOrderSavingsToDistribute_thenCallsGetCurrency() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}.
   * <ul>
   *   <li>Then calls {@link Order#getSubTotal()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  public void testGetOrderSavingsToDistribute_thenCallsGetSubTotal() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  public void testGetOrderSavingsToDistribute_whenNullOrderImpl_thenReturnZero() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  public void testGetOrderSavingsToDistribute_whenOrderImplCurrencyIsNull_thenReturnMoney() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  public void testGetOrderSavingsToDistribute_whenOrderImpl_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();

    // Act
    Money actualOrderSavingsToDistribute = fulfillmentItemPricingActivity.getOrderSavingsToDistribute(new OrderImpl());

    // Assert
    assertEquals(actualOrderSavingsToDistribute.ZERO, actualOrderSavingsToDistribute);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#getAmount()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenMoneySubtractReturnMoney_thenCallsGetAmount() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money());
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getHasOrderAdjustments()).thenReturn(true);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    when(nullOrderImpl.getOrderAdjustmentsValue()).thenReturn(money);
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentItemPricingActivity.execute(context);

    // Assert
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
   * Test {@link FulfillmentItemPricingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl}
   * {@link NullOrderImpl#getHasOrderAdjustments()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenNullOrderImplGetHasOrderAdjustmentsReturnFalse() throws Exception {
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
   * Test {@link FulfillmentItemPricingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl}
   * {@link NullOrderImpl#getOrderAdjustmentsValue()} return
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenNullOrderImplGetOrderAdjustmentsValueReturnMoney() throws Exception {
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
   * Test {@link FulfillmentItemPricingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl}
   * {@link NullOrderImpl#getOrderAdjustmentsValue()} return
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenNullOrderImplGetOrderAdjustmentsValueReturnMoney2() throws Exception {
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
   * Test {@link FulfillmentItemPricingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl}
   * {@link NullOrderImpl#getOrderAdjustmentsValue()} return
   * {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenNullOrderImplGetOrderAdjustmentsValueReturnMoneyWithAmountIsTen() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getHasOrderAdjustments()).thenReturn(true);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    when(nullOrderImpl.getOrderAdjustmentsValue()).thenReturn(new Money(10.0d));
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
   * Test
   * {@link FulfillmentItemPricingActivity#populateItemTotalAmount(Order, Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link NullOrderImpl#getFulfillmentGroups()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#populateItemTotalAmount(Order, Map)}
   */
  @Test
  public void testPopulateItemTotalAmount_givenArrayList_thenCallsGetFulfillmentGroups() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#populateItemTotalAmount(Order, Map)}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getFulfillmentGroups()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#populateItemTotalAmount(Order, Map)}
   */
  @Test
  public void testPopulateItemTotalAmount_thenCallsGetFulfillmentGroups() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}.
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}
   */
  @Test
  public void testFixItemTotalRoundingIssues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(null);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getTotalPrice()).thenReturn(new Money(10.0d));

    HashMap<OrderItem, List<FulfillmentGroupItem>> partialOrderItemMap = new HashMap<>();
    partialOrderItemMap.put(bundleOrderItemImpl, new ArrayList<>());

    // Act
    fulfillmentItemPricingActivity.fixItemTotalRoundingIssues(order, partialOrderItemMap);

    // Assert
    verify(bundleOrderItemImpl).getTotalPrice();
    verify(order).getCurrency();
  }

  /**
   * Test
   * {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}.
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}
   */
  @Test
  public void testFixItemTotalRoundingIssues2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(null);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getTotalPrice()).thenReturn(new Money(-0.5d));

    HashMap<OrderItem, List<FulfillmentGroupItem>> partialOrderItemMap = new HashMap<>();
    partialOrderItemMap.put(bundleOrderItemImpl, new ArrayList<>());

    // Act
    fulfillmentItemPricingActivity.fixItemTotalRoundingIssues(order, partialOrderItemMap);

    // Assert
    verify(bundleOrderItemImpl).getTotalPrice();
    verify(order).getCurrency();
  }

  /**
   * Test
   * {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl}
   * {@link BundleOrderItemImpl#getTotalPrice()} return
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}
   */
  @Test
  public void testFixItemTotalRoundingIssues_givenBundleOrderItemImplGetTotalPriceReturnMoney() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#subtract(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}
   */
  @Test
  public void testFixItemTotalRoundingIssues_givenMoneySubtractReturnMoney_thenCallsSubtract() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(null);
    Money money = mock(Money.class);
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getTotalPrice()).thenReturn(money);

    HashMap<OrderItem, List<FulfillmentGroupItem>> partialOrderItemMap = new HashMap<>();
    partialOrderItemMap.put(bundleOrderItemImpl, new ArrayList<>());

    // Act
    fulfillmentItemPricingActivity.fixItemTotalRoundingIssues(order, partialOrderItemMap);

    // Assert
    verify(money).subtract(isA(Money.class));
    verify(bundleOrderItemImpl).getTotalPrice();
    verify(order).getCurrency();
  }

  /**
   * Test
   * {@link FulfillmentItemPricingActivity#calculateTotalPriceForAllFulfillmentItems(Order)}.
   * <ul>
   *   <li>Then calls {@link Order#getCurrency()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#calculateTotalPriceForAllFulfillmentItems(Order)}
   */
  @Test
  public void testCalculateTotalPriceForAllFulfillmentItems_thenCallsGetCurrency() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#calculateTotalPriceForAllFulfillmentItems(Order)}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#calculateTotalPriceForAllFulfillmentItems(Order)}
   */
  @Test
  public void testCalculateTotalPriceForAllFulfillmentItems_whenOrderImpl_thenReturnZero() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link Money#getAmount()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}
   */
  @Test
  public void testDistributeOrderSavingsToItems_givenArrayList_thenCallsGetAmount() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}.
   * <ul>
   *   <li>Then calls {@link Money#getAmount()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}
   */
  @Test
  public void testDistributeOrderSavingsToItems_thenCallsGetAmount() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}
   */
  @Test
  public void testDistributeOrderSavingsToItems_whenOrderImpl_thenReturnZero() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}.
   * <p>
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
   * Test
   * {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  public void testFixOrderSavingsRoundingIssues_givenArrayListAddFulfillmentGroupImpl() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is {@code -0.5}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  public void testFixOrderSavingsRoundingIssues_givenMoneyWithAmountIs05() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  public void testFixOrderSavingsRoundingIssues_givenMoneyWithAmountIsTen() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}.
   * <ul>
   *   <li>Then calls {@link Money#subtract(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  public void testFixOrderSavingsRoundingIssues_thenCallsSubtract() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}.
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  public void testUpdateTaxableAmountsOnItems() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}.
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  public void testUpdateTaxableAmountsOnItems2() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#subtract(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  public void testUpdateTaxableAmountsOnItems_givenMoneySubtractReturnMoney_thenCallsSubtract() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}.
   * <ul>
   *   <li>Then calls {@link Order#getCurrency()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  public void testUpdateTaxableAmountsOnItems_thenCallsGetCurrency() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}.
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#isTaxable()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  public void testUpdateTaxableAmountsOnItems_thenCallsIsTaxable() {
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
   * Test {@link FulfillmentItemPricingActivity#sumItemAmount(List, Order)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#sumItemAmount(List, Order)}
   */
  @Test
  public void testSumItemAmount_whenArrayList_thenReturnZero() {
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
   * Test {@link FulfillmentItemPricingActivity#sumTaxAmount(List, Order)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#sumTaxAmount(List, Order)}
   */
  @Test
  public void testSumTaxAmount_whenArrayList_thenReturnZero() {
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
   * Test {@link FulfillmentItemPricingActivity#countNumberOfUnits(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#countNumberOfUnits(Money)}
   */
  @Test
  public void testCountNumberOfUnits_whenMoney_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();

    // Act and Assert
    assertEquals(0L, fulfillmentItemPricingActivity.countNumberOfUnits(new Money()));
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#getUnitAmount(Money)}.
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is {@code -0.5}.</li>
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with
   * {@code -0.01}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#getUnitAmount(Money)}
   */
  @Test
  public void testGetUnitAmount_whenMoneyWithAmountIs05_thenReturnAmountIsBigDecimalWith001() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();

    // Act
    Money actualUnitAmount = fulfillmentItemPricingActivity.getUnitAmount(new Money(-0.5d));

    // Assert
    BigDecimal expectedAmount = new BigDecimal("-0.01");
    assertEquals(expectedAmount, actualUnitAmount.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("0.01");
    Money absResult = actualUnitAmount.abs();
    assertEquals(expectedAmount2, absResult.getAmount());
    assertEquals(absResult.abs(), absResult.abs());
    Money money = actualUnitAmount.ZERO;
    assertEquals(money, absResult.zero());
    assertEquals(money, actualUnitAmount.zero());
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#getUnitAmount(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with
   * {@code 0.01}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#getUnitAmount(Money)}
   */
  @Test
  public void testGetUnitAmount_whenMoney_thenReturnAmountIsBigDecimalWith001() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity = new FulfillmentItemPricingActivity();
    Money difference = new Money();

    // Act
    Money actualUnitAmount = fulfillmentItemPricingActivity.getUnitAmount(difference);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.01");
    assertEquals(expectedAmount, actualUnitAmount.getAmount());
    assertEquals(difference, actualUnitAmount.zero());
    assertEquals(actualUnitAmount, actualUnitAmount.abs());
  }

  /**
   * Test
   * {@link FulfillmentItemPricingActivity#applyDifferenceToAmount(FulfillmentGroupItem, long, Money)}.
   * <p>
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
   * Test
   * {@link FulfillmentItemPricingActivity#applyDifferenceToAmount(FulfillmentGroupItem, long, Money)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#add(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#applyDifferenceToAmount(FulfillmentGroupItem, long, Money)}
   */
  @Test
  public void testApplyDifferenceToAmount_givenMoneyAddReturnMoney_thenCallsAdd() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#applyDifferenceToAmount(FulfillmentGroupItem, long, Money)}.
   * <ul>
   *   <li>When {@link Money} {@link Money#multiply(BigDecimal)} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#multiply(BigDecimal)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#applyDifferenceToAmount(FulfillmentGroupItem, long, Money)}
   */
  @Test
  public void testApplyDifferenceToAmount_whenMoneyMultiplyReturnMoney_thenCallsMultiply() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#applyDifferenceToProratedAdj(FulfillmentGroupItem, long, Money)}.
   * <p>
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
   * Test
   * {@link FulfillmentItemPricingActivity#applyDifferenceToProratedAdj(FulfillmentGroupItem, long, Money)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#add(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#applyDifferenceToProratedAdj(FulfillmentGroupItem, long, Money)}
   */
  @Test
  public void testApplyDifferenceToProratedAdj_givenMoneyAddReturnMoney_thenCallsAdd() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#applyDifferenceToProratedAdj(FulfillmentGroupItem, long, Money)}.
   * <ul>
   *   <li>When {@link Money} {@link Money#multiply(BigDecimal)} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#multiply(BigDecimal)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#applyDifferenceToProratedAdj(FulfillmentGroupItem, long, Money)}
   */
  @Test
  public void testApplyDifferenceToProratedAdj_whenMoneyMultiplyReturnMoney_thenCallsMultiply() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#applyTaxDifference(FulfillmentGroupItem, long, Money)}.
   * <p>
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
   * Test
   * {@link FulfillmentItemPricingActivity#applyTaxDifference(FulfillmentGroupItem, long, Money)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#add(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#applyTaxDifference(FulfillmentGroupItem, long, Money)}
   */
  @Test
  public void testApplyTaxDifference_givenMoneyAddReturnMoney_thenCallsAdd() {
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
   * Test
   * {@link FulfillmentItemPricingActivity#applyTaxDifference(FulfillmentGroupItem, long, Money)}.
   * <ul>
   *   <li>When {@link Money} {@link Money#multiply(BigDecimal)} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#multiply(BigDecimal)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentItemPricingActivity#applyTaxDifference(FulfillmentGroupItem, long, Money)}
   */
  @Test
  public void testApplyTaxDifference_whenMoneyMultiplyReturnMoney_thenCallsMultiply() {
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
