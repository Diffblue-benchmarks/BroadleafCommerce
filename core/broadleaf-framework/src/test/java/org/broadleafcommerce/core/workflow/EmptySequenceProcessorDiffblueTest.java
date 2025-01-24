package org.broadleafcommerce.core.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class EmptySequenceProcessorDiffblueTest {
  /**
   * Test {@link EmptySequenceProcessor#createContext(Object)}.
   * <p>
   * Method under test: {@link EmptySequenceProcessor#createContext(Object)}
   */
  @Test
  public void testCreateContext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act and Assert
    assertNull(emptySequenceProcessor.createContext("Seed Data"));
  }

  /**
   * Test {@link EmptySequenceProcessor#createContext(Object)}.
   * <ul>
   *   <li>Given {@link EmptySequenceProcessor} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EmptySequenceProcessor#createContext(Object)}
   */
  @Test
  public void testCreateContext_givenEmptySequenceProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EmptySequenceProcessor()).createContext("Seed Data"));
  }

  /**
   * Test new {@link EmptySequenceProcessor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link EmptySequenceProcessor}
   */
  @Test
  public void testNewEmptySequenceProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
