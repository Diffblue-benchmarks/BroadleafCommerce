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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class EmptySequenceProcessorDiffblueTest {
  /**
   * Method under test: {@link EmptySequenceProcessor#createContext(Object)}
   */
  @Test
  public void testCreateContext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EmptySequenceProcessor()).createContext("Seed Data"));
  }

  /**
   * Method under test: {@link EmptySequenceProcessor#createContext(Object)}
   */
  @Test
  public void testCreateContext2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmptySequenceProcessor emptySequenceProcessor = new EmptySequenceProcessor();
    emptySequenceProcessor.setProcessContextFactory(mock(ProcessContextFactory.class));

    // Act and Assert
    assertNull(emptySequenceProcessor.createContext("Seed Data"));
  }

  /**
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
