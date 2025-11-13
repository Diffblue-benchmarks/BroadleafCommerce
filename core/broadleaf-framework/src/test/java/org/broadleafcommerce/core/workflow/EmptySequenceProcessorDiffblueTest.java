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

public class EmptySequenceProcessorDiffblueTest {
  /**
   * Test {@link EmptySequenceProcessor#createContext(Object)}.
   *
   * <p>Method under test: {@link EmptySequenceProcessor#createContext(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.workflow.ProcessContext EmptySequenceProcessor.createContext(Object)"
  })
  public void testCreateContext() {
    // Arrange, Act and Assert
    assertNull(new EmptySequenceProcessor().createContext("Seed Data"));
  }

  /**
   * Test new {@link EmptySequenceProcessor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link EmptySequenceProcessor}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmptySequenceProcessor.<init>()"})
  public void testNewEmptySequenceProcessor() {
    // Arrange and Act
    EmptySequenceProcessor actualEmptySequenceProcessor = new EmptySequenceProcessor();

    // Assert
    assertEquals("Workflow Processor: null", actualEmptySequenceProcessor.getBeanDesc());
    assertNull(actualEmptySequenceProcessor.getBeanName());
    assertNull(actualEmptySequenceProcessor.getDefaultErrorHandler());
    assertNull(actualEmptySequenceProcessor.getBeanFactory());
    assertFalse(actualEmptySequenceProcessor.isAllowEmptyActivities());
    assertTrue(actualEmptySequenceProcessor.getActivities().isEmpty());
    assertTrue(actualEmptySequenceProcessor.getModuleActivities().isEmpty());
    assertTrue(actualEmptySequenceProcessor.getAutoRollbackOnError());
  }
}
