package org.broadleafcommerce.profile.core.event;

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
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NotificationForgotPasswordEventListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NotificationForgotPasswordEventListenerDiffblueTest {
  @MockBean(name = "blCurrencyService")
  private BroadleafCurrencyService broadleafCurrencyService;

  @MockBean(name = "blCustomerService")
  private CustomerService customerService;

  @MockBean(name = "blLocaleService")
  private LocaleService localeService;

  @MockBean(name = "blNotificationDispatcher")
  private NotificationDispatcher notificationDispatcher;

  @Autowired
  private NotificationForgotPasswordEventListener notificationForgotPasswordEventListener;

  @MockBean(name = "blSiteService")
  private SiteService siteService;

  /**
   * Test {@link
   * NotificationForgotPasswordEventListener#handleApplicationEvent(ForgotPasswordEvent)} with
   * {@code ForgotPasswordEvent}.
   *
   * <p>Method under test: {@link
   * NotificationForgotPasswordEventListener#handleApplicationEvent(ForgotPasswordEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationForgotPasswordEventListener.handleApplicationEvent(ForgotPasswordEvent)"
  })
  public void testHandleApplicationEventWithForgotPasswordEvent() throws ServiceException {
    // Arrange
    when(customerService.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    doThrow(new ServiceException("An error occurred"))
        .when(notificationDispatcher)
        .dispatchNotification(Mockito.<Notification>any());
    ForgotPasswordEvent event =
        new ForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example");

    // Act
    notificationForgotPasswordEventListener.handleApplicationEvent(event);

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
    verify(customerService).readCustomerById(1L);
  }

  /**
   * Test {@link
   * NotificationForgotPasswordEventListener#handleApplicationEvent(ForgotPasswordEvent)} with
   * {@code ForgotPasswordEvent}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationDispatcher#dispatchNotification(Notification)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationForgotPasswordEventListener#handleApplicationEvent(ForgotPasswordEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationForgotPasswordEventListener.handleApplicationEvent(ForgotPasswordEvent)"
  })
  public void testHandleApplicationEventWithForgotPasswordEvent_thenCallsDispatchNotification()
      throws ServiceException {
    // Arrange
    when(customerService.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    doNothing().when(notificationDispatcher).dispatchNotification(Mockito.<Notification>any());
    ForgotPasswordEvent event =
        new ForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example");

    // Act
    notificationForgotPasswordEventListener.handleApplicationEvent(event);

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
    verify(customerService).readCustomerById(1L);
  }

  /**
   * Test {@link NotificationForgotPasswordEventListener#createContext(Customer,
   * ForgotPasswordEvent)}.
   *
   * <ul>
   *   <li>Then return {@code token}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationForgotPasswordEventListener#createContext(Customer,
   * ForgotPasswordEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map NotificationForgotPasswordEventListener.createContext(Customer, ForgotPasswordEvent)"
  })
  public void testCreateContext_thenReturnToken() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();
    ForgotPasswordEvent event =
        new ForgotPasswordEvent("Source", 1L, "token", "https://example.org/example");

    // Act
    Map<String, Object> actualCreateContextResult =
        notificationForgotPasswordEventListener.createContext(customer, event);

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult.get("customer");
    assertTrue(getResult instanceof CustomerImpl);
    assertEquals("https://example.org/example", actualCreateContextResult.get("resetPasswordUrl"));
    assertEquals("token", actualCreateContextResult.get("token"));
    assertSame(customer, getResult);
  }

  /**
   * Test {@link NotificationForgotPasswordEventListener#createContext(Customer,
   * ForgotPasswordEvent)}.
   *
   * <ul>
   *   <li>Then return {@code token} is {@code ABC123}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationForgotPasswordEventListener#createContext(Customer,
   * ForgotPasswordEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map NotificationForgotPasswordEventListener.createContext(Customer, ForgotPasswordEvent)"
  })
  public void testCreateContext_thenReturnTokenIsAbc123() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();
    ForgotPasswordEvent event =
        new ForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example");

    // Act
    Map<String, Object> actualCreateContextResult =
        notificationForgotPasswordEventListener.createContext(customer, event);

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult.get("customer");
    assertTrue(getResult instanceof CustomerImpl);
    assertEquals("ABC123", actualCreateContextResult.get("token"));
    assertEquals("https://example.org/example", actualCreateContextResult.get("resetPasswordUrl"));
    assertSame(customer, getResult);
  }

  /**
   * Test {@link NotificationForgotPasswordEventListener#isAsynchronous()}.
   *
   * <p>Method under test: {@link NotificationForgotPasswordEventListener#isAsynchronous()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationForgotPasswordEventListener.isAsynchronous()"})
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue(new NotificationForgotPasswordEventListener().isAsynchronous());
  }
}
