package org.broadleafcommerce.core.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WorkflowExceptionDiffblueTest {
  /**
   * Test {@link WorkflowException#WorkflowException()}.
   *
   * <p>Method under test: {@link WorkflowException#WorkflowException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WorkflowException.<init>()"})
  public void testNewWorkflowException() {
    // Arrange and Act
    WorkflowException actualWorkflowException = new WorkflowException();

    // Assert
    assertNull(actualWorkflowException.getMessage());
    assertNull(actualWorkflowException.getCause());
    assertNull(actualWorkflowException.getRootCause());
    assertEquals(0, actualWorkflowException.getSuppressed().length);
  }
}
