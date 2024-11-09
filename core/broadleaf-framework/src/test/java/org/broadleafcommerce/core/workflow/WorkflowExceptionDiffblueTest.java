/*-
 * #%L
 * BroadleafCommerce Framework
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
   * Test {@link WorkflowException#WorkflowException()}.
   * <p>
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
   * Test {@link WorkflowException#WorkflowException(String)}.
   * <p>
   * Method under test: {@link WorkflowException#WorkflowException(String)}
   */
  @Test
  public void testNewWorkflowException2() {
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
   * Test {@link WorkflowException#WorkflowException(Throwable)}.
   * <ul>
   *   <li>Then return LocalizedMessage is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WorkflowException#WorkflowException(Throwable)}
   */
  @Test
  public void testNewWorkflowException_thenReturnLocalizedMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WorkflowException actualWorkflowException = new WorkflowException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualWorkflowException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualWorkflowException.getMessage());
    assertSame(cause, actualWorkflowException.getCause());
    assertSame(cause, actualWorkflowException.getRootCause());
  }

  /**
   * Test {@link WorkflowException#WorkflowException(Throwable)}.
   * <ul>
   *   <li>Then return RootCause LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WorkflowException#WorkflowException(Throwable)}
   */
  @Test
  public void testNewWorkflowException_thenReturnRootCauseLocalizedMessageIsNull() {
    // Arrange
    Throwable cause = new Throwable();
    Throwable throwable = new Throwable();
    cause.initCause(throwable);

    // Act
    WorkflowException actualWorkflowException = new WorkflowException(cause);

    // Assert
    Throwable rootCause = actualWorkflowException.getRootCause();
    assertNull(rootCause.getLocalizedMessage());
    assertNull(rootCause.getMessage());
    assertNull(rootCause.getCause());
    assertSame(throwable, actualWorkflowException.getCause().getCause());
  }

  /**
   * Test {@link WorkflowException#WorkflowException(String, Throwable)}.
   * <ul>
   *   <li>Then return RootCause LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WorkflowException#WorkflowException(String, Throwable)}
   */
  @Test
  public void testNewWorkflowException_thenReturnRootCauseLocalizedMessageIsNull2() {
    // Arrange
    IOException cause = new IOException("foo", new Throwable());

    // Act
    WorkflowException actualWorkflowException = new WorkflowException("An error occurred", cause);

    // Assert
    Throwable rootCause = actualWorkflowException.getRootCause();
    assertNull(rootCause.getLocalizedMessage());
    assertNull(rootCause.getMessage());
    assertNull(rootCause.getCause());
    assertSame(cause, actualWorkflowException.getCause());
  }

  /**
   * Test {@link WorkflowException#WorkflowException(String, Throwable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return LocalizedMessage is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WorkflowException#WorkflowException(String, Throwable)}
   */
  @Test
  public void testNewWorkflowException_whenNull_thenReturnLocalizedMessageIsAnErrorOccurred() {
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
   * Test {@link WorkflowException#WorkflowException(Throwable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WorkflowException#WorkflowException(Throwable)}
   */
  @Test
  public void testNewWorkflowException_whenNull_thenReturnLocalizedMessageIsNull() {
    // Arrange and Act
    WorkflowException actualWorkflowException = new WorkflowException((Throwable) null);

    // Assert
    assertNull(actualWorkflowException.getLocalizedMessage());
    assertNull(actualWorkflowException.getMessage());
    assertNull(actualWorkflowException.getCause());
    assertNull(actualWorkflowException.getRootCause());
  }

  /**
   * Test {@link WorkflowException#WorkflowException(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WorkflowException#WorkflowException(String, Throwable)}
   */
  @Test
  public void testNewWorkflowException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WorkflowException actualWorkflowException = new WorkflowException("An error occurred", cause);

    // Assert
    Throwable cause2 = actualWorkflowException.getCause();
    assertSame(cause, cause2);
    assertSame(cause2, actualWorkflowException.getRootCause());
  }
}
