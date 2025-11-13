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

@ContextConfiguration(classes = {NotificationRegisterCustomerEventListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NotificationRegisterCustomerEventListenerDiffblueTest {
  @MockBean(name = "blCurrencyService")
  private BroadleafCurrencyService broadleafCurrencyService;

  @MockBean(name = "blCustomerService")
  private CustomerService customerService;

  @MockBean(name = "blLocaleService")
  private LocaleService localeService;

  @MockBean(name = "blNotificationDispatcher")
  private NotificationDispatcher notificationDispatcher;

  @Autowired
  private NotificationRegisterCustomerEventListener notificationRegisterCustomerEventListener;

  @MockBean(name = "blSiteService")
  private SiteService siteService;

  /**
   * Test {@link
   * NotificationRegisterCustomerEventListener#handleApplicationEvent(RegisterCustomerEvent)} with
   * {@code RegisterCustomerEvent}.
   *
   * <p>Method under test: {@link
   * NotificationRegisterCustomerEventListener#handleApplicationEvent(RegisterCustomerEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationRegisterCustomerEventListener.handleApplicationEvent(RegisterCustomerEvent)"
  })
  public void testHandleApplicationEventWithRegisterCustomerEvent() throws ServiceException {
    // Arrange
    when(customerService.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    doNothing().when(notificationDispatcher).dispatchNotification(Mockito.<Notification>any());

    // Act
    notificationRegisterCustomerEventListener.handleApplicationEvent(
        new RegisterCustomerEvent("Source", 1L));

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
    verify(customerService).readCustomerById(1L);
  }

  /**
   * Test {@link
   * NotificationRegisterCustomerEventListener#handleApplicationEvent(RegisterCustomerEvent)} with
   * {@code RegisterCustomerEvent}.
   *
   * <p>Method under test: {@link
   * NotificationRegisterCustomerEventListener#handleApplicationEvent(RegisterCustomerEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationRegisterCustomerEventListener.handleApplicationEvent(RegisterCustomerEvent)"
  })
  public void testHandleApplicationEventWithRegisterCustomerEvent2() throws ServiceException {
    // Arrange
    when(customerService.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    doThrow(new ServiceException("An error occurred"))
        .when(notificationDispatcher)
        .dispatchNotification(Mockito.<Notification>any());

    // Act
    notificationRegisterCustomerEventListener.handleApplicationEvent(
        new RegisterCustomerEvent("Source", 1L));

    // Assert
    verify(notificationDispatcher, atLeast(1)).dispatchNotification(Mockito.<Notification>any());
    verify(customerService).readCustomerById(1L);
  }

  /**
   * Test {@link
   * NotificationRegisterCustomerEventListener#handleApplicationEvent(RegisterCustomerEvent)} with
   * {@code RegisterCustomerEvent}.
   *
   * <p>Method under test: {@link
   * NotificationRegisterCustomerEventListener#handleApplicationEvent(RegisterCustomerEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationRegisterCustomerEventListener.handleApplicationEvent(RegisterCustomerEvent)"
  })
  public void testHandleApplicationEventWithRegisterCustomerEvent3() {
    // Arrange
    when(customerService.readCustomerById(Mockito.<Long>any())).thenReturn(null);

    // Act
    notificationRegisterCustomerEventListener.handleApplicationEvent(
        new RegisterCustomerEvent("Source", 1L));

    // Assert
    verify(customerService).readCustomerById(1L);
  }

  /**
   * Test {@link NotificationRegisterCustomerEventListener#createContext(Customer,
   * RegisterCustomerEvent)}.
   *
   * <p>Method under test: {@link NotificationRegisterCustomerEventListener#createContext(Customer,
   * RegisterCustomerEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map NotificationRegisterCustomerEventListener.createContext(Customer, RegisterCustomerEvent)"
  })
  public void testCreateContext() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    Map<String, Object> actualCreateContextResult =
        notificationRegisterCustomerEventListener.createContext(
            customer, new RegisterCustomerEvent("Source", 1L));

    // Assert
    assertEquals(1, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult.get("customer");
    assertTrue(getResult instanceof CustomerImpl);
    assertSame(customer, getResult);
  }

  /**
   * Test {@link NotificationRegisterCustomerEventListener#isAsynchronous()}.
   *
   * <p>Method under test: {@link NotificationRegisterCustomerEventListener#isAsynchronous()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRegisterCustomerEventListener.isAsynchronous()"})
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue(new NotificationRegisterCustomerEventListener().isAsynchronous());
  }
}
