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
