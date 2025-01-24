package org.broadleafcommerce.core.workflow.state;

import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

public class RollbackStateLocalDiffblueTest {
  /**
   * Test {@link RollbackStateLocal#getRollbackStateLocal()}.
   * <p>
   * Method under test: {@link RollbackStateLocal#getRollbackStateLocal()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRollbackStateLocal() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.util.EmptyStackException
    //       at java.base/java.util.Stack.peek(Stack.java:102)
    //       at org.broadleafcommerce.core.workflow.state.RollbackStateLocal.getRollbackStateLocal(RollbackStateLocal.java:35)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    RollbackStateLocal.getRollbackStateLocal();
  }

  /**
   * Test {@link RollbackStateLocal#setRollbackStateLocal(RollbackStateLocal)}.
   * <p>
   * Method under test:
   * {@link RollbackStateLocal#setRollbackStateLocal(RollbackStateLocal)}
   */
  @Test
  public void testSetRollbackStateLocal() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    RollbackStateLocal rollbackStateLocal = new RollbackStateLocal();
    rollbackStateLocal.setThreadId("42");
    rollbackStateLocal.setWorkflowId("42");

    // Act
    RollbackStateLocal.setRollbackStateLocal(rollbackStateLocal);
  }

  /**
   * Test {@link RollbackStateLocal#clearRollbackStateLocal()}.
   * <p>
   * Method under test: {@link RollbackStateLocal#clearRollbackStateLocal()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClearRollbackStateLocal() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.util.EmptyStackException
    //       at java.base/java.util.Stack.peek(Stack.java:102)
    //       at java.base/java.util.Stack.pop(Stack.java:84)
    //       at org.broadleafcommerce.core.workflow.state.RollbackStateLocal.clearRollbackStateLocal(RollbackStateLocal.java:45)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    RollbackStateLocal.clearRollbackStateLocal();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RollbackStateLocal}
   *   <li>{@link RollbackStateLocal#setThreadId(String)}
   *   <li>{@link RollbackStateLocal#setWorkflowId(String)}
   *   <li>{@link RollbackStateLocal#getThreadId()}
   *   <li>{@link RollbackStateLocal#getWorkflowId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RollbackStateLocal actualRollbackStateLocal = new RollbackStateLocal();
    actualRollbackStateLocal.setThreadId("42");
    actualRollbackStateLocal.setWorkflowId("42");
    String actualThreadId = actualRollbackStateLocal.getThreadId();

    // Assert that nothing has changed
    assertEquals("42", actualThreadId);
    assertEquals("42", actualRollbackStateLocal.getWorkflowId());
  }
}
