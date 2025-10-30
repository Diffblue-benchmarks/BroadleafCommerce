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
package org.broadleafcommerce.common.notification.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {EmailNotification.class, NotificationEventType.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class NotificationDiffblueTest {
  @Autowired
  private Notification notification;

  @Autowired
  private NotificationEventType notificationEventType;

  /**
   * Test {@link Notification#getContext()}.
   * <p>
   * Method under test: {@link Notification#getContext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map Notification.getContext()"})
  public void testGetContext() {
    // Arrange, Act and Assert
    assertTrue((new EmailNotification()).getContext().isEmpty());
  }

  /**
   * Test {@link Notification#setContext(Map)}.
   * <p>
   * Method under test: {@link Notification#setContext(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Notification.setContext(Map)"})
  public void testSetContext() {
    // Arrange
    EmailNotification emailNotification = new EmailNotification();
    HashMap<String, Object> context = new HashMap<>();

    // Act
    emailNotification.setContext(context);

    // Assert
    assertSame(context, emailNotification.getContext());
  }

  /**
   * Test {@link Notification#getType()}.
   * <ul>
   *   <li>Given {@link EmailNotification#EmailNotification()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Notification#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationEventType Notification.getType()"})
  public void testGetType_givenEmailNotification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new EmailNotification()).getType());
  }

  /**
   * Test {@link Notification#getType()}.
   * <ul>
   *   <li>Then return {@link NotificationEventType#ADMIN_FORGOT_PASSWORD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Notification#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationEventType Notification.getType()"})
  public void testGetType_thenReturnAdmin_forgot_password() {
    // Arrange
    EmailNotification emailNotification = new EmailNotification();
    emailNotification.setType(NotificationEventType.ADMIN_FORGOT_PASSWORD);

    // Act
    NotificationEventType actualType = emailNotification.getType();

    // Assert
    assertSame(actualType.ADMIN_FORGOT_PASSWORD, actualType);
  }

  /**
   * Test {@link Notification#setType(NotificationEventType)}.
   * <ul>
   *   <li>Then {@link Notification} {@link Notification#notificationType} is {@code ADMIN_FORGOT_PASSWORD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Notification#setType(NotificationEventType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Notification.setType(NotificationEventType)"})
  public void testSetType_thenNotificationNotificationTypeIsAdminForgotPassword() {
    // Arrange
    NotificationEventType notificationEventType2 = NotificationEventType.ADMIN_FORGOT_PASSWORD;

    // Act
    notification.setType(notificationEventType2);

    // Assert
    assertTrue(notification instanceof EmailNotification);
    assertEquals("ADMIN_FORGOT_PASSWORD", ((EmailNotification) notification).notificationType);
    NotificationEventType expectedType = notificationEventType2.ADMIN_FORGOT_PASSWORD;
    assertSame(expectedType, notification.getType());
  }
}
