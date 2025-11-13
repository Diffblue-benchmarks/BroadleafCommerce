package org.broadleafcommerce.core.workflow.state.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.testng.annotations.Test;

public class TestExampleModuleActivityDiffblueTest {
  /**
   * Test {@link TestExampleModuleActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link TestExampleModuleActivity#execute(ProcessContext)}
   */
  @Test(testName = "Test execute(ProcessContext)", groups = "ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext TestExampleModuleActivity.execute(ProcessContext)"})
  public void testExecute() throws Exception {
    // Arrange
    TestExampleModuleActivity testExampleModuleActivity = new TestExampleModuleActivity();
    DefaultProcessContextImpl<?> context = new DefaultProcessContextImpl<>();

    // Act
    ProcessContext<?> actualExecuteResult = testExampleModuleActivity.execute(context);

    // Assert
    assertSame(actualExecuteResult, context);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TestExampleModuleActivity}
   *   <li>{@link TestExampleModuleActivity#getModuleName()}
   * </ul>
   */
  @Test(testName = "Test getters and setters", groups = "ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TestExampleModuleActivity.<init>()",
    "java.lang.String TestExampleModuleActivity.getModuleName()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    TestExampleModuleActivity actualTestExampleModuleActivity = new TestExampleModuleActivity();

    // Assert
    assertEquals(actualTestExampleModuleActivity.getModuleName(), "integration");
    assertNull(actualTestExampleModuleActivity.getBeanName());
    assertNull(actualTestExampleModuleActivity.getRollbackRegion());
    assertNull(actualTestExampleModuleActivity.getStateConfiguration());
    assertNull(actualTestExampleModuleActivity.getErrorHandler());
    assertNull(actualTestExampleModuleActivity.getRollbackHandler());
    assertFalse(actualTestExampleModuleActivity.getAutomaticallyRegisterRollbackHandler());
    assertEquals(actualTestExampleModuleActivity.getOrder(), Integer.MAX_VALUE);
  }
}
