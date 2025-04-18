/*-
 * #%L
 * BroadleafCommerce Integration
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
package org.broadleafcommerce.core.workflow.state.test;

import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.testng.annotations.Test;

public class TestPassThroughRollbackErrorHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TestPassThroughRollbackErrorHandler}
   *   <li>
   * {@link TestPassThroughRollbackErrorHandler#handleError(ProcessContext, Throwable)}
   *   <li>{@link TestPassThroughRollbackErrorHandler#setBeanName(String)}
   * </ul>
   */
  @Test(testName = "Test getters and setters")
  public void testGettersAndSetters() throws WorkflowException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    TestPassThroughRollbackErrorHandler actualTestPassThroughRollbackErrorHandler = new TestPassThroughRollbackErrorHandler();
    DefaultProcessContextImpl context = new DefaultProcessContextImpl();
    actualTestPassThroughRollbackErrorHandler.handleError(context, new Throwable());
    actualTestPassThroughRollbackErrorHandler.setBeanName("Name");
  }
}
