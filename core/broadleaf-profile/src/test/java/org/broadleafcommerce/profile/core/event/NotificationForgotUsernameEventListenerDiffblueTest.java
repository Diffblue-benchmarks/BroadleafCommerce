package org.broadleafcommerce.profile.core.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public class NotificationForgotUsernameEventListenerDiffblueTest {
  @Autowired
  private NotificationForgotUsernameEventListener notificationForgotUsernameEventListener;

  /**
   * Test
   * {@link NotificationForgotUsernameEventListener#handleApplicationEvent(ForgotUsernameEvent)}
   * with {@code ForgotUsernameEvent}.
   * <p>
   * Method under test:
   * {@link NotificationForgotUsernameEventListener#handleApplicationEvent(ForgotUsernameEvent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandleApplicationEventWithForgotUsernameEvent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.event;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass118 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.event.NotificationForgotUsernameEventListener notificationForgotUsernameEventListener;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NotificationForgotUsernameEventListener notificationForgotUsernameEventListener2 = new NotificationForgotUsernameEventListener();

    // Act
    notificationForgotUsernameEventListener2
        .handleApplicationEvent(new ForgotUsernameEvent("Source", "42 Main St", new ArrayList<>()));
  }

  /**
   * Test
   * {@link NotificationForgotUsernameEventListener#createContext(ForgotUsernameEvent)}.
   * <p>
   * Method under test:
   * {@link NotificationForgotUsernameEventListener#createContext(ForgotUsernameEvent)}
   */
  @Test
  public void testCreateContext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationForgotUsernameEventListener notificationForgotUsernameEventListener = new NotificationForgotUsernameEventListener();
    ArrayList<String> activeUsernames = new ArrayList<>();

    // Act
    Map<String, Object> actualCreateContextResult = notificationForgotUsernameEventListener
        .createContext(new ForgotUsernameEvent("Source", "42 Main St", activeUsernames));

    // Assert
    assertEquals(1, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult.get("activeUsernames");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(activeUsernames, getResult);
  }

  /**
   * Test
   * {@link NotificationForgotUsernameEventListener#createContext(ForgotUsernameEvent)}.
   * <p>
   * Method under test:
   * {@link NotificationForgotUsernameEventListener#createContext(ForgotUsernameEvent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateContext2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.event;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass93 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.event.NotificationForgotUsernameEventListener notificationForgotUsernameEventListener;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NotificationForgotUsernameEventListener notificationForgotUsernameEventListener2 = new NotificationForgotUsernameEventListener();

    // Act
    notificationForgotUsernameEventListener2
        .createContext(new ForgotUsernameEvent("Source", "42 Main St", new ArrayList<>()));
  }

  /**
   * Test
   * {@link NotificationForgotUsernameEventListener#createContext(ForgotUsernameEvent)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ForgotUsernameEvent#getActiveUsernames()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationForgotUsernameEventListener#createContext(ForgotUsernameEvent)}
   */
  @Test
  public void testCreateContext_givenArrayList_thenCallsGetActiveUsernames() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationForgotUsernameEventListener notificationForgotUsernameEventListener = new NotificationForgotUsernameEventListener();
    ForgotUsernameEvent event = mock(ForgotUsernameEvent.class);
    ArrayList<String> stringList = new ArrayList<>();
    when(event.getActiveUsernames()).thenReturn(stringList);

    // Act
    Map<String, Object> actualCreateContextResult = notificationForgotUsernameEventListener.createContext(event);

    // Assert
    verify(event).getActiveUsernames();
    assertEquals(1, actualCreateContextResult.size());
    Object getResult = actualCreateContextResult.get("activeUsernames");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(stringList, getResult);
  }

  /**
   * Test {@link NotificationForgotUsernameEventListener#isAsynchronous()}.
   * <p>
   * Method under test:
   * {@link NotificationForgotUsernameEventListener#isAsynchronous()}
   */
  @Test
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue((new NotificationForgotUsernameEventListener()).isAsynchronous());
  }
}
