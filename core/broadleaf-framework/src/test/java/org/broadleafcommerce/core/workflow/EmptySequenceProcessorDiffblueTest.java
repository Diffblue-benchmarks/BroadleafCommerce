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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EmptySequenceProcessorDiffblueTest {
  /**
   * Test {@link EmptySequenceProcessor#createContext(Object)}.
   * <p>
   * Method under test: {@link EmptySequenceProcessor#createContext(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.core.workflow.ProcessContext EmptySequenceProcessor.createContext(Object)"})
  public void testCreateContext() {
    // Arrange, Act and Assert
    assertNull((new EmptySequenceProcessor()).createContext("Seed Data"));
  }

  /**
   * Test new {@link EmptySequenceProcessor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link EmptySequenceProcessor}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
