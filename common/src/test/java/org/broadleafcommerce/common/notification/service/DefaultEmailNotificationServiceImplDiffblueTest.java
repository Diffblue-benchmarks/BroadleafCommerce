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
   * Method under test:
   * {@link DefaultEmailNotificationServiceImpl#canHandle(Class)}
   */
  @Test
  public void testCanHandle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEmailNotificationServiceImpl defaultEmailNotificationServiceImpl = new DefaultEmailNotificationServiceImpl();
    Class<Notification> clazz = Notification.class;

    // Act and Assert
    assertFalse(defaultEmailNotificationServiceImpl.canHandle(clazz));
  }

  /**
   * Method under test:
   * {@link DefaultEmailNotificationServiceImpl#canHandle(Class)}
   */
  @Test
  public void testCanHandle2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEmailNotificationServiceImpl defaultEmailNotificationServiceImpl = new DefaultEmailNotificationServiceImpl();
    Class<EmailNotification> clazz = EmailNotification.class;

    // Act and Assert
    assertTrue(defaultEmailNotificationServiceImpl.canHandle(clazz));
  }

  /**
   * Method under test:
   * {@link DefaultEmailNotificationServiceImpl#sendNotification(Notification)}
   */
  @Test
  public void testSendNotification() {
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
