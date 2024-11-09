/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
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
