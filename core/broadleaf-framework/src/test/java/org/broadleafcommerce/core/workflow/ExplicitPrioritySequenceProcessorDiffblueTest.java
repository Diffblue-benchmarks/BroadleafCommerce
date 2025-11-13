package org.broadleafcommerce.core.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExplicitPrioritySequenceProcessorDiffblueTest {
  /**
   * Test new {@link ExplicitPrioritySequenceProcessor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ExplicitPrioritySequenceProcessor}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExplicitPrioritySequenceProcessor.<init>()"})
  public void testNewExplicitPrioritySequenceProcessor() {
    // Arrange and Act
    ExplicitPrioritySequenceProcessor actualExplicitPrioritySequenceProcessor =
        new ExplicitPrioritySequenceProcessor();

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
