package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.EmptySequenceProcessor;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.Processor;
import org.junit.Ignore;
import org.junit.Test;

public class CompositeActivityDiffblueTest {
  /**
   * Test {@link CompositeActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link CompositeActivity} (default constructor).</li>
   *   <li>When {@link DefaultProcessContextImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CompositeActivity#execute(ProcessContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecute_givenCompositeActivity_whenDefaultProcessContextImpl() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.checkout.service.workflow.CompositeActivity.execute(CompositeActivity.java:33)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    CompositeActivity compositeActivity = new CompositeActivity();

    // Act
    compositeActivity.execute((ProcessContext<CheckoutSeed>) new DefaultProcessContextImpl<>());
  }

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
