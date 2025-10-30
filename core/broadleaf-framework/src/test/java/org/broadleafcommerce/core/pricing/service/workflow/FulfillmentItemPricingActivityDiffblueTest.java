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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FulfillmentItemPricingActivity.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FulfillmentItemPricingActivityDiffblueTest {
  @Autowired
  private FulfillmentItemPricingActivity fulfillmentItemPricingActivity;

  /**
   * Test {@link FulfillmentItemPricingActivity#getCurrency(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#getCurrency(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BroadleafCurrency FulfillmentItemPricingActivity.getCurrency(FulfillmentGroup)"})
  public void testGetCurrency_givenNullOrderImpl_thenReturnNull() {
    // Arrange
    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    when(fg.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    BroadleafCurrency actualCurrency = fulfillmentItemPricingActivity.getCurrency(fg);

    // Assert
    verify(fg).getOrder();
    assertNull(actualCurrency);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}.
   * <ul>
   *   <li>Then calls {@link Order#getCurrency()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.getOrderSavingsToDistribute(Order)"})
  public void testGetOrderSavingsToDistribute_thenCallsGetCurrency() {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.getOrderSavingsToDistribute(Order)"})
  public void testGetOrderSavingsToDistribute_whenNullOrderImpl_thenReturnZero() {
    // Arrange and Act
    Money actualOrderSavingsToDistribute = fulfillmentItemPricingActivity
        .getOrderSavingsToDistribute(new NullOrderImpl());

    // Assert
    assertSame(actualOrderSavingsToDistribute.ZERO, actualOrderSavingsToDistribute);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.getOrderSavingsToDistribute(Order)"})
  public void testGetOrderSavingsToDistribute_whenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.getOrderSavingsToDistribute(Order)"})
  public void testGetOrderSavingsToDistribute_whenOrderImpl_thenReturnZero() {
    // Arrange and Act
    Money actualOrderSavingsToDistribute = fulfillmentItemPricingActivity.getOrderSavingsToDistribute(new OrderImpl());

    // Assert
    assertEquals(actualOrderSavingsToDistribute.ZERO, actualOrderSavingsToDistribute);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext FulfillmentItemPricingActivity.execute(ProcessContext)"})
  public void testExecute_givenArrayListAddFulfillmentGroupImpl_thenReturnProcessContext() throws Exception {
    // Arrange
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
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext FulfillmentItemPricingActivity.execute(ProcessContext)"})
  public void testExecute_givenMoneySubtractReturnMoneyWithAmountIsTen() throws Exception {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext FulfillmentItemPricingActivity.execute(ProcessContext)"})
  public void testExecute_givenMoneySubtractReturnMoney_thenCallsGetCurrencyCode() throws Exception {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} {@link NullOrderImpl#getCurrency()} return {@code null}.</li>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext FulfillmentItemPricingActivity.execute(ProcessContext)"})
  public void testExecute_givenNullOrderImplGetCurrencyReturnNull_thenReturnProcessContext() throws Exception {
    // Arrange
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
   *   <li>Given {@link NullOrderImpl} {@link NullOrderImpl#getHasOrderAdjustments()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext FulfillmentItemPricingActivity.execute(ProcessContext)"})
  public void testExecute_givenNullOrderImplGetHasOrderAdjustmentsReturnFalse() throws Exception {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.fixItemTotalRoundingIssues(Order, Map)"})
  public void testFixItemTotalRoundingIssues_givenMoneySubtractReturnMoney() {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.fixItemTotalRoundingIssues(Order, Map)"})
  public void testFixItemTotalRoundingIssues_givenMoneySubtractReturnMoneyWithAmountIsTen() {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}.
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getTotalPrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.fixItemTotalRoundingIssues(Order, Map)"})
  public void testFixItemTotalRoundingIssues_thenCallsGetTotalPrice() {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#calculateTotalPriceForAllFulfillmentItems(Order)}.
   * <ul>
   *   <li>Then calls {@link Order#getCurrency()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#calculateTotalPriceForAllFulfillmentItems(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.calculateTotalPriceForAllFulfillmentItems(Order)"})
  public void testCalculateTotalPriceForAllFulfillmentItems_thenCallsGetCurrency() {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#calculateTotalPriceForAllFulfillmentItems(Order)}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#calculateTotalPriceForAllFulfillmentItems(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.calculateTotalPriceForAllFulfillmentItems(Order)"})
  public void testCalculateTotalPriceForAllFulfillmentItems_whenOrderImpl_thenReturnZero() {
    // Arrange and Act
    Money actualCalculateTotalPriceForAllFulfillmentItemsResult = fulfillmentItemPricingActivity
        .calculateTotalPriceForAllFulfillmentItems(new OrderImpl());

    // Assert
    assertEquals(actualCalculateTotalPriceForAllFulfillmentItemsResult.ZERO,
        actualCalculateTotalPriceForAllFulfillmentItemsResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link Money#getAmount()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.distributeOrderSavingsToItems(Order, BigDecimal)"})
  public void testDistributeOrderSavingsToItems_givenArrayList_thenCallsGetAmount() {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}.
   * <ul>
   *   <li>Then calls {@link Money#getAmount()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.distributeOrderSavingsToItems(Order, BigDecimal)"})
  public void testDistributeOrderSavingsToItems_thenCallsGetAmount() {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.distributeOrderSavingsToItems(Order, BigDecimal)"})
  public void testDistributeOrderSavingsToItems_whenOrderImpl_thenReturnZero() {
    // Arrange
    OrderImpl order = new OrderImpl();

    // Act
    Money actualDistributeOrderSavingsToItemsResult = fulfillmentItemPricingActivity
        .distributeOrderSavingsToItems(order, new BigDecimal("2.3"));

    // Assert
    assertEquals(actualDistributeOrderSavingsToItemsResult.ZERO, actualDistributeOrderSavingsToItemsResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}.
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(Order, Money)"})
  public void testFixOrderSavingsRoundingIssues() {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(Order, Money)"})
  public void testFixOrderSavingsRoundingIssues_givenArrayListAddFulfillmentGroupImpl() {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is {@code -0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(Order, Money)"})
  public void testFixOrderSavingsRoundingIssues_givenMoneyWithAmountIs05() {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(Order, Money)"})
  public void testFixOrderSavingsRoundingIssues_givenMoneyWithAmountIsTen() {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}.
   * <ul>
   *   <li>Then calls {@link Money#subtract(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(Order, Money)"})
  public void testFixOrderSavingsRoundingIssues_thenCallsSubtract() {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}.
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.updateTaxableAmountsOnItems(Order)"})
  public void testUpdateTaxableAmountsOnItems() {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}.
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.updateTaxableAmountsOnItems(Order)"})
  public void testUpdateTaxableAmountsOnItems2() {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#subtract(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.updateTaxableAmountsOnItems(Order)"})
  public void testUpdateTaxableAmountsOnItems_givenMoneySubtractReturnMoney_thenCallsSubtract() {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}.
   * <ul>
   *   <li>Then calls {@link Order#getCurrency()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.updateTaxableAmountsOnItems(Order)"})
  public void testUpdateTaxableAmountsOnItems_thenCallsGetCurrency() {
    // Arrange
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
   * Test {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}.
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#isTaxable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.updateTaxableAmountsOnItems(Order)"})
  public void testUpdateTaxableAmountsOnItems_thenCallsIsTaxable() {
    // Arrange
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
   * Method under test: {@link FulfillmentItemPricingActivity#sumItemAmount(List, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.sumItemAmount(List, Order)"})
  public void testSumItemAmount_whenArrayList_thenReturnZero() {
    // Arrange
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
   * Method under test: {@link FulfillmentItemPricingActivity#sumTaxAmount(List, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.sumTaxAmount(List, Order)"})
  public void testSumTaxAmount_whenArrayList_thenReturnZero() {
    // Arrange
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
   * Method under test: {@link FulfillmentItemPricingActivity#countNumberOfUnits(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long FulfillmentItemPricingActivity.countNumberOfUnits(Money)"})
  public void testCountNumberOfUnits_whenMoney_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, fulfillmentItemPricingActivity.countNumberOfUnits(new Money()));
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#getUnitAmount(Money)}.
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is {@code -0.5}.</li>
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with {@code -0.01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#getUnitAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.getUnitAmount(Money)"})
  public void testGetUnitAmount_whenMoneyWithAmountIs05_thenReturnAmountIsBigDecimalWith001() {
    // Arrange and Act
    Money actualUnitAmount = fulfillmentItemPricingActivity.getUnitAmount(new Money(-0.5d));

    // Assert
    BigDecimal expectedAmount = new BigDecimal("-0.01");
    assertEquals(expectedAmount, actualUnitAmount.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("0.01");
    Money absResult = actualUnitAmount.abs();
    assertEquals(expectedAmount2, absResult.getAmount());
    assertEquals(absResult.abs(), absResult.abs());
    Money expectedZeroResult = actualUnitAmount.ZERO;
    assertEquals(expectedZeroResult, actualUnitAmount.zero());
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#getUnitAmount(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with {@code 0.01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentItemPricingActivity#getUnitAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.getUnitAmount(Money)"})
  public void testGetUnitAmount_whenMoney_thenReturnAmountIsBigDecimalWith001() {
    // Arrange
    Money difference = new Money();

    // Act
    Money actualUnitAmount = fulfillmentItemPricingActivity.getUnitAmount(difference);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.01");
    assertEquals(expectedAmount, actualUnitAmount.getAmount());
    assertEquals(difference, actualUnitAmount.zero());
    assertEquals(actualUnitAmount, actualUnitAmount.abs());
  }
}
