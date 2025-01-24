package org.broadleafcommerce.core.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.state.RollbackHandler;
import org.junit.Test;

public class ThirdPartyInteractionLatencySimulationActivityDiffblueTest {
  /**
   * Test
   * {@link ThirdPartyInteractionLatencySimulationActivity#execute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link ThirdPartyInteractionLatencySimulationActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute() throws Exception {
    // Arrange
    ThirdPartyInteractionLatencySimulationActivity thirdPartyInteractionLatencySimulationActivity = new ThirdPartyInteractionLatencySimulationActivity();
    thirdPartyInteractionLatencySimulationActivity.setRollbackHandler(mock(RollbackHandler.class));
    DefaultProcessContextImpl<Object> context = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertSame(context, thirdPartyInteractionLatencySimulationActivity.execute(context));
  }

  /**
   * Test
   * {@link ThirdPartyInteractionLatencySimulationActivity#execute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link ThirdPartyInteractionLatencySimulationActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute2() throws Exception {
    // Arrange
    ThirdPartyInteractionLatencySimulationActivity thirdPartyInteractionLatencySimulationActivity = new ThirdPartyInteractionLatencySimulationActivity();
    thirdPartyInteractionLatencySimulationActivity.setWaitTime(-1L);
    DefaultProcessContextImpl<Object> context = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertSame(context, thirdPartyInteractionLatencySimulationActivity.execute(context));
  }

  /**
   * Test
   * {@link ThirdPartyInteractionLatencySimulationActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link ThirdPartyInteractionLatencySimulationActivity} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThirdPartyInteractionLatencySimulationActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenThirdPartyInteractionLatencySimulationActivity() throws Exception {
    // Arrange
    ThirdPartyInteractionLatencySimulationActivity thirdPartyInteractionLatencySimulationActivity = new ThirdPartyInteractionLatencySimulationActivity();
    DefaultProcessContextImpl<Object> context = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertSame(context, thirdPartyInteractionLatencySimulationActivity.execute(context));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ThirdPartyInteractionLatencySimulationActivity}
   *   <li>{@link ThirdPartyInteractionLatencySimulationActivity#setWaitTime(long)}
   *   <li>{@link ThirdPartyInteractionLatencySimulationActivity#getWaitTime()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ThirdPartyInteractionLatencySimulationActivity actualThirdPartyInteractionLatencySimulationActivity = new ThirdPartyInteractionLatencySimulationActivity();
    actualThirdPartyInteractionLatencySimulationActivity.setWaitTime(1L);

    // Assert that nothing has changed
    assertEquals(1L, actualThirdPartyInteractionLatencySimulationActivity.getWaitTime());
    assertFalse(actualThirdPartyInteractionLatencySimulationActivity.getAutomaticallyRegisterRollbackHandler());
    assertEquals(Integer.MAX_VALUE, actualThirdPartyInteractionLatencySimulationActivity.getOrder());
  }
}
