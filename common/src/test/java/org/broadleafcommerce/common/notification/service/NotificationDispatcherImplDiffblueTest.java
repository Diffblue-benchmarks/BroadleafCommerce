/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.notification.service;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.notification.service.type.EmailNotification;
import org.broadleafcommerce.common.notification.service.type.Notification;
import org.broadleafcommerce.common.notification.service.type.NotificationEventType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NotificationDispatcherImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NotificationDispatcherImplDiffblueTest {
  @Autowired
  private List<NotificationService> list;

  @Autowired
  private NotificationDispatcherImpl notificationDispatcherImpl;

  @MockBean
  private NotificationService notificationService;

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   * <ul>
   *   <li>Given {@link NotificationService} {@link NotificationService#canHandle(Class)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationDispatcherImpl.dispatchNotification(Notification)"})
  public void testDispatchNotification_givenNotificationServiceCanHandleReturnFalse() throws ServiceException {
    // Arrange
    when(notificationService.canHandle(Mockito.<Class<Notification>>any())).thenReturn(false);

    // Act
    notificationDispatcherImpl
        .dispatchNotification(new EmailNotification(NotificationEventType.ADMIN_FORGOT_PASSWORD, new HashMap<>()));

    // Assert
    verify(notificationService).canHandle(isA(Class.class));
  }

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   * <ul>
   *   <li>Given {@link NotificationService}.</li>
   *   <li>When {@link EmailNotification#EmailNotification()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationDispatcherImpl.dispatchNotification(Notification)"})
  public void testDispatchNotification_givenNotificationService_whenEmailNotification() throws ServiceException {
    // Arrange, Act and Assert
    assertThrows(ServiceException.class,
        () -> notificationDispatcherImpl.dispatchNotification(new EmailNotification()));
  }

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   * <ul>
   *   <li>Given {@link NotificationService}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationDispatcherImpl.dispatchNotification(Notification)"})
  public void testDispatchNotification_givenNotificationService_whenNull() throws ServiceException {
    // Arrange, Act and Assert
    assertThrows(ServiceException.class, () -> notificationDispatcherImpl.dispatchNotification(null));
  }

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link EmailNotification#EmailNotification()} Context is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationDispatcherImpl.dispatchNotification(Notification)"})
  public void testDispatchNotification_givenNull_whenEmailNotificationContextIsNull() throws ServiceException {
    // Arrange
    EmailNotification notification = new EmailNotification();
    notification.setContext(null);
    notification.setType(NotificationEventType.ADMIN_FORGOT_PASSWORD);

    // Act and Assert
    assertThrows(ServiceException.class, () -> notificationDispatcherImpl.dispatchNotification(notification));
  }

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   * <ul>
   *   <li>Then calls {@link NotificationService#sendNotification(Notification)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationDispatcherImpl.dispatchNotification(Notification)"})
  public void testDispatchNotification_thenCallsSendNotification() throws ServiceException {
    // Arrange
    doNothing().when(notificationService).sendNotification(Mockito.<Notification>any());
    when(notificationService.canHandle(Mockito.<Class<Notification>>any())).thenReturn(true);

    // Act
    notificationDispatcherImpl
        .dispatchNotification(new EmailNotification(NotificationEventType.ADMIN_FORGOT_PASSWORD, new HashMap<>()));

    // Assert
    verify(notificationService).canHandle(isA(Class.class));
    verify(notificationService).sendNotification(isA(Notification.class));
  }
}
