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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.currency.service.BroadleafCurrencyService;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.notification.service.NotificationDispatcher;
import org.broadleafcommerce.common.notification.service.type.Notification;
import org.broadleafcommerce.common.site.service.SiteService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NotificationForgotUsernameEventListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NotificationForgotUsernameEventListenerDiffblueTest {
  @MockBean(name = "blCurrencyService")
  private BroadleafCurrencyService broadleafCurrencyService;

  @MockBean(name = "blLocaleService")
  private LocaleService localeService;

  @MockBean(name = "blNotificationDispatcher")
  private NotificationDispatcher notificationDispatcher;

  @Autowired
  private NotificationForgotUsernameEventListener notificationForgotUsernameEventListener;

  @MockBean(name = "blSiteService")
  private SiteService siteService;

  /**
   * Test {@link NotificationForgotUsernameEventListener#handleApplicationEvent(ForgotUsernameEvent)} with {@code ForgotUsernameEvent}.
   * <p>
   * Method under test: {@link NotificationForgotUsernameEventListener#handleApplicationEvent(ForgotUsernameEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationForgotUsernameEventListener.handleApplicationEvent(ForgotUsernameEvent)"})
  public void testHandleApplicationEventWithForgotUsernameEvent() throws ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred")).when(notificationDispatcher)
        .dispatchNotification(Mockito.<Notification>any());

    // Act
    notificationForgotUsernameEventListener
        .handleApplicationEvent(new ForgotUsernameEvent("Source", "42 Main St", new ArrayList<>()));

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
  }

  /**
   * Test {@link NotificationForgotUsernameEventListener#handleApplicationEvent(ForgotUsernameEvent)} with {@code ForgotUsernameEvent}.
   * <ul>
   *   <li>Then calls {@link NotificationDispatcher#dispatchNotification(Notification)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationForgotUsernameEventListener#handleApplicationEvent(ForgotUsernameEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationForgotUsernameEventListener.handleApplicationEvent(ForgotUsernameEvent)"})
  public void testHandleApplicationEventWithForgotUsernameEvent_thenCallsDispatchNotification()
      throws ServiceException {
    // Arrange
    doNothing().when(notificationDispatcher).dispatchNotification(Mockito.<Notification>any());

    // Act
    notificationForgotUsernameEventListener
        .handleApplicationEvent(new ForgotUsernameEvent("Source", "42 Main St", new ArrayList<>()));

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
  }

  /**
   * Test {@link NotificationForgotUsernameEventListener#createContext(ForgotUsernameEvent)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationForgotUsernameEventListener#createContext(ForgotUsernameEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map NotificationForgotUsernameEventListener.createContext(ForgotUsernameEvent)"})
  public void testCreateContext_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<String> activeUsernames = new ArrayList<>();

    // Act
    Map<String, Object> actualCreateContextResult = notificationForgotUsernameEventListener
        .createContext(new ForgotUsernameEvent("Source", "42 Main St", activeUsernames));

    // Assert
    assertEquals(1, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult.get("activeUsernames");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(activeUsernames, getResult);
  }

  /**
   * Test {@link NotificationForgotUsernameEventListener#isAsynchronous()}.
   * <p>
   * Method under test: {@link NotificationForgotUsernameEventListener#isAsynchronous()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NotificationForgotUsernameEventListener.isAsynchronous()"})
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue((new NotificationForgotUsernameEventListener()).isAsynchronous());
  }
}
