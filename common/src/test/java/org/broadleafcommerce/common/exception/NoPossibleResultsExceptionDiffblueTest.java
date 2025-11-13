package org.broadleafcommerce.common.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NoPossibleResultsExceptionDiffblueTest {
  /**
   * Test {@link NoPossibleResultsException#NoPossibleResultsException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link NoPossibleResultsException#NoPossibleResultsException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NoPossibleResultsException.<init>()",
    "void NoPossibleResultsException.<init>(String)",
    "void NoPossibleResultsException.<init>(String, Throwable)",
    "void NoPossibleResultsException.<init>(Throwable)"
  })
  public void testNewNoPossibleResultsException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    NoPossibleResultsException actualNoPossibleResultsException =
        new NoPossibleResultsException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualNoPossibleResultsException.getMessage());
    assertNull(actualNoPossibleResultsException.getCause());
    assertEquals(0, actualNoPossibleResultsException.getSuppressed().length);
  }

  /**
   * Test {@link NoPossibleResultsException#NoPossibleResultsException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link NoPossibleResultsException#NoPossibleResultsException(String,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NoPossibleResultsException.<init>()",
    "void NoPossibleResultsException.<init>(String)",
    "void NoPossibleResultsException.<init>(String, Throwable)",
    "void NoPossibleResultsException.<init>(Throwable)"
  })
  public void testNewNoPossibleResultsException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    NoPossibleResultsException actualNoPossibleResultsException =
        new NoPossibleResultsException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualNoPossibleResultsException.getMessage());
    assertEquals(0, actualNoPossibleResultsException.getSuppressed().length);
    assertSame(cause, actualNoPossibleResultsException.getCause());
  }

  /**
   * Test {@link NoPossibleResultsException#NoPossibleResultsException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link NoPossibleResultsException#NoPossibleResultsException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NoPossibleResultsException.<init>()",
    "void NoPossibleResultsException.<init>(String)",
    "void NoPossibleResultsException.<init>(String, Throwable)",
    "void NoPossibleResultsException.<init>(Throwable)"
  })
  public void testNewNoPossibleResultsException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    NoPossibleResultsException actualNoPossibleResultsException =
        new NoPossibleResultsException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualNoPossibleResultsException.getMessage());
    assertEquals(0, actualNoPossibleResultsException.getSuppressed().length);
    assertSame(cause, actualNoPossibleResultsException.getCause());
  }

  /**
   * Test {@link NoPossibleResultsException#NoPossibleResultsException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NoPossibleResultsException#NoPossibleResultsException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NoPossibleResultsException.<init>()",
    "void NoPossibleResultsException.<init>(String)",
    "void NoPossibleResultsException.<init>(String, Throwable)",
    "void NoPossibleResultsException.<init>(Throwable)"
  })
  public void testNewNoPossibleResultsException_thenReturnMessageIsNull() {
    // Arrange and Act
    NoPossibleResultsException actualNoPossibleResultsException = new NoPossibleResultsException();

    // Assert
    assertNull(actualNoPossibleResultsException.getMessage());
    assertNull(actualNoPossibleResultsException.getCause());
    assertEquals(0, actualNoPossibleResultsException.getSuppressed().length);
  }
}
