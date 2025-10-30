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
package org.broadleafcommerce.core.order.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.broadleafcommerce.common.currency.service.BroadleafCurrencyService;
import org.broadleafcommerce.common.event.OrderSubmittedEvent;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.notification.service.NotificationDispatcher;
import org.broadleafcommerce.common.notification.service.type.Notification;
import org.broadleafcommerce.common.site.service.SiteService;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.OrderService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NotificationOrderSubmittedEventListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NotificationOrderSubmittedEventListenerDiffblueTest {
  @MockBean(name = "blCurrencyService")
  private BroadleafCurrencyService broadleafCurrencyService;

  @MockBean(name = "blLocaleService")
  private LocaleService localeService;

  @MockBean(name = "blNotificationDispatcher")
  private NotificationDispatcher notificationDispatcher;

  @Autowired
  private NotificationOrderSubmittedEventListener notificationOrderSubmittedEventListener;

  @MockBean(name = "blOrderService")
  private OrderService orderService;

  @MockBean(name = "blSiteService")
  private SiteService siteService;

  /**
   * Test {@link NotificationOrderSubmittedEventListener#handleApplicationEvent(OrderSubmittedEvent)} with {@code OrderSubmittedEvent}.
   * <p>
   * Method under test: {@link NotificationOrderSubmittedEventListener#handleApplicationEvent(OrderSubmittedEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationOrderSubmittedEventListener.handleApplicationEvent(OrderSubmittedEvent)"})
  public void testHandleApplicationEventWithOrderSubmittedEvent() throws ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred")).when(notificationDispatcher)
        .dispatchNotification(Mockito.<Notification>any());
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    // Act
    notificationOrderSubmittedEventListener.handleApplicationEvent(new OrderSubmittedEvent("Source", 1L, "42"));

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
    verify(orderService).findOrderById(eq(1L));
  }

  /**
   * Test {@link NotificationOrderSubmittedEventListener#handleApplicationEvent(OrderSubmittedEvent)} with {@code OrderSubmittedEvent}.
   * <p>
   * Method under test: {@link NotificationOrderSubmittedEventListener#handleApplicationEvent(OrderSubmittedEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationOrderSubmittedEventListener.handleApplicationEvent(OrderSubmittedEvent)"})
  public void testHandleApplicationEventWithOrderSubmittedEvent2() {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(null);

    // Act
    notificationOrderSubmittedEventListener.handleApplicationEvent(new OrderSubmittedEvent("Source", 1L, "42"));

    // Assert
    verify(orderService).findOrderById(eq(1L));
  }

  /**
   * Test {@link NotificationOrderSubmittedEventListener#handleApplicationEvent(OrderSubmittedEvent)} with {@code OrderSubmittedEvent}.
   * <ul>
   *   <li>Then calls {@link NotificationDispatcher#dispatchNotification(Notification)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationOrderSubmittedEventListener#handleApplicationEvent(OrderSubmittedEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationOrderSubmittedEventListener.handleApplicationEvent(OrderSubmittedEvent)"})
  public void testHandleApplicationEventWithOrderSubmittedEvent_thenCallsDispatchNotification()
      throws ServiceException {
    // Arrange
    doNothing().when(notificationDispatcher).dispatchNotification(Mockito.<Notification>any());
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());

    // Act
    notificationOrderSubmittedEventListener.handleApplicationEvent(new OrderSubmittedEvent("Source", 1L, "42"));

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
    verify(orderService).findOrderById(eq(1L));
  }

  /**
   * Test {@link NotificationOrderSubmittedEventListener#createContext(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationOrderSubmittedEventListener#createContext(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map NotificationOrderSubmittedEventListener.createContext(Order)"})
  public void testCreateContext_whenNullOrderImpl_thenReturnSizeIsTwo() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Map<String, Object> actualCreateContextResult = notificationOrderSubmittedEventListener.createContext(order);

    // Assert
    assertEquals(2, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult.get("order");
    assertTrue(getResult instanceof NullOrderImpl);
    assertNull(actualCreateContextResult.get("customer"));
    assertSame(order, getResult);
  }

  /**
   * Test {@link NotificationOrderSubmittedEventListener#createContext(Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationOrderSubmittedEventListener#createContext(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map NotificationOrderSubmittedEventListener.createContext(Order)"})
  public void testCreateContext_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(notificationOrderSubmittedEventListener.createContext(null).isEmpty());
  }

  /**
   * Test {@link NotificationOrderSubmittedEventListener#isAsynchronous()}.
   * <p>
   * Method under test: {@link NotificationOrderSubmittedEventListener#isAsynchronous()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NotificationOrderSubmittedEventListener.isAsynchronous()"})
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue((new NotificationOrderSubmittedEventListener()).isAsynchronous());
  }
}
