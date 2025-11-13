package org.broadleafcommerce.common.web.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class HaltFilterChainExceptionDiffblueTest {
  /**
   * Test {@link HaltFilterChainException#HaltFilterChainException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link HaltFilterChainException#HaltFilterChainException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HaltFilterChainException.<init>()",
    "void HaltFilterChainException.<init>(String)",
    "void HaltFilterChainException.<init>(String, Throwable)",
    "void HaltFilterChainException.<init>(Throwable)"
  })
  public void testNewHaltFilterChainException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    HaltFilterChainException actualHaltFilterChainException =
        new HaltFilterChainException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualHaltFilterChainException.getMessage());
    assertNull(actualHaltFilterChainException.getCause());
    assertEquals(0, actualHaltFilterChainException.getSuppressed().length);
  }

  /**
   * Test {@link HaltFilterChainException#HaltFilterChainException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link HaltFilterChainException#HaltFilterChainException(String,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HaltFilterChainException.<init>()",
    "void HaltFilterChainException.<init>(String)",
    "void HaltFilterChainException.<init>(String, Throwable)",
    "void HaltFilterChainException.<init>(Throwable)"
  })
  public void testNewHaltFilterChainException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    HaltFilterChainException actualHaltFilterChainException =
        new HaltFilterChainException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualHaltFilterChainException.getMessage());
    assertEquals(0, actualHaltFilterChainException.getSuppressed().length);
    assertSame(cause, actualHaltFilterChainException.getCause());
  }

  /**
   * Test {@link HaltFilterChainException#HaltFilterChainException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link HaltFilterChainException#HaltFilterChainException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HaltFilterChainException.<init>()",
    "void HaltFilterChainException.<init>(String)",
    "void HaltFilterChainException.<init>(String, Throwable)",
    "void HaltFilterChainException.<init>(Throwable)"
  })
  public void testNewHaltFilterChainException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    HaltFilterChainException actualHaltFilterChainException = new HaltFilterChainException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualHaltFilterChainException.getMessage());
    assertEquals(0, actualHaltFilterChainException.getSuppressed().length);
    assertSame(cause, actualHaltFilterChainException.getCause());
  }

  /**
   * Test {@link HaltFilterChainException#HaltFilterChainException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HaltFilterChainException#HaltFilterChainException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HaltFilterChainException.<init>()",
    "void HaltFilterChainException.<init>(String)",
    "void HaltFilterChainException.<init>(String, Throwable)",
    "void HaltFilterChainException.<init>(Throwable)"
  })
  public void testNewHaltFilterChainException_thenReturnMessageIsNull() {
    // Arrange and Act
    HaltFilterChainException actualHaltFilterChainException = new HaltFilterChainException();

    // Assert
    assertNull(actualHaltFilterChainException.getMessage());
    assertNull(actualHaltFilterChainException.getCause());
    assertEquals(0, actualHaltFilterChainException.getSuppressed().length);
  }
}
