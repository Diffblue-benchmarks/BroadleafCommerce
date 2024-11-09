/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.aspectj.lang.ProceedingJoinPoint;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class OrderStateAOPDiffblueTest {
  /**
   * Test {@link OrderStateAOP#processOrderRetrieval(ProceedingJoinPoint)}.
   * <p>
   * Method under test:
   * {@link OrderStateAOP#processOrderRetrieval(ProceedingJoinPoint)}
   */
  @Test
  @DisplayName("Test processOrderRetrieval(ProceedingJoinPoint)")
  void testProcessOrderRetrieval() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = mock(OrderState.class);
    when(orderState.getOrder(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    AnnotationConfigApplicationContext applicationContext = mock(AnnotationConfigApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(orderState);

    OrderStateAOP orderStateAOP = new OrderStateAOP();
    orderStateAOP.setApplicationContext(applicationContext);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("blOrderState");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");
    ProceedingJoinPoint call = mock(ProceedingJoinPoint.class);
    when(call.getArgs()).thenReturn(new Object[]{customerImpl});

    // Act
    Object actualProcessOrderRetrievalResult = orderStateAOP.processOrderRetrieval(call);

    // Assert
    verify(call).getArgs();
    verify(orderState).getOrder(isA(Customer.class));
    verify(applicationContext).getBean(eq("blOrderState"));
    assertTrue(actualProcessOrderRetrievalResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = ((NullOrderImpl) actualProcessOrderRetrievalResult).getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, ((NullOrderImpl) actualProcessOrderRetrievalResult).getSubTotal());
  }

  /**
   * Test {@link OrderStateAOP#processOrderRetrieval(ProceedingJoinPoint)}.
   * <ul>
   *   <li>Then return SubTotal is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderStateAOP#processOrderRetrieval(ProceedingJoinPoint)}
   */
  @Test
  @DisplayName("Test processOrderRetrieval(ProceedingJoinPoint); then return SubTotal is Money()")
  void testProcessOrderRetrieval_thenReturnSubTotalIsMoney() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = mock(OrderState.class);
    when(orderState.setOrder(Mockito.<Customer>any(), Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(orderState.getOrder(Mockito.<Customer>any())).thenReturn(null);
    AnnotationConfigApplicationContext applicationContext = mock(AnnotationConfigApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(orderState);

    OrderStateAOP orderStateAOP = new OrderStateAOP();
    orderStateAOP.setApplicationContext(applicationContext);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("blOrderState");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable2);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("blOrderState");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(new OrderStatus("blOrderState", "blOrderState"));
    Money subTotal = new Money();
    orderImpl.setSubTotal(subTotal);
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    Money totalTax = new Money();
    orderImpl.setTotalTax(totalTax);
    ProceedingJoinPoint call = mock(ProceedingJoinPoint.class);
    when(call.proceed()).thenReturn(orderImpl);
    when(call.getArgs()).thenReturn(new Object[]{customerImpl});

    // Act
    Object actualProcessOrderRetrievalResult = orderStateAOP.processOrderRetrieval(call);

    // Assert
    verify(call).getArgs();
    verify(call).proceed();
    verify(orderState).getOrder(isA(Customer.class));
    verify(orderState).setOrder(isA(Customer.class), isA(Order.class));
    verify(applicationContext).getBean(eq("blOrderState"));
    assertTrue(actualProcessOrderRetrievalResult instanceof NullOrderImpl);
    assertEquals(subTotal, ((NullOrderImpl) actualProcessOrderRetrievalResult).getSubTotal());
    Money expectedOrderAdjustmentsValue = totalTax.ZERO;
    assertSame(expectedOrderAdjustmentsValue,
        ((NullOrderImpl) actualProcessOrderRetrievalResult).getOrderAdjustmentsValue());
  }
}
