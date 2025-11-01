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
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {EmailNotification.class, NotificationEventType.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class NotificationDiffblueTest {
  @Autowired
  private Notification notification;

  @Autowired
  private NotificationEventType notificationEventType;

  /**
   * Method under test: {@link Notification#getContext()}
   */
  @Test
  public void testGetContext() {
    // Arrange
    EmailNotification emailNotification = new EmailNotification();

    // Act
    Map<String, Object> actualContext = emailNotification.getContext();

    // Assert
    assertTrue(actualContext.isEmpty());
    assertSame(emailNotification.context, actualContext);
  }

  /**
   * Method under test: {@link Notification#getContext()}
   */
  @Test
  public void testGetContext2() {
    // Arrange
    HashMap<String, Object> context = new HashMap<>();
    context.computeIfPresent("foo", mock(BiFunction.class));
    EmailNotification emailNotification = new EmailNotification(NotificationEventType.ADMIN_FORGOT_PASSWORD, context);

    // Act
    Map<String, Object> actualContext = emailNotification.getContext();

    // Assert
    assertTrue(actualContext.isEmpty());
    assertSame(emailNotification.context, actualContext);
  }

  /**
   * Method under test: {@link Notification#setContext(Map)}
   */
  @Test
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
   * Method under test: {@link Notification#setContext(Map)}
   */
  @Test
  public void testSetContext2() {
    // Arrange
    EmailNotification emailNotification = new EmailNotification();

    HashMap<String, Object> context = new HashMap<>();
    context.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    emailNotification.setContext(context);

    // Assert
    assertSame(context, emailNotification.getContext());
  }

  /**
   * Method under test: {@link Notification#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull((new EmailNotification()).getType());
  }

  /**
   * Method under test: {@link Notification#getType()}
   */
  @Test
  public void testGetType2() {
    // Arrange
    EmailNotification emailNotification = new EmailNotification();
    emailNotification.setType(NotificationEventType.ADMIN_FORGOT_PASSWORD);

    // Act
    NotificationEventType actualType = emailNotification.getType();

    // Assert
    assertSame(actualType.ADMIN_FORGOT_PASSWORD, actualType);
  }

  /**
   * Method under test: {@link Notification#getType()}
   */
  @Test
  public void testGetType3() {
    // Arrange
    HashMap<String, Object> context = new HashMap<>();
    context.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    NotificationEventType actualType = (new EmailNotification(NotificationEventType.ADMIN_FORGOT_PASSWORD, context))
        .getType();

    // Assert
    assertSame(actualType.ADMIN_FORGOT_PASSWORD, actualType);
  }

  /**
   * Method under test: {@link Notification#setType(NotificationEventType)}
   */
  @Test
  public void testSetType() {
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
