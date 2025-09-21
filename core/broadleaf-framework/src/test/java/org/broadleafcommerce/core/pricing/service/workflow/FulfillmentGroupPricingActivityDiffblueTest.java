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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.pricing.service.FulfillmentPricingService;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FulfillmentGroupPricingActivityDiffblueTest {
  @InjectMocks private FulfillmentGroupPricingActivity fulfillmentGroupPricingActivity;

  @Mock private FulfillmentPricingService fulfillmentPricingService;

  /**
   * Test {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext FulfillmentGroupPricingActivity.execute(ProcessContext)"})
  public void testExecute() throws Exception {
    // Arrange
    when(fulfillmentPricingService.calculateCostForFulfillmentGroup(
            Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());

    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentGroupPricingActivity.execute(context);

    // Assert
    verify(nullOrderImpl).getCurrency();
    verify(nullOrderImpl).getFulfillmentGroups();
    verify(nullOrderImpl).setTotalFulfillmentCharges(isA(Money.class));
    verify(fulfillmentPricingService).calculateCostForFulfillmentGroup(isA(FulfillmentGroup.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext FulfillmentGroupPricingActivity.execute(ProcessContext)"})
  public void testExecute_givenArrayListAddNull_thenReturnDefaultProcessContextImpl()
      throws Exception {
    // Arrange
    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(null);

    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentGroupPricingActivity.execute(context);

    // Assert
    verify(nullOrderImpl).getCurrency();
    verify(nullOrderImpl).getFulfillmentGroups();
    verify(nullOrderImpl).setTotalFulfillmentCharges(isA(Money.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).
   *   <li>Then SeedData return {@link OrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext FulfillmentGroupPricingActivity.execute(ProcessContext)"})
  public void testExecute_givenOrderImpl_thenSeedDataReturnOrderImpl() throws Exception {
    // Arrange
    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    OrderImpl orderImpl = new OrderImpl();
    context.setSeedData(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentGroupPricingActivity.execute(context);

    // Assert
    Order seedData = actualExecuteResult.getSeedData();
    assertTrue(seedData instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(orderImpl, seedData);
  }

  /**
   * Test {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       FulfillmentPricingService#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext FulfillmentGroupPricingActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsCalculateCostForFulfillmentGroup() throws Exception {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentPrice()).thenReturn(new Money());
    when(fulfillmentPricingService.calculateCostForFulfillmentGroup(
            Mockito.<FulfillmentGroup>any()))
        .thenReturn(fulfillmentGroupImpl);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());

    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentGroupPricingActivity.execute(context);

    // Assert
    verify(fulfillmentGroupImpl, atLeast(1)).getFulfillmentPrice();
    verify(nullOrderImpl).getCurrency();
    verify(nullOrderImpl).getFulfillmentGroups();
    verify(nullOrderImpl).setTotalFulfillmentCharges(isA(Money.class));
    verify(fulfillmentPricingService).calculateCostForFulfillmentGroup(isA(FulfillmentGroup.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then calls {@link FulfillmentGroupImpl#getShippingOverride()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext FulfillmentGroupPricingActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsGetShippingOverride() throws Exception {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentPrice()).thenReturn(new Money());
    when(fulfillmentGroupImpl.getShippingOverride()).thenReturn(true);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);

    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentGroupPricingActivity.execute(context);

    // Assert
    verify(fulfillmentGroupImpl, atLeast(1)).getFulfillmentPrice();
    verify(fulfillmentGroupImpl).getShippingOverride();
    verify(nullOrderImpl).getCurrency();
    verify(nullOrderImpl).getFulfillmentGroups();
    verify(nullOrderImpl).setTotalFulfillmentCharges(isA(Money.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext FulfillmentGroupPricingActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentGroupPricingActivity.execute(context);

    // Assert
    verify(nullOrderImpl).getCurrency();
    verify(nullOrderImpl).getFulfillmentGroups();
    verify(nullOrderImpl).setTotalFulfillmentCharges(isA(Money.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext FulfillmentGroupPricingActivity.execute(ProcessContext)"})
  public void testExecute_thenThrowUnsupportedOperationException() throws Exception {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentPrice()).thenReturn(new Money());
    when(fulfillmentGroupImpl.getShippingOverride()).thenReturn(true);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(nullOrderImpl.getCurrency()).thenReturn(broadleafCurrency);

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(nullOrderImpl);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> fulfillmentGroupPricingActivity.execute(context));
    verify(broadleafCurrency).getCurrencyCode();
    verify(fulfillmentGroupImpl, atLeast(1)).getFulfillmentPrice();
    verify(fulfillmentGroupImpl).getShippingOverride();
    verify(nullOrderImpl).getCurrency();
    verify(nullOrderImpl).getFulfillmentGroups();
  }
}
