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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.email.service.EmailService;
import org.broadleafcommerce.common.email.service.info.EmailInfo;
import org.broadleafcommerce.common.email.service.message.Attachment;
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

@ContextConfiguration(classes = {DefaultEmailNotificationServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultEmailNotificationServiceImplDiffblueTest {
  @Autowired private DefaultEmailNotificationServiceImpl defaultEmailNotificationServiceImpl;

  @MockBean private EmailInfo emailInfo;

  @MockBean(name = "blEmailService")
  private EmailService emailService;

  @Autowired private List<EmailInfo> list;

  /**
   * Test {@link DefaultEmailNotificationServiceImpl#canHandle(Class)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEmailNotificationServiceImpl#canHandle(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultEmailNotificationServiceImpl.canHandle(Class)"})
  public void testCanHandle_thenReturnFalse() {
    // Arrange
    Class<Notification> clazz = Notification.class;

    // Act and Assert
    assertFalse(defaultEmailNotificationServiceImpl.canHandle(clazz));
  }

  /**
   * Test {@link DefaultEmailNotificationServiceImpl#canHandle(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEmailNotificationServiceImpl#canHandle(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultEmailNotificationServiceImpl.canHandle(Class)"})
  public void testCanHandle_thenReturnTrue() {
    // Arrange
    Class<EmailNotification> clazz = EmailNotification.class;

    // Act and Assert
    assertTrue(defaultEmailNotificationServiceImpl.canHandle(clazz));
  }

  /**
   * Test {@link DefaultEmailNotificationServiceImpl#sendNotification(Notification)}.
   *
   * <p>Method under test: {@link
   * DefaultEmailNotificationServiceImpl#sendNotification(Notification)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultEmailNotificationServiceImpl.sendNotification(Notification)"})
  public void testSendNotification() {
    // Arrange
    when(emailInfo.getEmailType()).thenReturn("jane.doe@example.org");
    EmailNotification notification =
        new EmailNotification(NotificationEventType.ADMIN_FORGOT_PASSWORD, new HashMap<>());

    // Act
    defaultEmailNotificationServiceImpl.sendNotification(notification);

    // Assert
    verify(emailInfo).getEmailType();
  }

  /**
   * Test {@link DefaultEmailNotificationServiceImpl#sendNotification(Notification)}.
   *
   * <ul>
   *   <li>Given {@link EmailInfo} {@link EmailInfo#clone()} return {@link EmailInfo} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultEmailNotificationServiceImpl#sendNotification(Notification)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultEmailNotificationServiceImpl.sendNotification(Notification)"})
  public void testSendNotification_givenEmailInfoCloneReturnEmailInfo() {
    // Arrange
    when(emailInfo.clone()).thenReturn(new EmailInfo());
    when(emailInfo.getEmailType())
        .thenReturn("Unable to find an EmailInfo that matched a notification of type ");
    when(emailService.sendTemplateEmail(
            Mockito.<String>any(), Mockito.<EmailInfo>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);
    NotificationEventType notificationEventType =
        new NotificationEventType(
            "Unable to find an EmailInfo that matched a notification of type ",
            "Unable to find an EmailInfo that matched a notification of type ");
    EmailNotification notification = new EmailNotification(notificationEventType, new HashMap<>());

    // Act
    defaultEmailNotificationServiceImpl.sendNotification(notification);

    // Assert
    verify(emailService).sendTemplateEmail((String) isNull(), isA(EmailInfo.class), isA(Map.class));
    verify(emailInfo).clone();
    verify(emailInfo).getEmailType();
  }

  /**
   * Test {@link DefaultEmailNotificationServiceImpl#sendNotification(Notification)}.
   *
   * <ul>
   *   <li>Then calls {@link EmailInfo#setAttachments(List)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultEmailNotificationServiceImpl#sendNotification(Notification)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultEmailNotificationServiceImpl.sendNotification(Notification)"})
  public void testSendNotification_thenCallsSetAttachments() {
    // Arrange
    doNothing().when(emailInfo).setAttachments(Mockito.<List<Attachment>>any());
    when(emailInfo.clone()).thenReturn(emailInfo);
    when(emailInfo.getEmailType())
        .thenReturn("Unable to find an EmailInfo that matched a notification of type ");
    when(emailService.sendTemplateEmail(
            Mockito.<String>any(), Mockito.<EmailInfo>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);
    NotificationEventType notificationEventType =
        new NotificationEventType(
            "Unable to find an EmailInfo that matched a notification of type ",
            "Unable to find an EmailInfo that matched a notification of type ");
    EmailNotification notification = new EmailNotification(notificationEventType, new HashMap<>());

    // Act
    defaultEmailNotificationServiceImpl.sendNotification(notification);

    // Assert
    verify(emailService).sendTemplateEmail((String) isNull(), isA(EmailInfo.class), isA(Map.class));
    verify(emailInfo).clone();
    verify(emailInfo).getEmailType();
    verify(emailInfo).setAttachments(isA(List.class));
  }
}
