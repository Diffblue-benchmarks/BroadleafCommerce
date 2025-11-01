/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
   * Method under test:
   * {@link WorkflowRuntimeException#WorkflowRuntimeException()}
   */
  @Test
  public void testNewWorkflowRuntimeException() {
    // Arrange and Act
    WorkflowRuntimeException actualWorkflowRuntimeException = new WorkflowRuntimeException();

    // Assert
    assertNull(actualWorkflowRuntimeException.getMessage());
    assertNull(actualWorkflowRuntimeException.getCause());
    assertEquals(0, actualWorkflowRuntimeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link WorkflowRuntimeException#WorkflowRuntimeException(String)}
   */
  @Test
  public void testNewWorkflowRuntimeException2() {
    // Arrange and Act
    WorkflowRuntimeException actualWorkflowRuntimeException = new WorkflowRuntimeException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualWorkflowRuntimeException.getMessage());
    assertNull(actualWorkflowRuntimeException.getCause());
    assertEquals(0, actualWorkflowRuntimeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link WorkflowRuntimeException#WorkflowRuntimeException(String, Throwable)}
   */
  @Test
  public void testNewWorkflowRuntimeException3() {
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
   * Method under test:
   * {@link WorkflowRuntimeException#WorkflowRuntimeException(Throwable)}
   */
  @Test
  public void testNewWorkflowRuntimeException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WorkflowRuntimeException actualWorkflowRuntimeException = new WorkflowRuntimeException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualWorkflowRuntimeException.getMessage());
    assertEquals(0, actualWorkflowRuntimeException.getSuppressed().length);
    assertSame(cause, actualWorkflowRuntimeException.getCause());
  }
}
