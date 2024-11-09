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
package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.core.workflow.EmptySequenceProcessor;
import org.broadleafcommerce.core.workflow.Processor;
import org.junit.Test;

public class CompositeActivityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CompositeActivity}
   *   <li>{@link CompositeActivity#setWorkflow(Processor)}
   *   <li>{@link CompositeActivity#getWorkflow()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CompositeActivity actualCompositeActivity = new CompositeActivity();
    EmptySequenceProcessor workflow = new EmptySequenceProcessor();
    actualCompositeActivity.setWorkflow(workflow);
    Processor actualWorkflow = actualCompositeActivity.getWorkflow();

    // Assert that nothing has changed
    assertFalse(actualCompositeActivity.getAutomaticallyRegisterRollbackHandler());
    assertEquals(Integer.MAX_VALUE, actualCompositeActivity.getOrder());
    assertSame(workflow, actualWorkflow);
  }
}
