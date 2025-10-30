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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SMSNotification.class, NotificationEventType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SMSNotificationDiffblueTest {
  @Autowired
  private NotificationEventType notificationEventType;

  @Autowired
  private SMSNotification sMSNotification;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SMSNotification#SMSNotification()}
   *   <li>{@link SMSNotification#setPhoneNumber(String)}
   *   <li>{@link SMSNotification#getPhoneNumber()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SMSNotification.<init>()", "String SMSNotification.getPhoneNumber()",
      "void SMSNotification.setPhoneNumber(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    SMSNotification actualSmsNotification = new SMSNotification();
    actualSmsNotification.setPhoneNumber("6625550144");

    // Assert
    assertEquals("6625550144", actualSmsNotification.getPhoneNumber());
    assertTrue(actualSmsNotification.getContext().isEmpty());
  }

  /**
   * Test {@link SMSNotification#SMSNotification(String, NotificationEventType, Map)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then return Type FriendlyType is {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SMSNotification#SMSNotification(String, NotificationEventType, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SMSNotification.<init>(String, NotificationEventType, Map)"})
  public void testNewSMSNotification_givenType_thenReturnTypeFriendlyTypeIsFriendlyType() {
    // Arrange
    NotificationEventType notificationEventType2 = mock(NotificationEventType.class);
    when(notificationEventType2.getType()).thenReturn("Type");

    // Act
    SMSNotification actualSmsNotification = new SMSNotification("6625550144", notificationEventType2, new HashMap<>());

    // Assert
    verify(notificationEventType2).getType();
    assertEquals("6625550144", actualSmsNotification.getPhoneNumber());
    NotificationEventType type = actualSmsNotification.getType();
    assertEquals("Friendly Type", type.getFriendlyType());
    assertEquals("Type", type.getType());
    assertEquals("Type", actualSmsNotification.notificationType);
    assertTrue(actualSmsNotification.getContext().isEmpty());
  }

  /**
   * Test {@link SMSNotification#SMSNotification(NotificationEventType, Map)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then return Type FriendlyType is {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SMSNotification#SMSNotification(NotificationEventType, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SMSNotification.<init>(NotificationEventType, Map)"})
  public void testNewSMSNotification_givenType_thenReturnTypeFriendlyTypeIsFriendlyType2() {
    // Arrange
    NotificationEventType notificationEventType2 = mock(NotificationEventType.class);
    when(notificationEventType2.getType()).thenReturn("Type");

    // Act
    SMSNotification actualSmsNotification = new SMSNotification(notificationEventType2, new HashMap<>());

    // Assert
    verify(notificationEventType2).getType();
    NotificationEventType type = actualSmsNotification.getType();
    assertEquals("Friendly Type", type.getFriendlyType());
    assertEquals("Type", type.getType());
    assertEquals("Type", actualSmsNotification.notificationType);
    assertNull(actualSmsNotification.getPhoneNumber());
    assertTrue(actualSmsNotification.getContext().isEmpty());
  }

  /**
   * Test {@link SMSNotification#SMSNotification(String, NotificationEventType, Map)}.
   * <ul>
   *   <li>Then return {@link Notification#notificationType} is {@code ADMIN_FORGOT_PASSWORD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SMSNotification#SMSNotification(String, NotificationEventType, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SMSNotification.<init>(String, NotificationEventType, Map)"})
  public void testNewSMSNotification_thenReturnNotificationTypeIsAdminForgotPassword() {
    // Arrange
    NotificationEventType notificationEventType2 = NotificationEventType.ADMIN_FORGOT_PASSWORD;

    // Act
    SMSNotification actualSmsNotification = new SMSNotification("6625550144", notificationEventType2, new HashMap<>());

    // Assert
    assertEquals("6625550144", actualSmsNotification.getPhoneNumber());
    assertEquals("ADMIN_FORGOT_PASSWORD", actualSmsNotification.notificationType);
    assertTrue(actualSmsNotification.getContext().isEmpty());
    NotificationEventType expectedType = notificationEventType2.ADMIN_FORGOT_PASSWORD;
    assertSame(expectedType, actualSmsNotification.getType());
  }

  /**
   * Test {@link SMSNotification#SMSNotification(NotificationEventType, Map)}.
   * <ul>
   *   <li>Then return {@link Notification#notificationType} is {@code ADMIN_FORGOT_PASSWORD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SMSNotification#SMSNotification(NotificationEventType, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SMSNotification.<init>(NotificationEventType, Map)"})
  public void testNewSMSNotification_thenReturnNotificationTypeIsAdminForgotPassword2() {
    // Arrange
    NotificationEventType notificationEventType2 = NotificationEventType.ADMIN_FORGOT_PASSWORD;

    // Act
    SMSNotification actualSmsNotification = new SMSNotification(notificationEventType2, new HashMap<>());

    // Assert
    assertEquals("ADMIN_FORGOT_PASSWORD", actualSmsNotification.notificationType);
    assertNull(actualSmsNotification.getPhoneNumber());
    assertTrue(actualSmsNotification.getContext().isEmpty());
    NotificationEventType expectedType = notificationEventType2.ADMIN_FORGOT_PASSWORD;
    assertSame(expectedType, actualSmsNotification.getType());
  }
}
