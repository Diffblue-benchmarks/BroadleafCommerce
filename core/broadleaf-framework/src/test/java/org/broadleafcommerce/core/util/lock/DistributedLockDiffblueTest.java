package org.broadleafcommerce.core.util.lock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.util.lock.DistributedLock.DistributedLockException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DistributedLockDiffblueTest {
  /**
   * Test DistributedLockException {@link DistributedLockException#DistributedLockException(String,
   * Throwable)}.
   *
   * <p>Method under test: {@link DistributedLockException#DistributedLockException(String,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DistributedLockException.<init>()",
    "void DistributedLockException.<init>(String)",
    "void DistributedLockException.<init>(String, Throwable)",
    "void DistributedLockException.<init>(String, Throwable, boolean, boolean)",
    "void DistributedLockException.<init>(Throwable)"
  })
  public void testDistributedLockExceptionNewDistributedLockException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DistributedLockException actualDistributedLockException =
        new DistributedLockException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualDistributedLockException.getMessage());
    assertEquals(0, actualDistributedLockException.getSuppressed().length);
    assertSame(cause, actualDistributedLockException.getCause());
  }

  /**
   * Test DistributedLockException {@link
   * DistributedLockException#DistributedLockException(Throwable)}.
   *
   * <p>Method under test: {@link DistributedLockException#DistributedLockException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DistributedLockException.<init>()",
    "void DistributedLockException.<init>(String)",
    "void DistributedLockException.<init>(String, Throwable)",
    "void DistributedLockException.<init>(String, Throwable, boolean, boolean)",
    "void DistributedLockException.<init>(Throwable)"
  })
  public void testDistributedLockExceptionNewDistributedLockException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DistributedLockException actualDistributedLockException = new DistributedLockException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualDistributedLockException.getMessage());
    assertEquals(0, actualDistributedLockException.getSuppressed().length);
    assertSame(cause, actualDistributedLockException.getCause());
  }

  /**
   * Test DistributedLockException {@link
   * DistributedLockException#DistributedLockException(String)}.
   *
   * <ul>
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DistributedLockException#DistributedLockException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DistributedLockException.<init>()",
    "void DistributedLockException.<init>(String)",
    "void DistributedLockException.<init>(String, Throwable)",
    "void DistributedLockException.<init>(String, Throwable, boolean, boolean)",
    "void DistributedLockException.<init>(Throwable)"
  })
  public void testDistributedLockExceptionNewDistributedLockException_thenReturnCauseIsNull() {
    // Arrange and Act
    DistributedLockException actualDistributedLockException =
        new DistributedLockException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualDistributedLockException.getMessage());
    assertNull(actualDistributedLockException.getCause());
    assertEquals(0, actualDistributedLockException.getSuppressed().length);
  }

  /**
   * Test DistributedLockException {@link DistributedLockException#DistributedLockException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DistributedLockException#DistributedLockException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DistributedLockException.<init>()",
    "void DistributedLockException.<init>(String)",
    "void DistributedLockException.<init>(String, Throwable)",
    "void DistributedLockException.<init>(String, Throwable, boolean, boolean)",
    "void DistributedLockException.<init>(Throwable)"
  })
  public void testDistributedLockExceptionNewDistributedLockException_thenReturnMessageIsNull() {
    // Arrange and Act
    DistributedLockException actualDistributedLockException = new DistributedLockException();

    // Assert
    assertNull(actualDistributedLockException.getMessage());
    assertNull(actualDistributedLockException.getCause());
    assertEquals(0, actualDistributedLockException.getSuppressed().length);
  }

  /**
   * Test DistributedLockException {@link DistributedLockException#DistributedLockException(String,
   * Throwable, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DistributedLockException#DistributedLockException(String,
   * Throwable, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DistributedLockException.<init>()",
    "void DistributedLockException.<init>(String)",
    "void DistributedLockException.<init>(String, Throwable)",
    "void DistributedLockException.<init>(String, Throwable, boolean, boolean)",
    "void DistributedLockException.<init>(Throwable)"
  })
  public void testDistributedLockExceptionNewDistributedLockException_whenTrue() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DistributedLockException actualDistributedLockException =
        new DistributedLockException("An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualDistributedLockException.getMessage());
    assertEquals(0, actualDistributedLockException.getSuppressed().length);
    assertSame(cause, actualDistributedLockException.getCause());
  }
}
