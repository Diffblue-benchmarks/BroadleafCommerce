package org.broadleafcommerce.openadmin.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class WorkflowRuntimeExceptionDiffblueTest {
  /**
   * Test {@link WorkflowRuntimeException#WorkflowRuntimeException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WorkflowRuntimeException#WorkflowRuntimeException(String)}
   */
  @Test
  public void testNewWorkflowRuntimeException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    WorkflowRuntimeException actualWorkflowRuntimeException = new WorkflowRuntimeException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualWorkflowRuntimeException.getMessage());
    assertNull(actualWorkflowRuntimeException.getCause());
    assertEquals(0, actualWorkflowRuntimeException.getSuppressed().length);
  }

  /**
   * Test
   * {@link WorkflowRuntimeException#WorkflowRuntimeException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WorkflowRuntimeException#WorkflowRuntimeException(String, Throwable)}
   */
  @Test
  public void testNewWorkflowRuntimeException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WorkflowRuntimeException actualWorkflowRuntimeException = new WorkflowRuntimeException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualWorkflowRuntimeException.getMessage());
    assertEquals(0, actualWorkflowRuntimeException.getSuppressed().length);
    assertSame(cause, actualWorkflowRuntimeException.getCause());
  }

  /**
   * Test {@link WorkflowRuntimeException#WorkflowRuntimeException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WorkflowRuntimeException#WorkflowRuntimeException(Throwable)}
   */
  @Test
  public void testNewWorkflowRuntimeException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WorkflowRuntimeException actualWorkflowRuntimeException = new WorkflowRuntimeException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualWorkflowRuntimeException.getMessage());
    assertEquals(0, actualWorkflowRuntimeException.getSuppressed().length);
    assertSame(cause, actualWorkflowRuntimeException.getCause());
  }

  /**
   * Test {@link WorkflowRuntimeException#WorkflowRuntimeException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WorkflowRuntimeException#WorkflowRuntimeException()}
   */
  @Test
  public void testNewWorkflowRuntimeException_thenReturnMessageIsNull() {
    // Arrange and Act
    WorkflowRuntimeException actualWorkflowRuntimeException = new WorkflowRuntimeException();

    // Assert
    assertNull(actualWorkflowRuntimeException.getMessage());
    assertNull(actualWorkflowRuntimeException.getCause());
    assertEquals(0, actualWorkflowRuntimeException.getSuppressed().length);
  }
}
