package org.broadleafcommerce.core.web.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.concurrent.locks.ReentrantLock;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;

class SessionOrderLockManagerDiffblueTest {
  /**
   * Test {@link SessionOrderLockManager#acquireLock(Order)}.
   * <ul>
   *   <li>Given {@link SessionOrderLockManager} (default constructor).</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionOrderLockManager#acquireLock(Order)}
   */
  @Test
  @DisplayName("Test acquireLock(Order); given SessionOrderLockManager (default constructor); then throw IllegalStateException")
  void testAcquireLock_givenSessionOrderLockManager_thenThrowIllegalStateException() {
    // Arrange
    SessionOrderLockManager sessionOrderLockManager = new SessionOrderLockManager();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> sessionOrderLockManager.acquireLock(new NullOrderImpl()));
  }

  /**
   * Test {@link SessionOrderLockManager#acquireLockIfAvailable(Order)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SessionOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @DisplayName("Test acquireLockIfAvailable(Order); then throw IllegalStateException")
  void testAcquireLockIfAvailable_thenThrowIllegalStateException() {
    // Arrange
    SessionOrderLockManager sessionOrderLockManager = new SessionOrderLockManager();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> sessionOrderLockManager.acquireLockIfAvailable(new NullOrderImpl()));
  }

  /**
   * Test {@link SessionOrderLockManager#releaseLock(Object)}.
   * <p>
   * Method under test: {@link SessionOrderLockManager#releaseLock(Object)}
   */
  @Test
  @DisplayName("Test releaseLock(Object)")
  @Disabled("TODO: Complete this test")
  void testReleaseLock() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalMonitorStateException
    //       at java.base/java.util.concurrent.locks.ReentrantLock$Sync.tryRelease(ReentrantLock.java:149)
    //       at java.base/java.util.concurrent.locks.AbstractQueuedSynchronizer.release(AbstractQueuedSynchronizer.java:1302)
    //       at java.base/java.util.concurrent.locks.ReentrantLock.unlock(ReentrantLock.java:439)
    //       at org.broadleafcommerce.core.web.order.SessionOrderLockManager.releaseLock(SessionOrderLockManager.java:79)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    SessionOrderLockManager sessionOrderLockManager = new SessionOrderLockManager();

    // Act
    sessionOrderLockManager.releaseLock(new ReentrantLock());
  }

  /**
   * Test
   * {@link SessionOrderLockManager#onApplicationEvent(HttpSessionDestroyedEvent)}
   * with {@code HttpSessionDestroyedEvent}.
   * <p>
   * Method under test:
   * {@link SessionOrderLockManager#onApplicationEvent(HttpSessionDestroyedEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(HttpSessionDestroyedEvent) with 'HttpSessionDestroyedEvent'")
  void testOnApplicationEventWithHttpSessionDestroyedEvent() {
    // Arrange
    SessionOrderLockManager sessionOrderLockManager = new SessionOrderLockManager();
    MockHttpSession session = mock(MockHttpSession.class);
    when(session.getId()).thenReturn("https://example.org/example");
    doNothing().when(session).putValue(Mockito.<String>any(), Mockito.<Object>any());
    session.putValue("https://example.org/example", "Value");
    HttpSessionDestroyedEvent event = new HttpSessionDestroyedEvent(session);

    // Act
    sessionOrderLockManager.onApplicationEvent(event);

    // Assert
    verify(session).getId();
    verify(session).putValue(eq("https://example.org/example"), isA(Object.class));
    assertEquals("https://example.org/example", event.getId());
  }

  /**
   * Test {@link SessionOrderLockManager#getRequest()}.
   * <p>
   * Method under test: {@link SessionOrderLockManager#getRequest()}
   */
  @Test
  @DisplayName("Test getRequest()")
  void testGetRequest() {
    // Arrange, Act and Assert
    assertNull((new SessionOrderLockManager()).getRequest());
  }

  /**
   * Test {@link SessionOrderLockManager#getSessionLock()}.
   * <p>
   * Method under test: {@link SessionOrderLockManager#getSessionLock()}
   */
  @Test
  @DisplayName("Test getSessionLock()")
  void testGetSessionLock() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new SessionOrderLockManager()).getSessionLock());
  }

  /**
   * Test {@link SessionOrderLockManager#isActive()}.
   * <p>
   * Method under test: {@link SessionOrderLockManager#isActive()}
   */
  @Test
  @DisplayName("Test isActive()")
  void testIsActive() {
    // Arrange, Act and Assert
    assertFalse((new SessionOrderLockManager()).isActive());
  }

  /**
   * Test new {@link SessionOrderLockManager} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link SessionOrderLockManager}
   */
  @Test
  @DisplayName("Test new SessionOrderLockManager (default constructor)")
  void testNewSessionOrderLockManager() {
    // Arrange and Act
    SessionOrderLockManager actualSessionOrderLockManager = new SessionOrderLockManager();

    // Assert
    assertNull(actualSessionOrderLockManager.getRequest());
    assertFalse(actualSessionOrderLockManager.isActive());
  }
}
