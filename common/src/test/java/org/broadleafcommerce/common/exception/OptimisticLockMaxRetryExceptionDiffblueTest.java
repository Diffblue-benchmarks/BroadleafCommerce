package org.broadleafcommerce.common.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OptimisticLockMaxRetryExceptionDiffblueTest {
  /**
   * Test {@link OptimisticLockMaxRetryException#OptimisticLockMaxRetryException(String,
   * Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OptimisticLockMaxRetryException#OptimisticLockMaxRetryException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OptimisticLockMaxRetryException.<init>()",
    "void OptimisticLockMaxRetryException.<init>(String)",
    "void OptimisticLockMaxRetryException.<init>(String, Throwable)",
    "void OptimisticLockMaxRetryException.<init>(String, Throwable, boolean, boolean)",
    "void OptimisticLockMaxRetryException.<init>(Throwable)"
  })
  public void testNewOptimisticLockMaxRetryException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OptimisticLockMaxRetryException actualOptimisticLockMaxRetryException =
        new OptimisticLockMaxRetryException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualOptimisticLockMaxRetryException.getMessage());
    assertEquals(0, actualOptimisticLockMaxRetryException.getSuppressed().length);
    assertSame(cause, actualOptimisticLockMaxRetryException.getCause());
  }

  /**
   * Test {@link OptimisticLockMaxRetryException#OptimisticLockMaxRetryException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OptimisticLockMaxRetryException#OptimisticLockMaxRetryException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OptimisticLockMaxRetryException.<init>()",
    "void OptimisticLockMaxRetryException.<init>(String)",
    "void OptimisticLockMaxRetryException.<init>(String, Throwable)",
    "void OptimisticLockMaxRetryException.<init>(String, Throwable, boolean, boolean)",
    "void OptimisticLockMaxRetryException.<init>(Throwable)"
  })
  public void testNewOptimisticLockMaxRetryException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OptimisticLockMaxRetryException actualOptimisticLockMaxRetryException =
        new OptimisticLockMaxRetryException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualOptimisticLockMaxRetryException.getMessage());
    assertEquals(0, actualOptimisticLockMaxRetryException.getSuppressed().length);
    assertSame(cause, actualOptimisticLockMaxRetryException.getCause());
  }

  /**
   * Test {@link OptimisticLockMaxRetryException#OptimisticLockMaxRetryException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OptimisticLockMaxRetryException#OptimisticLockMaxRetryException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OptimisticLockMaxRetryException.<init>()",
    "void OptimisticLockMaxRetryException.<init>(String)",
    "void OptimisticLockMaxRetryException.<init>(String, Throwable)",
    "void OptimisticLockMaxRetryException.<init>(String, Throwable, boolean, boolean)",
    "void OptimisticLockMaxRetryException.<init>(Throwable)"
  })
  public void testNewOptimisticLockMaxRetryException_thenReturnMessageIsNull() {
    // Arrange and Act
    OptimisticLockMaxRetryException actualOptimisticLockMaxRetryException =
        new OptimisticLockMaxRetryException();

    // Assert
    assertNull(actualOptimisticLockMaxRetryException.getMessage());
    assertNull(actualOptimisticLockMaxRetryException.getCause());
    assertEquals(0, actualOptimisticLockMaxRetryException.getSuppressed().length);
  }

  /**
   * Test {@link OptimisticLockMaxRetryException#OptimisticLockMaxRetryException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OptimisticLockMaxRetryException#OptimisticLockMaxRetryException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OptimisticLockMaxRetryException.<init>()",
    "void OptimisticLockMaxRetryException.<init>(String)",
    "void OptimisticLockMaxRetryException.<init>(String, Throwable)",
    "void OptimisticLockMaxRetryException.<init>(String, Throwable, boolean, boolean)",
    "void OptimisticLockMaxRetryException.<init>(Throwable)"
  })
  public void testNewOptimisticLockMaxRetryException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    OptimisticLockMaxRetryException actualOptimisticLockMaxRetryException =
        new OptimisticLockMaxRetryException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualOptimisticLockMaxRetryException.getMessage());
    assertNull(actualOptimisticLockMaxRetryException.getCause());
    assertEquals(0, actualOptimisticLockMaxRetryException.getSuppressed().length);
  }

  /**
   * Test {@link OptimisticLockMaxRetryException#OptimisticLockMaxRetryException(String, Throwable,
   * boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OptimisticLockMaxRetryException#OptimisticLockMaxRetryException(String, Throwable, boolean,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OptimisticLockMaxRetryException.<init>()",
    "void OptimisticLockMaxRetryException.<init>(String)",
    "void OptimisticLockMaxRetryException.<init>(String, Throwable)",
    "void OptimisticLockMaxRetryException.<init>(String, Throwable, boolean, boolean)",
    "void OptimisticLockMaxRetryException.<init>(Throwable)"
  })
  public void testNewOptimisticLockMaxRetryException_whenTrue() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OptimisticLockMaxRetryException actualOptimisticLockMaxRetryException =
        new OptimisticLockMaxRetryException("An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualOptimisticLockMaxRetryException.getMessage());
    assertEquals(0, actualOptimisticLockMaxRetryException.getSuppressed().length);
    assertSame(cause, actualOptimisticLockMaxRetryException.getCause());
  }
}
