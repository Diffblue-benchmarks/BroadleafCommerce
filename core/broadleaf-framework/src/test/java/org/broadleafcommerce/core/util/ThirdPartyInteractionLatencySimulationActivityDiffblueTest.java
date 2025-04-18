/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ThirdPartyInteractionLatencySimulationActivityDiffblueTest {
  /**
   * Test {@link ThirdPartyInteractionLatencySimulationActivity#execute(ProcessContext)}.
   * <p>
   * Method under test: {@link ThirdPartyInteractionLatencySimulationActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ThirdPartyInteractionLatencySimulationActivity.execute(ProcessContext)"})
  public void testExecute() throws Exception {
    // Arrange
    ThirdPartyInteractionLatencySimulationActivity thirdPartyInteractionLatencySimulationActivity = new ThirdPartyInteractionLatencySimulationActivity();
    thirdPartyInteractionLatencySimulationActivity.setWaitTime(-1L);
    DefaultProcessContextImpl<Object> context = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertSame(context, thirdPartyInteractionLatencySimulationActivity.execute(context));
  }

  /**
   * Test {@link ThirdPartyInteractionLatencySimulationActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link ThirdPartyInteractionLatencySimulationActivity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ThirdPartyInteractionLatencySimulationActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ThirdPartyInteractionLatencySimulationActivity.execute(ProcessContext)"})
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
   *   <li>default or parameterless constructor of {@link ThirdPartyInteractionLatencySimulationActivity}
   *   <li>{@link ThirdPartyInteractionLatencySimulationActivity#setWaitTime(long)}
   *   <li>{@link ThirdPartyInteractionLatencySimulationActivity#getWaitTime()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ThirdPartyInteractionLatencySimulationActivity.<init>()",
      "long ThirdPartyInteractionLatencySimulationActivity.getWaitTime()",
      "void ThirdPartyInteractionLatencySimulationActivity.setWaitTime(long)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    ThirdPartyInteractionLatencySimulationActivity actualThirdPartyInteractionLatencySimulationActivity = new ThirdPartyInteractionLatencySimulationActivity();
    actualThirdPartyInteractionLatencySimulationActivity.setWaitTime(1L);
    long actualWaitTime = actualThirdPartyInteractionLatencySimulationActivity.getWaitTime();

    // Assert
    assertNull(actualThirdPartyInteractionLatencySimulationActivity.getBeanName());
    assertNull(actualThirdPartyInteractionLatencySimulationActivity.getRollbackRegion());
    assertNull(actualThirdPartyInteractionLatencySimulationActivity.getStateConfiguration());
    assertNull(actualThirdPartyInteractionLatencySimulationActivity.getErrorHandler());
    assertNull(actualThirdPartyInteractionLatencySimulationActivity.getRollbackHandler());
    assertEquals(1L, actualWaitTime);
    assertFalse(actualThirdPartyInteractionLatencySimulationActivity.getAutomaticallyRegisterRollbackHandler());
    assertEquals(Integer.MAX_VALUE, actualThirdPartyInteractionLatencySimulationActivity.getOrder());
  }
}
