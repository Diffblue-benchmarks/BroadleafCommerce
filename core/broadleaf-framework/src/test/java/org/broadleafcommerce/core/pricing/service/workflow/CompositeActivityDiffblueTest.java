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
package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.EmptySequenceProcessor;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.Processor;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class CompositeActivityDiffblueTest {
  /**
   * Test {@link CompositeActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then {@link DefaultProcessContextImpl} (default constructor) Stopped.
   * </ul>
   *
   * <p>Method under test: {@link CompositeActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext CompositeActivity.execute(ProcessContext)"})
  public void testExecute_thenDefaultProcessContextImplStopped() throws Exception {
    // Arrange
    DefaultProcessContextImpl<Object> defaultProcessContextImpl =
        mock(DefaultProcessContextImpl.class);
    when(defaultProcessContextImpl.isStopped()).thenReturn(true);

    EmptySequenceProcessor workflow = mock(EmptySequenceProcessor.class);
    when(workflow.doActivities(Mockito.<Object>any())).thenReturn(defaultProcessContextImpl);

    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setWorkflow(workflow);
    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();

    // Act
    ProcessContext<Order> actualExecuteResult = compositeActivity.execute(context);

    // Assert
    verify(defaultProcessContextImpl).isStopped();
    verify(workflow).doActivities((Object) isNull());
    assertTrue(context.isStopped());
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link CompositeActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then not {@link DefaultProcessContextImpl} (default constructor) Stopped.
   * </ul>
   *
   * <p>Method under test: {@link CompositeActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext CompositeActivity.execute(ProcessContext)"})
  public void testExecute_thenNotDefaultProcessContextImplStopped() throws Exception {
    // Arrange
    EmptySequenceProcessor workflow = mock(EmptySequenceProcessor.class);
    when(workflow.doActivities(Mockito.<Object>any()))
        .thenReturn(new DefaultProcessContextImpl<>());

    CompositeActivity compositeActivity = new CompositeActivity();
    compositeActivity.setWorkflow(workflow);
    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();

    // Act
    ProcessContext<Order> actualExecuteResult = compositeActivity.execute(context);

    // Assert
    verify(workflow).doActivities((Object) isNull());
    assertFalse(context.isStopped());
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CompositeActivity}
   *   <li>{@link CompositeActivity#setWorkflow(Processor)}
   *   <li>{@link CompositeActivity#getWorkflow()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CompositeActivity.<init>()",
    "Processor CompositeActivity.getWorkflow()",
    "void CompositeActivity.setWorkflow(Processor)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CompositeActivity actualCompositeActivity = new CompositeActivity();
    EmptySequenceProcessor workflow = new EmptySequenceProcessor();
    actualCompositeActivity.setWorkflow(workflow);
    Processor actualWorkflow = actualCompositeActivity.getWorkflow();

    // Assert
    assertNull(actualCompositeActivity.getBeanName());
    assertNull(actualCompositeActivity.getRollbackRegion());
    assertNull(actualCompositeActivity.getStateConfiguration());
    assertNull(actualCompositeActivity.getErrorHandler());
    assertNull(actualCompositeActivity.getRollbackHandler());
    assertFalse(actualCompositeActivity.getAutomaticallyRegisterRollbackHandler());
    assertEquals(Integer.MAX_VALUE, actualCompositeActivity.getOrder());
    assertSame(workflow, actualWorkflow);
  }
}
