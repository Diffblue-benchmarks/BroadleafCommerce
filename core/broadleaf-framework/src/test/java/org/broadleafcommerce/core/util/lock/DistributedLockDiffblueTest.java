package org.broadleafcommerce.core.util.lock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.core.util.lock.DistributedLock.DistributedLockException;
import org.junit.Test;

public class DistributedLockDiffblueTest {
  /**
   * Test DistributedLockException
   * {@link DistributedLockException#DistributedLockException(String, Throwable)}.
   * <p>
   * Method under test:
   * {@link DistributedLock.DistributedLockException#DistributedLockException(String, Throwable)}
   */
  @Test
  public void testDistributedLockExceptionNewDistributedLockException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DistributedLock.DistributedLockException actualDistributedLockException = new DistributedLock.DistributedLockException(
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualDistributedLockException.getMessage());
    assertEquals(0, actualDistributedLockException.getSuppressed().length);
    assertSame(cause, actualDistributedLockException.getCause());
  }

  /**
   * Test DistributedLockException
   * {@link DistributedLockException#DistributedLockException(Throwable)}.
   * <p>
   * Method under test:
   * {@link DistributedLock.DistributedLockException#DistributedLockException(Throwable)}
   */
  @Test
  public void testDistributedLockExceptionNewDistributedLockException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DistributedLock.DistributedLockException actualDistributedLockException = new DistributedLock.DistributedLockException(
        cause);

    // Assert
    assertEquals("java.lang.Throwable", actualDistributedLockException.getMessage());
    assertEquals(0, actualDistributedLockException.getSuppressed().length);
    assertSame(cause, actualDistributedLockException.getCause());
  }

  /**
   * Test DistributedLockException
   * {@link DistributedLockException#DistributedLockException(String)}.
   * <ul>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DistributedLock.DistributedLockException#DistributedLockException(String)}
   */
  @Test
  public void testDistributedLockExceptionNewDistributedLockException_thenReturnCauseIsNull() {
    // Arrange and Act
    DistributedLock.DistributedLockException actualDistributedLockException = new DistributedLock.DistributedLockException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualDistributedLockException.getMessage());
    assertNull(actualDistributedLockException.getCause());
    assertEquals(0, actualDistributedLockException.getSuppressed().length);
  }

  /**
   * Test DistributedLockException
   * {@link DistributedLockException#DistributedLockException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DistributedLock.DistributedLockException#DistributedLockException()}
   */
  @Test
  public void testDistributedLockExceptionNewDistributedLockException_thenReturnMessageIsNull() {
    // Arrange and Act
    DistributedLock.DistributedLockException actualDistributedLockException = new DistributedLock.DistributedLockException();

    // Assert
    assertNull(actualDistributedLockException.getMessage());
    assertNull(actualDistributedLockException.getCause());
    assertEquals(0, actualDistributedLockException.getSuppressed().length);
  }

  /**
   * Test DistributedLockException
   * {@link DistributedLockException#DistributedLockException(String, Throwable, boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DistributedLock.DistributedLockException#DistributedLockException(String, Throwable, boolean, boolean)}
   */
  @Test
  public void testDistributedLockExceptionNewDistributedLockException_whenTrue() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DistributedLock.DistributedLockException actualDistributedLockException = new DistributedLock.DistributedLockException(
        "An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualDistributedLockException.getMessage());
    assertEquals(0, actualDistributedLockException.getSuppressed().length);
    assertSame(cause, actualDistributedLockException.getCause());
  }
}
