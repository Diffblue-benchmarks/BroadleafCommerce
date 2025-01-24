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
