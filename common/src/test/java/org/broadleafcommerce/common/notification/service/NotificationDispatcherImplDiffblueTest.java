/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.notification.service;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.notification.service.type.EmailNotification;
import org.broadleafcommerce.common.notification.service.type.Notification;
import org.broadleafcommerce.common.notification.service.type.NotificationEventType;
import org.junit.Test;
import org.mockito.Mockito;

public class NotificationDispatcherImplDiffblueTest {
  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link DefaultEmailNotificationServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  public void testDispatchNotification_givenArrayListAddDefaultEmailNotificationServiceImpl() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<NotificationService> notificationServices = new ArrayList<>();
    notificationServices.add(new DefaultEmailNotificationServiceImpl());
    NotificationDispatcherImpl notificationDispatcherImpl = new NotificationDispatcherImpl(notificationServices);
    EmailNotification notification = mock(EmailNotification.class);
    when(notification.getContext()).thenReturn(new HashMap<>());
    when(notification.getType()).thenReturn(NotificationEventType.ADMIN_FORGOT_PASSWORD);

    // Act
    notificationDispatcherImpl.dispatchNotification(notification);

    // Assert
    verify(notification).getContext();
    verify(notification, atLeast(1)).getType();
  }

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link DefaultSMSNotificationServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  public void testDispatchNotification_givenArrayListAddDefaultSMSNotificationServiceImpl() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<NotificationService> notificationServices = new ArrayList<>();
    notificationServices.add(new DefaultSMSNotificationServiceImpl());
    NotificationDispatcherImpl notificationDispatcherImpl = new NotificationDispatcherImpl(notificationServices);
    EmailNotification notification = mock(EmailNotification.class);
    when(notification.getContext()).thenReturn(new HashMap<>());
    when(notification.getType()).thenReturn(NotificationEventType.ADMIN_FORGOT_PASSWORD);

    // Act
    notificationDispatcherImpl.dispatchNotification(notification);

    // Assert
    verify(notification).getContext();
    verify(notification).getType();
  }

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   * <ul>
   *   <li>Then calls
   * {@link DefaultEmailNotificationServiceImpl#canHandle(Class)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  public void testDispatchNotification_thenCallsCanHandle() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEmailNotificationServiceImpl defaultEmailNotificationServiceImpl = mock(
        DefaultEmailNotificationServiceImpl.class);
    doNothing().when(defaultEmailNotificationServiceImpl).sendNotification(Mockito.<Notification>any());
    when(defaultEmailNotificationServiceImpl.canHandle(Mockito.<Class<Notification>>any())).thenReturn(true);

    ArrayList<NotificationService> notificationServices = new ArrayList<>();
    notificationServices.add(defaultEmailNotificationServiceImpl);
    NotificationDispatcherImpl notificationDispatcherImpl = new NotificationDispatcherImpl(notificationServices);
    EmailNotification notification = mock(EmailNotification.class);
    when(notification.getContext()).thenReturn(new HashMap<>());
    when(notification.getType()).thenReturn(NotificationEventType.ADMIN_FORGOT_PASSWORD);

    // Act
    notificationDispatcherImpl.dispatchNotification(notification);

    // Assert
    verify(defaultEmailNotificationServiceImpl).canHandle(isA(Class.class));
    verify(defaultEmailNotificationServiceImpl).sendNotification(isA(Notification.class));
    verify(notification).getContext();
    verify(notification).getType();
  }

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  public void testDispatchNotification_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<NotificationService> notificationServices = new ArrayList<>();
    notificationServices.add(new DefaultEmailNotificationServiceImpl());
    NotificationDispatcherImpl notificationDispatcherImpl = new NotificationDispatcherImpl(notificationServices);

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> notificationDispatcherImpl.dispatchNotification(new EmailNotification()));
  }

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   * <ul>
   *   <li>When {@link EmailNotification#EmailNotification()}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  public void testDispatchNotification_whenEmailNotification_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationDispatcherImpl notificationDispatcherImpl = new NotificationDispatcherImpl(new ArrayList<>());

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> notificationDispatcherImpl.dispatchNotification(new EmailNotification()));
  }
}
