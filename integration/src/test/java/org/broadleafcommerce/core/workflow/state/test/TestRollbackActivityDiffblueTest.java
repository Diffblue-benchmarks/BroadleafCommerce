package org.broadleafcommerce.core.workflow.state.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.testng.annotations.Test;

public class TestRollbackActivityDiffblueTest {
  /**
   * Test {@link TestRollbackActivity#execute(ProcessContext)}.
   * <p>
   * Method under test: {@link TestRollbackActivity#execute(ProcessContext)}
   */
  @Test(expectedExceptions = {IllegalArgumentException.class}, testName = "Test execute(ProcessContext)")
  public void testExecute() throws Exception {
    // Arrange
    TestRollbackActivity testRollbackActivity = new TestRollbackActivity();

    // Act
    testRollbackActivity.execute(new DefaultProcessContextImpl<>());
  }

  /**
   * Test new {@link TestRollbackActivity} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TestRollbackActivity}
   */
  @Test(testName = "Test new TestRollbackActivity (default constructor)")
  public void testNewTestRollbackActivity() {
    // Arrange and Act
    TestRollbackActivity actualTestRollbackActivity = new TestRollbackActivity();

    // Assert
    assertNull(actualTestRollbackActivity.getBeanName());
    assertNull(actualTestRollbackActivity.getRollbackRegion());
    assertNull(actualTestRollbackActivity.getStateConfiguration());
    assertNull(actualTestRollbackActivity.getErrorHandler());
    assertNull(actualTestRollbackActivity.getRollbackHandler());
    assertFalse(actualTestRollbackActivity.getAutomaticallyRegisterRollbackHandler());
    assertEquals(actualTestRollbackActivity.getOrder(), Integer.MAX_VALUE);
  }
}
