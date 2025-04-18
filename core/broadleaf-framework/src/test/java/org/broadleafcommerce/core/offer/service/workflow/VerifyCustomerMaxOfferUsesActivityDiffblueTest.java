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
package org.broadleafcommerce.core.offer.service.workflow;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import org.broadleafcommerce.core.checkout.service.workflow.CheckoutSeed;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.OfferAuditService;
import org.broadleafcommerce.core.offer.service.OfferService;
import org.broadleafcommerce.core.offer.service.exception.OfferMaxUseExceededException;
import org.broadleafcommerce.core.offer.service.type.CustomerMaxUsesStrategyType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VerifyCustomerMaxOfferUsesActivityDiffblueTest {
  @Mock
  private OfferAuditService offerAuditService;

  @Mock
  private OfferService offerService;

  @InjectMocks
  private VerifyCustomerMaxOfferUsesActivity verifyCustomerMaxOfferUsesActivity;

  /**
   * Test {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}.
   * <p>
   * Method under test: {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext VerifyCustomerMaxOfferUsesActivity.execute(ProcessContext)"})
  public void testExecute() throws Exception {
    // Arrange
    when(offerAuditService.countUsesByAccount(Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<Long>any())).thenReturn(3L);
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getId()).thenReturn(1L);
    when(offerImpl.getMaxUsesPerCustomer()).thenReturn(1L);
    when(offerImpl.getMinimumDaysPerUsage()).thenReturn(1L);
    when(offerImpl.getMaxUsesStrategyType()).thenReturn(new CustomerMaxUsesStrategyType());
    when(offerImpl.isLimitedUsePerCustomer()).thenReturn(true);

    HashSet<Offer> offerSet = new HashSet<>();
    offerSet.add(offerImpl);
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(offerSet);
    ProcessContext<CheckoutSeed> context = mock(ProcessContext.class);
    NullOrderImpl order = new NullOrderImpl();
    when(context.getSeedData()).thenReturn(new CheckoutSeed(order, new HashMap<>()));

    // Act and Assert
    assertThrows(OfferMaxUseExceededException.class, () -> verifyCustomerMaxOfferUsesActivity.execute(context));
    verify(offerImpl).getId();
    verify(offerImpl).getMaxUsesPerCustomer();
    verify(offerImpl).getMaxUsesStrategyType();
    verify(offerImpl).getMinimumDaysPerUsage();
    verify(offerImpl).isLimitedUsePerCustomer();
    verify(offerAuditService).countUsesByAccount(isA(Order.class), isNull(), eq(1L), eq(1L));
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    verify(context).getSeedData();
  }

  /**
   * Test {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}.
   * <p>
   * Method under test: {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext VerifyCustomerMaxOfferUsesActivity.execute(ProcessContext)"})
  public void testExecute2() throws Exception {
    // Arrange
    when(offerAuditService.countUsesByAccount(Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<Long>any())).thenReturn(3L);
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getId()).thenReturn(1L);
    when(offerImpl.getMaxUsesPerCustomer()).thenReturn(1L);
    when(offerImpl.getMinimumDaysPerUsage()).thenReturn(1L);
    when(offerImpl.getMaxUsesStrategyType()).thenReturn(mock(CustomerMaxUsesStrategyType.class));
    when(offerImpl.isLimitedUsePerCustomer()).thenReturn(true);

    HashSet<Offer> offerSet = new HashSet<>();
    offerSet.add(offerImpl);
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(offerSet);
    ProcessContext<CheckoutSeed> context = mock(ProcessContext.class);
    NullOrderImpl order = new NullOrderImpl();
    when(context.getSeedData()).thenReturn(new CheckoutSeed(order, new HashMap<>()));

    // Act and Assert
    assertThrows(OfferMaxUseExceededException.class, () -> verifyCustomerMaxOfferUsesActivity.execute(context));
    verify(offerImpl).getId();
    verify(offerImpl).getMaxUsesPerCustomer();
    verify(offerImpl).getMaxUsesStrategyType();
    verify(offerImpl).getMinimumDaysPerUsage();
    verify(offerImpl).isLimitedUsePerCustomer();
    verify(offerAuditService).countUsesByAccount(isA(Order.class), isNull(), eq(1L), eq(1L));
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    verify(context).getSeedData();
  }

  /**
   * Test {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link OfferAuditService#countUsesByAccount(Order, Long, Long, Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext VerifyCustomerMaxOfferUsesActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsCountUsesByAccount() throws Exception {
    // Arrange
    when(offerAuditService.countUsesByAccount(Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<Long>any())).thenReturn(3L);
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getId()).thenReturn(1L);
    when(offerImpl.getMaxUsesPerCustomer()).thenReturn(1L);
    when(offerImpl.getMinimumDaysPerUsage()).thenReturn(1L);
    when(offerImpl.getMaxUsesStrategyType()).thenReturn(CustomerMaxUsesStrategyType.ACCOUNT);
    when(offerImpl.isLimitedUsePerCustomer()).thenReturn(true);

    HashSet<Offer> offerSet = new HashSet<>();
    offerSet.add(offerImpl);
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(offerSet);
    ProcessContext<CheckoutSeed> context = mock(ProcessContext.class);
    NullOrderImpl order = new NullOrderImpl();
    when(context.getSeedData()).thenReturn(new CheckoutSeed(order, new HashMap<>()));

    // Act and Assert
    assertThrows(OfferMaxUseExceededException.class, () -> verifyCustomerMaxOfferUsesActivity.execute(context));
    verify(offerImpl).getId();
    verify(offerImpl).getMaxUsesPerCustomer();
    verify(offerImpl).getMaxUsesStrategyType();
    verify(offerImpl).getMinimumDaysPerUsage();
    verify(offerImpl).isLimitedUsePerCustomer();
    verify(offerAuditService).countUsesByAccount(isA(Order.class), isNull(), eq(1L), eq(1L));
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    verify(context).getSeedData();
  }

  /**
   * Test {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link OfferAuditService#countUsesByCustomer(Order, Long, Long, Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext VerifyCustomerMaxOfferUsesActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsCountUsesByCustomer() throws Exception {
    // Arrange
    when(offerAuditService.countUsesByCustomer(Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<Long>any())).thenReturn(3L);
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getId()).thenReturn(1L);
    when(offerImpl.getMaxUsesPerCustomer()).thenReturn(1L);
    when(offerImpl.getMinimumDaysPerUsage()).thenReturn(1L);
    when(offerImpl.getMaxUsesStrategyType()).thenReturn(CustomerMaxUsesStrategyType.CUSTOMER);
    when(offerImpl.isLimitedUsePerCustomer()).thenReturn(true);

    HashSet<Offer> offerSet = new HashSet<>();
    offerSet.add(offerImpl);
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(offerSet);
    Order order = mock(Order.class);
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    ProcessContext<CheckoutSeed> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CheckoutSeed(order, new HashMap<>()));

    // Act and Assert
    assertThrows(OfferMaxUseExceededException.class, () -> verifyCustomerMaxOfferUsesActivity.execute(context));
    verify(offerImpl).getId();
    verify(offerImpl).getMaxUsesPerCustomer();
    verify(offerImpl).getMaxUsesStrategyType();
    verify(offerImpl).getMinimumDaysPerUsage();
    verify(offerImpl).isLimitedUsePerCustomer();
    verify(offerAuditService).countUsesByCustomer(isA(Order.class), isNull(), eq(1L), eq(1L));
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    verify(order).getCustomer();
    verify(context).getSeedData();
  }

  /**
   * Test {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext VerifyCustomerMaxOfferUsesActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnProcessContext() throws Exception {
    // Arrange
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(new HashSet<>());
    ProcessContext<CheckoutSeed> context = mock(ProcessContext.class);
    OrderImpl order = new OrderImpl();
    when(context.getSeedData()).thenReturn(new CheckoutSeed(order, new HashMap<>()));

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult = verifyCustomerMaxOfferUsesActivity.execute(context);

    // Assert
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    verify(context).getSeedData();
    assertSame(context, actualExecuteResult);
  }
}
