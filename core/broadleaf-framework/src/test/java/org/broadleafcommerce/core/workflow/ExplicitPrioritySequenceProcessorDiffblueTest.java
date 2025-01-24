package org.broadleafcommerce.core.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ExplicitPrioritySequenceProcessorDiffblueTest {
  /**
   * Test new {@link ExplicitPrioritySequenceProcessor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ExplicitPrioritySequenceProcessor}
   */
  @Test
  public void testNewExplicitPrioritySequenceProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ExplicitPrioritySequenceProcessor actualExplicitPrioritySequenceProcessor = new ExplicitPrioritySequenceProcessor();

    // Assert
    assertEquals("Workflow Processor: null", actualExplicitPrioritySequenceProcessor.getBeanDesc());
    assertNull(actualExplicitPrioritySequenceProcessor.getBeanName());
    assertNull(actualExplicitPrioritySequenceProcessor.getDefaultErrorHandler());
    assertNull(actualExplicitPrioritySequenceProcessor.getBeanFactory());
    assertFalse(actualExplicitPrioritySequenceProcessor.isAllowEmptyActivities());
    assertTrue(actualExplicitPrioritySequenceProcessor.getActivities().isEmpty());
    assertTrue(actualExplicitPrioritySequenceProcessor.getModuleActivities().isEmpty());
    assertTrue(actualExplicitPrioritySequenceProcessor.getAutoRollbackOnError());
  }
}
