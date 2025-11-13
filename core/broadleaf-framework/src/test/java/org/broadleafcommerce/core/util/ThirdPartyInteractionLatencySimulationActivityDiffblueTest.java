package org.broadleafcommerce.core.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ThirdPartyInteractionLatencySimulationActivityDiffblueTest {
  /**
   * Test {@link ThirdPartyInteractionLatencySimulationActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link
   * ThirdPartyInteractionLatencySimulationActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessContext ThirdPartyInteractionLatencySimulationActivity.execute(ProcessContext)"
  })
  public void testExecute() throws Exception {
    // Arrange
    ThirdPartyInteractionLatencySimulationActivity thirdPartyInteractionLatencySimulationActivity =
        new ThirdPartyInteractionLatencySimulationActivity();
    thirdPartyInteractionLatencySimulationActivity.setWaitTime(-1L);
    DefaultProcessContextImpl<Object> context = new DefaultProcessContextImpl<>();

    // Act
    ProcessContext<Object> actualExecuteResult =
        thirdPartyInteractionLatencySimulationActivity.execute(context);

    // Assert
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ThirdPartyInteractionLatencySimulationActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link ThirdPartyInteractionLatencySimulationActivity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * ThirdPartyInteractionLatencySimulationActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessContext ThirdPartyInteractionLatencySimulationActivity.execute(ProcessContext)"
  })
  public void testExecute_givenThirdPartyInteractionLatencySimulationActivity() throws Exception {
    // Arrange
    ThirdPartyInteractionLatencySimulationActivity thirdPartyInteractionLatencySimulationActivity =
        new ThirdPartyInteractionLatencySimulationActivity();
    DefaultProcessContextImpl<Object> context = new DefaultProcessContextImpl<>();

    // Act
    ProcessContext<Object> actualExecuteResult =
        thirdPartyInteractionLatencySimulationActivity.execute(context);

    // Assert
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link
   *       ThirdPartyInteractionLatencySimulationActivity}
   *   <li>{@link ThirdPartyInteractionLatencySimulationActivity#setWaitTime(long)}
   *   <li>{@link ThirdPartyInteractionLatencySimulationActivity#getWaitTime()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThirdPartyInteractionLatencySimulationActivity.<init>()",
    "long ThirdPartyInteractionLatencySimulationActivity.getWaitTime()",
    "void ThirdPartyInteractionLatencySimulationActivity.setWaitTime(long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ThirdPartyInteractionLatencySimulationActivity
        actualThirdPartyInteractionLatencySimulationActivity =
            new ThirdPartyInteractionLatencySimulationActivity();
    actualThirdPartyInteractionLatencySimulationActivity.setWaitTime(1L);
    long actualWaitTime = actualThirdPartyInteractionLatencySimulationActivity.getWaitTime();

    // Assert
    assertNull(actualThirdPartyInteractionLatencySimulationActivity.getBeanName());
    assertNull(actualThirdPartyInteractionLatencySimulationActivity.getRollbackRegion());
    assertNull(actualThirdPartyInteractionLatencySimulationActivity.getStateConfiguration());
    assertNull(actualThirdPartyInteractionLatencySimulationActivity.getErrorHandler());
    assertNull(actualThirdPartyInteractionLatencySimulationActivity.getRollbackHandler());
    assertEquals(1L, actualWaitTime);
    assertFalse(
        actualThirdPartyInteractionLatencySimulationActivity
            .getAutomaticallyRegisterRollbackHandler());
    assertEquals(
        Integer.MAX_VALUE, actualThirdPartyInteractionLatencySimulationActivity.getOrder());
  }
}
