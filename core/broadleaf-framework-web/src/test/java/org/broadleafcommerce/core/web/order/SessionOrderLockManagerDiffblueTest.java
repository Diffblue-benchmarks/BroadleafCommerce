package org.broadleafcommerce.core.web.order;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SessionOrderLockManagerDiffblueTest {
  /**
   * Test {@link SessionOrderLockManager#acquireLock(Order)}.
   *
   * <p>Method under test: {@link SessionOrderLockManager#acquireLock(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object SessionOrderLockManager.acquireLock(Order)"})
  public void testAcquireLock() {
    // Arrange
    SessionOrderLockManager sessionOrderLockManager = new SessionOrderLockManager();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> sessionOrderLockManager.acquireLock(new NullOrderImpl()));
  }

  /**
   * Test {@link SessionOrderLockManager#acquireLockIfAvailable(Order)}.
   *
   * <p>Method under test: {@link SessionOrderLockManager#acquireLockIfAvailable(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object SessionOrderLockManager.acquireLockIfAvailable(Order)"})
  public void testAcquireLockIfAvailable() {
    // Arrange
    SessionOrderLockManager sessionOrderLockManager = new SessionOrderLockManager();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> sessionOrderLockManager.acquireLockIfAvailable(new NullOrderImpl()));
  }

  /**
   * Test {@link SessionOrderLockManager#getRequest()}.
   *
   * <p>Method under test: {@link SessionOrderLockManager#getRequest()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"javax.servlet.http.HttpServletRequest SessionOrderLockManager.getRequest()"})
  public void testGetRequest() {
    // Arrange, Act and Assert
    assertNull(new SessionOrderLockManager().getRequest());
  }

  /**
   * Test {@link SessionOrderLockManager#getSessionLock()}.
   *
   * <p>Method under test: {@link SessionOrderLockManager#getSessionLock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.concurrent.locks.ReentrantLock SessionOrderLockManager.getSessionLock()"
  })
  public void testGetSessionLock() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> new SessionOrderLockManager().getSessionLock());
  }

  /**
   * Test {@link SessionOrderLockManager#isActive()}.
   *
   * <p>Method under test: {@link SessionOrderLockManager#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionOrderLockManager.isActive()"})
  public void testIsActive() {
    // Arrange, Act and Assert
    assertFalse(new SessionOrderLockManager().isActive());
  }

  /**
   * Test new {@link SessionOrderLockManager} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SessionOrderLockManager}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SessionOrderLockManager.<init>()"})
  public void testNewSessionOrderLockManager() {
    // Arrange and Act
    SessionOrderLockManager actualSessionOrderLockManager = new SessionOrderLockManager();

    // Assert
    assertNull(actualSessionOrderLockManager.getRequest());
    assertFalse(actualSessionOrderLockManager.isActive());
  }
}
