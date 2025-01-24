package org.broadleafcommerce.profile.core.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Map;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml",
    "/bl-profile-applicationContext-persistence.xml", "/bl-profile-applicationContext.xml",
    "/blc-config/admin/framework/bl-profile-applicationContext.xml",
    "/blc-config/site/framework/bl-profile-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class NotificationRegisterCustomerEventListenerDiffblueTest {
  @Autowired
  private NotificationRegisterCustomerEventListener notificationRegisterCustomerEventListener;

  /**
   * Test
   * {@link NotificationRegisterCustomerEventListener#handleApplicationEvent(RegisterCustomerEvent)}
   * with {@code RegisterCustomerEvent}.
   * <p>
   * Method under test:
   * {@link NotificationRegisterCustomerEventListener#handleApplicationEvent(RegisterCustomerEvent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandleApplicationEventWithRegisterCustomerEvent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.event;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass195 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.event.NotificationRegisterCustomerEventListener notificationRegisterCustomerEventListener;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NotificationRegisterCustomerEventListener notificationRegisterCustomerEventListener2 = new NotificationRegisterCustomerEventListener();

    // Act
    notificationRegisterCustomerEventListener2.handleApplicationEvent(new RegisterCustomerEvent("Source", 1L));
  }

  /**
   * Test
   * {@link NotificationRegisterCustomerEventListener#createContext(Customer, RegisterCustomerEvent)}.
   * <p>
   * Method under test:
   * {@link NotificationRegisterCustomerEventListener#createContext(Customer, RegisterCustomerEvent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateContext() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.event;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass143 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.event.NotificationRegisterCustomerEventListener notificationRegisterCustomerEventListener;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NotificationRegisterCustomerEventListener notificationRegisterCustomerEventListener2 = new NotificationRegisterCustomerEventListener();
    CustomerImpl customer = new CustomerImpl();

    // Act
    notificationRegisterCustomerEventListener2.createContext(customer, new RegisterCustomerEvent("Source", 1L));
  }

  /**
   * Test
   * {@link NotificationRegisterCustomerEventListener#createContext(Customer, RegisterCustomerEvent)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@code customer} is {@link CustomerImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRegisterCustomerEventListener#createContext(Customer, RegisterCustomerEvent)}
   */
  @Test
  public void testCreateContext_whenCustomerImpl_thenReturnCustomerIsCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRegisterCustomerEventListener notificationRegisterCustomerEventListener = new NotificationRegisterCustomerEventListener();
    CustomerImpl customer = new CustomerImpl();

    // Act
    Map<String, Object> actualCreateContextResult = notificationRegisterCustomerEventListener.createContext(customer,
        new RegisterCustomerEvent("Source", 1L));

    // Assert
    assertEquals(1, actualCreateContextResult.size());
    assertSame(customer, actualCreateContextResult.get("customer"));
  }

  /**
   * Test
   * {@link NotificationRegisterCustomerEventListener#createContext(Customer, RegisterCustomerEvent)}.
   * <ul>
   *   <li>When {@link CustomerImpl}.</li>
   *   <li>Then return {@code customer} is {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRegisterCustomerEventListener#createContext(Customer, RegisterCustomerEvent)}
   */
  @Test
  public void testCreateContext_whenCustomerImpl_thenReturnCustomerIsCustomerImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRegisterCustomerEventListener notificationRegisterCustomerEventListener = new NotificationRegisterCustomerEventListener();
    CustomerImpl customer = mock(CustomerImpl.class);

    // Act
    Map<String, Object> actualCreateContextResult = notificationRegisterCustomerEventListener.createContext(customer,
        new RegisterCustomerEvent("Source", 1L));

    // Assert
    assertEquals(1, actualCreateContextResult.size());
    assertSame(customer, actualCreateContextResult.get("customer"));
  }

  /**
   * Test {@link NotificationRegisterCustomerEventListener#isAsynchronous()}.
   * <p>
   * Method under test:
   * {@link NotificationRegisterCustomerEventListener#isAsynchronous()}
   */
  @Test
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue((new NotificationRegisterCustomerEventListener()).isAsynchronous());
  }
}
