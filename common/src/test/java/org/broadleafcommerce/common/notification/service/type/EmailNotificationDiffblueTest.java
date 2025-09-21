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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.email.service.message.Attachment;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {EmailNotification.class, NotificationEventType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailNotificationDiffblueTest {
  @Autowired private EmailNotification emailNotification;

  @Autowired private NotificationEventType notificationEventType;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmailNotification#EmailNotification()}
   *   <li>{@link EmailNotification#setAttachments(List)}
   *   <li>{@link EmailNotification#setEmailAddress(String)}
   *   <li>{@link EmailNotification#getAttachments()}
   *   <li>{@link EmailNotification#getEmailAddress()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EmailNotification.<init>()",
    "List EmailNotification.getAttachments()",
    "String EmailNotification.getEmailAddress()",
    "void EmailNotification.setAttachments(List)",
    "void EmailNotification.setEmailAddress(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    EmailNotification actualEmailNotification = new EmailNotification();
    ArrayList<Attachment> attachments = new ArrayList<>();
    actualEmailNotification.setAttachments(attachments);
    actualEmailNotification.setEmailAddress("42 Main St");
    List<Attachment> actualAttachments = actualEmailNotification.getAttachments();

    // Assert
    assertEquals("42 Main St", actualEmailNotification.getEmailAddress());
    assertTrue(actualAttachments.isEmpty());
    assertTrue(actualEmailNotification.getContext().isEmpty());
    assertSame(attachments, actualAttachments);
  }

  /**
   * Test {@link EmailNotification#EmailNotification(String, NotificationEventType, Map)}.
   *
   * <ul>
   *   <li>Then return {@link Notification#notificationType} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EmailNotification#EmailNotification(String, NotificationEventType,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmailNotification.<init>(String, NotificationEventType, Map)"})
  public void testNewEmailNotification_thenReturnNotificationTypeIsNull() {
    // Arrange and Act
    EmailNotification actualEmailNotification =
        new EmailNotification("42 Main St", notificationEventType, new HashMap<>());

    // Assert
    assertEquals("42 Main St", actualEmailNotification.getEmailAddress());
    assertNull(actualEmailNotification.notificationType);
    assertNull(actualEmailNotification.getType());
    assertTrue(actualEmailNotification.getAttachments().isEmpty());
    assertTrue(actualEmailNotification.getContext().isEmpty());
  }

  /**
   * Test {@link EmailNotification#EmailNotification(NotificationEventType, Map)}.
   *
   * <ul>
   *   <li>Then return {@link Notification#notificationType} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EmailNotification#EmailNotification(NotificationEventType, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmailNotification.<init>(NotificationEventType, Map)"})
  public void testNewEmailNotification_thenReturnNotificationTypeIsNull2() {
    // Arrange and Act
    EmailNotification actualEmailNotification =
        new EmailNotification(notificationEventType, new HashMap<>());

    // Assert
    assertNull(actualEmailNotification.getEmailAddress());
    assertNull(actualEmailNotification.notificationType);
    assertNull(actualEmailNotification.getType());
    assertTrue(actualEmailNotification.getAttachments().isEmpty());
    assertTrue(actualEmailNotification.getContext().isEmpty());
  }
}
