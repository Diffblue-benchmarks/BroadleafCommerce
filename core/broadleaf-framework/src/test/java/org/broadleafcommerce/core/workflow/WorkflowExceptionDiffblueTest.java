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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {WorkflowException.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class WorkflowExceptionDiffblueTest {
  @Autowired
  private WorkflowException workflowException;

  /**
   * Test {@link WorkflowException#WorkflowException()}.
   * <p>
   * Method under test: {@link WorkflowException#WorkflowException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WorkflowException.<init>()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WorkflowException.<init>(String)"})
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
   *   <li>Then return LocalizedMessage is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WorkflowException#WorkflowException(Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WorkflowException.<init>(Throwable)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WorkflowException.<init>(Throwable)"})
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
   * Method under test: {@link WorkflowException#WorkflowException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WorkflowException.<init>(String, Throwable)"})
  public void testNewWorkflowException_thenReturnRootCauseLocalizedMessageIsNull2() {
    // Arrange
    Throwable cause = new Throwable();
    Throwable throwable = new Throwable();
    cause.initCause(throwable);

    // Act
    WorkflowException actualWorkflowException = new WorkflowException("An error occurred", cause);

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
   *   <li>When {@code null}.</li>
   *   <li>Then return LocalizedMessage is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WorkflowException#WorkflowException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WorkflowException.<init>(String, Throwable)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WorkflowException.<init>(Throwable)"})
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
   *   <li>Then return RootCauseMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WorkflowException#WorkflowException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WorkflowException.<init>(String, Throwable)"})
  public void testNewWorkflowException_whenThrowable_thenReturnRootCauseMessageIsNull() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    WorkflowException actualWorkflowException = new WorkflowException("An error occurred", cause);

    // Assert
    assertNull(actualWorkflowException.getRootCauseMessage());
    assertSame(cause, actualWorkflowException.getCause());
    assertSame(cause, actualWorkflowException.getRootCause());
  }
}
