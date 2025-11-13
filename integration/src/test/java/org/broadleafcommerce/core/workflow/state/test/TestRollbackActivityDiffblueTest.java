package org.broadleafcommerce.core.workflow.state.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.testng.annotations.Test;

public class TestRollbackActivityDiffblueTest {
  /**
   * Test new {@link TestRollbackActivity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TestRollbackActivity}
   */
  @Test(
      testName = "Test new TestRollbackActivity (default constructor)",
      groups = "ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TestRollbackActivity.<init>()"})
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
