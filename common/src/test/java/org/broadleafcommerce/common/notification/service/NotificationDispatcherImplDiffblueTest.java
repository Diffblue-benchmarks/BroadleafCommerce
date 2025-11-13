package org.broadleafcommerce.common.notification.service;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.exception.ServiceException;
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

@ContextConfiguration(classes = {NotificationDispatcherImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NotificationDispatcherImplDiffblueTest {
  @Autowired private List<NotificationService> list;

  @Autowired private NotificationDispatcherImpl notificationDispatcherImpl;

  @MockBean private NotificationService notificationService;

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   *
   * <p>Method under test: {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationDispatcherImpl.dispatchNotification(Notification)"})
  public void testDispatchNotification() throws ServiceException {
    // Arrange
    doThrow(new RuntimeException())
        .when(notificationService)
        .sendNotification(Mockito.<Notification>any());
    when(notificationService.canHandle(Mockito.<Class<Notification>>any())).thenReturn(true);

    EmailNotification notification =
        new EmailNotification(NotificationEventType.ADMIN_FORGOT_PASSWORD, new HashMap<>());
    notification.setContext(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> notificationDispatcherImpl.dispatchNotification(notification));
    verify(notificationService).canHandle(isA(Class.class));
    verify(notificationService).sendNotification(isA(Notification.class));
  }

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   *
   * <p>Method under test: {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationDispatcherImpl.dispatchNotification(Notification)"})
  public void testDispatchNotification2() throws ServiceException {
    // Arrange
    NotificationDispatcherImpl notificationDispatcherImpl =
        new NotificationDispatcherImpl(new ArrayList<>());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> notificationDispatcherImpl.dispatchNotification(new EmailNotification()));
  }

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   *
   * <p>Method under test: {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationDispatcherImpl.dispatchNotification(Notification)"})
  public void testDispatchNotification3() throws ServiceException {
    // Arrange
    NotificationDispatcherImpl notificationDispatcherImpl = new NotificationDispatcherImpl(null);

    EmailNotification notification =
        new EmailNotification(NotificationEventType.ADMIN_FORGOT_PASSWORD, new HashMap<>());
    notification.setContext(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> notificationDispatcherImpl.dispatchNotification(notification));
  }

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   *
   * <ul>
   *   <li>Given {@link NotificationService} {@link NotificationService#canHandle(Class)} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationDispatcherImpl.dispatchNotification(Notification)"})
  public void testDispatchNotification_givenNotificationServiceCanHandleReturnFalse()
      throws ServiceException {
    // Arrange
    when(notificationService.canHandle(Mockito.<Class<Notification>>any())).thenReturn(false);

    EmailNotification notification =
        new EmailNotification(NotificationEventType.ADMIN_FORGOT_PASSWORD, new HashMap<>());
    notification.setContext(new HashMap<>());

    // Act
    notificationDispatcherImpl.dispatchNotification(notification);

    // Assert
    verify(notificationService).canHandle(isA(Class.class));
  }

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   *
   * <ul>
   *   <li>Given {@link NotificationService} {@link NotificationService#canHandle(Class)} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationDispatcherImpl.dispatchNotification(Notification)"})
  public void testDispatchNotification_givenNotificationServiceCanHandleThrowRuntimeException()
      throws ServiceException {
    // Arrange
    when(notificationService.canHandle(Mockito.<Class<Notification>>any()))
        .thenThrow(new RuntimeException());

    EmailNotification notification =
        new EmailNotification(NotificationEventType.ADMIN_FORGOT_PASSWORD, new HashMap<>());
    notification.setContext(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> notificationDispatcherImpl.dispatchNotification(notification));
    verify(notificationService).canHandle(isA(Class.class));
  }

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   *
   * <ul>
   *   <li>Given {@link NotificationService} {@link
   *       NotificationService#sendNotification(Notification)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationDispatcherImpl.dispatchNotification(Notification)"})
  public void testDispatchNotification_givenNotificationServiceSendNotificationDoesNothing()
      throws ServiceException {
    // Arrange
    doNothing().when(notificationService).sendNotification(Mockito.<Notification>any());
    when(notificationService.canHandle(Mockito.<Class<Notification>>any())).thenReturn(true);

    EmailNotification notification =
        new EmailNotification(NotificationEventType.ADMIN_FORGOT_PASSWORD, new HashMap<>());
    notification.setContext(new HashMap<>());

    // Act
    notificationDispatcherImpl.dispatchNotification(notification);

    // Assert
    verify(notificationService).canHandle(isA(Class.class));
    verify(notificationService).sendNotification(isA(Notification.class));
  }

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   *
   * <ul>
   *   <li>Given {@link NotificationService}.
   *   <li>When {@link EmailNotification#EmailNotification()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationDispatcherImpl.dispatchNotification(Notification)"})
  public void testDispatchNotification_givenNotificationService_whenEmailNotification()
      throws ServiceException {
    // Arrange, Act and Assert
    assertThrows(
        ServiceException.class,
        () -> notificationDispatcherImpl.dispatchNotification(new EmailNotification()));
  }

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   *
   * <ul>
   *   <li>Given {@link NotificationService}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationDispatcherImpl.dispatchNotification(Notification)"})
  public void testDispatchNotification_givenNotificationService_whenNull() throws ServiceException {
    // Arrange, Act and Assert
    assertThrows(
        ServiceException.class, () -> notificationDispatcherImpl.dispatchNotification(null));
  }

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationDispatcherImpl.dispatchNotification(Notification)"})
  public void testDispatchNotification_givenNull() throws ServiceException {
    // Arrange
    EmailNotification notification =
        new EmailNotification(NotificationEventType.ADMIN_FORGOT_PASSWORD, new HashMap<>());
    notification.setContext(null);

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> notificationDispatcherImpl.dispatchNotification(notification));
  }

  /**
   * Test {@link NotificationDispatcherImpl#dispatchNotification(Notification)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link NotificationDispatcherImpl#dispatchNotification(Notification)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationDispatcherImpl.dispatchNotification(Notification)"})
  public void testDispatchNotification_thenDoesNotThrow() throws ServiceException {
    // Arrange
    ArrayList<NotificationService> notificationServices = new ArrayList<>();
    notificationServices.add(new DefaultEmailNotificationServiceImpl());
    NotificationDispatcherImpl notificationDispatcherImpl =
        new NotificationDispatcherImpl(notificationServices);

    EmailNotification notification =
        new EmailNotification(NotificationEventType.ADMIN_FORGOT_PASSWORD, new HashMap<>());
    notification.setContext(new HashMap<>());

    // Act and Assert
    notificationDispatcherImpl.dispatchNotification(notification);
  }
}
