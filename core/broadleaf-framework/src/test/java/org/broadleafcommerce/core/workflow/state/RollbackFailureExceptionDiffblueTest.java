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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.checkout.service.workflow.CommitTaxActivity;
import org.broadleafcommerce.core.checkout.service.workflow.CommitTaxRollbackHandler;
import org.broadleafcommerce.core.workflow.Activity;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RollbackFailureException.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class RollbackFailureExceptionDiffblueTest {
  @Autowired
  private RollbackFailureException rollbackFailureException;

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RollbackFailureException.<init>()", "Activity RollbackFailureException.getActivity()",
      "Throwable RollbackFailureException.getOriginalWorkflowException()",
      "ProcessContext RollbackFailureException.getProcessContext()", "Map RollbackFailureException.getStateItems()",
      "void RollbackFailureException.setActivity(Activity)",
      "void RollbackFailureException.setOriginalWorkflowException(Throwable)",
      "void RollbackFailureException.setProcessContext(ProcessContext)",
      "void RollbackFailureException.setStateItems(Map)"})
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

    // Assert
    assertNull(actualRollbackFailureException.getMessage());
    assertNull(actualRollbackFailureException.getCause());
    assertNull(actualRollbackFailureException.getRootCause());
    assertEquals(0, actualRollbackFailureException.getSuppressed().length);
    assertTrue(actualStateItems.isEmpty());
    assertSame(originalWorkflowException, actualOriginalWorkflowException);
    assertSame(stateItems, actualStateItems);
    assertSame(activity, actualActivity);
    assertSame(processContext, actualProcessContext);
  }

  /**
   * Test {@link RollbackFailureException#RollbackFailureException(String)}.
   * <p>
   * Method under test: {@link RollbackFailureException#RollbackFailureException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RollbackFailureException.<init>(String)"})
  public void testNewRollbackFailureException() {
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
   * Test {@link RollbackFailureException#RollbackFailureException(String, Throwable)}.
   * <ul>
   *   <li>Then return LocalizedMessage is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RollbackFailureException#RollbackFailureException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RollbackFailureException.<init>(String, Throwable)"})
  public void testNewRollbackFailureException_thenReturnLocalizedMessageIsAnErrorOccurred() {
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
   * Test {@link RollbackFailureException#RollbackFailureException(Throwable)}.
   * <ul>
   *   <li>Then return LocalizedMessage is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RollbackFailureException#RollbackFailureException(Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RollbackFailureException.<init>(Throwable)"})
  public void testNewRollbackFailureException_thenReturnLocalizedMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualRollbackFailureException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRollbackFailureException.getMessage());
    assertSame(cause, actualRollbackFailureException.getCause());
    assertSame(cause, actualRollbackFailureException.getRootCause());
  }

  /**
   * Test {@link RollbackFailureException#RollbackFailureException(Throwable, Throwable)}.
   * <ul>
   *   <li>Then return LocalizedMessage is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RollbackFailureException#RollbackFailureException(Throwable, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RollbackFailureException.<init>(Throwable, Throwable)"})
  public void testNewRollbackFailureException_thenReturnLocalizedMessageIsJavaLangThrowable2() {
    // Arrange
    Throwable rollbackFailureCause = new Throwable();

    // Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException(rollbackFailureCause,
        new Throwable());

    // Assert
    assertEquals("java.lang.Throwable", actualRollbackFailureException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRollbackFailureException.getMessage());
    assertSame(rollbackFailureCause, actualRollbackFailureException.getCause());
    assertSame(rollbackFailureCause, actualRollbackFailureException.getRootCause());
  }

  /**
   * Test {@link RollbackFailureException#RollbackFailureException(Throwable)}.
   * <ul>
   *   <li>Then return RootCause LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RollbackFailureException#RollbackFailureException(Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RollbackFailureException.<init>(Throwable)"})
  public void testNewRollbackFailureException_thenReturnRootCauseLocalizedMessageIsNull() {
    // Arrange
    Throwable cause = new Throwable();
    Throwable throwable = new Throwable();
    cause.initCause(throwable);

    // Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException(cause);

    // Assert
    Throwable rootCause = actualRollbackFailureException.getRootCause();
    assertNull(rootCause.getLocalizedMessage());
    assertNull(rootCause.getMessage());
    assertNull(rootCause.getCause());
    assertSame(throwable, actualRollbackFailureException.getCause().getCause());
  }

  /**
   * Test {@link RollbackFailureException#RollbackFailureException(Throwable, Throwable)}.
   * <ul>
   *   <li>Then return RootCause LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RollbackFailureException#RollbackFailureException(Throwable, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RollbackFailureException.<init>(Throwable, Throwable)"})
  public void testNewRollbackFailureException_thenReturnRootCauseLocalizedMessageIsNull2() {
    // Arrange
    Throwable rollbackFailureCause = new Throwable();
    Throwable throwable = new Throwable();
    rollbackFailureCause.initCause(throwable);

    // Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException(rollbackFailureCause,
        new Throwable());

    // Assert
    Throwable rootCause = actualRollbackFailureException.getRootCause();
    assertNull(rootCause.getLocalizedMessage());
    assertNull(rootCause.getMessage());
    assertNull(rootCause.getCause());
    assertSame(throwable, actualRollbackFailureException.getCause().getCause());
  }

  /**
   * Test {@link RollbackFailureException#RollbackFailureException(String, Throwable)}.
   * <ul>
   *   <li>Then return RootCause LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RollbackFailureException#RollbackFailureException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RollbackFailureException.<init>(String, Throwable)"})
  public void testNewRollbackFailureException_thenReturnRootCauseLocalizedMessageIsNull3() {
    // Arrange
    Throwable cause = new Throwable();
    Throwable throwable = new Throwable();
    cause.initCause(throwable);

    // Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException("An error occurred", cause);

    // Assert
    Throwable rootCause = actualRollbackFailureException.getRootCause();
    assertNull(rootCause.getLocalizedMessage());
    assertNull(rootCause.getMessage());
    assertNull(rootCause.getCause());
    assertSame(throwable, actualRollbackFailureException.getCause().getCause());
  }

  /**
   * Test {@link RollbackFailureException#RollbackFailureException(Throwable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RollbackFailureException#RollbackFailureException(Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RollbackFailureException.<init>(Throwable)"})
  public void testNewRollbackFailureException_whenNull_thenReturnLocalizedMessageIsNull() {
    // Arrange and Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException((Throwable) null);

    // Assert
    assertNull(actualRollbackFailureException.getLocalizedMessage());
    assertNull(actualRollbackFailureException.getMessage());
    assertNull(actualRollbackFailureException.getCause());
    assertNull(actualRollbackFailureException.getRootCause());
  }

  /**
   * Test {@link RollbackFailureException#RollbackFailureException(Throwable, Throwable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RollbackFailureException#RollbackFailureException(Throwable, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RollbackFailureException.<init>(Throwable, Throwable)"})
  public void testNewRollbackFailureException_whenNull_thenReturnLocalizedMessageIsNull2() {
    // Arrange and Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException((Throwable) null,
        new Throwable());

    // Assert
    assertNull(actualRollbackFailureException.getLocalizedMessage());
    assertNull(actualRollbackFailureException.getMessage());
    assertNull(actualRollbackFailureException.getCause());
    assertNull(actualRollbackFailureException.getRootCause());
  }

  /**
   * Test {@link RollbackFailureException#RollbackFailureException(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return RootCauseMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RollbackFailureException#RollbackFailureException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RollbackFailureException.<init>(String, Throwable)"})
  public void testNewRollbackFailureException_whenThrowable_thenReturnRootCauseMessageIsNull() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    RollbackFailureException actualRollbackFailureException = new RollbackFailureException("An error occurred", cause);

    // Assert
    assertNull(actualRollbackFailureException.getRootCauseMessage());
    assertSame(cause, actualRollbackFailureException.getCause());
    assertSame(cause, actualRollbackFailureException.getRootCause());
  }
}
