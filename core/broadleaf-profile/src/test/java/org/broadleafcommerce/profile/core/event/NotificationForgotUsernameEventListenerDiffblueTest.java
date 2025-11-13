package org.broadleafcommerce.profile.core.event;

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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NotificationForgotUsernameEventListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NotificationForgotUsernameEventListenerDiffblueTest {
  @MockBean(name = "blCurrencyService")
  private BroadleafCurrencyService broadleafCurrencyService;

  @MockBean(name = "blLocaleService")
  private LocaleService localeService;

  @MockBean(name = "blNotificationDispatcher")
  private NotificationDispatcher notificationDispatcher;

  @Autowired
  private NotificationForgotUsernameEventListener notificationForgotUsernameEventListener;

  @MockBean(name = "blSiteService")
  private SiteService siteService;

  /**
   * Test {@link
   * NotificationForgotUsernameEventListener#handleApplicationEvent(ForgotUsernameEvent)} with
   * {@code ForgotUsernameEvent}.
   *
   * <p>Method under test: {@link
   * NotificationForgotUsernameEventListener#handleApplicationEvent(ForgotUsernameEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationForgotUsernameEventListener.handleApplicationEvent(ForgotUsernameEvent)"
  })
  public void testHandleApplicationEventWithForgotUsernameEvent() throws ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred"))
        .when(notificationDispatcher)
        .dispatchNotification(Mockito.<Notification>any());
    ForgotUsernameEvent event = new ForgotUsernameEvent("Source", "42 Main St", new ArrayList<>());

    // Act
    notificationForgotUsernameEventListener.handleApplicationEvent(event);

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
  }

  /**
   * Test {@link
   * NotificationForgotUsernameEventListener#handleApplicationEvent(ForgotUsernameEvent)} with
   * {@code ForgotUsernameEvent}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationDispatcher#dispatchNotification(Notification)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationForgotUsernameEventListener#handleApplicationEvent(ForgotUsernameEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationForgotUsernameEventListener.handleApplicationEvent(ForgotUsernameEvent)"
  })
  public void testHandleApplicationEventWithForgotUsernameEvent_thenCallsDispatchNotification()
      throws ServiceException {
    // Arrange
    doNothing().when(notificationDispatcher).dispatchNotification(Mockito.<Notification>any());
    ForgotUsernameEvent event = new ForgotUsernameEvent("Source", "42 Main St", new ArrayList<>());

    // Act
    notificationForgotUsernameEventListener.handleApplicationEvent(event);

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
  }

  /**
   * Test {@link NotificationForgotUsernameEventListener#createContext(ForgotUsernameEvent)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationForgotUsernameEventListener#createContext(ForgotUsernameEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map NotificationForgotUsernameEventListener.createContext(ForgotUsernameEvent)"
  })
  public void testCreateContext_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<String> activeUsernames = new ArrayList<>();
    ForgotUsernameEvent event = new ForgotUsernameEvent("Source", "42 Main St", activeUsernames);

    // Act
    Map<String, Object> actualCreateContextResult =
        notificationForgotUsernameEventListener.createContext(event);

    // Assert
    assertEquals(1, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult.get("activeUsernames");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(activeUsernames, getResult);
  }

  /**
   * Test {@link NotificationForgotUsernameEventListener#isAsynchronous()}.
   *
   * <p>Method under test: {@link NotificationForgotUsernameEventListener#isAsynchronous()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationForgotUsernameEventListener.isAsynchronous()"})
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue(new NotificationForgotUsernameEventListener().isAsynchronous());
  }
}
