package org.broadleafcommerce.core.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.core.workflow.state.RollbackHandler;
import org.junit.Test;

public class PassThroughActivityDiffblueTest {
  /**
   * Test {@link PassThroughActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link PassThroughActivity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PassThroughActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenPassThroughActivity() throws Exception {
    // Arrange
    PassThroughActivity passThroughActivity = new PassThroughActivity();
    DefaultProcessContextImpl<?> context = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertSame(context, passThroughActivity.execute(context));
  }

  /**
   * Test {@link PassThroughActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link PassThroughActivity} (default constructor) RollbackHandler
   * is {@link RollbackHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PassThroughActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenPassThroughActivityRollbackHandlerIsRollbackHandler() throws Exception {
    // Arrange
    PassThroughActivity passThroughActivity = new PassThroughActivity();
    passThroughActivity.setRollbackHandler(mock(RollbackHandler.class));
    DefaultProcessContextImpl<?> context = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertSame(context, passThroughActivity.execute(context));
  }

  /**
   * Test new {@link PassThroughActivity} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PassThroughActivity}
   */
  @Test
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
