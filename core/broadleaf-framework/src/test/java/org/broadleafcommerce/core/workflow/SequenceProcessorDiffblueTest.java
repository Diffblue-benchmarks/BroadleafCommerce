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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.core.util.ThirdPartyInteractionLatencySimulationActivity;
import org.junit.Test;
import org.mockito.Mockito;

public class SequenceProcessorDiffblueTest {
  /**
   * Test {@link SequenceProcessor#supports(Activity)}.
   * <ul>
   *   <li>When {@link Activity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SequenceProcessor#supports(Activity)}
   */
  @Test
  public void testSupports_whenActivity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();

    // Act and Assert
    assertTrue(sequenceProcessor.supports(mock(Activity.class)));
  }

  /**
   * Test {@link SequenceProcessor#supports(Activity)}.
   * <ul>
   *   <li>When {@link ThirdPartyInteractionLatencySimulationActivity} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SequenceProcessor#supports(Activity)}
   */
  @Test
  public void testSupports_whenThirdPartyInteractionLatencySimulationActivity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();

    // Act and Assert
    assertTrue(sequenceProcessor.supports(new ThirdPartyInteractionLatencySimulationActivity()));
  }

  /**
   * Test {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}
   */
  @Test
  public void testProcessShouldStop_givenTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();
    DefaultProcessContextImpl<Object> context = mock(DefaultProcessContextImpl.class);
    when(context.isStopped()).thenReturn(true);

    // Act
    boolean actualProcessShouldStopResult = sequenceProcessor.processShouldStop(context,
        new ThirdPartyInteractionLatencySimulationActivity());

    // Assert
    verify(context).isStopped();
    assertTrue(actualProcessShouldStopResult);
  }

  /**
   * Test {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}.
   * <ul>
   *   <li>When {@link DefaultProcessContextImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}
   */
  @Test
  public void testProcessShouldStop_whenDefaultProcessContextImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();
    DefaultProcessContextImpl<Object> context = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertFalse(sequenceProcessor.processShouldStop(context, new ThirdPartyInteractionLatencySimulationActivity()));
  }

  /**
   * Test {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SequenceProcessor#processShouldStop(ProcessContext, Activity)}
   */
  @Test
  public void testProcessShouldStop_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SequenceProcessor<Object, Object> sequenceProcessor = new SequenceProcessor<>();

    // Act and Assert
    assertTrue(sequenceProcessor.processShouldStop(null, new ThirdPartyInteractionLatencySimulationActivity()));
  }

  /**
   * Test {@link SequenceProcessor#createContext(Object)}.
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SequenceProcessor#createContext(Object)}
   */
  @Test
  public void testCreateContext_thenReturnDefaultProcessContextImpl() throws WorkflowException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProcessContextFactory<Object, Object> processContextFactory = mock(ProcessContextFactory.class);
    DefaultProcessContextImpl<Object> defaultProcessContextImpl = new DefaultProcessContextImpl<>();
    when(processContextFactory.createContext(Mockito.<Object>any())).thenReturn(defaultProcessContextImpl);

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
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link SequenceProcessor}
   */
  @Test
  public void testNewSequenceProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
