package org.broadleafcommerce.core.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PassThroughActivityDiffblueTest {
  /**
   * Test {@link PassThroughActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link PassThroughActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext PassThroughActivity.execute(ProcessContext)"})
  public void testExecute() throws Exception {
    // Arrange
    PassThroughActivity passThroughActivity = new PassThroughActivity();
    DefaultProcessContextImpl<?> context = new DefaultProcessContextImpl<>();

    // Act
    ProcessContext<?> actualExecuteResult = passThroughActivity.execute(context);

    // Assert
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test new {@link PassThroughActivity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PassThroughActivity}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PassThroughActivity.<init>()"})
  public void testNewPassThroughActivity() {
    // Arrange and Act
    PassThroughActivity actualPassThroughActivity = new PassThroughActivity();

    // Assert
    assertNull(actualPassThroughActivity.getBeanName());
    assertNull(actualPassThroughActivity.getRollbackRegion());
    assertNull(actualPassThroughActivity.getStateConfiguration());
    assertNull(actualPassThroughActivity.getErrorHandler());
    assertNull(actualPassThroughActivity.getRollbackHandler());
    assertFalse(actualPassThroughActivity.getAutomaticallyRegisterRollbackHandler());
    assertEquals(Integer.MAX_VALUE, actualPassThroughActivity.getOrder());
  }
}
