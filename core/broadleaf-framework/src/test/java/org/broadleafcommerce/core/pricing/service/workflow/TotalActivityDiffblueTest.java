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
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupFee;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupFeeImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.TaxDetail;
import org.broadleafcommerce.core.order.domain.TaxDetailImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.mockito.Mockito;

public class TotalActivityDiffblueTest {
  /**
   * Method under test: {@link TotalActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotalActivity totalActivity = new TotalActivity();
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
   * Method under test: {@link TotalActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotalActivity totalActivity = new TotalActivity();
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
   * Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  public void testSetTaxSums() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotalActivity totalActivity = new TotalActivity();
    Order order = mock(Order.class);
    when(order.getTaxOverride()).thenReturn(true);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setTotalTax(Mockito.<Money>any());

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  public void testSetTaxSums2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotalActivity totalActivity = new TotalActivity();
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getTaxOverride()).thenReturn(true);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setTotalTax(Mockito.<Money>any());

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  public void testSetTaxSums3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotalActivity totalActivity = new TotalActivity();
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getTaxOverride()).thenReturn(false);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setTotalTax(Mockito.<Money>any());

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  public void testSetTaxSums4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotalActivity totalActivity = new TotalActivity();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getTaxOverride()).thenReturn(true);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setTotalTax(Mockito.<Money>any());

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  public void testSetTaxSums5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotalActivity totalActivity = new TotalActivity();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getTaxOverride()).thenReturn(false);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setTotalTax(Mockito.<Money>any());

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  public void testSetTaxSums6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotalActivity totalActivity = new TotalActivity();
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
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getTaxOverride()).thenReturn(true);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setTotalTax(Mockito.<Money>any());

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
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
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  public void testSetTaxSums7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotalActivity totalActivity = new TotalActivity();
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
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getTaxOverride()).thenReturn(false);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setTotalTax(Mockito.<Money>any());

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
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
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  public void testSetTaxSums8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotalActivity totalActivity = new TotalActivity();

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
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getTaxOverride()).thenReturn(true);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setTotalTax(Mockito.<Money>any());

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
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
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  public void testSetTaxSums9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotalActivity totalActivity = new TotalActivity();

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
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getTaxOverride()).thenReturn(true);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setTotalTax(Mockito.<Money>any());

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
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
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  public void testSetTaxSums10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotalActivity totalActivity = new TotalActivity();

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
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getTaxOverride()).thenReturn(false);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setTotalTax(Mockito.<Money>any());

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
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
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  public void testSetTaxSums11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotalActivity totalActivity = new TotalActivity();

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
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getTaxOverride()).thenReturn(false);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setTotalTax(Mockito.<Money>any());

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
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
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  public void testSetTaxSums12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotalActivity totalActivity = new TotalActivity();
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
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getTaxOverride()).thenReturn(true);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setTotalTax(Mockito.<Money>any());

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
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
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  public void testSetTaxSums13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotalActivity totalActivity = new TotalActivity();
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
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getTaxOverride()).thenReturn(false);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setTotalTax(Mockito.<Money>any());

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
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
    verify(order).setTotalTax(isA(Money.class));
  }

  /**
   * Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  public void testSetTaxSums14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotalActivity totalActivity = new TotalActivity();
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getAmount()).thenReturn(new Money());

    ArrayList<TaxDetail> taxDetailList = new ArrayList<>();
    taxDetailList.add(taxDetailImpl);
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getTaxes()).thenReturn(taxDetailList);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);
    when(fulfillmentGroupImpl.getTaxes()).thenReturn(new ArrayList<>());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getTaxOverride()).thenReturn(false);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> totalActivity.setTaxSums(order));
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(fulfillmentGroupImpl).getFulfillmentGroupItems();
    verify(fulfillmentGroupImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupItemImpl, atLeast(1)).getTaxes();
    verify(order, atLeast(1)).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(taxDetailImpl).getAmount();
  }

  /**
   * Method under test: {@link TotalActivity#setTaxSums(Order)}
   */
  @Test
  public void testSetTaxSums15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotalActivity totalActivity = new TotalActivity();

    ArrayList<TaxDetail> taxDetailList = new ArrayList<>();
    taxDetailList.add(mock(TaxDetailImpl.class));
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(taxDetailList);
    doNothing().when(fulfillmentGroupFeeImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);

    ArrayList<TaxDetail> taxDetailList2 = new ArrayList<>();
    taxDetailList2.add(mock(TaxDetailImpl.class));
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getTaxes()).thenReturn(taxDetailList2);
    doNothing().when(fulfillmentGroupItemImpl).setTotalTax(Mockito.<Money>any());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);
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
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getTaxOverride()).thenReturn(true);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setTotalTax(Mockito.<Money>any());

    // Act
    totalActivity.setTaxSums(order);

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(fulfillmentGroupFeeImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupFeeImpl).setTotalTax(isA(Money.class));
    verify(fulfillmentGroupImpl).getFulfillmentGroupFees();
    verify(fulfillmentGroupImpl).getFulfillmentGroupItems();
    verify(fulfillmentGroupImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupImpl).setTotalFeeTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalItemTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalTax(isA(Money.class));
    verify(fulfillmentGroupItemImpl, atLeast(1)).getTaxes();
    verify(fulfillmentGroupItemImpl).setTotalTax(isA(Money.class));
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order).getTaxOverride();
    verify(order).setTotalTax(isA(Money.class));
  }
}
