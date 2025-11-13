package org.broadleafcommerce.common.notification.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.notification.service.type.Notification;
import org.broadleafcommerce.common.notification.service.type.SMSNotification;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultSMSNotificationServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultSMSNotificationServiceImplDiffblueTest {
  @Autowired private DefaultSMSNotificationServiceImpl defaultSMSNotificationServiceImpl;

  /**
   * Test {@link DefaultSMSNotificationServiceImpl#canHandle(Class)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultSMSNotificationServiceImpl#canHandle(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultSMSNotificationServiceImpl.canHandle(Class)"})
  public void testCanHandle_thenReturnFalse() {
    // Arrange
    Class<Notification> clazz = Notification.class;

    // Act and Assert
    assertFalse(defaultSMSNotificationServiceImpl.canHandle(clazz));
  }

  /**
   * Test {@link DefaultSMSNotificationServiceImpl#canHandle(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultSMSNotificationServiceImpl#canHandle(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultSMSNotificationServiceImpl.canHandle(Class)"})
  public void testCanHandle_thenReturnTrue() {
    // Arrange
    Class<SMSNotification> clazz = SMSNotification.class;

    // Act and Assert
    assertTrue(defaultSMSNotificationServiceImpl.canHandle(clazz));
  }
}
