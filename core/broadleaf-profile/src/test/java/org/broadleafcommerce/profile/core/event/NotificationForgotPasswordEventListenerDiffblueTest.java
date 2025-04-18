/*-
 * #%L
 * BroadleafCommerce Profile
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
package org.broadleafcommerce.profile.core.event;

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
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.notification.service.NotificationDispatcher;
import org.broadleafcommerce.common.notification.service.type.Notification;
import org.broadleafcommerce.common.site.service.SiteService;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NotificationForgotPasswordEventListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NotificationForgotPasswordEventListenerDiffblueTest {
  @MockBean(name = "blCurrencyService")
  private BroadleafCurrencyService broadleafCurrencyService;

  @MockBean(name = "blCustomerService")
  private CustomerService customerService;

  @MockBean(name = "blLocaleService")
  private LocaleService localeService;

  @MockBean(name = "blNotificationDispatcher")
  private NotificationDispatcher notificationDispatcher;

  @Autowired
  private NotificationForgotPasswordEventListener notificationForgotPasswordEventListener;

  @MockBean(name = "blSiteService")
  private SiteService siteService;

  /**
   * Test {@link NotificationForgotPasswordEventListener#handleApplicationEvent(ForgotPasswordEvent)} with {@code ForgotPasswordEvent}.
   * <p>
   * Method under test: {@link NotificationForgotPasswordEventListener#handleApplicationEvent(ForgotPasswordEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationForgotPasswordEventListener.handleApplicationEvent(ForgotPasswordEvent)"})
  public void testHandleApplicationEventWithForgotPasswordEvent() throws ServiceException {
    // Arrange
    when(customerService.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    doThrow(new ServiceException("An error occurred")).when(notificationDispatcher)
        .dispatchNotification(Mockito.<Notification>any());

    // Act
    notificationForgotPasswordEventListener
        .handleApplicationEvent(new ForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example"));

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
    verify(customerService).readCustomerById(eq(1L));
  }

  /**
   * Test {@link NotificationForgotPasswordEventListener#handleApplicationEvent(ForgotPasswordEvent)} with {@code ForgotPasswordEvent}.
   * <ul>
   *   <li>Then calls {@link NotificationDispatcher#dispatchNotification(Notification)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationForgotPasswordEventListener#handleApplicationEvent(ForgotPasswordEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationForgotPasswordEventListener.handleApplicationEvent(ForgotPasswordEvent)"})
  public void testHandleApplicationEventWithForgotPasswordEvent_thenCallsDispatchNotification()
      throws ServiceException {
    // Arrange
    when(customerService.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    doNothing().when(notificationDispatcher).dispatchNotification(Mockito.<Notification>any());

    // Act
    notificationForgotPasswordEventListener
        .handleApplicationEvent(new ForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example"));

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
    verify(customerService).readCustomerById(eq(1L));
  }

  /**
   * Test {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   *   <li>Then {@code customer} return {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map NotificationForgotPasswordEventListener.createContext(Customer, ForgotPasswordEvent)"})
  public void testCreateContext_whenCustomerImpl_thenCustomerReturnCustomerImpl() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    Map<String, Object> actualCreateContextResult = notificationForgotPasswordEventListener.createContext(customer,
        new ForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example"));

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult.get("customer");
    assertTrue(getResult instanceof CustomerImpl);
    assertTrue(actualCreateContextResult.containsKey("resetPasswordUrl"));
    assertTrue(actualCreateContextResult.containsKey("token"));
    assertSame(customer, getResult);
  }

  /**
   * Test {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code token} is {@code ABC123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map NotificationForgotPasswordEventListener.createContext(Customer, ForgotPasswordEvent)"})
  public void testCreateContext_whenNull_thenReturnTokenIsAbc123() {
    // Arrange and Act
    Map<String, Object> actualCreateContextResult = notificationForgotPasswordEventListener.createContext(null,
        new ForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example"));

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    assertEquals("ABC123", actualCreateContextResult.get("token"));
    assertEquals("https://example.org/example", actualCreateContextResult.get("resetPasswordUrl"));
    assertNull(actualCreateContextResult.get("customer"));
  }

  /**
   * Test {@link NotificationForgotPasswordEventListener#isAsynchronous()}.
   * <p>
   * Method under test: {@link NotificationForgotPasswordEventListener#isAsynchronous()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NotificationForgotPasswordEventListener.isAsynchronous()"})
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue((new NotificationForgotPasswordEventListener()).isAsynchronous());
  }
}
