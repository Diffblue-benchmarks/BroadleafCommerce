package org.broadleafcommerce.profile.core.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
public class NotificationForgotPasswordEventListenerDiffblueTest {
  @Autowired
  private NotificationForgotPasswordEventListener notificationForgotPasswordEventListener;

  /**
   * Test
   * {@link NotificationForgotPasswordEventListener#handleApplicationEvent(ForgotPasswordEvent)}
   * with {@code ForgotPasswordEvent}.
   * <p>
   * Method under test:
   * {@link NotificationForgotPasswordEventListener#handleApplicationEvent(ForgotPasswordEvent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandleApplicationEventWithForgotPasswordEvent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.event;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass60 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.event.NotificationForgotPasswordEventListener notificationForgotPasswordEventListener;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NotificationForgotPasswordEventListener notificationForgotPasswordEventListener2 = new NotificationForgotPasswordEventListener();

    // Act
    notificationForgotPasswordEventListener2
        .handleApplicationEvent(new ForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example"));
  }

  /**
   * Test
   * {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}.
   * <p>
   * Method under test:
   * {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}
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
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.event.NotificationForgotPasswordEventListener notificationForgotPasswordEventListener;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NotificationForgotPasswordEventListener notificationForgotPasswordEventListener2 = new NotificationForgotPasswordEventListener();
    CustomerImpl customer = new CustomerImpl();

    // Act
    notificationForgotPasswordEventListener2.createContext(customer,
        new ForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example"));
  }

  /**
   * Test
   * {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return containsKey {@code resetPasswordUrl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}
   */
  @Test
  public void testCreateContext_whenCustomerImpl_thenReturnContainsKeyResetPasswordUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationForgotPasswordEventListener notificationForgotPasswordEventListener = new NotificationForgotPasswordEventListener();
    CustomerImpl customer = new CustomerImpl();

    // Act
    Map<String, Object> actualCreateContextResult = notificationForgotPasswordEventListener.createContext(customer,
        new ForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example"));

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    assertTrue(actualCreateContextResult.containsKey("resetPasswordUrl"));
    assertTrue(actualCreateContextResult.containsKey("token"));
    assertSame(customer, actualCreateContextResult.get("customer"));
  }

  /**
   * Test
   * {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}.
   * <ul>
   *   <li>When {@link CustomerImpl}.</li>
   *   <li>Then return {@code customer} is {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}
   */
  @Test
  public void testCreateContext_whenCustomerImpl_thenReturnCustomerIsCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationForgotPasswordEventListener notificationForgotPasswordEventListener = new NotificationForgotPasswordEventListener();
    CustomerImpl customer = mock(CustomerImpl.class);

    // Act
    Map<String, Object> actualCreateContextResult = notificationForgotPasswordEventListener.createContext(customer,
        new ForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example"));

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    assertEquals("ABC123", actualCreateContextResult.get("token"));
    assertEquals("https://example.org/example", actualCreateContextResult.get("resetPasswordUrl"));
    assertSame(customer, actualCreateContextResult.get("customer"));
  }

  /**
   * Test
   * {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code customer} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}
   */
  @Test
  public void testCreateContext_whenNull_thenReturnCustomerIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationForgotPasswordEventListener notificationForgotPasswordEventListener = new NotificationForgotPasswordEventListener();

    // Act
    Map<String, Object> actualCreateContextResult = notificationForgotPasswordEventListener.createContext(null,
        new ForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example"));

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    assertEquals("ABC123", actualCreateContextResult.get("token"));
    assertEquals("https://example.org/example", actualCreateContextResult.get("resetPasswordUrl"));
    assertNull(actualCreateContextResult.get("customer"));
  }

  /**
   * Test {@link NotificationForgotPasswordEventListener#isAsynchronous()}.
   * <p>
   * Method under test:
   * {@link NotificationForgotPasswordEventListener#isAsynchronous()}
   */
  @Test
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue((new NotificationForgotPasswordEventListener()).isAsynchronous());
  }
}
