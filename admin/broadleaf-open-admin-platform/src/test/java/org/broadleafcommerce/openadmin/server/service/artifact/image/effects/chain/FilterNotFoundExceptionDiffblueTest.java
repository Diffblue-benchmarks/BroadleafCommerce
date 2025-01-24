package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class FilterNotFoundExceptionDiffblueTest {
  /**
   * Test {@link FilterNotFoundException#FilterNotFoundException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterNotFoundException#FilterNotFoundException(String)}
   */
  @Test
  public void testNewFilterNotFoundException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    FilterNotFoundException actualFilterNotFoundException = new FilterNotFoundException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualFilterNotFoundException.getMessage());
    assertNull(actualFilterNotFoundException.getCause());
    assertEquals(0, actualFilterNotFoundException.getSuppressed().length);
  }

  /**
   * Test
   * {@link FilterNotFoundException#FilterNotFoundException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterNotFoundException#FilterNotFoundException(String, Throwable)}
   */
  @Test
  public void testNewFilterNotFoundException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    FilterNotFoundException actualFilterNotFoundException = new FilterNotFoundException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualFilterNotFoundException.getMessage());
    assertEquals(0, actualFilterNotFoundException.getSuppressed().length);
    assertSame(cause, actualFilterNotFoundException.getCause());
  }

  /**
   * Test {@link FilterNotFoundException#FilterNotFoundException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FilterNotFoundException#FilterNotFoundException(Throwable)}
   */
  @Test
  public void testNewFilterNotFoundException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    FilterNotFoundException actualFilterNotFoundException = new FilterNotFoundException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualFilterNotFoundException.getMessage());
    assertEquals(0, actualFilterNotFoundException.getSuppressed().length);
    assertSame(cause, actualFilterNotFoundException.getCause());
  }

  /**
   * Test {@link FilterNotFoundException#FilterNotFoundException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterNotFoundException#FilterNotFoundException()}
   */
  @Test
  public void testNewFilterNotFoundException_thenReturnMessageIsNull() {
    // Arrange and Act
    FilterNotFoundException actualFilterNotFoundException = new FilterNotFoundException();

    // Assert
    assertNull(actualFilterNotFoundException.getMessage());
    assertNull(actualFilterNotFoundException.getCause());
    assertEquals(0, actualFilterNotFoundException.getSuppressed().length);
  }
}
