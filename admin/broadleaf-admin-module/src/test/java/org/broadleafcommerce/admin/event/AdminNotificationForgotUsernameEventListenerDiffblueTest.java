package org.broadleafcommerce.admin.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.currency.service.BroadleafCurrencyService;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.notification.service.NotificationDispatcher;
import org.broadleafcommerce.common.notification.service.type.Notification;
import org.broadleafcommerce.common.site.service.SiteService;
import org.broadleafcommerce.openadmin.server.security.event.AdminForgotUsernameEvent;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AdminNotificationForgotUsernameEventListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminNotificationForgotUsernameEventListenerDiffblueTest {
  @Autowired
  private AdminNotificationForgotUsernameEventListener adminNotificationForgotUsernameEventListener;

  @MockBean(name = "blCurrencyService")
  private BroadleafCurrencyService broadleafCurrencyService;

  @MockBean(name = "blLocaleService")
  private LocaleService localeService;

  @MockBean(name = "blNotificationDispatcher")
  private NotificationDispatcher notificationDispatcher;

  @MockBean(name = "blSiteService")
  private SiteService siteService;

  /**
   * Test {@link
   * AdminNotificationForgotUsernameEventListener#handleApplicationEvent(AdminForgotUsernameEvent)}
   * with {@code AdminForgotUsernameEvent}.
   *
   * <p>Method under test: {@link
   * AdminNotificationForgotUsernameEventListener#handleApplicationEvent(AdminForgotUsernameEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminNotificationForgotUsernameEventListener.handleApplicationEvent(AdminForgotUsernameEvent)"
  })
  public void testHandleApplicationEventWithAdminForgotUsernameEvent() throws ServiceException {
    // Arrange
    doNothing().when(notificationDispatcher).dispatchNotification(Mockito.<Notification>any());
    AdminForgotUsernameEvent event =
        new AdminForgotUsernameEvent("Source", "42 Main St", "6625550144", new ArrayList<>());

    // Act
    adminNotificationForgotUsernameEventListener.handleApplicationEvent(event);

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
  }

  /**
   * Test {@link
   * AdminNotificationForgotUsernameEventListener#handleApplicationEvent(AdminForgotUsernameEvent)}
   * with {@code AdminForgotUsernameEvent}.
   *
   * <p>Method under test: {@link
   * AdminNotificationForgotUsernameEventListener#handleApplicationEvent(AdminForgotUsernameEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminNotificationForgotUsernameEventListener.handleApplicationEvent(AdminForgotUsernameEvent)"
  })
  public void testHandleApplicationEventWithAdminForgotUsernameEvent2() throws ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred"))
        .when(notificationDispatcher)
        .dispatchNotification(Mockito.<Notification>any());
    AdminForgotUsernameEvent event =
        new AdminForgotUsernameEvent("Source", "42 Main St", "6625550144", new ArrayList<>());

    // Act
    adminNotificationForgotUsernameEventListener.handleApplicationEvent(event);

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
  }

  /**
   * Test {@link
   * AdminNotificationForgotUsernameEventListener#createContext(AdminForgotUsernameEvent)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminNotificationForgotUsernameEventListener#createContext(AdminForgotUsernameEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminNotificationForgotUsernameEventListener.createContext(AdminForgotUsernameEvent)"
  })
  public void testCreateContext_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<String> activeUsernames = new ArrayList<>();
    AdminForgotUsernameEvent event =
        new AdminForgotUsernameEvent("Source", "42 Main St", "6625550144", activeUsernames);

    // Act
    Map<String, Object> actualCreateContextResult =
        adminNotificationForgotUsernameEventListener.createContext(event);

    // Assert
    assertEquals(1, actualCreateContextResult.size());
    Object getResult =
        actualCreateContextResult.get(
            AdminNotificationForgotUsernameEventListener.ACTIVE_USERNAMES_CONTEXT_KEY);
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(activeUsernames, getResult);
  }

  /**
   * Test {@link AdminNotificationForgotUsernameEventListener#isAsynchronous()}.
   *
   * <p>Method under test: {@link AdminNotificationForgotUsernameEventListener#isAsynchronous()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminNotificationForgotUsernameEventListener.isAsynchronous()"})
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue(new AdminNotificationForgotUsernameEventListener().isAsynchronous());
  }
}
