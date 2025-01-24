package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class AutoBundleActivityDiffblueTest {
  /**
   * Test new {@link AutoBundleActivity} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AutoBundleActivity}
   */
  @Test
  public void testNewAutoBundleActivity() {
    // Arrange and Act
    AutoBundleActivity actualAutoBundleActivity = new AutoBundleActivity();

    // Assert
    assertNull(actualAutoBundleActivity.getBeanName());
    assertNull(actualAutoBundleActivity.getRollbackRegion());
    assertNull(actualAutoBundleActivity.getStateConfiguration());
    assertNull(actualAutoBundleActivity.getErrorHandler());
    assertNull(actualAutoBundleActivity.getRollbackHandler());
    assertFalse(actualAutoBundleActivity.getAutomaticallyRegisterRollbackHandler());
    assertEquals(Integer.MAX_VALUE, actualAutoBundleActivity.getOrder());
  }
}
