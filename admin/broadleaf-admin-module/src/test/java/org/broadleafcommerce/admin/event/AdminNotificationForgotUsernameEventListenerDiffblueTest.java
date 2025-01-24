package org.broadleafcommerce.admin.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.server.security.event.AdminForgotUsernameEvent;
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
public class AdminNotificationForgotUsernameEventListenerDiffblueTest {
  @Autowired
  private AdminNotificationForgotUsernameEventListener adminNotificationForgotUsernameEventListener;

  /**
   * Test
   * {@link AdminNotificationForgotUsernameEventListener#handleApplicationEvent(AdminForgotUsernameEvent)}
   * with {@code AdminForgotUsernameEvent}.
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotUsernameEventListener#handleApplicationEvent(AdminForgotUsernameEvent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandleApplicationEventWithAdminForgotUsernameEvent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.event;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass111 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.event.AdminNotificationForgotUsernameEventListener adminNotificationForgotUsernameEventListener;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminNotificationForgotUsernameEventListener adminNotificationForgotUsernameEventListener2 = new AdminNotificationForgotUsernameEventListener();

    // Act
    adminNotificationForgotUsernameEventListener2
        .handleApplicationEvent(new AdminForgotUsernameEvent("Source", "42 Main St", "6625550144", new ArrayList<>()));
  }

  /**
   * Test
   * {@link AdminNotificationForgotUsernameEventListener#createContext(AdminForgotUsernameEvent)}.
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotUsernameEventListener#createContext(AdminForgotUsernameEvent)}
   */
  @Test
  public void testCreateContext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNotificationForgotUsernameEventListener adminNotificationForgotUsernameEventListener = new AdminNotificationForgotUsernameEventListener();
    ArrayList<String> activeUsernames = new ArrayList<>();

    // Act
    Map<String, Object> actualCreateContextResult = adminNotificationForgotUsernameEventListener
        .createContext(new AdminForgotUsernameEvent("Source", "42 Main St", "6625550144", activeUsernames));

    // Assert
    assertEquals(1, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult
        .get(AdminNotificationForgotUsernameEventListener.ACTIVE_USERNAMES_CONTEXT_KEY);
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(activeUsernames, getResult);
  }

  /**
   * Test
   * {@link AdminNotificationForgotUsernameEventListener#createContext(AdminForgotUsernameEvent)}.
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotUsernameEventListener#createContext(AdminForgotUsernameEvent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateContext2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.event;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass81 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.event.AdminNotificationForgotUsernameEventListener adminNotificationForgotUsernameEventListener;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminNotificationForgotUsernameEventListener adminNotificationForgotUsernameEventListener2 = new AdminNotificationForgotUsernameEventListener();

    // Act
    adminNotificationForgotUsernameEventListener2
        .createContext(new AdminForgotUsernameEvent("Source", "42 Main St", "6625550144", new ArrayList<>()));
  }

  /**
   * Test
   * {@link AdminNotificationForgotUsernameEventListener#createContext(AdminForgotUsernameEvent)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link AdminForgotUsernameEvent#getActiveUsernames()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotUsernameEventListener#createContext(AdminForgotUsernameEvent)}
   */
  @Test
  public void testCreateContext_givenArrayList_thenCallsGetActiveUsernames() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminNotificationForgotUsernameEventListener adminNotificationForgotUsernameEventListener = new AdminNotificationForgotUsernameEventListener();
    AdminForgotUsernameEvent event = mock(AdminForgotUsernameEvent.class);
    ArrayList<String> stringList = new ArrayList<>();
    when(event.getActiveUsernames()).thenReturn(stringList);

    // Act
    Map<String, Object> actualCreateContextResult = adminNotificationForgotUsernameEventListener.createContext(event);

    // Assert
    verify(event).getActiveUsernames();
    assertEquals(1, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult
        .get(AdminNotificationForgotUsernameEventListener.ACTIVE_USERNAMES_CONTEXT_KEY);
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(stringList, getResult);
  }

  /**
   * Test {@link AdminNotificationForgotUsernameEventListener#isAsynchronous()}.
   * <p>
   * Method under test:
   * {@link AdminNotificationForgotUsernameEventListener#isAsynchronous()}
   */
  @Test
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue((new AdminNotificationForgotUsernameEventListener()).isAsynchronous());
  }
}
