package org.broadleafcommerce.core.order.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Map;
import org.broadleafcommerce.common.event.OrderSubmittedEvent;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class NotificationOrderSubmittedEventListenerDiffblueTest {
  @Autowired
  private NotificationOrderSubmittedEventListener notificationOrderSubmittedEventListener;

  /**
   * Test
   * {@link NotificationOrderSubmittedEventListener#handleApplicationEvent(OrderSubmittedEvent)}
   * with {@code OrderSubmittedEvent}.
   * <p>
   * Method under test:
   * {@link NotificationOrderSubmittedEventListener#handleApplicationEvent(OrderSubmittedEvent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandleApplicationEventWithOrderSubmittedEvent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.event;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1249 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.event.NotificationOrderSubmittedEventListener notificationOrderSubmittedEventListener;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NotificationOrderSubmittedEventListener notificationOrderSubmittedEventListener2 = new NotificationOrderSubmittedEventListener();

    // Act
    notificationOrderSubmittedEventListener2.handleApplicationEvent(new OrderSubmittedEvent("Source", 1L, "42"));
  }

  /**
   * Test {@link NotificationOrderSubmittedEventListener#createContext(Order)}.
   * <p>
   * Method under test:
   * {@link NotificationOrderSubmittedEventListener#createContext(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateContext() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.event;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1236 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.event.NotificationOrderSubmittedEventListener notificationOrderSubmittedEventListener;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NotificationOrderSubmittedEventListener notificationOrderSubmittedEventListener2 = new NotificationOrderSubmittedEventListener();

    // Act
    notificationOrderSubmittedEventListener2.createContext(new NullOrderImpl());
  }

  /**
   * Test {@link NotificationOrderSubmittedEventListener#createContext(Order)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@code customer} is {@link CustomerImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationOrderSubmittedEventListener#createContext(Order)}
   */
  @Test
  public void testCreateContext_givenCustomerImpl_thenReturnCustomerIsCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationOrderSubmittedEventListener notificationOrderSubmittedEventListener = new NotificationOrderSubmittedEventListener();
    NullOrderImpl order = mock(NullOrderImpl.class);
    CustomerImpl customerImpl = new CustomerImpl();
    when(order.getCustomer()).thenReturn(customerImpl);

    // Act
    Map<String, Object> actualCreateContextResult = notificationOrderSubmittedEventListener.createContext(order);

    // Assert
    verify(order).getCustomer();
    assertEquals(2, actualCreateContextResult.size());
    assertSame(customerImpl, actualCreateContextResult.get("customer"));
    assertSame(order, actualCreateContextResult.get("order"));
  }

  /**
   * Test {@link NotificationOrderSubmittedEventListener#createContext(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code customer} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationOrderSubmittedEventListener#createContext(Order)}
   */
  @Test
  public void testCreateContext_whenNullOrderImpl_thenReturnCustomerIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationOrderSubmittedEventListener notificationOrderSubmittedEventListener = new NotificationOrderSubmittedEventListener();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Map<String, Object> actualCreateContextResult = notificationOrderSubmittedEventListener.createContext(order);

    // Assert
    assertEquals(2, actualCreateContextResult.size());
    assertNull(actualCreateContextResult.get("customer"));
    assertSame(order, actualCreateContextResult.get("order"));
  }

  /**
   * Test {@link NotificationOrderSubmittedEventListener#createContext(Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationOrderSubmittedEventListener#createContext(Order)}
   */
  @Test
  public void testCreateContext_whenNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new NotificationOrderSubmittedEventListener()).createContext(null).isEmpty());
  }

  /**
   * Test {@link NotificationOrderSubmittedEventListener#isAsynchronous()}.
   * <p>
   * Method under test:
   * {@link NotificationOrderSubmittedEventListener#isAsynchronous()}
   */
  @Test
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue((new NotificationOrderSubmittedEventListener()).isAsynchronous());
  }
}
