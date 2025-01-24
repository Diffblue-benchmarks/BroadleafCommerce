package org.broadleafcommerce.admin.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Map;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.event.AdminForgotPasswordEvent;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml", "/bl-admin-applicationContext.xml",
    "/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-admin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminNotificationForgotPasswordEventListenerDiffblueTest {
  @Autowired
  private AdminNotificationForgotPasswordEventListener adminNotificationForgotPasswordEventListener;

  /**
   * Test
   * {@link AdminNotificationForgotPasswordEventListener#handleApplicationEvent(AdminForgotPasswordEvent)}
   * with {@code AdminForgotPasswordEvent}.
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotPasswordEventListener#handleApplicationEvent(AdminForgotPasswordEvent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandleApplicationEventWithAdminForgotPasswordEvent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.event;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass48 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.event.AdminNotificationForgotPasswordEventListener adminNotificationForgotPasswordEventListener;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminNotificationForgotPasswordEventListener adminNotificationForgotPasswordEventListener2 = new AdminNotificationForgotPasswordEventListener();

    // Act
    adminNotificationForgotPasswordEventListener2
        .handleApplicationEvent(new AdminForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example"));
  }

  /**
   * Test
   * {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}.
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}
   */
  @Test
  public void testCreateContext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNotificationForgotPasswordEventListener adminNotificationForgotPasswordEventListener = new AdminNotificationForgotPasswordEventListener();
    AdminForgotPasswordEvent event = new AdminForgotPasswordEvent("Source", 1L, "ABC123",
        "https://example.org/example");

    AdminUserImpl adminUser = new AdminUserImpl();

    // Act
    Map<String, Object> actualCreateContextResult = adminNotificationForgotPasswordEventListener.createContext(event,
        adminUser);

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    assertEquals("ABC123", actualCreateContextResult.get("token"));
    assertEquals("https://example.org/example", actualCreateContextResult.get("resetPasswordUrl"));
    assertSame(adminUser, actualCreateContextResult.get("adminUser"));
  }

  /**
   * Test
   * {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}.
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}
   */
  @Test
  public void testCreateContext2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNotificationForgotPasswordEventListener adminNotificationForgotPasswordEventListener = new AdminNotificationForgotPasswordEventListener();
    AdminForgotPasswordEvent event = new AdminForgotPasswordEvent("token", 1L, "ABC123", "https://example.org/example");

    AdminUserImpl adminUser = new AdminUserImpl();

    // Act
    Map<String, Object> actualCreateContextResult = adminNotificationForgotPasswordEventListener.createContext(event,
        adminUser);

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    assertEquals("ABC123", actualCreateContextResult.get("token"));
    assertEquals("https://example.org/example", actualCreateContextResult.get("resetPasswordUrl"));
    assertSame(adminUser, actualCreateContextResult.get("adminUser"));
  }

  /**
   * Test
   * {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}.
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateContext3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.event;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.event.AdminNotificationForgotPasswordEventListener adminNotificationForgotPasswordEventListener;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminNotificationForgotPasswordEventListener adminNotificationForgotPasswordEventListener2 = new AdminNotificationForgotPasswordEventListener();
    AdminForgotPasswordEvent event = new AdminForgotPasswordEvent("Source", 1L, "ABC123",
        "https://example.org/example");

    // Act
    adminNotificationForgotPasswordEventListener2.createContext(event, new AdminUserImpl());
  }

  /**
   * Test
   * {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then calls {@link AdminForgotPasswordEvent#getResetPasswordUrl()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotPasswordEventListener#createContext(AdminForgotPasswordEvent, AdminUser)}
   */
  @Test
  public void testCreateContext_givenHttpsExampleOrgExample_thenCallsGetResetPasswordUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNotificationForgotPasswordEventListener adminNotificationForgotPasswordEventListener = new AdminNotificationForgotPasswordEventListener();
    AdminForgotPasswordEvent event = mock(AdminForgotPasswordEvent.class);
    when(event.getResetPasswordUrl()).thenReturn("https://example.org/example");
    when(event.getToken()).thenReturn("ABC123");
    AdminUserImpl adminUser = new AdminUserImpl();

    // Act
    Map<String, Object> actualCreateContextResult = adminNotificationForgotPasswordEventListener.createContext(event,
        adminUser);

    // Assert
    verify(event).getResetPasswordUrl();
    verify(event).getToken();
    assertEquals(3, actualCreateContextResult.size());
    assertEquals("ABC123", actualCreateContextResult.get("token"));
    assertEquals("https://example.org/example", actualCreateContextResult.get("resetPasswordUrl"));
    assertSame(adminUser, actualCreateContextResult.get("adminUser"));
  }

  /**
   * Test {@link AdminNotificationForgotPasswordEventListener#isAsynchronous()}.
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotPasswordEventListener#isAsynchronous()}
   */
  @Test
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue((new AdminNotificationForgotPasswordEventListener()).isAsynchronous());
  }
}
