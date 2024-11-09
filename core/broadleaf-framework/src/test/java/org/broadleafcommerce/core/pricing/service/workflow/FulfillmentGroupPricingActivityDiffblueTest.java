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

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.mockito.Mockito;

public class FulfillmentGroupPricingActivityDiffblueTest {
  /**
   * Test {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenArrayListAddNull_thenReturnProcessContext() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupPricingActivity fulfillmentGroupPricingActivity = new FulfillmentGroupPricingActivity();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(null);
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentGroupPricingActivity.execute(context);

    // Assert
    verify(nullOrderImpl).getCurrency();
    verify(nullOrderImpl).getFulfillmentGroups();
    verify(nullOrderImpl).setTotalFulfillmentCharges(isA(Money.class));
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}
   * {@link FulfillmentGroupImpl#getFulfillmentPrice()} return
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenFulfillmentGroupImplGetFulfillmentPriceReturnMoney() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupPricingActivity fulfillmentGroupPricingActivity = new FulfillmentGroupPricingActivity();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentPrice()).thenReturn(new Money());
    when(fulfillmentGroupImpl.getShippingOverride()).thenReturn(true);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentGroupPricingActivity.execute(context);

    // Assert
    verify(fulfillmentGroupImpl, atLeast(1)).getFulfillmentPrice();
    verify(fulfillmentGroupImpl).getShippingOverride();
    verify(nullOrderImpl).getCurrency();
    verify(nullOrderImpl).getFulfillmentGroups();
    verify(nullOrderImpl).setTotalFulfillmentCharges(isA(Money.class));
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}
   * {@link FulfillmentGroupImpl#getFulfillmentPrice()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenFulfillmentGroupImplGetFulfillmentPriceReturnNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupPricingActivity fulfillmentGroupPricingActivity = new FulfillmentGroupPricingActivity();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentPrice()).thenReturn(null);
    when(fulfillmentGroupImpl.getShippingOverride()).thenReturn(true);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentGroupPricingActivity.execute(context);

    // Assert
    verify(fulfillmentGroupImpl).getFulfillmentPrice();
    verify(fulfillmentGroupImpl).getShippingOverride();
    verify(nullOrderImpl).getCurrency();
    verify(nullOrderImpl).getFulfillmentGroups();
    verify(nullOrderImpl).setTotalFulfillmentCharges(isA(Money.class));
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} {@link NullOrderImpl#getCurrency()} return
   * {@code null}.</li>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenNullOrderImplGetCurrencyReturnNull_thenReturnProcessContext() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupPricingActivity fulfillmentGroupPricingActivity = new FulfillmentGroupPricingActivity();
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentGroupPricingActivity.execute(context);

    // Assert
    verify(nullOrderImpl).getCurrency();
    verify(nullOrderImpl).getFulfillmentGroups();
    verify(nullOrderImpl).setTotalFulfillmentCharges(isA(Money.class));
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }
}
