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

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupFee;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupFeeImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.TaxDetail;
import org.broadleafcommerce.core.order.domain.TaxDetailImpl;
import org.broadleafcommerce.core.order.domain.TaxType;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TotalActivity.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TotalActivityDiffblueTest {
  @Autowired private TotalActivity totalActivity;

  /**
   * Test {@link TotalActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} {@link NullOrderImpl#getTotalTax()} return {@link
   *       Money#Money()}.
   *   <li>Then return {@link ProcessContext}.
   * </ul>
   *
   * <p>Method under test: {@link TotalActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext TotalActivity.execute(ProcessContext)"})
  public void testExecute_givenNullOrderImplGetTotalTaxReturnMoney_thenReturnProcessContext()
      throws Exception {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getTotalTax()).thenReturn(new Money());
    doNothing().when(nullOrderImpl).setTotal(Mockito.<Money>any());
    when(nullOrderImpl.getTotalShipping()).thenReturn(new Money());
    when(nullOrderImpl.getOrderAdjustmentsValue()).thenReturn(new Money());
    when(nullOrderImpl.getTaxOverride()).thenReturn(true);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    when(nullOrderImpl.getSubTotal()).thenReturn(new Money());
    doNothing().when(nullOrderImpl).setTotalTax(Mockito.<Money>any());

    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = totalActivity.execute(context);

    // Assert
    verify(nullOrderImpl, atLeast(1)).getCurrency();
    verify(nullOrderImpl, atLeast(1)).getFulfillmentGroups();
    verify(nullOrderImpl).getOrderAdjustmentsValue();
    verify(nullOrderImpl).getSubTotal();
    verify(nullOrderImpl).getTaxOverride();
    verify(nullOrderImpl).getTotalShipping();
    verify(nullOrderImpl, atLeast(1)).getTotalTax();
    verify(nullOrderImpl).setTotal(isA(Money.class));
    verify(nullOrderImpl).setTotalTax(isA(Money.class));
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link TotalActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} {@link NullOrderImpl#getTotalTax()} return {@code null}.
   *   <li>Then return {@link ProcessContext}.
   * </ul>
   *
   * <p>Method under test: {@link TotalActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext TotalActivity.execute(ProcessContext)"})
  public void testExecute_givenNullOrderImplGetTotalTaxReturnNull_thenReturnProcessContext()
      throws Exception {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getTotalTax()).thenReturn(null);
    doNothing().when(nullOrderImpl).setTotal(Mockito.<Money>any());
    when(nullOrderImpl.getTotalShipping()).thenReturn(new Money());
    when(nullOrderImpl.getOrderAdjustmentsValue()).thenReturn(new Money());
    when(nullOrderImpl.getTaxOverride()).thenReturn(true);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    when(nullOrderImpl.getSubTotal()).thenReturn(new Money());
    doNothing().when(nullOrderImpl).setTotalTax(Mockito.<Money>any());

    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = totalActivity.execute(context);

    // Assert
    verify(nullOrderImpl, atLeast(1)).getCurrency();
    verify(nullOrderImpl, atLeast(1)).getFulfillmentGroups();
    verify(nullOrderImpl).getOrderAdjustmentsValue();
    verify(nullOrderImpl).getSubTotal();
    verify(nullOrderImpl).getTaxOverride();
    verify(nullOrderImpl).getTotalShipping();
    verify(nullOrderImpl).getTotalTax();
    verify(nullOrderImpl).setTotal(isA(Money.class));
    verify(nullOrderImpl).setTotalTax(isA(Money.class));
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link TotalActivity#setTaxSums(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupFeeImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TotalActivity.setTaxSums(Order)"})
  public void testSetTaxSums_givenArrayListAddFulfillmentGroupFeeImpl() {
    // Arrange
    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(new FulfillmentGroupFeeImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);
    when(fulfillmentGroupImpl.getFulfillmentGroupItems()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupImpl.getTaxes()).thenReturn(new ArrayList<>());
    doNothing().when(fulfillmentGroupImpl).setTotalFeeTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalItemTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);

    OrderImpl order = mock(OrderImpl.class);
    when(order.getTaxOverride()).thenReturn(true);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(order).setTotalTax(Mockito.<Money>any());
    order.setCurrency(mock(BroadleafCurrency.class));

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(fulfillmentGroupImpl).getFulfillmentGroupFees();
    verify(fulfillmentGroupImpl).getFulfillmentGroupItems();
    verify(fulfillmentGroupImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupImpl).setTotalFeeTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalItemTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalTax(isA(Money.class));
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setCurrency(isA(BroadleafCurrency.class));
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Test {@link TotalActivity#setTaxSums(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupFeeImpl} (default
   *       constructor).
   *   <li>Then calls {@link FulfillmentGroupFeeImpl#getTaxes()}.
   * </ul>
   *
   * <p>Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TotalActivity.setTaxSums(Order)"})
  public void testSetTaxSums_givenArrayListAddFulfillmentGroupFeeImpl_thenCallsGetTaxes() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(new ArrayList<>());
    doNothing().when(fulfillmentGroupFeeImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(new FulfillmentGroupFeeImpl());
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);
    when(fulfillmentGroupImpl.getFulfillmentGroupItems()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupImpl.getTaxes()).thenReturn(new ArrayList<>());
    doNothing().when(fulfillmentGroupImpl).setTotalFeeTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalItemTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);

    OrderImpl order = mock(OrderImpl.class);
    when(order.getTaxOverride()).thenReturn(false);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(order).setTotalTax(Mockito.<Money>any());
    order.setCurrency(mock(BroadleafCurrency.class));

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(fulfillmentGroupFeeImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupFeeImpl).setTotalTax(isA(Money.class));
    verify(fulfillmentGroupImpl).getFulfillmentGroupFees();
    verify(fulfillmentGroupImpl).getFulfillmentGroupItems();
    verify(fulfillmentGroupImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupImpl).setTotalFeeTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalItemTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalTax(isA(Money.class));
    verify(order, atLeast(1)).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setCurrency(isA(BroadleafCurrency.class));
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Test {@link TotalActivity#setTaxSums(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TotalActivity.setTaxSums(Order)"})
  public void testSetTaxSums_givenArrayListAddFulfillmentGroupImpl() {
    // Arrange
    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());

    OrderImpl order = mock(OrderImpl.class);
    when(order.getTaxOverride()).thenReturn(true);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(order).setTotalTax(Mockito.<Money>any());
    order.setCurrency(mock(BroadleafCurrency.class));

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setCurrency(isA(BroadleafCurrency.class));
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Test {@link TotalActivity#setTaxSums(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl} (default
   *       constructor).
   *   <li>Then calls {@link FulfillmentGroupFeeImpl#getTaxes()}.
   * </ul>
   *
   * <p>Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TotalActivity.setTaxSums(Order)"})
  public void testSetTaxSums_givenArrayListAddFulfillmentGroupImpl_thenCallsGetTaxes() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(new ArrayList<>());
    doNothing().when(fulfillmentGroupFeeImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);
    when(fulfillmentGroupImpl.getFulfillmentGroupItems()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupImpl.getTaxes()).thenReturn(new ArrayList<>());
    doNothing().when(fulfillmentGroupImpl).setTotalFeeTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalItemTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    fulfillmentGroupList.add(fulfillmentGroupImpl);

    OrderImpl order = mock(OrderImpl.class);
    when(order.getTaxOverride()).thenReturn(false);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(order).setTotalTax(Mockito.<Money>any());
    order.setCurrency(mock(BroadleafCurrency.class));

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(fulfillmentGroupFeeImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupFeeImpl).setTotalTax(isA(Money.class));
    verify(fulfillmentGroupImpl).getFulfillmentGroupFees();
    verify(fulfillmentGroupImpl).getFulfillmentGroupItems();
    verify(fulfillmentGroupImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupImpl).setTotalFeeTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalItemTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalTax(isA(Money.class));
    verify(order, atLeast(1)).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setCurrency(isA(BroadleafCurrency.class));
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Test {@link TotalActivity#setTaxSums(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupItemImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TotalActivity.setTaxSums(Order)"})
  public void testSetTaxSums_givenArrayListAddFulfillmentGroupItemImpl() {
    // Arrange
    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(new FulfillmentGroupItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentGroupFees()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupImpl.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);
    when(fulfillmentGroupImpl.getTaxes()).thenReturn(new ArrayList<>());
    doNothing().when(fulfillmentGroupImpl).setTotalFeeTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalItemTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);

    OrderImpl order = mock(OrderImpl.class);
    when(order.getTaxOverride()).thenReturn(true);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(order).setTotalTax(Mockito.<Money>any());
    order.setCurrency(mock(BroadleafCurrency.class));

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(fulfillmentGroupImpl).getFulfillmentGroupFees();
    verify(fulfillmentGroupImpl).getFulfillmentGroupItems();
    verify(fulfillmentGroupImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupImpl).setTotalFeeTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalItemTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalTax(isA(Money.class));
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setCurrency(isA(BroadleafCurrency.class));
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Test {@link TotalActivity#setTaxSums(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupItemImpl} (default
   *       constructor).
   *   <li>Then calls {@link FulfillmentGroupFeeImpl#getTaxes()}.
   * </ul>
   *
   * <p>Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TotalActivity.setTaxSums(Order)"})
  public void testSetTaxSums_givenArrayListAddFulfillmentGroupItemImpl_thenCallsGetTaxes() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(new ArrayList<>());
    doNothing().when(fulfillmentGroupFeeImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(new FulfillmentGroupItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);
    when(fulfillmentGroupImpl.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);
    when(fulfillmentGroupImpl.getTaxes()).thenReturn(new ArrayList<>());
    doNothing().when(fulfillmentGroupImpl).setTotalFeeTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalItemTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);

    OrderImpl order = mock(OrderImpl.class);
    when(order.getTaxOverride()).thenReturn(false);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(order).setTotalTax(Mockito.<Money>any());
    order.setCurrency(mock(BroadleafCurrency.class));

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(fulfillmentGroupFeeImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupFeeImpl).setTotalTax(isA(Money.class));
    verify(fulfillmentGroupImpl).getFulfillmentGroupFees();
    verify(fulfillmentGroupImpl).getFulfillmentGroupItems();
    verify(fulfillmentGroupImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupImpl).setTotalFeeTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalItemTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalTax(isA(Money.class));
    verify(order, atLeast(1)).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setCurrency(isA(BroadleafCurrency.class));
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Test {@link TotalActivity#setTaxSums(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link OrderImpl} {@link OrderImpl#getTaxOverride()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TotalActivity.setTaxSums(Order)"})
  public void testSetTaxSums_givenArrayList_whenOrderImplGetTaxOverrideReturnTrue() {
    // Arrange
    OrderImpl order = mock(OrderImpl.class);
    when(order.getTaxOverride()).thenReturn(true);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(order).setTotalTax(Mockito.<Money>any());
    order.setCurrency(mock(BroadleafCurrency.class));

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setCurrency(isA(BroadleafCurrency.class));
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Test {@link TotalActivity#setTaxSums(Order)}.
   *
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then calls {@link FulfillmentGroupFeeImpl#getTaxes()}.
   * </ul>
   *
   * <p>Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TotalActivity.setTaxSums(Order)"})
  public void testSetTaxSums_givenBigDecimalWith23_thenCallsGetTaxes() {
    // Arrange
    ArrayList<TaxDetail> taxDetailList = new ArrayList<>();
    Money amount = new Money();
    TaxDetailImpl taxDetailImpl = new TaxDetailImpl(TaxType.CITY, amount, new BigDecimal("2.3"));
    taxDetailList.add(taxDetailImpl);

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(taxDetailList);
    doNothing().when(fulfillmentGroupFeeImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);
    when(fulfillmentGroupImpl.getFulfillmentGroupItems()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupImpl.getTaxes()).thenReturn(new ArrayList<>());
    doNothing().when(fulfillmentGroupImpl).setTotalFeeTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalItemTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);

    OrderImpl order = mock(OrderImpl.class);
    when(order.getTaxOverride()).thenReturn(false);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(order).setTotalTax(Mockito.<Money>any());
    order.setCurrency(mock(BroadleafCurrency.class));

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(fulfillmentGroupFeeImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupFeeImpl).setTotalTax(isA(Money.class));
    verify(fulfillmentGroupImpl).getFulfillmentGroupFees();
    verify(fulfillmentGroupImpl).getFulfillmentGroupItems();
    verify(fulfillmentGroupImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupImpl).setTotalFeeTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalItemTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalTax(isA(Money.class));
    verify(order, atLeast(1)).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setCurrency(isA(BroadleafCurrency.class));
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Test {@link TotalActivity#setTaxSums(Order)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link FulfillmentGroupImpl#getFulfillmentGroupFees()}.
   * </ul>
   *
   * <p>Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TotalActivity.setTaxSums(Order)"})
  public void testSetTaxSums_givenFalse_thenCallsGetFulfillmentGroupFees() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentGroupFees()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupImpl.getFulfillmentGroupItems()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupImpl.getTaxes()).thenReturn(new ArrayList<>());
    doNothing().when(fulfillmentGroupImpl).setTotalFeeTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalItemTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);

    OrderImpl order = mock(OrderImpl.class);
    when(order.getTaxOverride()).thenReturn(false);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(order).setTotalTax(Mockito.<Money>any());
    order.setCurrency(mock(BroadleafCurrency.class));

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(fulfillmentGroupImpl).getFulfillmentGroupFees();
    verify(fulfillmentGroupImpl).getFulfillmentGroupItems();
    verify(fulfillmentGroupImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupImpl).setTotalFeeTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalItemTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalTax(isA(Money.class));
    verify(order, atLeast(1)).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setCurrency(isA(BroadleafCurrency.class));
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Test {@link TotalActivity#setTaxSums(Order)}.
   *
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getAmount()} return {@link
   *       Money#Money()}.
   *   <li>Then calls {@link TaxDetailImpl#getAmount()}.
   * </ul>
   *
   * <p>Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TotalActivity.setTaxSums(Order)"})
  public void testSetTaxSums_givenTaxDetailImplGetAmountReturnMoney_thenCallsGetAmount() {
    // Arrange
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getAmount()).thenReturn(new Money());

    ArrayList<TaxDetail> taxDetailList = new ArrayList<>();
    taxDetailList.add(taxDetailImpl);

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(taxDetailList);
    doNothing().when(fulfillmentGroupFeeImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);
    when(fulfillmentGroupImpl.getFulfillmentGroupItems()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupImpl.getTaxes()).thenReturn(new ArrayList<>());
    doNothing().when(fulfillmentGroupImpl).setTotalFeeTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalItemTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);

    OrderImpl order = mock(OrderImpl.class);
    when(order.getTaxOverride()).thenReturn(false);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(order).setTotalTax(Mockito.<Money>any());
    order.setCurrency(mock(BroadleafCurrency.class));

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(fulfillmentGroupFeeImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupFeeImpl).setTotalTax(isA(Money.class));
    verify(fulfillmentGroupImpl).getFulfillmentGroupFees();
    verify(fulfillmentGroupImpl).getFulfillmentGroupItems();
    verify(fulfillmentGroupImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupImpl).setTotalFeeTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalItemTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalTax(isA(Money.class));
    verify(order, atLeast(1)).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setCurrency(isA(BroadleafCurrency.class));
    verify(order).setTotalTax(isA(Money.class));
    verify(taxDetailImpl).getAmount();
  }

  /**
   * Test {@link TotalActivity#setTaxSums(Order)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link OrderImpl} {@link OrderImpl#getTaxOverride()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TotalActivity.setTaxSums(Order)"})
  public void testSetTaxSums_givenTrue_whenOrderImplGetTaxOverrideReturnTrue() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentGroupFees()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupImpl.getFulfillmentGroupItems()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupImpl.getTaxes()).thenReturn(new ArrayList<>());
    doNothing().when(fulfillmentGroupImpl).setTotalFeeTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalItemTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);

    OrderImpl order = mock(OrderImpl.class);
    when(order.getTaxOverride()).thenReturn(true);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(order).setTotalTax(Mockito.<Money>any());
    order.setCurrency(mock(BroadleafCurrency.class));

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(fulfillmentGroupImpl).getFulfillmentGroupFees();
    verify(fulfillmentGroupImpl).getFulfillmentGroupItems();
    verify(fulfillmentGroupImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupImpl).setTotalFeeTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalItemTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalTax(isA(Money.class));
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setCurrency(isA(BroadleafCurrency.class));
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Test {@link TotalActivity#setTaxSums(Order)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link OrderImpl} {@link OrderImpl#getTaxOverride()} return {@code true}.
   *   <li>Then calls {@link FulfillmentGroupFeeImpl#getTaxes()}.
   * </ul>
   *
   * <p>Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TotalActivity.setTaxSums(Order)"})
  public void testSetTaxSums_givenTrue_whenOrderImplGetTaxOverrideReturnTrue_thenCallsGetTaxes() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(new ArrayList<>());
    doNothing().when(fulfillmentGroupFeeImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);
    when(fulfillmentGroupImpl.getFulfillmentGroupItems()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupImpl.getTaxes()).thenReturn(new ArrayList<>());
    doNothing().when(fulfillmentGroupImpl).setTotalFeeTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalItemTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);

    OrderImpl order = mock(OrderImpl.class);
    when(order.getTaxOverride()).thenReturn(true);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(order).setTotalTax(Mockito.<Money>any());
    order.setCurrency(mock(BroadleafCurrency.class));

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(fulfillmentGroupFeeImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupFeeImpl).setTotalTax(isA(Money.class));
    verify(fulfillmentGroupImpl).getFulfillmentGroupFees();
    verify(fulfillmentGroupImpl).getFulfillmentGroupItems();
    verify(fulfillmentGroupImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupImpl).setTotalFeeTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalItemTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalTax(isA(Money.class));
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setCurrency(isA(BroadleafCurrency.class));
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Test {@link TotalActivity#setTaxSums(Order)}.
   *
   * <ul>
   *   <li>Then calls {@link FulfillmentGroupFeeImpl#getTaxes()}.
   * </ul>
   *
   * <p>Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TotalActivity.setTaxSums(Order)"})
  public void testSetTaxSums_thenCallsGetTaxes() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(new ArrayList<>());
    doNothing().when(fulfillmentGroupFeeImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);
    when(fulfillmentGroupImpl.getFulfillmentGroupItems()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupImpl.getTaxes()).thenReturn(new ArrayList<>());
    doNothing().when(fulfillmentGroupImpl).setTotalFeeTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalItemTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);

    OrderImpl order = mock(OrderImpl.class);
    when(order.getTaxOverride()).thenReturn(false);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setCurrency(Mockito.<BroadleafCurrency>any());
    doNothing().when(order).setTotalTax(Mockito.<Money>any());
    order.setCurrency(mock(BroadleafCurrency.class));

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(fulfillmentGroupFeeImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupFeeImpl).setTotalTax(isA(Money.class));
    verify(fulfillmentGroupImpl).getFulfillmentGroupFees();
    verify(fulfillmentGroupImpl).getFulfillmentGroupItems();
    verify(fulfillmentGroupImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupImpl).setTotalFeeTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalItemTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalTax(isA(Money.class));
    verify(order, atLeast(1)).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setCurrency(isA(BroadleafCurrency.class));
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Test {@link TotalActivity#setTaxSums(Order)}.
   *
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor) Currency is {@link BroadleafCurrency}.
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TotalActivity.setTaxSums(Order)"})
  public void testSetTaxSums_whenOrderImplCurrencyIsBroadleafCurrency_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setCurrency(currency);

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(currency).getCurrencyCode();
  }
}
