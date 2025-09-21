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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class NotificationDiffblueTest {
  /**
   * Test {@link Notification#getContext()}.
   *
   * <p>Method under test: {@link Notification#getContext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map Notification.getContext()"})
  public void testGetContext() {
    // Arrange, Act and Assert
    assertTrue(new EmailNotification().getContext().isEmpty());
  }

  /**
   * Test {@link Notification#setContext(Map)}.
   *
   * <p>Method under test: {@link Notification#setContext(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link EmailNotification#EmailNotification()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Notification#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationEventType Notification.getType()"})
  public void testGetType_givenEmailNotification_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new EmailNotification().getType());
  }

  /**
   * Test {@link Notification#getType()}.
   *
   * <ul>
   *   <li>Then return {@link NotificationEventType#ADMIN_FORGOT_PASSWORD}.
   * </ul>
   *
   * <p>Method under test: {@link Notification#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationEventType Notification.getType()"})
  public void testGetType_thenReturnAdmin_forgot_password() {
    // Arrange
    EmailNotification emailNotification =
        new EmailNotification(NotificationEventType.ADMIN_FORGOT_PASSWORD, new HashMap<>());
    emailNotification.setType(NotificationEventType.ADMIN_FORGOT_PASSWORD);

    // Act and Assert
    assertSame(NotificationEventType.ADMIN_FORGOT_PASSWORD, emailNotification.getType());
  }

  /**
   * Test {@link Notification#setType(NotificationEventType)}.
   *
   * <ul>
   *   <li>Then {@link EmailNotification#EmailNotification()} {@link Notification#notificationType}
   *       is {@code ADMIN_FORGOT_PASSWORD}.
   * </ul>
   *
   * <p>Method under test: {@link Notification#setType(NotificationEventType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Notification.setType(NotificationEventType)"})
  public void testSetType_thenEmailNotificationNotificationTypeIsAdminForgotPassword() {
    // Arrange
    EmailNotification emailNotification = new EmailNotification();

    // Act
    emailNotification.setType(NotificationEventType.ADMIN_FORGOT_PASSWORD);

    // Assert
    assertEquals("ADMIN_FORGOT_PASSWORD", emailNotification.notificationType);
    assertSame(NotificationEventType.ADMIN_FORGOT_PASSWORD, emailNotification.getType());
  }
}
