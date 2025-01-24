package org.broadleafcommerce.core.order.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class OrderServiceExceptionDiffblueTest {
  /**
   * Test {@link OrderServiceException#OrderServiceException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceException#OrderServiceException(String)}
   */
  @Test
  public void testNewOrderServiceException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    OrderServiceException actualOrderServiceException = new OrderServiceException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualOrderServiceException.getMessage());
    assertNull(actualOrderServiceException.getCause());
    assertEquals(0, actualOrderServiceException.getSuppressed().length);
  }

  /**
   * Test {@link OrderServiceException#OrderServiceException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceException#OrderServiceException(String, Throwable)}
   */
  @Test
  public void testNewOrderServiceException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OrderServiceException actualOrderServiceException = new OrderServiceException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualOrderServiceException.getMessage());
    assertEquals(0, actualOrderServiceException.getSuppressed().length);
    assertSame(cause, actualOrderServiceException.getCause());
  }

  /**
   * Test {@link OrderServiceException#OrderServiceException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceException#OrderServiceException()}
   */
  @Test
  public void testNewOrderServiceException_thenReturnMessageIsNull() {
    // Arrange and Act
    OrderServiceException actualOrderServiceException = new OrderServiceException();

    // Assert
    assertNull(actualOrderServiceException.getMessage());
    assertNull(actualOrderServiceException.getCause());
    assertEquals(0, actualOrderServiceException.getSuppressed().length);
  }

  /**
   * Test {@link OrderServiceException#OrderServiceException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceException#OrderServiceException(Throwable)}
   */
  @Test
  public void testNewOrderServiceException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OrderServiceException actualOrderServiceException = new OrderServiceException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualOrderServiceException.getMessage());
    assertEquals(0, actualOrderServiceException.getSuppressed().length);
    assertSame(cause, actualOrderServiceException.getCause());
  }
}
