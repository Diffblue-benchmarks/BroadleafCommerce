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
package org.broadleafcommerce.core.registration;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionHandler;
import org.broadleafcommerce.common.extension.ExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.extension.PostUpdateOrderExtensionHandler;
import org.broadleafcommerce.core.order.extension.PostUpdateOrderExtensionManager;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MergeOrdersByEmailPostRegistrationObserverDiffblueTest {
  @Mock
  private CustomerService customerService;

  @InjectMocks
  private MergeOrdersByEmailPostRegistrationObserver mergeOrdersByEmailPostRegistrationObserver;

  @Mock
  private OrderService orderService;

  @Mock
  private PostUpdateOrderExtensionManager postUpdateOrderExtensionManager;

  /**
   * Test {@link MergeOrdersByEmailPostRegistrationObserver#processRegistrationEvent(Customer)}.
   * <p>
   * Method under test: {@link MergeOrdersByEmailPostRegistrationObserver#processRegistrationEvent(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergeOrdersByEmailPostRegistrationObserver.processRegistrationEvent(Customer)"})
  public void testProcessRegistrationEvent() {
    // Arrange
    PostUpdateOrderExtensionHandler postUpdateOrderExtensionHandler = mock(PostUpdateOrderExtensionHandler.class);
    when(postUpdateOrderExtensionHandler.postUpdateAll(Mockito.<List<Order>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    ArrayList<PostUpdateOrderExtensionHandler> postUpdateOrderExtensionHandlerList = new ArrayList<>();
    postUpdateOrderExtensionHandlerList.add(postUpdateOrderExtensionHandler);
    when(postUpdateOrderExtensionManager.shouldContinue(Mockito.<ExtensionResultStatusType>any(),
        Mockito.<ExtensionHandler>any(), Mockito.<Method>any(), Mockito.<Object[]>any())).thenReturn(false);
    when(postUpdateOrderExtensionManager.getHandlers()).thenReturn(postUpdateOrderExtensionHandlerList);
    when(orderService.findOrdersByEmail(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    mergeOrdersByEmailPostRegistrationObserver.processRegistrationEvent(new CustomerImpl());

    // Assert
    verify(postUpdateOrderExtensionManager).getHandlers();
    verify(postUpdateOrderExtensionManager).shouldContinue(eq(ExtensionResultStatusType.HANDLED), isNull(), isNull(),
        isNull());
    verify(postUpdateOrderExtensionHandler).postUpdateAll(isA(List.class));
    verify(orderService).findOrdersByEmail(isNull());
  }

  /**
   * Test {@link MergeOrdersByEmailPostRegistrationObserver#processRegistrationEvent(Customer)}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Customer is {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeOrdersByEmailPostRegistrationObserver#processRegistrationEvent(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergeOrdersByEmailPostRegistrationObserver.processRegistrationEvent(Customer)"})
  public void testProcessRegistrationEvent_givenOrderImplCustomerIsCustomerImpl() {
    // Arrange
    PostUpdateOrderExtensionHandler postUpdateOrderExtensionHandler = mock(PostUpdateOrderExtensionHandler.class);
    when(postUpdateOrderExtensionHandler.postUpdateAll(Mockito.<List<Order>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    ArrayList<PostUpdateOrderExtensionHandler> postUpdateOrderExtensionHandlerList = new ArrayList<>();
    postUpdateOrderExtensionHandlerList.add(postUpdateOrderExtensionHandler);
    when(postUpdateOrderExtensionManager.shouldContinue(Mockito.<ExtensionResultStatusType>any(),
        Mockito.<ExtensionHandler>any(), Mockito.<Method>any(), Mockito.<Object[]>any())).thenReturn(true);
    when(postUpdateOrderExtensionManager.getHandlers()).thenReturn(postUpdateOrderExtensionHandlerList);

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
    orderImpl.setTotalTax(new Money());

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(orderImpl);
    when(orderService.findOrdersByEmail(Mockito.<String>any())).thenReturn(orderList);

    // Act
    mergeOrdersByEmailPostRegistrationObserver.processRegistrationEvent(new CustomerImpl());

    // Assert
    verify(postUpdateOrderExtensionManager).getHandlers();
    verify(postUpdateOrderExtensionManager).shouldContinue(eq(ExtensionResultStatusType.HANDLED), isNull(), isNull(),
        isNull());
    verify(postUpdateOrderExtensionHandler).postUpdateAll(isA(List.class));
    verify(orderService).findOrdersByEmail(isNull());
  }

  /**
   * Test {@link MergeOrdersByEmailPostRegistrationObserver#processRegistrationEvent(Customer)}.
   * <ul>
   *   <li>Then calls {@link Customer#isRegistered()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeOrdersByEmailPostRegistrationObserver#processRegistrationEvent(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergeOrdersByEmailPostRegistrationObserver.processRegistrationEvent(Customer)"})
  public void testProcessRegistrationEvent_thenCallsIsRegistered() {
    // Arrange
    PostUpdateOrderExtensionHandler postUpdateOrderExtensionHandler = mock(PostUpdateOrderExtensionHandler.class);
    when(postUpdateOrderExtensionHandler.postUpdateAll(Mockito.<List<Order>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    ArrayList<PostUpdateOrderExtensionHandler> postUpdateOrderExtensionHandlerList = new ArrayList<>();
    postUpdateOrderExtensionHandlerList.add(postUpdateOrderExtensionHandler);
    when(postUpdateOrderExtensionManager.shouldContinue(Mockito.<ExtensionResultStatusType>any(),
        Mockito.<ExtensionHandler>any(), Mockito.<Method>any(), Mockito.<Object[]>any())).thenReturn(true);
    when(postUpdateOrderExtensionManager.getHandlers()).thenReturn(postUpdateOrderExtensionHandlerList);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    Customer customer = mock(Customer.class);
    when(customer.isRegistered()).thenReturn(true);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(customer);
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
    orderImpl.setTotalTax(new Money());

    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(orderImpl);
    when(orderService.findOrdersByEmail(Mockito.<String>any())).thenReturn(orderList);

    // Act
    mergeOrdersByEmailPostRegistrationObserver.processRegistrationEvent(new CustomerImpl());

    // Assert
    verify(postUpdateOrderExtensionManager).getHandlers();
    verify(postUpdateOrderExtensionManager).shouldContinue(eq(ExtensionResultStatusType.HANDLED), isNull(), isNull(),
        isNull());
    verify(postUpdateOrderExtensionHandler).postUpdateAll(isA(List.class));
    verify(orderService).findOrdersByEmail(isNull());
    verify(customer).isRegistered();
  }

  /**
   * Test {@link MergeOrdersByEmailPostRegistrationObserver#processRegistrationEvent(Customer)}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeOrdersByEmailPostRegistrationObserver#processRegistrationEvent(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergeOrdersByEmailPostRegistrationObserver.processRegistrationEvent(Customer)"})
  public void testProcessRegistrationEvent_thenCallsShouldContinue() {
    // Arrange
    PostUpdateOrderExtensionHandler postUpdateOrderExtensionHandler = mock(PostUpdateOrderExtensionHandler.class);
    when(postUpdateOrderExtensionHandler.postUpdateAll(Mockito.<List<Order>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    ArrayList<PostUpdateOrderExtensionHandler> postUpdateOrderExtensionHandlerList = new ArrayList<>();
    postUpdateOrderExtensionHandlerList.add(postUpdateOrderExtensionHandler);
    when(postUpdateOrderExtensionManager.shouldContinue(Mockito.<ExtensionResultStatusType>any(),
        Mockito.<ExtensionHandler>any(), Mockito.<Method>any(), Mockito.<Object[]>any())).thenReturn(true);
    when(postUpdateOrderExtensionManager.getHandlers()).thenReturn(postUpdateOrderExtensionHandlerList);
    when(orderService.findOrdersByEmail(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    mergeOrdersByEmailPostRegistrationObserver.processRegistrationEvent(new CustomerImpl());

    // Assert
    verify(postUpdateOrderExtensionManager).getHandlers();
    verify(postUpdateOrderExtensionManager).shouldContinue(eq(ExtensionResultStatusType.HANDLED), isNull(), isNull(),
        isNull());
    verify(postUpdateOrderExtensionHandler).postUpdateAll(isA(List.class));
    verify(orderService).findOrdersByEmail(isNull());
  }

  /**
   * Test {@link MergeOrdersByEmailPostRegistrationObserver#processRegistrationEvent(Customer)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   *   <li>Then calls {@link ExtensionManager#getHandlers()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeOrdersByEmailPostRegistrationObserver#processRegistrationEvent(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergeOrdersByEmailPostRegistrationObserver.processRegistrationEvent(Customer)"})
  public void testProcessRegistrationEvent_whenCustomerImpl_thenCallsGetHandlers() {
    // Arrange
    when(postUpdateOrderExtensionManager.getHandlers()).thenReturn(new ArrayList<>());
    when(orderService.findOrdersByEmail(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    mergeOrdersByEmailPostRegistrationObserver.processRegistrationEvent(new CustomerImpl());

    // Assert
    verify(postUpdateOrderExtensionManager).getHandlers();
    verify(orderService).findOrdersByEmail(isNull());
  }
}
