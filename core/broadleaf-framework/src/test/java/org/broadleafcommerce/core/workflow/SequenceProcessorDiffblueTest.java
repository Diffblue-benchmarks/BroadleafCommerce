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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.util.ThirdPartyInteractionLatencySimulationActivity;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SequenceProcessorDiffblueTest {
  /**
   * Test {@link SequenceProcessor#supports(Activity)}.
   *
   * <p>Method under test: {@link SequenceProcessor#supports(Activity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SequenceProcessor.supports(Activity)"})
  public void testSupports() {
    // Arrange
    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();

    // Act and Assert
    assertTrue(sequenceProcessor.supports(new ThirdPartyInteractionLatencySimulationActivity()));
  }

  /**
   * Test {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SequenceProcessor.processShouldStop(ProcessContext, Activity)"})
  public void testProcessShouldStop_givenTrue_thenReturnTrue() {
    // Arrange
    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();

    DefaultProcessContextImpl<Object> context = mock(DefaultProcessContextImpl.class);
    when(context.isStopped()).thenReturn(true);

    // Act
    boolean actualProcessShouldStopResult =
        sequenceProcessor.processShouldStop(
            context, new ThirdPartyInteractionLatencySimulationActivity());

    // Assert
    verify(context).isStopped();
    assertTrue(actualProcessShouldStopResult);
  }

  /**
   * Test {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}.
   *
   * <ul>
   *   <li>When {@link DefaultProcessContextImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SequenceProcessor.processShouldStop(ProcessContext, Activity)"})
  public void testProcessShouldStop_whenDefaultProcessContextImpl_thenReturnFalse() {
    // Arrange
    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();
    DefaultProcessContextImpl<Object> context = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertFalse(
        sequenceProcessor.processShouldStop(
            context, new ThirdPartyInteractionLatencySimulationActivity()));
  }

  /**
   * Test {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SequenceProcessor.processShouldStop(ProcessContext, Activity)"})
  public void testProcessShouldStop_whenNull_thenReturnTrue() {
    // Arrange
    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();

    // Act and Assert
    assertTrue(
        sequenceProcessor.processShouldStop(
            null, new ThirdPartyInteractionLatencySimulationActivity()));
  }

  /**
   * Test {@link SequenceProcessor#createContext(Object)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SequenceProcessor#createContext(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext SequenceProcessor.createContext(Object)"})
  public void testCreateContext_thenReturnDefaultProcessContextImpl() throws WorkflowException {
    // Arrange
    ProcessContextFactory<Object, Object> processContextFactory = mock(ProcessContextFactory.class);
    DefaultProcessContextImpl<Object> defaultProcessContextImpl = new DefaultProcessContextImpl<>();
    when(processContextFactory.createContext(Mockito.<Object>any()))
        .thenReturn(defaultProcessContextImpl);

    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();
    sequenceProcessor.setProcessContextFactory(processContextFactory);

    // Act
    ProcessContext<Object> actualCreateContextResult = sequenceProcessor.createContext("Seed Data");

    // Assert
    verify(processContextFactory).createContext(isA(Object.class));
    assertSame(defaultProcessContextImpl, actualCreateContextResult);
  }

  /**
   * Test new {@link SequenceProcessor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SequenceProcessor}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SequenceProcessor.<init>()"})
  public void testNewSequenceProcessor() {
    // Arrange and Act
    SequenceProcessor<Object, Object> actualSequenceProcessor = new SequenceProcessor<>();

    // Assert
    assertEquals("Workflow Processor: null", actualSequenceProcessor.getBeanDesc());
    assertNull(actualSequenceProcessor.getBeanName());
    assertNull(actualSequenceProcessor.getDefaultErrorHandler());
    assertNull(actualSequenceProcessor.getBeanFactory());
    assertFalse(actualSequenceProcessor.isAllowEmptyActivities());
    assertTrue(actualSequenceProcessor.getActivities().isEmpty());
    assertTrue(actualSequenceProcessor.getModuleActivities().isEmpty());
    assertTrue(actualSequenceProcessor.getAutoRollbackOnError());
  }
}
