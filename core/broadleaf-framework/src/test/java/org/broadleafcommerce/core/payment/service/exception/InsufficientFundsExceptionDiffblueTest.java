package org.broadleafcommerce.core.payment.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class InsufficientFundsExceptionDiffblueTest {
  /**
   * Test {@link InsufficientFundsException#InsufficientFundsException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InsufficientFundsException#InsufficientFundsException(String)}
   */
  @Test
  public void testNewInsufficientFundsException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    InsufficientFundsException actualInsufficientFundsException = new InsufficientFundsException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualInsufficientFundsException.getMessage());
    assertNull(actualInsufficientFundsException.getCause());
    assertEquals(0, actualInsufficientFundsException.getSuppressed().length);
  }

  /**
   * Test
   * {@link InsufficientFundsException#InsufficientFundsException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InsufficientFundsException#InsufficientFundsException(String, Throwable)}
   */
  @Test
  public void testNewInsufficientFundsException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    InsufficientFundsException actualInsufficientFundsException = new InsufficientFundsException("An error occurred",
        cause);

    // Assert
    assertEquals("An error occurred", actualInsufficientFundsException.getMessage());
    assertEquals(0, actualInsufficientFundsException.getSuppressed().length);
    assertSame(cause, actualInsufficientFundsException.getCause());
  }

  /**
   * Test
   * {@link InsufficientFundsException#InsufficientFundsException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InsufficientFundsException#InsufficientFundsException(Throwable)}
   */
  @Test
  public void testNewInsufficientFundsException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    InsufficientFundsException actualInsufficientFundsException = new InsufficientFundsException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualInsufficientFundsException.getMessage());
    assertEquals(0, actualInsufficientFundsException.getSuppressed().length);
    assertSame(cause, actualInsufficientFundsException.getCause());
  }

  /**
   * Test {@link InsufficientFundsException#InsufficientFundsException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InsufficientFundsException#InsufficientFundsException()}
   */
  @Test
  public void testNewInsufficientFundsException_thenReturnMessageIsNull() {
    // Arrange and Act
    InsufficientFundsException actualInsufficientFundsException = new InsufficientFundsException();

    // Assert
    assertNull(actualInsufficientFundsException.getMessage());
    assertNull(actualInsufficientFundsException.getCause());
    assertEquals(0, actualInsufficientFundsException.getSuppressed().length);
  }
}
