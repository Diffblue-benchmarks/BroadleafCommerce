package org.broadleafcommerce.admin.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.broadleafcommerce.common.currency.service.BroadleafCurrencyService;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.notification.service.NotificationDispatcher;
import org.broadleafcommerce.common.notification.service.type.Notification;
import org.broadleafcommerce.common.site.service.SiteService;
import org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.event.AdminForgotPasswordEvent;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AdminNotificationForgotPasswordEventListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminNotificationForgotPasswordEventListenerDiffblueTest {
  @Autowired
  private AdminNotificationForgotPasswordEventListener adminNotificationForgotPasswordEventListener;

  @MockBean(name = "blAdminUserDao")
  private AdminUserDao adminUserDao;

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
   * AdminNotificationForgotPasswordEventListener#handleApplicationEvent(AdminForgotPasswordEvent)}
   * with {@code AdminForgotPasswordEvent}.
   *
   * <p>Method under test: {@link
   * AdminNotificationForgotPasswordEventListener#handleApplicationEvent(AdminForgotPasswordEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminNotificationForgotPasswordEventListener.handleApplicationEvent(AdminForgotPasswordEvent)"
  })
  public void testHandleApplicationEventWithAdminForgotPasswordEvent() throws ServiceException {
    // Arrange
    when(adminUserDao.readAdminUserById(Mockito.<Long>any())).thenReturn(new AdminUserImpl());
    doNothing().when(notificationDispatcher).dispatchNotification(Mockito.<Notification>any());
    AdminForgotPasswordEvent event =
        new AdminForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example");

    // Act
    adminNotificationForgotPasswordEventListener.handleApplicationEvent(event);

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
    verify(adminUserDao).readAdminUserById(1L);
  }

  /**
   * Test {@link
   * AdminNotificationForgotPasswordEventListener#handleApplicationEvent(AdminForgotPasswordEvent)}
   * with {@code AdminForgotPasswordEvent}.
   *
   * <p>Method under test: {@link
   * AdminNotificationForgotPasswordEventListener#handleApplicationEvent(AdminForgotPasswordEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminNotificationForgotPasswordEventListener.handleApplicationEvent(AdminForgotPasswordEvent)"
  })
  public void testHandleApplicationEventWithAdminForgotPasswordEvent2() throws ServiceException {
    // Arrange
    when(adminUserDao.readAdminUserById(Mockito.<Long>any())).thenReturn(new AdminUserImpl());
    doThrow(new ServiceException("An error occurred"))
        .when(notificationDispatcher)
        .dispatchNotification(Mockito.<Notification>any());
    AdminForgotPasswordEvent event =
        new AdminForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example");

    // Act
    adminNotificationForgotPasswordEventListener.handleApplicationEvent(event);

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
    verify(adminUserDao).readAdminUserById(1L);
  }

  /**
   * Test {@link
   * AdminNotificationForgotPasswordEventListener#handleApplicationEvent(AdminForgotPasswordEvent)}
   * with {@code AdminForgotPasswordEvent}.
   *
   * <p>Method under test: {@link
   * AdminNotificationForgotPasswordEventListener#handleApplicationEvent(AdminForgotPasswordEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminNotificationForgotPasswordEventListener.handleApplicationEvent(AdminForgotPasswordEvent)"
  })
  public void testHandleApplicationEventWithAdminForgotPasswordEvent3() {
    // Arrange
    when(adminUserDao.readAdminUserById(Mockito.<Long>any())).thenReturn(null);
    AdminForgotPasswordEvent event =
        new AdminForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example");

    // Act
    adminNotificationForgotPasswordEventListener.handleApplicationEvent(event);

    // Assert
    verify(adminUserDao).readAdminUserById(1L);
  }

  /**
   * Test {@link
   * AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent,
   * AdminUser)}.
   *
   * <ul>
   *   <li>Then return {@code token}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent,
   * AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminNotificationForgotPasswordEventListener.createContext(AdminForgotPasswordEvent, AdminUser)"
  })
  public void testCreateContext_thenReturnToken() {
    // Arrange
    AdminForgotPasswordEvent event =
        new AdminForgotPasswordEvent("Source", 1L, "token", "https://example.org/example");
    AdminUserImpl adminUser = new AdminUserImpl();

    // Act
    Map<String, Object> actualCreateContextResult =
        adminNotificationForgotPasswordEventListener.createContext(event, adminUser);

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult.get("adminUser");
    assertTrue(getResult instanceof AdminUserImpl);
    assertEquals("https://example.org/example", actualCreateContextResult.get("resetPasswordUrl"));
    assertEquals("token", actualCreateContextResult.get("token"));
    assertSame(adminUser, getResult);
  }

  /**
   * Test {@link
   * AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent,
   * AdminUser)}.
   *
   * <ul>
   *   <li>Then return {@code token} is {@code ABC123}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent,
   * AdminUser)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminNotificationForgotPasswordEventListener.createContext(AdminForgotPasswordEvent, AdminUser)"
  })
  public void testCreateContext_thenReturnTokenIsAbc123() {
    // Arrange
    AdminForgotPasswordEvent event =
        new AdminForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example");
    AdminUserImpl adminUser = new AdminUserImpl();

    // Act
    Map<String, Object> actualCreateContextResult =
        adminNotificationForgotPasswordEventListener.createContext(event, adminUser);

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult.get("adminUser");
    assertTrue(getResult instanceof AdminUserImpl);
    assertEquals("ABC123", actualCreateContextResult.get("token"));
    assertEquals("https://example.org/example", actualCreateContextResult.get("resetPasswordUrl"));
    assertSame(adminUser, getResult);
  }

  /**
   * Test {@link AdminNotificationForgotPasswordEventListener#isAsynchronous()}.
   *
   * <p>Method under test: {@link AdminNotificationForgotPasswordEventListener#isAsynchronous()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminNotificationForgotPasswordEventListener.isAsynchronous()"})
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue(new AdminNotificationForgotPasswordEventListener().isAsynchronous());
  }
}
