/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {WorkflowException.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class WorkflowExceptionDiffblueTest {
  @Autowired
  private WorkflowException workflowException;

  /**
   * Method under test: {@link WorkflowException#WorkflowException()}
   */
  @Test
  public void testNewWorkflowException() {
    // Arrange and Act
    WorkflowException actualWorkflowException = new WorkflowException();

    // Assert
    assertNull(actualWorkflowException.getMessage());
    assertNull(actualWorkflowException.getCause());
    assertNull(actualWorkflowException.getRootCause());
    assertEquals(0, actualWorkflowException.getSuppressed().length);
  }

  /**
   * Method under test: {@link WorkflowException#WorkflowException(Throwable)}
   */
  @Test
  public void testNewWorkflowException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WorkflowException actualWorkflowException = new WorkflowException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualWorkflowException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualWorkflowException.getMessage());
    assertNull(actualWorkflowException.getRootCauseMessage());
    assertEquals(0, actualWorkflowException.getSuppressed().length);
    assertSame(cause, actualWorkflowException.getCause());
    assertSame(cause, actualWorkflowException.getRootCause());
  }

  /**
   * Method under test: {@link WorkflowException#WorkflowException(Throwable)}
   */
  @Test
  public void testNewWorkflowException3() {
    // Arrange and Act
    WorkflowException actualWorkflowException = new WorkflowException((Throwable) null);

    // Assert
    assertNull(actualWorkflowException.getLocalizedMessage());
    assertNull(actualWorkflowException.getMessage());
    assertNull(actualWorkflowException.getRootCauseMessage());
    assertNull(actualWorkflowException.getCause());
    assertNull(actualWorkflowException.getRootCause());
    assertEquals(0, actualWorkflowException.getSuppressed().length);
  }

  /**
   * Method under test: {@link WorkflowException#WorkflowException(Throwable)}
   */
  @Test
  public void testNewWorkflowException4() {
    // Arrange
    Throwable cause = new Throwable();
    Throwable throwable = new Throwable();
    cause.initCause(throwable);

    // Act
    WorkflowException actualWorkflowException = new WorkflowException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualWorkflowException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualWorkflowException.getMessage());
    assertNull(actualWorkflowException.getRootCauseMessage());
    assertEquals(0, actualWorkflowException.getSuppressed().length);
    assertSame(cause, actualWorkflowException.getCause());
    assertSame(throwable, actualWorkflowException.getRootCause());
  }

  /**
   * Method under test: {@link WorkflowException#WorkflowException(String)}
   */
  @Test
  public void testNewWorkflowException5() {
    // Arrange and Act
    WorkflowException actualWorkflowException = new WorkflowException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualWorkflowException.getLocalizedMessage());
    assertEquals("An error occurred", actualWorkflowException.getMessage());
    assertEquals("An error occurred", actualWorkflowException.getRootCauseMessage());
    assertNull(actualWorkflowException.getCause());
    assertEquals(0, actualWorkflowException.getSuppressed().length);
    assertSame(actualWorkflowException, actualWorkflowException.getRootCause());
  }

  /**
   * Method under test:
   * {@link WorkflowException#WorkflowException(String, Throwable)}
   */
  @Test
  public void testNewWorkflowException6() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WorkflowException actualWorkflowException = new WorkflowException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualWorkflowException.getLocalizedMessage());
    assertEquals("An error occurred", actualWorkflowException.getMessage());
    assertNull(actualWorkflowException.getRootCauseMessage());
    assertEquals(0, actualWorkflowException.getSuppressed().length);
    assertSame(cause, actualWorkflowException.getCause());
    assertSame(cause, actualWorkflowException.getRootCause());
  }

  /**
   * Method under test:
   * {@link WorkflowException#WorkflowException(String, Throwable)}
   */
  @Test
  public void testNewWorkflowException7() {
    // Arrange and Act
    WorkflowException actualWorkflowException = new WorkflowException("An error occurred", null);

    // Assert
    assertEquals("An error occurred", actualWorkflowException.getLocalizedMessage());
    assertEquals("An error occurred", actualWorkflowException.getMessage());
    assertEquals("An error occurred", actualWorkflowException.getRootCauseMessage());
    assertNull(actualWorkflowException.getCause());
    assertEquals(0, actualWorkflowException.getSuppressed().length);
    assertSame(actualWorkflowException, actualWorkflowException.getRootCause());
  }

  /**
   * Method under test:
   * {@link WorkflowException#WorkflowException(String, Throwable)}
   */
  @Test
  public void testNewWorkflowException8() {
    // Arrange
    Throwable throwable = new Throwable();
    IOException cause = new IOException("foo", throwable);

    // Act
    WorkflowException actualWorkflowException = new WorkflowException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualWorkflowException.getLocalizedMessage());
    assertEquals("An error occurred", actualWorkflowException.getMessage());
    assertNull(actualWorkflowException.getRootCauseMessage());
    assertEquals(0, actualWorkflowException.getSuppressed().length);
    assertSame(cause, actualWorkflowException.getCause());
    assertSame(throwable, actualWorkflowException.getRootCause());
  }
}
