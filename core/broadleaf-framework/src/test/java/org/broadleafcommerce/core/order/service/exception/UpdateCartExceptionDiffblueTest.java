package org.broadleafcommerce.core.order.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class UpdateCartExceptionDiffblueTest {
  /**
   * Test {@link UpdateCartException#UpdateCartException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateCartException#UpdateCartException(String)}
   */
  @Test
  public void testNewUpdateCartException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    UpdateCartException actualUpdateCartException = new UpdateCartException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualUpdateCartException.getMessage());
    assertNull(actualUpdateCartException.getCause());
    assertEquals(0, actualUpdateCartException.getSuppressed().length);
  }

  /**
   * Test {@link UpdateCartException#UpdateCartException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UpdateCartException#UpdateCartException(String, Throwable)}
   */
  @Test
  public void testNewUpdateCartException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    UpdateCartException actualUpdateCartException = new UpdateCartException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualUpdateCartException.getMessage());
    assertEquals(0, actualUpdateCartException.getSuppressed().length);
    assertSame(cause, actualUpdateCartException.getCause());
  }

  /**
   * Test {@link UpdateCartException#UpdateCartException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateCartException#UpdateCartException()}
   */
  @Test
  public void testNewUpdateCartException_thenReturnMessageIsNull() {
    // Arrange and Act
    UpdateCartException actualUpdateCartException = new UpdateCartException();

    // Assert
    assertNull(actualUpdateCartException.getMessage());
    assertNull(actualUpdateCartException.getCause());
    assertEquals(0, actualUpdateCartException.getSuppressed().length);
  }

  /**
   * Test {@link UpdateCartException#UpdateCartException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateCartException#UpdateCartException(Throwable)}
   */
  @Test
  public void testNewUpdateCartException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    UpdateCartException actualUpdateCartException = new UpdateCartException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualUpdateCartException.getMessage());
    assertEquals(0, actualUpdateCartException.getSuppressed().length);
    assertSame(cause, actualUpdateCartException.getCause());
  }
}
