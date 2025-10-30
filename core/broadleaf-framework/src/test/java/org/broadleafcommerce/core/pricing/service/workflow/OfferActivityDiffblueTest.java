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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionManager;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.AbstractOfferValueModifierExtensionHandler;
import org.broadleafcommerce.core.offer.service.OfferService;
import org.broadleafcommerce.core.offer.service.OfferValueModifierExtensionManager;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
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
public class OfferActivityDiffblueTest {
  @InjectMocks
  private OfferActivity offerActivity;

  @Mock
  private OfferService offerService;

  @Mock
  private OfferValueModifierExtensionManager offerValueModifierExtensionManager;

  @Mock
  private OrderService orderService;

  /**
   * Test {@link OfferActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OfferCodeImpl} (default constructor).</li>
   *   <li>Then calls {@link OrderService#addOfferCodes(Order, List, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext OfferActivity.execute(ProcessContext)"})
  public void testExecute_givenArrayListAddOfferCodeImpl_thenCallsAddOfferCodes() throws Exception {
    // Arrange
    when(offerValueModifierExtensionManager.getProxy()).thenReturn(new AbstractOfferValueModifierExtensionHandler());

    ArrayList<OfferCode> offerCodeList = new ArrayList<>();
    offerCodeList.add(new OfferCodeImpl());

    ArrayList<Offer> offerList = new ArrayList<>();
    offerList.add(new OfferImpl());
    when(offerService.buildOfferListForOrder(Mockito.<Order>any())).thenReturn(offerList);
    when(offerService.applyAndSaveOffersToOrder(Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(new NullOrderImpl());
    when(offerService.buildOfferCodeListForCustomer(Mockito.<Order>any())).thenReturn(offerCodeList);
    when(orderService.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(), anyBoolean()))
        .thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = offerActivity.execute(context);

    // Assert
    verify(offerValueModifierExtensionManager).getProxy();
    verify(offerService).applyAndSaveOffersToOrder(isA(List.class), isA(Order.class));
    verify(offerService).buildOfferCodeListForCustomer(isA(Order.class));
    verify(offerService).buildOfferListForOrder(isA(Order.class));
    verify(orderService).addOfferCodes(isA(Order.class), isA(List.class), eq(false));
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link OfferActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext OfferActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsGetProxy() throws Exception {
    // Arrange
    when(offerValueModifierExtensionManager.getProxy()).thenReturn(new AbstractOfferValueModifierExtensionHandler());

    ArrayList<Offer> offerList = new ArrayList<>();
    offerList.add(new OfferImpl());
    when(offerService.buildOfferListForOrder(Mockito.<Order>any())).thenReturn(offerList);
    when(offerService.applyAndSaveOffersToOrder(Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(new NullOrderImpl());
    when(offerService.buildOfferCodeListForCustomer(Mockito.<Order>any())).thenReturn(new ArrayList<>());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = offerActivity.execute(context);

    // Assert
    verify(offerValueModifierExtensionManager).getProxy();
    verify(offerService).applyAndSaveOffersToOrder(isA(List.class), isA(Order.class));
    verify(offerService).buildOfferCodeListForCustomer(isA(Order.class));
    verify(offerService).buildOfferListForOrder(isA(Order.class));
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link OfferActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext OfferActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnProcessContext() throws Exception {
    // Arrange
    when(offerService.buildOfferListForOrder(Mockito.<Order>any())).thenReturn(new ArrayList<>());
    when(offerService.applyAndSaveOffersToOrder(Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(new NullOrderImpl());
    when(offerService.buildOfferCodeListForCustomer(Mockito.<Order>any())).thenReturn(new ArrayList<>());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = offerActivity.execute(context);

    // Assert
    verify(offerService).applyAndSaveOffersToOrder(isA(List.class), isA(Order.class));
    verify(offerService).buildOfferCodeListForCustomer(isA(Order.class));
    verify(offerService).buildOfferListForOrder(isA(Order.class));
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link OfferActivity#getNewOfferCodesFromCustomer(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferActivity#getNewOfferCodesFromCustomer(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferActivity.getNewOfferCodesFromCustomer(Order)"})
  public void testGetNewOfferCodesFromCustomer_givenAuditableCreatedByIsOne_thenReturnEmpty() {
    // Arrange
    when(offerService.buildOfferCodeListForCustomer(Mockito.<Order>any())).thenReturn(new ArrayList<>());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
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
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    List<OfferCode> actualNewOfferCodesFromCustomer = offerActivity.getNewOfferCodesFromCustomer(order);

    // Assert
    verify(offerService).buildOfferCodeListForCustomer(isA(Order.class));
    assertTrue(actualNewOfferCodesFromCustomer.isEmpty());
  }
}
