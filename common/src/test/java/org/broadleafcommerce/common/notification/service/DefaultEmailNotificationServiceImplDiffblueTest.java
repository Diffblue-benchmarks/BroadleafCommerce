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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.notification.service.type.EmailNotification;
import org.broadleafcommerce.common.notification.service.type.Notification;
import org.broadleafcommerce.common.notification.service.type.NotificationEventType;
import org.junit.Test;

public class DefaultEmailNotificationServiceImplDiffblueTest {
  /**
   * Test {@link DefaultEmailNotificationServiceImpl#canHandle(Class)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEmailNotificationServiceImpl#canHandle(Class)}
   */
  @Test
  public void testCanHandle_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEmailNotificationServiceImpl defaultEmailNotificationServiceImpl = new DefaultEmailNotificationServiceImpl();
    Class<Notification> clazz = Notification.class;

    // Act and Assert
    assertFalse(defaultEmailNotificationServiceImpl.canHandle(clazz));
  }

  /**
   * Test {@link DefaultEmailNotificationServiceImpl#canHandle(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEmailNotificationServiceImpl#canHandle(Class)}
   */
  @Test
  public void testCanHandle_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEmailNotificationServiceImpl defaultEmailNotificationServiceImpl = new DefaultEmailNotificationServiceImpl();
    Class<EmailNotification> clazz = EmailNotification.class;

    // Act and Assert
    assertTrue(defaultEmailNotificationServiceImpl.canHandle(clazz));
  }

  /**
   * Test
   * {@link DefaultEmailNotificationServiceImpl#sendNotification(Notification)}.
   * <ul>
   *   <li>Given {@link NotificationEventType#ADMIN_FORGOT_PASSWORD}.</li>
   *   <li>Then calls {@link Notification#getType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEmailNotificationServiceImpl#sendNotification(Notification)}
   */
  @Test
  public void testSendNotification_givenAdmin_forgot_password_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEmailNotificationServiceImpl defaultEmailNotificationServiceImpl = new DefaultEmailNotificationServiceImpl();
    EmailNotification notification = mock(EmailNotification.class);
    when(notification.getType()).thenReturn(NotificationEventType.ADMIN_FORGOT_PASSWORD);

    // Act
    defaultEmailNotificationServiceImpl.sendNotification(notification);

    // Assert
    verify(notification).getType();
  }
}
