package org.broadleafcommerce.core.web.order.security.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderLockAcquisitionFailureExceptionDiffblueTest {
  /**
   * Test
   * {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(String)}
   */
  @Test
  @DisplayName("Test new OrderLockAcquisitionFailureException(String); then return Message is 'An error occurred'")
  void testNewOrderLockAcquisitionFailureException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    OrderLockAcquisitionFailureException actualOrderLockAcquisitionFailureException = new OrderLockAcquisitionFailureException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualOrderLockAcquisitionFailureException.getMessage());
    assertNull(actualOrderLockAcquisitionFailureException.getCause());
    assertEquals(0, actualOrderLockAcquisitionFailureException.getSuppressed().length);
  }

  /**
   * Test
   * {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new OrderLockAcquisitionFailureException(String, Throwable); then return Message is 'An error occurred'")
  void testNewOrderLockAcquisitionFailureException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OrderLockAcquisitionFailureException actualOrderLockAcquisitionFailureException = new OrderLockAcquisitionFailureException(
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualOrderLockAcquisitionFailureException.getMessage());
    assertEquals(0, actualOrderLockAcquisitionFailureException.getSuppressed().length);
    assertSame(cause, actualOrderLockAcquisitionFailureException.getCause());
  }

  /**
   * Test
   * {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException(Throwable)}
   */
  @Test
  @DisplayName("Test new OrderLockAcquisitionFailureException(Throwable); then return Message is 'java.lang.Throwable'")
  void testNewOrderLockAcquisitionFailureException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OrderLockAcquisitionFailureException actualOrderLockAcquisitionFailureException = new OrderLockAcquisitionFailureException(
        cause);

    // Assert
    assertEquals("java.lang.Throwable", actualOrderLockAcquisitionFailureException.getMessage());
    assertEquals(0, actualOrderLockAcquisitionFailureException.getSuppressed().length);
    assertSame(cause, actualOrderLockAcquisitionFailureException.getCause());
  }

  /**
   * Test
   * {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderLockAcquisitionFailureException#OrderLockAcquisitionFailureException()}
   */
  @Test
  @DisplayName("Test new OrderLockAcquisitionFailureException(); then return Message is 'null'")
  void testNewOrderLockAcquisitionFailureException_thenReturnMessageIsNull() {
    // Arrange and Act
    OrderLockAcquisitionFailureException actualOrderLockAcquisitionFailureException = new OrderLockAcquisitionFailureException();

    // Assert
    assertNull(actualOrderLockAcquisitionFailureException.getMessage());
    assertNull(actualOrderLockAcquisitionFailureException.getCause());
    assertEquals(0, actualOrderLockAcquisitionFailureException.getSuppressed().length);
  }
}
