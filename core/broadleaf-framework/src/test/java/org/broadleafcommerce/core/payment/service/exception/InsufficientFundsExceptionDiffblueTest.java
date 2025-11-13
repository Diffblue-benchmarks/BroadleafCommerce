package org.broadleafcommerce.core.payment.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InsufficientFundsExceptionDiffblueTest {
  /**
   * Test {@link InsufficientFundsException#InsufficientFundsException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link InsufficientFundsException#InsufficientFundsException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InsufficientFundsException.<init>()",
    "void InsufficientFundsException.<init>(String)",
    "void InsufficientFundsException.<init>(String, Throwable)",
    "void InsufficientFundsException.<init>(Throwable)"
  })
  public void testNewInsufficientFundsException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    InsufficientFundsException actualInsufficientFundsException =
        new InsufficientFundsException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualInsufficientFundsException.getMessage());
    assertNull(actualInsufficientFundsException.getCause());
    assertEquals(0, actualInsufficientFundsException.getSuppressed().length);
  }

  /**
   * Test {@link InsufficientFundsException#InsufficientFundsException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link InsufficientFundsException#InsufficientFundsException(String,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InsufficientFundsException.<init>()",
    "void InsufficientFundsException.<init>(String)",
    "void InsufficientFundsException.<init>(String, Throwable)",
    "void InsufficientFundsException.<init>(Throwable)"
  })
  public void testNewInsufficientFundsException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    InsufficientFundsException actualInsufficientFundsException =
        new InsufficientFundsException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualInsufficientFundsException.getMessage());
    assertEquals(0, actualInsufficientFundsException.getSuppressed().length);
    assertSame(cause, actualInsufficientFundsException.getCause());
  }

  /**
   * Test {@link InsufficientFundsException#InsufficientFundsException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link InsufficientFundsException#InsufficientFundsException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InsufficientFundsException.<init>()",
    "void InsufficientFundsException.<init>(String)",
    "void InsufficientFundsException.<init>(String, Throwable)",
    "void InsufficientFundsException.<init>(Throwable)"
  })
  public void testNewInsufficientFundsException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    InsufficientFundsException actualInsufficientFundsException =
        new InsufficientFundsException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualInsufficientFundsException.getMessage());
    assertEquals(0, actualInsufficientFundsException.getSuppressed().length);
    assertSame(cause, actualInsufficientFundsException.getCause());
  }

  /**
   * Test {@link InsufficientFundsException#InsufficientFundsException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InsufficientFundsException#InsufficientFundsException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InsufficientFundsException.<init>()",
    "void InsufficientFundsException.<init>(String)",
    "void InsufficientFundsException.<init>(String, Throwable)",
    "void InsufficientFundsException.<init>(Throwable)"
  })
  public void testNewInsufficientFundsException_thenReturnMessageIsNull() {
    // Arrange and Act
    InsufficientFundsException actualInsufficientFundsException = new InsufficientFundsException();

    // Assert
    assertNull(actualInsufficientFundsException.getMessage());
    assertNull(actualInsufficientFundsException.getCause());
    assertEquals(0, actualInsufficientFundsException.getSuppressed().length);
  }
}
