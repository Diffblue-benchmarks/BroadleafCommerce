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
package org.broadleafcommerce.core.checkout.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
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
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.checkout.service.exception.CheckoutException;
import org.broadleafcommerce.core.checkout.service.workflow.CheckoutSeed;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.exception.RequiredAttributeNotProvidedException;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.Processor;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutServiceImplDiffblueTest {
  @InjectMocks
  private CheckoutServiceImpl checkoutServiceImpl;

  @Mock
  private OrderService orderService;

  @Mock
  private Processor<CheckoutSeed, CheckoutSeed> processor;

  /**
   * Test {@link CheckoutServiceImpl#performCheckout(Order)}.
   * <p>
   * Method under test: {@link CheckoutServiceImpl#performCheckout(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.checkout.service.workflow.CheckoutResponse CheckoutServiceImpl.performCheckout(Order)"})
  public void testPerformCheckout() throws CheckoutException, PricingException {
    // Arrange
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenThrow(new PricingException("An error occurred"));

    // Act and Assert
    assertThrows(CheckoutException.class, () -> checkoutServiceImpl.performCheckout(new NullOrderImpl()));
    verify(orderService).save(isA(Order.class), eq(false));
  }

  /**
   * Test {@link CheckoutServiceImpl#performCheckout(Order)}.
   * <p>
   * Method under test: {@link CheckoutServiceImpl#performCheckout(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.checkout.service.workflow.CheckoutResponse CheckoutServiceImpl.performCheckout(Order)"})
  public void testPerformCheckout2() throws CheckoutException, PricingException {
    // Arrange
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

    // Act and Assert
    assertThrows(CheckoutException.class, () -> checkoutServiceImpl.performCheckout(new NullOrderImpl()));
    verify(orderService).save(isA(Order.class), eq(false));
  }

  /**
   * Test {@link CheckoutServiceImpl#performCheckout(Order)}.
   * <ul>
   *   <li>Given {@link OrderStatus#ARCHIVED}.</li>
   *   <li>When {@link OrderImpl} (default constructor) Status is {@link OrderStatus#ARCHIVED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#performCheckout(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.checkout.service.workflow.CheckoutResponse CheckoutServiceImpl.performCheckout(Order)"})
  public void testPerformCheckout_givenArchived_whenOrderImplStatusIsArchived()
      throws CheckoutException, PricingException, WorkflowException {
    // Arrange
    when(processor.doActivities(Mockito.<CheckoutSeed>any())).thenReturn(mock(DefaultProcessContextImpl.class));
    Order order = mock(Order.class);
    when(order.getId()).thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));
    when(order.getOrderMessages()).thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(order);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order2 = new OrderImpl();
    order2.setAdditionalOfferInformation(new HashMap<>());
    order2.setAuditable(auditable);
    order2.setCandidateOrderOffers(new ArrayList<>());
    order2.setCurrency(new BroadleafCurrencyImpl());
    order2.setCustomer(new CustomerImpl());
    order2.setEmailAddress("42 Main St");
    order2.setFulfillmentGroups(new ArrayList<>());
    order2.setId(1L);
    order2.setLocale(new LocaleImpl());
    order2.setName("Unable to checkout order -- id: ");
    order2.setOrderAttributes(new HashMap<>());
    order2.setOrderItems(new ArrayList<>());
    order2.setOrderMessages(new ArrayList<>());
    order2.setOrderNumber("42");
    order2.setPayments(new ArrayList<>());
    order2.setStatus(OrderStatus.ARCHIVED);
    order2.setSubTotal(new Money());
    order2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order2.setTaxOverride(true);
    order2.setTotal(new Money());
    order2.setTotalFulfillmentCharges(new Money());
    order2.setTotalTax(new Money());

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class, () -> checkoutServiceImpl.performCheckout(order2));
    verify(order).getId();
    verify(order).getOrderMessages();
    verify(orderService, atLeast(1)).save(Mockito.<Order>any(), eq(false));
    verify(processor).doActivities(isA(CheckoutSeed.class));
  }

  /**
   * Test {@link CheckoutServiceImpl#performCheckout(Order)}.
   * <ul>
   *   <li>Given {@link OrderStatus#CANCELLED}.</li>
   *   <li>When {@link OrderImpl} (default constructor) Status is {@link OrderStatus#CANCELLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#performCheckout(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.checkout.service.workflow.CheckoutResponse CheckoutServiceImpl.performCheckout(Order)"})
  public void testPerformCheckout_givenCancelled_whenOrderImplStatusIsCancelled() throws CheckoutException {
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
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Unable to checkout order -- id: ");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.CANCELLED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(CheckoutException.class, () -> checkoutServiceImpl.performCheckout(order));
  }

  /**
   * Test {@link CheckoutServiceImpl#performCheckout(Order)}.
   * <ul>
   *   <li>Given {@link OrderStatus#SUBMITTED}.</li>
   *   <li>When {@link OrderImpl} (default constructor) Status is {@link OrderStatus#SUBMITTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#performCheckout(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.checkout.service.workflow.CheckoutResponse CheckoutServiceImpl.performCheckout(Order)"})
  public void testPerformCheckout_givenSubmitted_whenOrderImplStatusIsSubmitted() throws CheckoutException {
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
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Unable to checkout order -- id: ");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.SUBMITTED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(CheckoutException.class, () -> checkoutServiceImpl.performCheckout(order));
  }

  /**
   * Test {@link CheckoutServiceImpl#performCheckout(Order)}.
   * <ul>
   *   <li>Then calls {@link DefaultProcessContextImpl#getActivityMessages()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#performCheckout(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.checkout.service.workflow.CheckoutResponse CheckoutServiceImpl.performCheckout(Order)"})
  public void testPerformCheckout_thenCallsGetActivityMessages()
      throws CheckoutException, PricingException, WorkflowException {
    // Arrange
    DefaultProcessContextImpl<Object> defaultProcessContextImpl = mock(DefaultProcessContextImpl.class);
    when(defaultProcessContextImpl.getActivityMessages())
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));
    when(processor.doActivities(Mockito.<CheckoutSeed>any())).thenReturn(defaultProcessContextImpl);
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

    // Act and Assert
    assertThrows(CheckoutException.class, () -> checkoutServiceImpl.performCheckout(new NullOrderImpl()));
    verify(orderService, atLeast(1)).save(Mockito.<Order>any(), eq(false));
    verify(defaultProcessContextImpl).getActivityMessages();
    verify(processor).doActivities(isA(CheckoutSeed.class));
  }

  /**
   * Test {@link CheckoutServiceImpl#performCheckout(Order)}.
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#performCheckout(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.checkout.service.workflow.CheckoutResponse CheckoutServiceImpl.performCheckout(Order)"})
  public void testPerformCheckout_thenThrowRequiredAttributeNotProvidedException()
      throws CheckoutException, PricingException, WorkflowException {
    // Arrange
    when(processor.doActivities(Mockito.<CheckoutSeed>any())).thenReturn(mock(DefaultProcessContextImpl.class));
    Order order = mock(Order.class);
    when(order.getId()).thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));
    when(order.getOrderMessages()).thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(order);

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> checkoutServiceImpl.performCheckout(new NullOrderImpl()));
    verify(order).getId();
    verify(order).getOrderMessages();
    verify(orderService, atLeast(1)).save(Mockito.<Order>any(), eq(false));
    verify(processor).doActivities(isA(CheckoutSeed.class));
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CheckoutServiceImpl.hasOrderBeenCompleted(Order)"})
  public void testHasOrderBeenCompleted() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getStatus()).thenReturn(new OrderStatus("SUBMITTED", "SUBMITTED"));

    // Act
    boolean actualHasOrderBeenCompletedResult = checkoutServiceImpl.hasOrderBeenCompleted(order);

    // Assert
    verify(order).getStatus();
    assertTrue(actualHasOrderBeenCompletedResult);
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <ul>
   *   <li>Given {@link OrderStatus#ARCHIVED}.</li>
   *   <li>When {@link NullOrderImpl} {@link NullOrderImpl#getStatus()} return {@link OrderStatus#ARCHIVED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CheckoutServiceImpl.hasOrderBeenCompleted(Order)"})
  public void testHasOrderBeenCompleted_givenArchived_whenNullOrderImplGetStatusReturnArchived() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getStatus()).thenReturn(OrderStatus.ARCHIVED);

    // Act
    boolean actualHasOrderBeenCompletedResult = checkoutServiceImpl.hasOrderBeenCompleted(order);

    // Assert
    verify(order, atLeast(1)).getStatus();
    assertFalse(actualHasOrderBeenCompletedResult);
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CheckoutServiceImpl.hasOrderBeenCompleted(Order)"})
  public void testHasOrderBeenCompleted_givenAuditableCreatedByIsOne() {
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
    order.setTotalTax(new Money());

    // Act and Assert
    assertFalse(checkoutServiceImpl.hasOrderBeenCompleted(order));
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <ul>
   *   <li>Given {@link OrderStatus#CANCELLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CheckoutServiceImpl.hasOrderBeenCompleted(Order)"})
  public void testHasOrderBeenCompleted_givenCancelled() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getStatus()).thenReturn(OrderStatus.CANCELLED);

    // Act
    boolean actualHasOrderBeenCompletedResult = checkoutServiceImpl.hasOrderBeenCompleted(order);

    // Assert
    verify(order, atLeast(1)).getStatus();
    assertTrue(actualHasOrderBeenCompletedResult);
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <ul>
   *   <li>Given {@link OrderStatus#SUBMITTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CheckoutServiceImpl.hasOrderBeenCompleted(Order)"})
  public void testHasOrderBeenCompleted_givenSubmitted() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getStatus()).thenReturn(OrderStatus.SUBMITTED);

    // Act
    boolean actualHasOrderBeenCompletedResult = checkoutServiceImpl.hasOrderBeenCompleted(order);

    // Assert
    verify(order).getStatus();
    assertTrue(actualHasOrderBeenCompletedResult);
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CheckoutServiceImpl.hasOrderBeenCompleted(Order)"})
  public void testHasOrderBeenCompleted_whenNullOrderImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(checkoutServiceImpl.hasOrderBeenCompleted(new NullOrderImpl()));
  }
}
