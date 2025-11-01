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
package org.broadleafcommerce.core.workflow.state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.checkout.service.workflow.CommitTaxActivity;
import org.broadleafcommerce.core.checkout.service.workflow.CommitTaxRollbackHandler;
import org.broadleafcommerce.core.workflow.Activity;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RollbackFailureException.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RollbackFailureExceptionDiffblueTest {
  @Autowired
  private RollbackFailureException rollbackFailureException;

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RollbackFailureException#RollbackFailureException()}
   *   <li>{@link RollbackFailureException#setActivity(Activity)}
   *   <li>{@link RollbackFailureException#setOriginalWorkflowException(Throwable)}
   *   <li>{@link RollbackFailureException#setProcessContext(ProcessContext)}
   *   <li>{@link RollbackFailureException#setStateItems(Map)}
   *   <li>{@link RollbackFailureException#getActivity()}
   *   <li>{@link RollbackFailureException#getOriginalWorkflowException()}
   *   <li>{@link RollbackFailureException#getProcessContext()}
   *   <li>{@link RollbackFailureException#getStateItems()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());
    actualRollbackFailureException.setActivity(activity);
    Throwable originalWorkflowException = new Throwable();
    actualRollbackFailureException.setOriginalWorkflowException(originalWorkflowException);
    DefaultProcessContextImpl<?> processContext = new DefaultProcessContextImpl<>();
    actualRollbackFailureException.setProcessContext(processContext);
    HashMap<String, Object> stateItems = new HashMap<>();
    actualRollbackFailureException.setStateItems(stateItems);
    Activity<? extends ProcessContext<?>> actualActivity = actualRollbackFailureException.getActivity();
    Throwable actualOriginalWorkflowException = actualRollbackFailureException.getOriginalWorkflowException();
    ProcessContext<?> actualProcessContext = actualRollbackFailureException.getProcessContext();
    Map<String, Object> actualStateItems = actualRollbackFailureException.getStateItems();

    // Assert that nothing has changed
    assertEquals(0, actualRollbackFailureException.getSuppressed().length);
    assertTrue(actualStateItems.isEmpty());
    assertSame(originalWorkflowException, actualOriginalWorkflowException);
    assertSame(stateItems, actualStateItems);
    assertSame(activity, actualActivity);
    assertSame(processContext, actualProcessContext);
  }

  /**
   * Method under test:
   * {@link RollbackFailureException#RollbackFailureException(Throwable)}
   */
  @Test
  public void testNewRollbackFailureException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualRollbackFailureException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRollbackFailureException.getMessage());
    assertNull(actualRollbackFailureException.getRootCauseMessage());
    assertNull(actualRollbackFailureException.getOriginalWorkflowException());
    assertNull(actualRollbackFailureException.getStateItems());
    assertNull(actualRollbackFailureException.getActivity());
    assertNull(actualRollbackFailureException.getProcessContext());
    assertEquals(0, actualRollbackFailureException.getSuppressed().length);
    assertSame(cause, actualRollbackFailureException.getCause());
    assertSame(cause, actualRollbackFailureException.getRootCause());
  }

  /**
   * Method under test:
   * {@link RollbackFailureException#RollbackFailureException(Throwable)}
   */
  @Test
  public void testNewRollbackFailureException2() {
    // Arrange and Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException((Throwable) null);

    // Assert
    assertNull(actualRollbackFailureException.getLocalizedMessage());
    assertNull(actualRollbackFailureException.getMessage());
    assertNull(actualRollbackFailureException.getRootCauseMessage());
    assertNull(actualRollbackFailureException.getCause());
    assertNull(actualRollbackFailureException.getRootCause());
    assertNull(actualRollbackFailureException.getOriginalWorkflowException());
    assertNull(actualRollbackFailureException.getStateItems());
    assertNull(actualRollbackFailureException.getActivity());
    assertNull(actualRollbackFailureException.getProcessContext());
    assertEquals(0, actualRollbackFailureException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link RollbackFailureException#RollbackFailureException(Throwable)}
   */
  @Test
  public void testNewRollbackFailureException3() {
    // Arrange
    Throwable cause = new Throwable();
    Throwable throwable = new Throwable();
    cause.initCause(throwable);

    // Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualRollbackFailureException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRollbackFailureException.getMessage());
    assertNull(actualRollbackFailureException.getRootCauseMessage());
    assertNull(actualRollbackFailureException.getOriginalWorkflowException());
    assertNull(actualRollbackFailureException.getStateItems());
    assertNull(actualRollbackFailureException.getActivity());
    assertNull(actualRollbackFailureException.getProcessContext());
    assertEquals(0, actualRollbackFailureException.getSuppressed().length);
    assertSame(cause, actualRollbackFailureException.getCause());
    assertSame(throwable, actualRollbackFailureException.getRootCause());
  }

  /**
   * Method under test:
   * {@link RollbackFailureException#RollbackFailureException(Throwable, Throwable)}
   */
  @Test
  public void testNewRollbackFailureException4() {
    // Arrange
    Throwable rollbackFailureCause = new Throwable();
    Throwable originalWorkflowException = new Throwable();

    // Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException(rollbackFailureCause,
        originalWorkflowException);

    // Assert
    assertEquals("java.lang.Throwable", actualRollbackFailureException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRollbackFailureException.getMessage());
    assertNull(actualRollbackFailureException.getRootCauseMessage());
    assertNull(actualRollbackFailureException.getStateItems());
    assertNull(actualRollbackFailureException.getActivity());
    assertNull(actualRollbackFailureException.getProcessContext());
    assertEquals(0, actualRollbackFailureException.getSuppressed().length);
    assertSame(rollbackFailureCause, actualRollbackFailureException.getCause());
    assertSame(rollbackFailureCause, actualRollbackFailureException.getRootCause());
    assertSame(originalWorkflowException, actualRollbackFailureException.getOriginalWorkflowException());
  }

  /**
   * Method under test:
   * {@link RollbackFailureException#RollbackFailureException(Throwable, Throwable)}
   */
  @Test
  public void testNewRollbackFailureException5() {
    // Arrange
    Throwable originalWorkflowException = new Throwable();

    // Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException((Throwable) null,
        originalWorkflowException);

    // Assert
    assertNull(actualRollbackFailureException.getLocalizedMessage());
    assertNull(actualRollbackFailureException.getMessage());
    assertNull(actualRollbackFailureException.getRootCauseMessage());
    assertNull(actualRollbackFailureException.getCause());
    assertNull(actualRollbackFailureException.getRootCause());
    assertNull(actualRollbackFailureException.getStateItems());
    assertNull(actualRollbackFailureException.getActivity());
    assertNull(actualRollbackFailureException.getProcessContext());
    assertEquals(0, actualRollbackFailureException.getSuppressed().length);
    assertSame(originalWorkflowException, actualRollbackFailureException.getOriginalWorkflowException());
  }

  /**
   * Method under test:
   * {@link RollbackFailureException#RollbackFailureException(Throwable, Throwable)}
   */
  @Test
  public void testNewRollbackFailureException6() {
    // Arrange
    Throwable rollbackFailureCause = new Throwable();
    Throwable throwable = new Throwable();
    rollbackFailureCause.initCause(throwable);
    Throwable originalWorkflowException = new Throwable();

    // Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException(rollbackFailureCause,
        originalWorkflowException);

    // Assert
    assertEquals("java.lang.Throwable", actualRollbackFailureException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRollbackFailureException.getMessage());
    assertNull(actualRollbackFailureException.getRootCauseMessage());
    assertNull(actualRollbackFailureException.getStateItems());
    assertNull(actualRollbackFailureException.getActivity());
    assertNull(actualRollbackFailureException.getProcessContext());
    assertEquals(0, actualRollbackFailureException.getSuppressed().length);
    assertSame(rollbackFailureCause, actualRollbackFailureException.getCause());
    assertSame(throwable, actualRollbackFailureException.getRootCause());
    assertSame(originalWorkflowException, actualRollbackFailureException.getOriginalWorkflowException());
  }

  /**
   * Method under test:
   * {@link RollbackFailureException#RollbackFailureException(String)}
   */
  @Test
  public void testNewRollbackFailureException7() {
    // Arrange and Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualRollbackFailureException.getLocalizedMessage());
    assertEquals("An error occurred", actualRollbackFailureException.getMessage());
    assertEquals("An error occurred", actualRollbackFailureException.getRootCauseMessage());
    assertNull(actualRollbackFailureException.getCause());
    assertNull(actualRollbackFailureException.getOriginalWorkflowException());
    assertNull(actualRollbackFailureException.getStateItems());
    assertNull(actualRollbackFailureException.getActivity());
    assertNull(actualRollbackFailureException.getProcessContext());
    assertEquals(0, actualRollbackFailureException.getSuppressed().length);
    assertSame(actualRollbackFailureException, actualRollbackFailureException.getRootCause());
  }

  /**
   * Method under test:
   * {@link RollbackFailureException#RollbackFailureException(String, Throwable)}
   */
  @Test
  public void testNewRollbackFailureException8() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualRollbackFailureException.getLocalizedMessage());
    assertEquals("An error occurred", actualRollbackFailureException.getMessage());
    assertNull(actualRollbackFailureException.getRootCauseMessage());
    assertNull(actualRollbackFailureException.getOriginalWorkflowException());
    assertNull(actualRollbackFailureException.getStateItems());
    assertNull(actualRollbackFailureException.getActivity());
    assertNull(actualRollbackFailureException.getProcessContext());
    assertEquals(0, actualRollbackFailureException.getSuppressed().length);
    assertSame(cause, actualRollbackFailureException.getCause());
    assertSame(cause, actualRollbackFailureException.getRootCause());
  }

  /**
   * Method under test:
   * {@link RollbackFailureException#RollbackFailureException(String, Throwable)}
   */
  @Test
  public void testNewRollbackFailureException9() {
    // Arrange and Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException("An error occurred", null);

    // Assert
    assertEquals("An error occurred", actualRollbackFailureException.getLocalizedMessage());
    assertEquals("An error occurred", actualRollbackFailureException.getMessage());
    assertEquals("An error occurred", actualRollbackFailureException.getRootCauseMessage());
    assertNull(actualRollbackFailureException.getCause());
    assertNull(actualRollbackFailureException.getOriginalWorkflowException());
    assertNull(actualRollbackFailureException.getStateItems());
    assertNull(actualRollbackFailureException.getActivity());
    assertNull(actualRollbackFailureException.getProcessContext());
    assertEquals(0, actualRollbackFailureException.getSuppressed().length);
    assertSame(actualRollbackFailureException, actualRollbackFailureException.getRootCause());
  }

  /**
   * Method under test:
   * {@link RollbackFailureException#RollbackFailureException(String, Throwable)}
   */
  @Test
  public void testNewRollbackFailureException10() {
    // Arrange
    Throwable throwable = new Throwable();
    IOException cause = new IOException("foo", throwable);

    // Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualRollbackFailureException.getLocalizedMessage());
    assertEquals("An error occurred", actualRollbackFailureException.getMessage());
    assertNull(actualRollbackFailureException.getRootCauseMessage());
    assertNull(actualRollbackFailureException.getOriginalWorkflowException());
    assertNull(actualRollbackFailureException.getStateItems());
    assertNull(actualRollbackFailureException.getActivity());
    assertNull(actualRollbackFailureException.getProcessContext());
    assertEquals(0, actualRollbackFailureException.getSuppressed().length);
    assertSame(cause, actualRollbackFailureException.getCause());
    assertSame(throwable, actualRollbackFailureException.getRootCause());
  }
}
