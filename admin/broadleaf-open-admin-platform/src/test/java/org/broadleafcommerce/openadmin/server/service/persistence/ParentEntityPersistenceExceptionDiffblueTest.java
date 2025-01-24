package org.broadleafcommerce.openadmin.server.service.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ParentEntityPersistenceExceptionDiffblueTest {
  /**
   * Test
   * {@link ParentEntityPersistenceException#ParentEntityPersistenceException(String)}.
   * <ul>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ParentEntityPersistenceException#ParentEntityPersistenceException(String)}
   */
  @Test
  public void testNewParentEntityPersistenceException_thenReturnCauseIsNull() {
    // Arrange and Act
    ParentEntityPersistenceException actualParentEntityPersistenceException = new ParentEntityPersistenceException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualParentEntityPersistenceException.getMessage());
    assertNull(actualParentEntityPersistenceException.getCause());
    assertEquals(0, actualParentEntityPersistenceException.getSuppressed().length);
  }

  /**
   * Test
   * {@link ParentEntityPersistenceException#ParentEntityPersistenceException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ParentEntityPersistenceException#ParentEntityPersistenceException(String, Throwable)}
   */
  @Test
  public void testNewParentEntityPersistenceException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ParentEntityPersistenceException actualParentEntityPersistenceException = new ParentEntityPersistenceException(
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualParentEntityPersistenceException.getMessage());
    assertEquals(0, actualParentEntityPersistenceException.getSuppressed().length);
    assertSame(cause, actualParentEntityPersistenceException.getCause());
  }

  /**
   * Test
   * {@link ParentEntityPersistenceException#ParentEntityPersistenceException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ParentEntityPersistenceException#ParentEntityPersistenceException(Throwable)}
   */
  @Test
  public void testNewParentEntityPersistenceException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ParentEntityPersistenceException actualParentEntityPersistenceException = new ParentEntityPersistenceException(
        cause);

    // Assert
    assertEquals("java.lang.Throwable", actualParentEntityPersistenceException.getMessage());
    assertEquals(0, actualParentEntityPersistenceException.getSuppressed().length);
    assertSame(cause, actualParentEntityPersistenceException.getCause());
  }
}
