package org.broadleafcommerce.core.workflow.state;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RollbackStateLocalDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RollbackStateLocal}
   *   <li>{@link RollbackStateLocal#setThreadId(String)}
   *   <li>{@link RollbackStateLocal#setWorkflowId(String)}
   *   <li>{@link RollbackStateLocal#getThreadId()}
   *   <li>{@link RollbackStateLocal#getWorkflowId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RollbackStateLocal.<init>()",
    "String RollbackStateLocal.getThreadId()",
    "String RollbackStateLocal.getWorkflowId()",
    "void RollbackStateLocal.setThreadId(String)",
    "void RollbackStateLocal.setWorkflowId(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    RollbackStateLocal actualRollbackStateLocal = new RollbackStateLocal();
    actualRollbackStateLocal.setThreadId("42");
    actualRollbackStateLocal.setWorkflowId("42");
    String actualThreadId = actualRollbackStateLocal.getThreadId();

    // Assert
    assertEquals("42", actualThreadId);
    assertEquals("42", actualRollbackStateLocal.getWorkflowId());
  }
}
